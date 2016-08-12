package net.BungeeCordPE.BungeeCordPE.network.packet;

import java.io.IOException;
import java.util.UUID;

import net.BungeeCordPE.BungeeCordPE.BungeeCordPE;
import net.BungeeCordPE.BungeeCordPE.util.*;

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

public class LoginPacket extends DataPacket{

    public String username;

    public int protocol;
    public int protocol2;

    public long clientID;
    public UUID clientUUID;

    public String serverAddress;
    public String clientSecret;

    public String skinName;
    public byte[] skin;

    public boolean isCorrect;

    @Override
    protected void _decode() {
        try{
            this.username = this.getString();
            this.protocol = this.getInt();
            this.protocol2 = this.getInt();
            this.clientID = this.getLong();
            this.clientUUID = this.getUUID();
            this.serverAddress = this.getString();
            this.clientSecret = this.getString();
            this.skinName = this.getString();
            this.skin = this.get(this.getShort());
            this.isCorrect = true;
        } catch(ArrayIndexOutOfBoundsException e){
            BungeeCordPE.SERVER_INSTANCE.getLogger().error("Not correct LoginPacket received!");
            this.isCorrect = false;
        }
    }

    @Override
    protected void _encode() {
        this.reset();
        this.putString(this.username);
        this.putInt(this.protocol);
        this.putInt(this.protocol2);
        this.putLong(this.clientID);
        this.putUUID(this.clientUUID);
        this.putString(this.serverAddress);
        this.putString(this.clientSecret);
        this.putString(this.skinName);
        this.putShort(this.skin.length);
        this.put(this.skin);
    }
}
