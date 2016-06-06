package me.Thomas.Senpai;

import java.util.HashSet;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.Thomas.Thomas.Main;

public class Senpai implements Listener {
	public static Main plugin;
	
	private HashSet<AIUser> users = new HashSet<AIUser>();
	private HashSet<AIMessage> messages = new HashSet<AIMessage>();
	private final static Random rand = new Random();
	
	static String botprefix = "§7[§e§lBot§7]";
	static String senpaiprefix = "§eSenpai";
	static String chatprefix = "§6§l>§f ";
	
	public Senpai(Main Senpai){
		plugin = Senpai;
		registerMessages();
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerChat1(AsyncPlayerChatEvent event){
		plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
			@Override
			public void run(){
				String message = ChatColor.stripColor(event.getMessage()).replaceAll("[^a-zA-Z\\s]", "").replaceAll("\\s+", " ").toLowerCase();
				if (message.contains("senpai")) {
					for (AIMessage aimsg : messages) {
						aimsg.parse(getUser(event.getPlayer()), aimsg instanceof SenpaiMention ? message : message.replaceAll("senpai", "").trim());
					}
				}
			}
		}, 20L);
	}
	
	private void registerMessages() {
		messages.add(new SenpaiName());
		messages.add(new SenpaiJoke());
		messages.add(new SenpaiCompliment());
		messages.add(new SenpaiInsult());
		messages.add(new SenpaiGender());
		messages.add(new SenpaiApologize());
		messages.add(new SenpaiMention());
	}
	
	private AIUser getUser(Player player) {
		for (AIUser user : users) {
			if (user.isPlayer(player)) {
				return user;
			}
		}
		AIUser newuser = new AIUser(player);
		users.add(newuser);
		return newuser;
	}
	
	public static void chat(String message) {
		Bukkit.broadcastMessage(botprefix + " " + senpaiprefix + " " + chatprefix + message);
	}
	
	public static String replaceNames(String message, AIUser user) {
		return message.replaceAll("%p",ChatColor.GOLD+user.toPlayer().getName()).replaceAll("%n", ChatColor.GOLD+user.getName());
	}
	
	public static String choosePhrase(String[] phrases) {
		return phrases[rand.nextInt(phrases.length)];
	}
	
	public static boolean randomBoolean() {
		return rand.nextBoolean();
	}
	
	public static void log(String message) {
		Bukkit.getLogger().info(message);
	}
}
