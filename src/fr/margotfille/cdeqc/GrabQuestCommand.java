package fr.margotfille.cdeqc;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.margotfille.cdeqc.utils.QuestState;
import fr.margotfille.cdeqc.utils.ServerQuest;
import fr.margotfille.cdeqc.utils.langs.ChatColorPlayer;
import fr.margotfille.cdeqc.utils.langs.Lang;
import fr.margotfille.cdeqc.utils.langs.LangValues;

public class GrabQuestCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		/*
		 * Permission verify
		 */
		if(sender instanceof Player) {
			Player p = (Player)sender;
			ChatColorPlayer cp = new ChatColorPlayer(p); 

			if(p.hasPermission("cdeqc.grabscommands") || p.isOp() || p.hasPermission("'*'") || p.hasPermission("cdeqc.grabscommands.all") || p.hasPermission("cdeqc.all")) {
				
			} else {
				cp.sendMessage(Lang.DONTHAVEPERMISSION.get());
				return true;
			}
		}
		
		/*
		 * If is not start
		 */
		if(ServerQuest.isState(QuestState.NOTSTART) || ServerQuest.isState(QuestState.COLLECT)) {
			return true;
		}

		/*
		 * Ingredient add
		 */
		if(args.length == 1) {
			
			/*
			 * Ingredient 1
			 */
			if(args[0].equalsIgnoreCase("1")) {
				main.INSTANCE.ingredient1++;
				
				if((main.INSTANCE.ingredient1 + main.INSTANCE.ingredient2 + main.INSTANCE.ingredient3) >= (main.INSTANCE.getSettings().getIngredient1_number_max() + main.INSTANCE.getSettings().getIngredient2_number_max() + main.INSTANCE.getSettings().getIngredient3_number_max())) {
					if((main.INSTANCE.ingredient1 + main.INSTANCE.ingredient2 + main.INSTANCE.ingredient3) > (main.INSTANCE.getSettings().getIngredient1_number_max() + main.INSTANCE.getSettings().getIngredient2_number_max() + main.INSTANCE.getSettings().getIngredient3_number_max())) {
						main.INSTANCE.ingredient1 = main.INSTANCE.getSettings().getIngredient1_number_max();
						
						return true;
					}
					ServerQuest.setState(QuestState.COLLECT);
					
					ServerQuest.sendMessagePlayers(Lang.IHAVE_ALL_INGREDIENTS.get()
							.replace(LangValues.QUANTITY.toName(), Integer.toString((main.INSTANCE.ingredient1 + main.INSTANCE.ingredient2 + main.INSTANCE.ingredient3 + 1)))
							.replace(LangValues.MAX_QUANTITY.toName(), Integer.toString((main.INSTANCE.getSettings().getIngredient1_number_max() + main.INSTANCE.getSettings().getIngredient2_number_max() + main.INSTANCE.getSettings().getIngredient3_number_max())))
							.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT1NAME.get())
							.replace(LangValues.NPC_NAME.toName(), main.INSTANCE.getSettings().getNPCName()));
					return true;
				}
				
				if(main.INSTANCE.ingredient1 >= main.INSTANCE.getSettings().getIngredient1_number_max()) {
					if(main.INSTANCE.ingredient1 > main.INSTANCE.getSettings().getIngredient1_number_max()) {
						main.INSTANCE.ingredient1 = main.INSTANCE.getSettings().getIngredient1_number_max();
						return true;
					}
					
					if(main.INSTANCE.getSettings().getIhaveAllIngredientsInCategories()) {
						ServerQuest.sendMessagePlayers(Lang.IHAVE_ALL_INGREDIENTS_IN_CATEGORIE.get()
								.replace(LangValues.QUANTITY.toName(), Integer.toString(main.INSTANCE.ingredient1))
								.replace(LangValues.MAX_QUANTITY.toName(), Integer.toString(main.INSTANCE.getSettings().getIngredient1_number_max()))
								.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT1NAME.get())
								.replace(LangValues.NPC_NAME.toName(), main.INSTANCE.getSettings().getNPCName()));
					}
					
					return true;
				}
				
				
				ServerQuest.sendMessagePlayers(Lang.MORE_INGREDIENTS.get()
						.replace(LangValues.QUANTITY.toName(), Integer.toString(main.INSTANCE.ingredient1))
						.replace(LangValues.MAX_QUANTITY.toName(), Integer.toString(main.INSTANCE.getSettings().getIngredient1_number_max()))
						.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT1NAME.get())
						.replace(LangValues.NPC_NAME.toName(), main.INSTANCE.getSettings().getNPCName()));
				
				return true;
				
				/*
				 * Ingredient 2
				 */
			} else if(args[0].equalsIgnoreCase("2")) {
				main.INSTANCE.ingredient2++;
				
				if((main.INSTANCE.ingredient1 + main.INSTANCE.ingredient2 + main.INSTANCE.ingredient3) >= (main.INSTANCE.getSettings().getIngredient1_number_max() + main.INSTANCE.getSettings().getIngredient2_number_max() + main.INSTANCE.getSettings().getIngredient3_number_max())) {
					if((main.INSTANCE.ingredient1 + main.INSTANCE.ingredient2 + main.INSTANCE.ingredient3) > (main.INSTANCE.getSettings().getIngredient1_number_max() + main.INSTANCE.getSettings().getIngredient2_number_max() + main.INSTANCE.getSettings().getIngredient3_number_max())) {
						main.INSTANCE.ingredient2 = main.INSTANCE.getSettings().getIngredient1_number_max();
						
						return true;
					}
					ServerQuest.setState(QuestState.COLLECT);
					
					ServerQuest.sendMessagePlayers(Lang.IHAVE_ALL_INGREDIENTS.get()
							.replace(LangValues.QUANTITY.toName(), Integer.toString((main.INSTANCE.ingredient1 + main.INSTANCE.ingredient2 + main.INSTANCE.ingredient3 + 1)))
							.replace(LangValues.MAX_QUANTITY.toName(), Integer.toString((main.INSTANCE.getSettings().getIngredient2_number_max() + main.INSTANCE.getSettings().getIngredient2_number_max() + main.INSTANCE.getSettings().getIngredient3_number_max())))
							.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT2NAME.get())
							.replace(LangValues.NPC_NAME.toName(), main.INSTANCE.getSettings().getNPCName()));
					return true;
				}
				
				if(main.INSTANCE.ingredient2 >= main.INSTANCE.getSettings().getIngredient2_number_max()) {
					if(main.INSTANCE.ingredient2 > main.INSTANCE.getSettings().getIngredient2_number_max()) {main.INSTANCE.ingredient2 = main.INSTANCE.getSettings().getIngredient2_number_max();return true;}
					
					main.INSTANCE.ingredient2 = main.INSTANCE.getSettings().getIngredient2_number_max();
					
					if(main.INSTANCE.getSettings().getIhaveAllIngredientsInCategories()) {
						ServerQuest.sendMessagePlayers(Lang.IHAVE_ALL_INGREDIENTS_IN_CATEGORIE.get()
								.replace(LangValues.QUANTITY.toName(), Integer.toString(main.INSTANCE.ingredient2))
								.replace(LangValues.MAX_QUANTITY.toName(), Integer.toString(main.INSTANCE.getSettings().getIngredient2_number_max()))
								.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT2NAME.get())
								.replace(LangValues.NPC_NAME.toName(), main.INSTANCE.getSettings().getNPCName()));
					}
					
					return true;
				}
				
				
				ServerQuest.sendMessagePlayers(Lang.MORE_INGREDIENTS.get()
						.replace(LangValues.QUANTITY.toName(), Integer.toString(main.INSTANCE.ingredient2))
						.replace(LangValues.MAX_QUANTITY.toName(), Integer.toString(main.INSTANCE.getSettings().getIngredient2_number_max()))
						.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT2NAME.get())
						.replace(LangValues.NPC_NAME.toName(), main.INSTANCE.getSettings().getNPCName()));
				
				return true;
				
				/*
				 * Ingredient 3
				 */
			} else if(args[0].equalsIgnoreCase("3")) {
				main.INSTANCE.ingredient3++;
				
				if((main.INSTANCE.ingredient1 + main.INSTANCE.ingredient2 + main.INSTANCE.ingredient3) >= (main.INSTANCE.getSettings().getIngredient1_number_max() + main.INSTANCE.getSettings().getIngredient2_number_max() + main.INSTANCE.getSettings().getIngredient3_number_max())) {
					if((main.INSTANCE.ingredient1 + main.INSTANCE.ingredient2 + main.INSTANCE.ingredient3) > (main.INSTANCE.getSettings().getIngredient1_number_max() + main.INSTANCE.getSettings().getIngredient2_number_max() + main.INSTANCE.getSettings().getIngredient3_number_max())) {
						main.INSTANCE.ingredient3 = main.INSTANCE.getSettings().getIngredient3_number_max();
						
						return true;
					}
					ServerQuest.setState(QuestState.COLLECT);
					
					ServerQuest.sendMessagePlayers(Lang.IHAVE_ALL_INGREDIENTS.get()
							.replace(LangValues.QUANTITY.toName(), Integer.toString((main.INSTANCE.ingredient1 + main.INSTANCE.ingredient2 + main.INSTANCE.ingredient3 + 1)))
							.replace(LangValues.MAX_QUANTITY.toName(), Integer.toString((main.INSTANCE.getSettings().getIngredient3_number_max() + main.INSTANCE.getSettings().getIngredient2_number_max() + main.INSTANCE.getSettings().getIngredient3_number_max())))
							.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT3NAME.get())
							.replace(LangValues.NPC_NAME.toName(), main.INSTANCE.getSettings().getNPCName()));
					return true;
				}
				
				if(main.INSTANCE.ingredient3 >= main.INSTANCE.getSettings().getIngredient3_number_max()) {
					if(main.INSTANCE.ingredient3 > main.INSTANCE.getSettings().getIngredient3_number_max()) {
						main.INSTANCE.ingredient3 = main.INSTANCE.getSettings().getIngredient3_number_max();

						return true;
					}
					
					if(main.INSTANCE.getSettings().getIhaveAllIngredientsInCategories()) {
						ServerQuest.sendMessagePlayers(Lang.IHAVE_ALL_INGREDIENTS_IN_CATEGORIE.get()
								.replace(LangValues.QUANTITY.toName(), Integer.toString(main.INSTANCE.ingredient3))
								.replace(LangValues.MAX_QUANTITY.toName(), Integer.toString(main.INSTANCE.getSettings().getIngredient3_number_max()))
								.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT3NAME.get())
								.replace(LangValues.NPC_NAME.toName(), main.INSTANCE.getSettings().getNPCName()));
					}
					
					return true;
				}
				
				
				ServerQuest.sendMessagePlayers(Lang.MORE_INGREDIENTS.get()
						.replace(LangValues.QUANTITY.toName(), Integer.toString(main.INSTANCE.ingredient3))
						.replace(LangValues.MAX_QUANTITY.toName(), Integer.toString(main.INSTANCE.getSettings().getIngredient3_number_max()))
						.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT3NAME.get())
						.replace(LangValues.NPC_NAME.toName(), main.INSTANCE.getSettings().getNPCName()));
				
				return true;
			}
			return true;
		} else {
			/*
			 * If command have 0 argument
			 */
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
