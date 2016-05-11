?php

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
 * you may not use the material for commercial purposes. 
 *
 * @author BukkitPE Team
 * @link http://www.bukkitpe.net/
 *
 *
*/

namespace BungeeCord;

use BukkitPE\plugin\PluginBase;
use BukkitPE\event\player\PlayerRespawnEvent;
use BukkitPE\event\player\PlayerPreLoginEvent;
use BukkitPE\utils\Config;
use BukkitPE\event\Listener;
use BukkitPE\network\protocol\Info;

class Main extends PluginBase implements Listener{

public function onEnable() {
        $this->getServer()->getPluginManager()->registerEvents($this, $this);
        $this->config = (new Config($this->getDataFolder()."Config.yml", Config::YAML))->getAll();
        $this->saveDefaultConfig();
        $this->getLogger()->info("BungeeCordPE has been enabled");
}
public function onDisable(){
        $this->getLogger()->info("BungeeCordPE has been disabled");
}
}
