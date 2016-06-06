package me.Thomas.Senpai;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class AIUser {
	
	private UUID uuid;
	private byte friendship = 10;
	private String name = null;
	
	public AIUser(Player player) {
		uuid = player.getUniqueId();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name == null ? toPlayer().getName() : name;
	}
	
	public void lowerAmity() {
		if (friendship > 0) {
			friendship--;
		}
	}
	
	public void raiseAmity() {
		if (friendship < 10) {
			friendship++;
		}
	}
	
	
	public void boostAmity() {
		boolean raise = true;
		while (raise) {
			raiseAmity();
			raise = Senpai.randomBoolean();
		}
	}
	
	public byte getAmity() {
		return friendship;
	}
	
	public boolean isPlayer(Player player) {
		return uuid.equals(player.getUniqueId());
	}
	
	public OfflinePlayer toPlayer() {
		return Bukkit.getOfflinePlayer(uuid);
	}
}
