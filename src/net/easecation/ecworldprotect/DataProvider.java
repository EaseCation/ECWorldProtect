package net.easecation.ecworldprotect;

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

    public boolean addLevel(Level level, int defaultPerm){
        if(this.config.containsValue(level.getFolderName())){

        }
        return true;
    }
}
