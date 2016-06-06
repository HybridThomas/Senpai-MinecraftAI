package me.Thomas.Senpai;

import me.Thomas.Thomas.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class SenpaiNoticeMe implements Listener {
	public static Main plugin;
	
	String botprefix = "§7[§e§lBot§7]";
	
	public SenpaiNoticeMe(Main SenpaiNoticeMe){
		plugin = SenpaiNoticeMe;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event){
		final Player player = event.getPlayer();
		if(event.getMessage().toLowerCase().contains("senpai notice me")){
			plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
				@Override
				public void run(){
					Bukkit.broadcastMessage(botprefix + ChatColor.AQUA+" Senpai " +ChatColor.LIGHT_PURPLE+"> " + ChatColor.YELLOW + "I noticed you " +ChatColor.GOLD+ player.getName());
				}
			}, 20L);
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerChat2(AsyncPlayerChatEvent event){
		final Player player = event.getPlayer();
		if(event.getMessage().toLowerCase().contains("notice me senpai")){
			plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
				@Override
				public void run(){
					Bukkit.broadcastMessage(botprefix + ChatColor.AQUA+" Senpai " +ChatColor.LIGHT_PURPLE+"> " + ChatColor.YELLOW + "I noticed you " +ChatColor.GOLD+ player.getName());
				}
			}, 20L);
		}
	}

}
