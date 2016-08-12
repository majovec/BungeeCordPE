package net.BungeeCordPE.BungeeCordPE.util;

import java.nio.ByteBuffer;

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

public class Util {

    public static String toHex(byte... bytes){
        String returnString = "";
        for(byte b: bytes){
            returnString = returnString + String.format("%02x", b) + " ";
        }

        return returnString;
    }

    public static boolean inArray(byte needle, byte[] haystack){
        for(byte item : haystack){
            if(item == needle){
                return true;
            }
        }
        return false;
    }

    public static int readLTriad(ByteBuffer bb){
        byte[] triad = new byte[3];
        bb.get(triad);
        return readLTriad(triad);
    }

    public static int readLTriad(byte[] triad){
        return triad[0]
                + (triad[1] << 8)
                + (triad[2] << 16);
    }
}
