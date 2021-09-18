package fr.margotfille.cdeqc;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import fr.margotfille.cdeqc.utils.QuestFiles;
import fr.margotfille.cdeqc.utils.configInformations;
import fr.margotfille.cdeqc.utils.configSetup;
import fr.margotfille.cdeqc.utils.langs.ChatColorPlayer;
import fr.margotfille.cdeqc.utils.langs.Lang;

public class SetupCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		/*
		 * Permission verify
		 */
		if(sender instanceof Player) {
			Player p = (Player)sender;
			ChatColorPlayer cp = new ChatColorPlayer(p); 

			if(p.hasPermission("cdeqc.setupcommands") || p.isOp() || p.hasPermission("'*'") || p.hasPermission("cdeqc.setupscommands.all") || p.hasPermission("cdeqc.all")) {

			} else {
				cp.sendMessage(Lang.DONTHAVEPERMISSION.get());
				return true;
			}
		}
		
		if(args.length == 0) {
			return true;
		}
		
		Map<String, Object> ConfigLower = configSetup.getConfigLower();
		Map<String, Object> Informations = configInformations.getInformations();
		Map<String, Object> Config = configSetup.getConfig();
		
		if(args.length == 1) {
			if(ConfigLower.containsKey(args[0].toLowerCase())) {
				if(Informations.containsKey(args[0].toLowerCase())) {
					sender.sendMessage(Informations.get(args[0].toLowerCase()).toString());
				}
				
				sender.sendMessage(Config.get(args[0].toLowerCase()).toString() + " : "  + ChatColor.BOLD + ConfigLower.get(args[0].toLowerCase()).toString());
			}
		}
		
		if(args.length == 2) {
			QuestFiles configname = QuestFiles.CONFIG;
			File configFile = configname.getFile();
			FileConfiguration config = configname.getConfig();
			
			if(ConfigLower.containsKey(args[0].toLowerCase())) {
				try {
					if(Informations.containsKey(args[0].toLowerCase())) {
						sender.sendMessage(Informations.get(args[0].toLowerCase()).toString());
					}
					
					config.set(Config.get(args[0].toLowerCase()).toString(), args[1]);
					config.save(configFile);
					sender.sendMessage(ChatColor.BOLD + Config.get(args[0].toLowerCase()).toString() + ChatColor.RESET + " has been set by the value : " + ChatColor.BOLD + args[1]);
				} catch (IOException e) {
					e.printStackTrace();
					sender.sendMessage("Erreur. Quelque chose cloche...");
				}
			}
			
			return true;
		}
		return false;
	}
}
