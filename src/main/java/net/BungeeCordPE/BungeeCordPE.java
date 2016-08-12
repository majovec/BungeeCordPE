package net.BungeeCordPE;
import net.BungeeCordPE.util.ProxyException;

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

public class BungeeCordPE implements Runnable{
    public final static String SOFTWARE_VERSION = "v1.1-SNAPSHOT";
    public final static String MCPE_VERSION = "0.15.4";
    public final static int MCPE_PROTOCOL = 82;

    public static MinecraftPEServer SERVER_INSTANCE;
    public static int PORT = 49256;

    private String[] programArgs;

    public BungeeCordPE(String[] args){
        this.programArgs = args;
    }

    public static void main(String[] args){
        BungeeCordPE ball = new BungeeCordPE(args);
        ball.run();
    }

    @Override
    public void run() {
        MinecraftPEServer server = new MinecraftPEServer(19132);
        SERVER_INSTANCE = server;
        server.setRunning(true);
        try {
            server.run();
        } catch (ProxyException e){
            server.getLogger().error("ProxyException: "+e.getMessage());
            e.printStackTrace();
        } catch(Exception e){
            server.getLogger().error("Exception: "+e.getMessage());
            e.printStackTrace();
        }
    }
}
