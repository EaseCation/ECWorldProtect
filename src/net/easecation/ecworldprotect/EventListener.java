package net.easecation.ecworldprotect;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.entity.EntityLevelChangeEvent;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.event.player.PlayerTeleportEvent;

/**
 * @author PeratX
 */
public class EventListener implements Listener{
    private ECWorldProtect plugin;

    public EventListener(ECWorldProtect plugin){
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockBreak(BlockBreakEvent ev){
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onInteract(PlayerInteractEvent ev){
        if(!this.plugin.getDataProvider().hasPermission(ev.getBlock().getLevel(), ev.getPlayer(), ECWorldProtect.WORLD_PERM_EDIT)){
            ev.setCancelled();
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onTeleport(PlayerTeleportEvent ev){
        if(!this.plugin.getDataProvider().hasPermission(ev.getTo().getLevel(), ev.getPlayer(),ECWorldProtect.WORLD_PERM_VIEW)){
            ev.setCancelled();
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onEntityLevelChange(EntityLevelChangeEvent ev){
        if(ev.getEntity() instanceof Player){
            if(!this.plugin.getDataProvider().hasPermission(ev.getTarget(), (Player) ev.getEntity(), ECWorldProtect.WORLD_PERM_VIEW)){
                ev.setCancelled();
            }
        }
    }
}
