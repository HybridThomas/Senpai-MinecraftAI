package me.Thomas.Senpai;

import me.Thomas.Thomas.Main;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class SenpaiAbuse implements Listener {
	public static Main plugin;
	
	String botprefix = "§7[§e§lBot§7]";
	
	public SenpaiAbuse(Main SenpaiAbuse){
		plugin = SenpaiAbuse;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event){
		final Player player = event.getPlayer();
		if(event.getMessage().toLowerCase().contains("senpai abused me")){
			plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
				@Override
				public void run(){
					Bukkit.broadcastMessage(botprefix + ChatColor.AQUA+" Senpai " +ChatColor.LIGHT_PURPLE+"> " + ChatColor.YELLOW + "I am sorry " +ChatColor.GOLD+ player.getName() + ChatColor.YELLOW + " if I abused you!" );
				}
			}, 20L);
		}
	}	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerChat2(AsyncPlayerChatEvent event){
		final Player player = event.getPlayer();
		if(event.getMessage().toLowerCase().contains("senpai abuse me")){
			plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
				@Override
				public void run(){
					Bukkit.broadcastMessage(botprefix + ChatColor.AQUA+" Senpai "+ChatColor.LIGHT_PURPLE+"> " + ChatColor.YELLOW + "You asked for this! " +ChatColor.GOLD+ player.getName());
					Bukkit.broadcastMessage(botprefix + ChatColor.AQUA+" Senpai " + ChatColor.LIGHT_PURPLE +"> " + ChatColor.RED + "Abusing time! >:)");
					player.setVelocity(player.getLocation().getDirection().multiply(-20));
					player.setVelocity(player.getLocation().getDirection().multiply(-25));
					player.damage(5);
				}
			}, 20L);
		}
	}
	
	

}

