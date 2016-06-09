/*
 *
 *______                             _____               _______ _____ 
 *| ___ \                           /  __ \             | | ___ \  ___|
 *| |_/ /_   _ _ __   __ _  ___  ___| /  \/ ___  _ __ __| | |_/ / |__  
 *| ___ \ | | | '_ \ / _` |/ _ \/ _ \ |    / _ \| '__/ _` |  __/|  __| 
 *| |_/ / |_| | | | | (_| |  __/  __/ \__/\ (_) | | | (_| | |   | |___ 
 *\____/ \__,_|_| |_|\__, |\___|\___|\____/\___/|_|  \__,_\_|   \____/ 
 *                  __/ |                                            
 *                  |___/                                             
 *
 * This program is free software, and it's under the  Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 , You can modify. But 
 * you may not import the material for commercial purposes. 
 *
 * @author BukkitPE Team
 * @link http://www.bukkitpe.net/
 *
 *
*/

package net.BukkitPE.BungeeCordPE;

import net.BukkitPE.plugin.PluginBase;
import net.BukkitPE.event.player.PlayerRespawnEvent;
import net.BukkitPE.event.player.PlayerPreLoginEvent;
import net.BukkitPE.utils.Config;
import net.BukkitPE.event.Listener;
import net.BukkitPE.network.protocol.ProtocolInfo;

public class BungeeCordPE extends PluginBase implements Listener{
    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        this.saveDefaultConfig();
        this.getLogger().info("BungeeCordPE has been enabled");
    }
    
    @Override
    public void onDisable(){
        this.getLogger().info("BungeeCordPE has been disabled");
    }
}
