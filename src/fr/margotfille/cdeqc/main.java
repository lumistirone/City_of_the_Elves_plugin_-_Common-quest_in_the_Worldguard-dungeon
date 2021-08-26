package fr.margotfille.cdeqc;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
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
import fr.margotfille.cdeqc.utils.langs.Lang;
import fr.margotfille.cdeqc.utils.langs.LangValues;

public class main extends JavaPlugin implements org.bukkit.event.Listener {
	public static main INSTANCE;
	private Settings settings;
	private int taskID;

	int ingredient1 = 0;
	int ingredient2 = 0;
	int ingredient3 = 0;

	public static List<Player> PlayerInDungeon = new ArrayList<Player>();

	public void onEnable() {
		INSTANCE = this;

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

		QuestFiles lang = QuestFiles.LANG;
		lang.create(getLogger());

		ServerQuest.setState(QuestState.NOTSTART);

		getCommand("grabblocksquest").setExecutor(new GrabQuestCommand());

		this.getServer().getPluginManager().registerEvents(new PlayerEnterListener(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerLeftListener(), this);

		this.getServer().getPluginManager().registerEvents(new NPCRightClickListener(), this);

		this.getServer().getPluginManager().registerEvents(this, this);

		if(!Bukkit.getOnlinePlayers().isEmpty())
			for(Player online : Bukkit.getOnlinePlayers())
				createBoard(online);
	}

	public void onDisable() {

	}
	
	public void start(Player p) {
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			LobbyBoard board = new LobbyBoard(p.getUniqueId());
			
			public void run() {
				if(!board.hasID()) board.setID(taskID);
				
				Objective obj = p.getScoreboard().getObjective(DisplaySlot.SIDEBAR);

				obj.setDisplayName(ChatColor.translateAlternateColorCodes('&', Lang.TITLE.get()));

				Score score = obj.getScore(ChatColor.translateAlternateColorCodes('&', Lang.SUB_TITLE.get()));
				score.setScore(4);

				Score score1 = obj.getScore(ChatColor.translateAlternateColorCodes('&', Lang.INGREDIENT1SCORE.get()
						.replace(LangValues.QUANTITY.toName(), Integer.toString(ingredient1))
						.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT1NAME.get())));
				score1.setScore(3);

				Score score2 = obj.getScore(ChatColor.translateAlternateColorCodes('&', Lang.INGREDIENT2SCORE.get()
						.replace(LangValues.QUANTITY.toName(), Integer.toString(ingredient2))
						.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT2NAME.get())));
				score2.setScore(2);

				Score score3 = obj.getScore(ChatColor.translateAlternateColorCodes('&', Lang.INGREDIENT3SCORE.get()
						.replace(LangValues.QUANTITY.toName(), Integer.toString(ingredient3))
						.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT3NAME.get())));

				score3.setScore(1);
			}
		}, 0, 10);
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {	
		Player p = e.getPlayer();

		createBoard(p);
		start(p);
	}

	@EventHandler
    public void onQuit(PlayerQuitEvent e) {
        LobbyBoard board = new LobbyBoard(e.getPlayer().getUniqueId());
        if (board.hasID())
            board.stop();
    }

	public void createBoard(Player p) {

		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard scoreboard = manager.getNewScoreboard();
		Objective obj = scoreboard.getObjective(DisplaySlot.SIDEBAR);

		obj.setDisplayName(ChatColor.translateAlternateColorCodes('&', Lang.TITLE.get()));

		Score score = obj.getScore(ChatColor.translateAlternateColorCodes('&', Lang.SUB_TITLE.get()));

		score.setScore(4);

		Score score1 = obj.getScore(ChatColor.translateAlternateColorCodes('&', Lang.INGREDIENT1SCORE.get()
								.replace(LangValues.QUANTITY.toName(), Integer.toString(ingredient1))
								.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT1NAME.get())));

		score1.setScore(3);

		Score score2 = obj.getScore(ChatColor.translateAlternateColorCodes('&', Lang.INGREDIENT2SCORE.get()
				.replace(LangValues.QUANTITY.toName(), Integer.toString(ingredient2))
				.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT2NAME.get())));

		score2.setScore(2);

		Score score3 = obj.getScore(ChatColor.translateAlternateColorCodes('&', Lang.INGREDIENT3SCORE.get()
				.replace(LangValues.QUANTITY.toName(), Integer.toString(ingredient3))
				.replace(LangValues.INGREDIENT_NAME.toName(), Lang.INGREDIENT3NAME.get())));

		score3.setScore(1);
	}
	
	public Settings getSettings() {
		return settings;
	}
}