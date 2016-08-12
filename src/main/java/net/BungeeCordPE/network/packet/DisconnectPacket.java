package net.BungeeCordPE.BungeeCordPE.network.packet;

import java.io.IOException;

import net.BungeeCordPE.BungeeCordPE.BungeeCordPE;

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

public class DisconnectPacket extends DataPacket{
    public String message;
    public boolean isCorrect;

    @Override
    protected void _decode() {
        this.message = this.getString();
        this.isCorrect = true;
    }

    @Override
    protected void _encode() {
        this.reset();
        this.putString(this.message);
    }
}
