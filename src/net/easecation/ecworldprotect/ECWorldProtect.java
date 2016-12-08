package net.easecation.ecworldprotect;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;

/**
 * @author PeratX
 */
class ECWorldProtect extends PluginBase{
    public static int WORLD_PERM_NONE = 0;
    public static int WORLD_PERM_VIEW = 1;
    public static int WORLD_PERM_EDIT = 2;

    private DataProvider dataProvider;

    @Override
    public void onEnable() {
        this.dataProvider = new DataProvider(this.getDataFolder() + "config.yml");
        this.getServer().getPluginManager().registerEvents(new EventListener(this), this);
        this.getLogger().info(TextFormat.GREEN + "ECWorldProject has been enabled.");
    }

    @Override
    public void onDisable() {
        this.dataProvider.save();
        this.getLogger().info(TextFormat.RED + "ECWorldProtect has been disabled.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        switch (command.getName()){
            case "ecwp":
                if(!command.testPermission(sender)){
                    break;
                }
                if(args.length < 3){
                    return false;
                }
                break;
        }
        return true;
    }
}