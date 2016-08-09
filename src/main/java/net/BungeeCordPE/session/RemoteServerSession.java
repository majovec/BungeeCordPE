package net.BungeeCordPE.BungeeCordPE.session;

import net.BungeeCordPE.BungeeCordPE.*;
import net.BungeeCordPE.BungeeCordPE.util.Binary;
import net.BungeeCordPE.BungeeCordPE.network.packet.DataPacket;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;

/*
 *
 * ____                               _____              _ _____  ______ 
 *|  _ \                             / ____|            | |  __ \|  ____|
 *| |_) |_   _ _ __   __ _  ___  ___| |     ___  _ __ __| | |__) | |__   
 *|  _ <| | | | '_ \ / _` |/ _ \/ _ \ |    / _ \| '__/ _` |  ___/|  __|  
 *| |_) | |_| | | | | (_| |  __/  __/ |___| (_) | | | (_| | |    | |____ 
 *|____/ \__,_|_| |_|\__, |\___|\___|\_____\___/|_|  \__,_|_|    |______|
 *                    __/ |                                              
 *                   |___/                                               
 *                                          
 *
 * This program is free software, and it's under GNU General Public License v3.0+
 * You can redistribute it and/or modify under the same license.
 *
 * @author BukkitPE Team
 * @link http://www.bukkitpe.net/
 *
 *
*/

public class RemoteServerSession extends Thread implements Session{
    private SocketAddress serverAddress;
    private MinecraftPEServer server;
    private SocketAddress clientAddr;

    private DatagramSocket socket;
    private boolean running = false;

    private int timeoutTimes = 0;

    public RemoteServerSession(MinecraftPEServer server, SocketAddress serverAddress, SocketAddress clientAddr){
        this.server = server;
        this.clientAddr = clientAddr;
        this.serverAddress = serverAddress;
    }

    public void setRunning(boolean running){
        this.running = running;
    }

    @Override
    public void handlePacket(byte[] buffer) {
        //server.getLogger().info("Got a packet!");
        timeoutTimes = 0;
        if(server.clientSessions.containsKey(clientAddr.toString())){
            server.clientSessions.get(clientAddr.toString()).forwardToClient(buffer);
        }
    }

    @Override
    public SocketAddress getAddress() {
        return serverAddress;
    }

    @Override
    public void run(){
        setName("RemoteServer-"+clientAddr.toString());
        try {
            //int port = Integer.parseInt(clientAddr.toString().split(":")[1]);
            BungeeCordPE.PORT += 1;
            socket = new DatagramSocket(BungeeCordPE.PORT);
            server.getLogger().debug("Opened connection to "+serverAddress.toString());
            while (running && (!isInterrupted())) {
                if(timeoutTimes >= 5){
                    break;
                }
                socket.setSoTimeout(2000);

                byte[] recvBuf = new byte[1024 * 1024];
                DatagramPacket dp = new DatagramPacket(recvBuf, recvBuf.length);
                try {
                    socket.receive(dp);
                    dp.setData(Arrays.copyOf(recvBuf, dp.getLength()));
                    handlePacket(dp.getData());
                } catch (SocketTimeoutException e) {
                    timeoutTimes++;
                } catch (IOException e) {
                    server.getLogger().error("IOException: " + e.getMessage());
                    e.printStackTrace();
                }
            }
            server.getLogger().debug("Closed connection to "+serverAddress.toString());
        } catch(SocketException e) {
            server.getLogger().error("SocketException: "+e.getMessage());
            e.printStackTrace();
        }
    }

    public void forwardToServer(byte[] buffer) throws IOException {
        //server.getLogger().debug("Sent to server.");
        if(socket != null) {
            socket.send(new DatagramPacket(buffer, buffer.length, serverAddress));
        }
    }
}
