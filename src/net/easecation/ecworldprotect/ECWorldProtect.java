package net.easecation.ecworldprotect;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

class ECWorldProtect extends PluginBase{
    private Config config;

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new EventListener(this), this);
        this.getLogger().notice("ECWorldProject has been enabled.");
    }
}