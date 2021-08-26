package fr.margotfille.cdeqc;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.margotfille.cdeqc.utils.QuestState;
import fr.margotfille.cdeqc.utils.ServerQuest;
import fr.margotfille.cdeqc.utils.langs.Lang;
import fr.margotfille.cdeqc.utils.langs.LangValues;
import net.md_5.bungee.api.ChatColor;

public class GrabQuestCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)  {
		if(sender instanceof Player) {
			Player p = (Player)sender;

			if(p.hasPermission("cdeqc.grabscommands") || p.isOp() || p.hasPermission("'*'") || p.hasPermission("cdeqc.grabscommands.all")) {

			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&fUn &epouvoir magique &fvous &eempêche &fde &efaire &fcela..."));
				return true;
			}
		}
		
		
		if(ServerQuest.isState(QuestState.NOTSTART) || ServerQuest.isState(QuestState.COLLECT)) {
			return true;
		}
		


		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("1")) {
				main.INSTANCE.ingredient1++;
				
				if((main.INSTANCE.ingredient1 + main.INSTANCE.ingredient2 + main.INSTANCE.ingredient3) == (main.INSTANCE.getSettings().getIngredient1_number_max() + main.INSTANCE.getSettings().getIngredient2_number_max() + main.INSTANCE.getSettings().getIngredient3_number_max())) {
					ServerQuest.sendMessagePlayers(Lang.IHAVEALLINGREDIENTS.get()
							.replace(LangValues.QUANTITY.toName(), Integer.toString(main.INSTANCE.ingredient1 + main.INSTANCE.ingredient2 + main.INSTANCE.ingredient3)));
					ServerQuest.setState(QuestState.COLLECT);
					return true;
				}
				
				if(main.INSTANCE.ingredient1 == main.INSTANCE.getSettings().getIngredient1_number_max()) {
					if(main.INSTANCE.getSettings().getAnnonceFullIngredientInCategorie() == true) {
						ServerQuest.sendMessagePlayers(Lang.IHAVEALLINGREDIENTSINCATEGORIE.get()
							.replace(LangValues.QUANTITY.toName(), Integer.toString(main.INSTANCE.ingredient1))
							.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT1NAME.get()));
					}
					return true;
				}
				
				if((main.INSTANCE.ingredient1 + main.INSTANCE.ingredient2 + main.INSTANCE.ingredient3) > (main.INSTANCE.getSettings().getIngredient1_number_max() + main.INSTANCE.getSettings().getIngredient2_number_max() + main.INSTANCE.getSettings().getIngredient3_number_max())) {
					main.INSTANCE.ingredient1 = main.INSTANCE.getSettings().getIngredient1_number_max();
					
					if(main.INSTANCE.getSettings().getBeforeHaveAll() == true) {
						ServerQuest.sendMessagePlayers(Lang.BEFOREHAVEALL.get()
							.replace(LangValues.QUANTITY.toName(), Integer.toString(main.INSTANCE.ingredient1))
							.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT1NAME.get()));
					}
					return true;
				}

				if(main.INSTANCE.ingredient1 > main.INSTANCE.getSettings().getIngredient1_number_max()) {
					main.INSTANCE.ingredient1 = main.INSTANCE.getSettings().getIngredient1_number_max();

					if(main.INSTANCE.getSettings().getBeforeHaveAllInCategorie() == true) {
						ServerQuest.sendMessagePlayers(Lang.BEFOREHAVEALLINCATEGORIE.get()
							.replace(LangValues.QUANTITY.toName(), Integer.toString(main.INSTANCE.ingredient1))
							.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT1NAME.get()));
					}
					return true;
				}
			} else if(args[0].equalsIgnoreCase("2")) {
				main.INSTANCE.ingredient2++;
				
				if((main.INSTANCE.ingredient1 + main.INSTANCE.ingredient2 + main.INSTANCE.ingredient3) == (main.INSTANCE.getSettings().getIngredient1_number_max() + main.INSTANCE.getSettings().getIngredient2_number_max() + main.INSTANCE.getSettings().getIngredient3_number_max())) {
					ServerQuest.sendMessagePlayers(Lang.IHAVEALLINGREDIENTS.get()
							.replace(LangValues.QUANTITY.toName(), Integer.toString(main.INSTANCE.ingredient1 + main.INSTANCE.ingredient2 + main.INSTANCE.ingredient3)));
					ServerQuest.setState(QuestState.COLLECT);
					return true;
				}
				
				if(main.INSTANCE.ingredient2 == main.INSTANCE.getSettings().getIngredient2_number_max()) {
					if(main.INSTANCE.getSettings().getAnnonceFullIngredientInCategorie() == true) {
						ServerQuest.sendMessagePlayers(Lang.IHAVEALLINGREDIENTSINCATEGORIE.get()
							.replace(LangValues.QUANTITY.toName(), Integer.toString(main.INSTANCE.ingredient2))
							.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT2NAME.get()));
					}
					return true;
				}
				
				if((main.INSTANCE.ingredient1 + main.INSTANCE.ingredient2 + main.INSTANCE.ingredient3) > (main.INSTANCE.getSettings().getIngredient1_number_max() + main.INSTANCE.getSettings().getIngredient2_number_max() + main.INSTANCE.getSettings().getIngredient3_number_max())) {
					main.INSTANCE.ingredient2 = main.INSTANCE.getSettings().getIngredient2_number_max();
					
					if(main.INSTANCE.getSettings().getBeforeHaveAll() == true) {
						ServerQuest.sendMessagePlayers(Lang.BEFOREHAVEALL.get()
							.replace(LangValues.QUANTITY.toName(), Integer.toString(main.INSTANCE.ingredient2))
							.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT2NAME.get()));
					}
					return true;
				}

				if(main.INSTANCE.ingredient2 > main.INSTANCE.getSettings().getIngredient2_number_max()) {
					main.INSTANCE.ingredient2 = main.INSTANCE.getSettings().getIngredient2_number_max();

					if(main.INSTANCE.getSettings().getBeforeHaveAllInCategorie() == true) {
						ServerQuest.sendMessagePlayers(Lang.BEFOREHAVEALLINCATEGORIE.get()
							.replace(LangValues.QUANTITY.toName(), Integer.toString(main.INSTANCE.ingredient2))
							.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT2NAME.get()));
					}
					return true;
				}
			} else if(args[0].equalsIgnoreCase("3")) {
				main.INSTANCE.ingredient3++;
				
				if((main.INSTANCE.ingredient1 + main.INSTANCE.ingredient2 + main.INSTANCE.ingredient3) == (main.INSTANCE.getSettings().getIngredient1_number_max() + main.INSTANCE.getSettings().getIngredient2_number_max() + main.INSTANCE.getSettings().getIngredient3_number_max())) {
					ServerQuest.sendMessagePlayers(Lang.IHAVEALLINGREDIENTS.get()
							.replace(LangValues.QUANTITY.toName(), Integer.toString(main.INSTANCE.ingredient1 + main.INSTANCE.ingredient2 + main.INSTANCE.ingredient3)));
					ServerQuest.setState(QuestState.COLLECT);
					return true;
				}
				
				if(main.INSTANCE.ingredient3 == main.INSTANCE.getSettings().getIngredient3_number_max()) {
					if(main.INSTANCE.getSettings().getAnnonceFullIngredientInCategorie() == true) {
						ServerQuest.sendMessagePlayers(Lang.IHAVEALLINGREDIENTSINCATEGORIE.get()
							.replace(LangValues.QUANTITY.toName(), Integer.toString(main.INSTANCE.ingredient3))
							.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT3NAME.get()));
					}
					return true;
				}
				
				if((main.INSTANCE.ingredient1 + main.INSTANCE.ingredient2 + main.INSTANCE.ingredient3) > (main.INSTANCE.getSettings().getIngredient1_number_max() + main.INSTANCE.getSettings().getIngredient2_number_max() + main.INSTANCE.getSettings().getIngredient3_number_max())) {
					main.INSTANCE.ingredient3 = main.INSTANCE.getSettings().getIngredient3_number_max();
					
					if(main.INSTANCE.getSettings().getBeforeHaveAll() == true) {
						ServerQuest.sendMessagePlayers(Lang.BEFOREHAVEALL.get()
							.replace(LangValues.QUANTITY.toName(), Integer.toString(main.INSTANCE.ingredient3))
							.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT3NAME.get()));
					}
					return true;
				}

				if(main.INSTANCE.ingredient3 > main.INSTANCE.getSettings().getIngredient3_number_max()) {
					main.INSTANCE.ingredient3 = main.INSTANCE.getSettings().getIngredient3_number_max();

					if(main.INSTANCE.getSettings().getBeforeHaveAllInCategorie() == true) {
						ServerQuest.sendMessagePlayers(Lang.BEFOREHAVEALLINCATEGORIE.get()
							.replace(LangValues.QUANTITY.toName(), Integer.toString(main.INSTANCE.ingredient3))
							.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT3NAME.get()));
					}
					return true;
				}
			}
			return true;
		} else {
			sender.sendMessage("Error | Argument.error");
			if(!(Bukkit.getOnlinePlayers().isEmpty())) {
				for(Player players : Bukkit.getOnlinePlayers()) {
					if(players.hasPermission("'*'") || players.hasPermission("*") || players.hasPermission("cdeqc.errorinformations") || players.hasPermission("cdeqc.allpermissions")) {
						if(players != sender) {
							players.sendMessage("Error | Argument.error");
						}
					}
				}
			}
		}

		return false;
	}
}
