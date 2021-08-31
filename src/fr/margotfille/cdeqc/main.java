package fr.margotfille.cdeqc;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.CustomClassLoaderConstructor;
import org.yaml.snakeyaml.introspector.BeanAccess;

import fr.margotfille.cdeqc.utils.LobbyBoard;
import fr.margotfille.cdeqc.utils.QuestFiles;
import fr.margotfille.cdeqc.utils.QuestState;
import fr.margotfille.cdeqc.utils.ServerQuest;
import fr.margotfille.cdeqc.utils.Settings;
import fr.margotfille.cdeqc.utils.langs.ChatColorMessage;
import fr.margotfille.cdeqc.utils.langs.Lang;
import fr.margotfille.cdeqc.utils.langs.LangValues;

public class main extends JavaPlugin implements org.bukkit.event.Listener {
	public static main INSTANCE;
	private Settings settings;
	private int taskID;

	int ingredient1 = 0;
	int ingredient2 = 0;
	int ingredient3 = 0;
	
	//ArrayList for all Players in the dungeon
	public static List<Player> PlayerInDungeon = new ArrayList<Player>();

	public void onEnable() {
		INSTANCE = this;
		
		/*
		 * Config file
		 */
		QuestFiles config = QuestFiles.CONFIG;
		config.create(getLogger());
		
		try (final Reader reader = Files.newBufferedReader(config.getFile().toPath(), StandardCharsets.UTF_8)) {
			final Yaml yaml = new Yaml(new CustomClassLoaderConstructor(getClassLoader()));
			yaml.setBeanAccess(BeanAccess.FIELD);

			settings = yaml.loadAs(reader, Settings.class);
			getLogger().info("Le fichier de configuration a été lu avec succès !");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * Lang file
		 */
		QuestFiles lang = QuestFiles.LANG;
		lang.create(getLogger());
		
		/*
		 * Set State
		 */
		ServerQuest.setState(QuestState.NOTSTART);
		
		/*
		 * Bukkit Commands
		 */
		getCommand("grabblocksquest").setExecutor(new GrabQuestCommand());
		
		/*
		 * Bukkit Listeners
		 */
		this.getServer().getPluginManager().registerEvents(new PlayerEnterListener(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerLeftListener(), this);

		this.getServer().getPluginManager().registerEvents(new NPCRightClickListener(), this);

		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	/*
	 * Refresh scoreboard
	 */
	public void start(Player p) {
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			LobbyBoard board = new LobbyBoard(p.getUniqueId());
			
			@Override
			public void run() {
				if(!board.hasID())
					board.setID(taskID);

				createBoard(p);
			}
		}, 0, 10);
	}
	
	/*
	 * Delete the scoreboard for the player
	 */
	@EventHandler
    public void onQuit(PlayerQuitEvent e) {
        LobbyBoard board = new LobbyBoard(e.getPlayer().getUniqueId());
        if (board.hasID())
            board.stop();
    }
	
	/*
	 * Scoreboard Management
	 */
	public void createBoard(Player player) {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		Objective obj = board.registerNewObjective("ScoreBoard", "dummy", 
				ChatColorMessage.translateColor(Lang.TITLE.get()));
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		if(!PlayerInDungeon.contains(player)) {
			board.clearSlot(DisplaySlot.SIDEBAR);
			player.setScoreboard(board);
			
	        LobbyBoard boards = new LobbyBoard(player.getUniqueId());
	        if (boards.hasID())
	            boards.stop();
			return;
		}
		
		if(getSettings().getIsBlocked() == false) {
			if(ServerQuest.isState(QuestState.START) || ServerQuest.isState(QuestState.COLLECT)) {
				Score subtitle = obj.getScore(ChatColorMessage.translateColor(Lang.SUB_TITLE.get()));
				subtitle.setScore(3);

				if(!(ingredient1 == getSettings().getIngredient1_number_max())) {
					Score ingredient1score = obj.getScore(Lang.INGREDIENT1SCORE.get()
							.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT1NAME.get())
							.replace(LangValues.DUNGEONS_NAME.toName(), getSettings().getWorldguardZone())
							.replace(LangValues.MAX_QUANTITY.toName(), Integer.toString(getSettings().getIngredient1_number_max()))
							.replace(LangValues.NPC_NAME.toName(), getSettings().getNPCName())
							.replace(LangValues.QUANTITY.toName(), Integer.toString(ingredient1)));
					ingredient1score.setScore(2);
				} else {
					Score ingredient1score = obj.getScore(Lang.INGREDIENT1SCOREFINISH.get()
							.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT1NAME.get())
							.replace(LangValues.DUNGEONS_NAME.toName(), getSettings().getWorldguardZone())
							.replace(LangValues.MAX_QUANTITY.toName(), Integer.toString(getSettings().getIngredient1_number_max()))
							.replace(LangValues.NPC_NAME.toName(), getSettings().getNPCName())
							.replace(LangValues.QUANTITY.toName(), Integer.toString(ingredient1)));
					ingredient1score.setScore(2);
				}
				
				if(!(ingredient2 == getSettings().getIngredient2_number_max())) {
					Score ingredient2score = obj.getScore(Lang.INGREDIENT2SCORE.get()
							.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT2NAME.get())
							.replace(LangValues.DUNGEONS_NAME.toName(), getSettings().getWorldguardZone())
							.replace(LangValues.MAX_QUANTITY.toName(), Integer.toString(getSettings().getIngredient2_number_max()))
							.replace(LangValues.NPC_NAME.toName(), getSettings().getNPCName())
							.replace(LangValues.QUANTITY.toName(), Integer.toString(ingredient2)) + "1".replace("1", " "));
					ingredient2score.setScore(1);
				} else {
					Score ingredient2score = obj.getScore(Lang.INGREDIENT2SCOREFINISH.get()
							.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT2NAME.get())
							.replace(LangValues.DUNGEONS_NAME.toName(), getSettings().getWorldguardZone())
							.replace(LangValues.MAX_QUANTITY.toName(), Integer.toString(getSettings().getIngredient2_number_max()))
							.replace(LangValues.NPC_NAME.toName(), getSettings().getNPCName())
							.replace(LangValues.QUANTITY.toName(), Integer.toString(ingredient2)) + "1".replace("1", " "));
					ingredient2score.setScore(1);
				}
				
				if(!(ingredient3 == getSettings().getIngredient3_number_max())) {
					Score ingredient3score = obj.getScore(Lang.INGREDIENT3SCORE.get()
							.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT3NAME.get())
							.replace(LangValues.DUNGEONS_NAME.toName(), getSettings().getWorldguardZone())
							.replace(LangValues.MAX_QUANTITY.toName(), Integer.toString(getSettings().getIngredient3_number_max()))
							.replace(LangValues.NPC_NAME.toName(), getSettings().getNPCName())
							.replace(LangValues.QUANTITY.toName(), Integer.toString(ingredient3)) + "2".replace("2", "  "));
					ingredient3score.setScore(0);
				} else {
					Score ingredient3score = obj.getScore(Lang.INGREDIENT3SCOREFINISH.get()
							.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT3NAME.get())
							.replace(LangValues.DUNGEONS_NAME.toName(), getSettings().getWorldguardZone())
							.replace(LangValues.MAX_QUANTITY.toName(), Integer.toString(getSettings().getIngredient3_number_max()))
							.replace(LangValues.NPC_NAME.toName(), getSettings().getNPCName())
							.replace(LangValues.QUANTITY.toName(), Integer.toString(ingredient3)) + "2".replace("2", "  "));
					ingredient3score.setScore(0);
				}
				
				player.setScoreboard(board);
			} else {
				board.clearSlot(DisplaySlot.SIDEBAR);
				player.setScoreboard(board);
				
		        LobbyBoard boards = new LobbyBoard(player.getUniqueId());
		        if (boards.hasID())
		            boards.stop();
			}
		} else {
			board.clearSlot(DisplaySlot.SIDEBAR);
			player.setScoreboard(board);
			
	        LobbyBoard boards = new LobbyBoard(player.getUniqueId());
	        if (boards.hasID())
	            boards.stop();
		}
	}
	
	/*
	 * Getter Settings
	 */
	public Settings getSettings() {
		return settings;
	}
}