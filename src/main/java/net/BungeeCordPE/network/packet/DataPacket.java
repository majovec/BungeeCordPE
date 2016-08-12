package net.BungeeCordPE.BungeeCordPE.network.packet;

import net.BungeeCordPE.BungeeCordPE.util.ProxyException;
import net.BungeeCordPE.BungeeCordPE.util.BinaryStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

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

public abstract class DataPacket extends BinaryStream {

    protected void _encode() {
        throw new UnsupportedOperationException("Encoding not implemented.");
    }
    protected void _decode() {
        throw new UnsupportedOperationException("Decoding not implemented.");
    }

    public byte[] encode(){
        _encode();
        return this.buffer;
    }

    public void decode(byte[] data){
        this.buffer = data;
        this.offset = 2;
        _decode();
    }
}
