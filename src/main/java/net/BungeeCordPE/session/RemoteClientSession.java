package net.BungeeCordPE.BungeeCordPE.session;

import net.BungeeCordPE.BungeeCordPE.MinecraftPEServer;
import net.BungeeCordPE.BungeeCordPE.network.packet.DataPacket;
import net.BungeeCordPE.BungeeCordPE.util.*;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.net.DatagramPacket;
import java.net.SocketAddress;

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

public class RemoteClientSession implements Session{
    private MinecraftPEServer server;
    private SocketAddress address;
    private RemoteServerSession remoteServer;

    private String username;

    private boolean hasSpawned = false;

    public RemoteClientSession(MinecraftPEServer server, SocketAddress address, RemoteServerSession remoteServer){
        this.server = server;
        this.address = address;
        this.remoteServer = remoteServer;
    }

    @Override
    public void handlePacket(byte[] buffer) {
        byte[] buf = server.getPacketIntercepter().interceptPacket(buffer, this, true);
        //server.getLogger().debug("Forwarded packet "+buffer[0]+" to ");
        try {
            remoteServer.forwardToServer(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void forwardToClient(byte[] buffer){
        byte[] buf = server.getPacketIntercepter().interceptPacket(buffer, this, false);
        DatagramPacket dp = new DatagramPacket(buf, buf.length, address);
        try {
            server.sendPacket(dp);
            //server.getLogger().debug("Forwarded packet to client.");
        } catch (IOException e) {
            throw new ProxyException(e);
        }
    }

    @Override
    public SocketAddress getAddress() {
        return address;
    }

    public boolean hasSpawned(){
        return hasSpawned;
    }

    public RemoteServerSession getRemoteServer(){
        return remoteServer;
    }

    public String getUsername(){
        return username;
    }

    public void setSpawned(boolean spawned){
        hasSpawned = spawned;
    }

    public void setUsername(String username){
        this.username = username;
    }
}
