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

	private static QuestFiles INSTANCEFiles;
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
	 * Get Instance
	 */
	public static QuestFiles getInstanceFiles() {
		return INSTANCEFiles;
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
			throw new IllegalArgumentException("resourcePath ne peux pas Ítre null ou vide");
		}
		
		InputStream in = main.INSTANCE.getResource(fileName);
		if(in == null) {
			throw new IllegalArgumentException("La ressource n'a pas ÈtÈ trouvÈe : " + fileName + " dans le plugin");
		}
		
		if(!dataFolder.exists() && !dataFolder.mkdir()) {
			main.INSTANCE.getLogger().severe("CrÈation du plugin ÈchouÈe.");
		}
		
		File outFile = getFile();
		
		if(!outFile.exists()) {
			try {
				main.INSTANCE.getLogger().info("Le fichier n'existe pas, nous le cr√©ons donc...");
				OutputStream out = new FileOutputStream(outFile);
				byte[] buf = new byte[1024];
				int n;
				
				while((n = in.read(buf)) >= 0) {
					out.write(buf, 0, n);
				}
				
				out.close();
				in.close();
				
				if(!outFile.exists()) {
					main.INSTANCE.getLogger().severe("On ne peut pas copier l'√©l√©ment.");
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}