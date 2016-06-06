package me.Thomas.Senpai;

import me.Thomas.Thomas.Main;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class SenpaiBroken implements Listener {
	public static Main plugin;
	
	String botprefix = "§7[§e§lBot§7]";
	
	public SenpaiBroken(Main SenpaiBroken){
		plugin = SenpaiBroken;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event){
		final Player player = event.getPlayer();
		if(event.getMessage().toLowerCase().contains("senpai why are you broken")){
			plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
				@Override
				public void run(){
					Bukkit.broadcastMessage(botprefix + ChatColor.AQUA+" Senpai " +ChatColor.LIGHT_PURPLE+"> " + ChatColor.YELLOW + "ERROR 501 INTERNAL SERVER ERROR. It appears you have broken me! " + ChatColor.GOLD+ player.getName());
				}
			}, 20L);
		}
	}
	

}
