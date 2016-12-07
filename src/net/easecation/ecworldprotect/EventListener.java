package net.easecation.ecworldprotect;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;

/**
 * @author Administrator
 */
public class EventListener implements Listener{
    private ECWorldProtect plugin;

    public EventListener(ECWorldProtect plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent ev){

    }
}
