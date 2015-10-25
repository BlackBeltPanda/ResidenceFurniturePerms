package main.java.me.BlackBeltPanda.ResidenceFurniturePerms;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.FlagPermissions;

import de.Ste3et_C0st.FurnitureLib.Events.FurnitureBreakEvent;

public class Main extends JavaPlugin implements Listener{
	
	public void onEnable(){
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		FlagPermissions.addFlag("build");
	}
	
	@EventHandler
	public void onFurnitureBreak(FurnitureBreakEvent event){
		Player player = event.getPlayer();
		Location loc = event.getLocation();
		if (Residence.getPermsByLoc(loc).playerHas(player.getName(), loc.getWorld().getName(), "build", true)) event.getID().remove(player);
	}
}
