package net.BungeeCordPE.BungeeCordPE.network.packet;

import java.io.IOException;

import net.BungeeCordPE.BungeeCordPE.BungeeCordPE;

/**
 * MCPE Disconnect Packet (0x92).
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
