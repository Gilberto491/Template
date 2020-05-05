package me.vilehan.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import static me.vilehan.Main.plugin;
import java.util.HashMap;
import java.util.Map;

public class Evento implements Listener{
    private static Map<Player, Location> lastLocation = new HashMap<Player, Location>();
    @EventHandler
    public static void aoEntrar(PlayerJoinEvent e){
        Player player = e.getPlayer();
        e.setJoinMessage(null);
        if(player.hasPermission("tag.diretor") || player.isOp()){
            e.setJoinMessage(player.getName() + plugin.getConfig().getString("Messages.entrada").replace("&","§")); /* Configurável conforme as tags */
        }
    }
}
