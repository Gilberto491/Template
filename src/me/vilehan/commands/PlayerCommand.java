package me.vilehan.commands;

import me.vilehan.manager.JoinEvent;
import me.vilehan.utils.IsEnable;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.vilehan.Main.plugin;
import me.vilehan.manager.JoinEvent;

public class PlayerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command c, String label, String[] args) {
        Player player = (Player) sender;
        if (!(sender instanceof Player)) return false;
        if (c.getName().equalsIgnoreCase("evento")) {
            if (args.length == 0) {
                player.sendMessage(plugin.getConfig().getString("Messages.permision").replace("&","§"));
                return true;
            }
            if (args.length == 1) {
                if (c.getName().equalsIgnoreCase("entrar")) {
                    IsEnable ativar = new IsEnable();
                    boolean evento = ativar.getEnable(); //verificando se está ocorrendo evento*/

                    JoinEvent inventory = new JoinEvent();
                    boolean checked = inventory.getInventoryChecked(player);
                   if (evento /*&& checked*/){
                        World world = Bukkit.getServer().getWorld(plugin.getConfig().getString("LobbyE.World"));
                        double d1 = plugin.getConfig().getDouble("LobbyE.X");
                        double d2 = plugin.getConfig().getDouble("LobbyE.Y");
                        double d3 = plugin.getConfig().getDouble("LobbyE.Z");
                        player.teleport(new Location(world, d1, d2, d3));
                    } else {
                        player.sendMessage(plugin.getConfig().getString("Messages.eventoof").replace("&","§"));
                    }
                }
            }
        }
        return true;
    }
}