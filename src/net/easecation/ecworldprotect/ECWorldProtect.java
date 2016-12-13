package net.easecation.ecworldprotect;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Level;
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

    public DataProvider getDataProvider(){
        return this.dataProvider;
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
                switch (args[0]){
                    case "add":
                        if(args.length == 3){
                            if(this.getServer().getLevelByName(args[1]) != null){
                                Level level = this.getServer().getLevelByName(args[1]);
                                boolean result = this.dataProvider.addLevel(level, this.dataProvider.getPermByName(args[2]));
                                if(result){
                                    sender.sendMessage(TextFormat.GREEN + "Level '" + level.getFolderName() + "' default perm " + args[2]);
                                }else{
                                    sender.sendMessage(TextFormat.RED + "Failed to add Level '" + level.getFolderName() + "'.");
                                }
                                return true;
                            }else{
                                sender.sendMessage(TextFormat.RED + "Level '" + args[1] + "' not found.");
                                return true;
                            }
                        }
                        if(args.length == 4){
                            if(this.getServer().getLevelByName(args[1]) != null && this.getServer().getPlayer(args[2]) != null){
                                Level level = this.getServer().getLevelByName(args[1]);
                                Player player = this.getServer().getPlayer(args[2]);
                                boolean result = this.dataProvider.addPlayer(level, player, this.dataProvider.getPermByName(args[2]));
                                if(result){
                                    sender.sendMessage(TextFormat.GREEN + "Added perm Level '" + level.getFolderName() + "' default perm " + args[2]);//TODO
                                }else{
                                    sender.sendMessage(TextFormat.RED + "Failed to add Level '" + level.getFolderName() + "'.");
                                }
                                return true;
                            }else{
                                sender.sendMessage(TextFormat.RED + "Level '" + args[1] + "' not found.");
                                return true;
                            }
                        }
                        return false;
                    case "remove":
                        break;
                    case "list":
                        break;
                    default:
                        return false;
                }
                break;
        }
        return true;
    }
}