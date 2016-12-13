package net.easecation.ecworldprotect;

import cn.nukkit.Player;
import cn.nukkit.level.Level;
import cn.nukkit.utils.Config;

import java.util.LinkedHashMap;

/**
 * @author PeratX
 */
public class DataProvider {
    private Config conf;
    private LinkedHashMap<String, Object> config;

    public DataProvider(String file){
        this.conf = new Config(file, Config.YAML);
        this.config = (LinkedHashMap<String, Object>)this.conf.getAll();
    }

    public void save(){
        this.conf.setAll(this.config);
        this.conf.save();
    }

    public int getPermByName(String name){
        switch (name){
            case "0":
            case "none":
                return ECWorldProtect.WORLD_PERM_NONE;
            case "1":
            case "view":
                return ECWorldProtect.WORLD_PERM_VIEW;
            case "2":
            case "edit":
                return ECWorldProtect.WORLD_PERM_EDIT;
            default:
                return ECWorldProtect.WORLD_PERM_NONE;
        }
    }

    public void checkData(){

    }

    public boolean hasPermission(Level level, Player player, int permLevel){
        return true;
    }

    public boolean addLevel(Level level, int defaultPerm){
        this.checkData();
        if(this.config.containsValue(level.getFolderName())){
            if(this.config.get(level.getFolderName()) instanceof LinkedHashMap){
                LinkedHashMap<String, Object> worldConfig = (LinkedHashMap) this.conf.get(level.getFolderName());
                if(worldConfig.containsValue("default-perm")){
                    worldConfig.put("default-perm", defaultPerm);
                }
            }
        }
        return true;
    }

    public boolean removeLevel(Level level){
        this.checkData();
        return true;
    }

    public boolean addPlayer(Level level, Player player, int permission){
        this.checkData();
        return true;
    }

    public boolean removePlayer(Level level, Player player){
        this.checkData();
        return true;
    }
}
