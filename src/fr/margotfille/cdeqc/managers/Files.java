package fr.margotfille.cdeqc.managers;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import fr.margotfille.cdeqc.main;

public enum Files {

	CONFIG("config.yml"),
    LANG("lang.yml");

    private final String fileName;
    private final File dataFolder;

    Files(String fileName) {
        this.fileName = fileName;
        this.dataFolder = main.getINSTANCE().getDataFolder();
    }

    public File getFile(){
        return new File(dataFolder, fileName);
    }

    public FileConfiguration getConfig(){
        return YamlConfiguration.loadConfiguration(getFile());
    }

    public void save(FileConfiguration config){
        try {
            config.save(getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFileName() {
        return fileName;
    }
	
}
