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
import static net.BungeeCordPE.Proxy.jraklibplus.JRakLibPlus.*;

/**
 * ID_INCOMPATIBLE_PROTOCOL_VERSION Packet implementation.
 *
 * @author RedstoneLamp Team
 */
public class IncompatibleProtocolVersionPacket extends RakNetPacket {

    public byte protocolVersion;
    public long serverID;

    @Override
    protected void _encode(Buffer buffer) {
        buffer.putByte(protocolVersion);
        buffer.put(RAKNET_MAGIC);
        buffer.putLong(serverID);
    }

    @Override
    protected void _decode(Buffer buffer) {
        protocolVersion = buffer.getByte();
        buffer.skip(16); //MAGIC
        serverID = buffer.getLong();
    }

    @Override
    public byte getPID() {
        return ID_INCOMPATIBLE_PROTOCOL_VERSION;
    }

    @Override
    public int getSize() {
        return 26;
    }
}