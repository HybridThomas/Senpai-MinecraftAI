package me.Thomas.Senpai;

import me.Thomas.Thomas.Main;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class SenpaiKillMe implements Listener {
	public static Main plugin;
	
	String botprefix = "§7[§e§lBot§7]";
	String senpaiprefix = " §eSenpai ";
	String chatprefix = "§6§l>§f ";
	
	public SenpaiKillMe(Main SenpaiKillMe){
		plugin = SenpaiKillMe;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event){
		final Player player = event.getPlayer();
		if(event.getMessage().toLowerCase().contains("senpai kill me") || event.getMessage().toLowerCase().contains("kill me senpai")){
			plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
				@Override
				public void run(){
					Bukkit.broadcastMessage(botprefix + senpaiprefix + chatprefix + "I am sorry " +ChatColor.GOLD+ player.getName() + ChatColor.RESET + " but you requested this..." );
					player.setHealth(0d);
				}
			}, 20L);
		}
	}
}
