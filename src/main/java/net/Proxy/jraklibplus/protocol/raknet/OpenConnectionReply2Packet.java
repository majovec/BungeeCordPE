/**
 * JRakLibPlus is not affiliated with Jenkins Software LLC or RakNet.
 * This software is an enhanced port of RakLib https://github.com/PocketMine/RakLib.

 * This file is part of JRakLibPlus.
 *
 * JRakLibPlus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JRakLibPlus is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JRakLibPlus.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.BungeeCordPE.Proxy.jraklibplus.protocol.raknet;

import net.BungeeCordPE.Proxy.jraklibplus.protocol.RakNetPacket;
import net.BungeeCordPE.Proxy.jraklibplus.nio.Buffer;
import net.BungeeCordPE.Proxy.jraklibplus.util.SystemAddress;
import static net.BungeeCordPE.Proxy.jraklibplus.JRakLibPlus.*;

/**
 * ID_OPEN_CONNECTION_REPLY_2 Packet implementation.
 *
 * @author RedstoneLamp Team
 */
public class OpenConnectionReply2Packet extends RakNetPacket {

    public long serverID;
    public SystemAddress clientAddress;
    /**
     * uint16 (unsigned short)
     */
    public int mtuSize;

    @Override
    protected void _encode(Buffer buffer) {
        buffer.put(RAKNET_MAGIC);
        buffer.putLong(serverID);
        buffer.putAddress(clientAddress);
        buffer.putUnsignedShort(mtuSize);
        buffer.putByte((byte) 0); //security
    }

    @Override
    protected void _decode(Buffer buffer) {
        buffer.skip(16); //MAGIC
        serverID = buffer.getLong();
        clientAddress = buffer.getAddress();
        mtuSize = buffer.getUnsignedShort();
        //security
    }

    @Override
    public byte getPID() {
        return ID_OPEN_CONNECTION_REPLY_2;
    }

    @Override
    public int getSize() {
        return 35;
    }
}
