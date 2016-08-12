package net.BungeeCordPE.session;

import java.net.SocketAddress;

/**
 * Created by Proxy on 3/24/2015.
 */
public interface Session {
    void handlePacket(byte[] buffer);
    SocketAddress getAddress();
}
