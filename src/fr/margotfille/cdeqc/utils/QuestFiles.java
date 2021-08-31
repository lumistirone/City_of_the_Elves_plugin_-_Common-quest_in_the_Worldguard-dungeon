package fr.margotfille.cdeqc.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import fr.margotfille.cdeqc.main;

public enum QuestFiles {
	CONFIG("config.yml"),
	LANG("lang.yml");

	private final String fileName;
	private final File dataFolder;
	
	/*
	 * Constructor
	 */
	QuestFiles(String fileName) {
		this.fileName = fileName;
		this.dataFolder = main.INSTANCE.getDataFolder();
	}
	
	/*
	 * Get File
	 */
	public File getFile() {
		return new File(dataFolder, fileName);
	}
	
	/*
	 * Get config
	 */
	public FileConfiguration getConfig() {
		return YamlConfiguration.loadConfiguration(getFile());
	}
	
	/*
	 * Save the file
	 */
	public void saveFile(FileConfiguration config) {
		try {
			config.save(getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Get the file's name
	 */
	public String getFileName() {
		return fileName;
	}
	
	/*
	 * Configuration file creation
	 */
	public void create(Logger logger) {
		if(fileName == null || fileName.isEmpty()) {
			throw new IllegalArgumentException("resourcePath ne peux pas être null ou vide");
		}
		
		InputStream in = main.INSTANCE.getResource(fileName);
		if(in == null) {
			throw new IllegalArgumentException("La ressource n'a pas été trouvé : " + fileName + " dans le plugin");
		}
		
		if(!dataFolder.exists() && !dataFolder.mkdir()) {
			main.INSTANCE.getLogger().severe("Création du plugin échouée.");
		}
		
		File outFile = getFile();
		
		if(!outFile.exists()) {
			try {
				main.INSTANCE.getLogger().info("Le fichier n'existe pas, nous le créons donc...");
				OutputStream out = new FileOutputStream(outFile);
				byte[] buf = new byte[1024];
				int n;
				
				while((n = in.read(buf)) >= 0) {
					out.write(buf, 0, n);
				}
				
				out.close();
				in.close();
				
				if(!outFile.exists()) {
					main.INSTANCE.getLogger().severe("On ne peut pas copier l'élément.");
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}