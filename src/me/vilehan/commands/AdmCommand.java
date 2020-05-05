package me.vilehan.commands;

import me.vilehan.utils.IsEnable;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;
import java.util.HashMap;

import static me.vilehan.Main.plugin;
import static org.bukkit.Bukkit.getServer;

public class AdmCommand implements CommandExecutor {
    public static String mensagemInicial = plugin.getConfig().getString("Messages.mensagemInicial").replace("&","§");
    public static String mensagemFinal = plugin.getConfig().getString("Messages.mensagemFinal").replace("&","§");
    public static String iniciar = plugin.getConfig().getString("Messages.iniciar").replace("&","§");
    public int time = 20;
    public HashMap<Player,Integer> task = new HashMap<Player,Integer>();
    public BukkitScheduler sh = Bukkit.getScheduler();

    @Override
    public boolean onCommand(CommandSender sender, Command c, String label, String[] args) {
        Player player = (Player) sender;
            if(c.getName().equalsIgnoreCase("cm") && player.isOp()){
                if(args.length == 0){
                    player.sendMessage(plugin.getConfig().getString("Messages.admin").replace("&","§"));
                    player.sendMessage(plugin.getConfig().getString("Messages.cm").replace("&","§"));
                    player.sendMessage(plugin.getConfig().getString("Messages.cminiciar").replace("&","§"));
                    player.sendMessage(plugin.getConfig().getString("Messages.cmsetspawn").replace("&","§"));
                    player.sendMessage(plugin.getConfig().getString("Messages.cmsetsaida").replace("&","§"));
                    player.sendMessage("teste");

                    return true;
                }
            }
            if(args.length == 1){
                if(args[0].equalsIgnoreCase("setspawn") && player.isOp()) {
                    plugin.getConfig().set("LobbyE.World", player.getLocation().getWorld().getName());
                    plugin.getConfig().set("LobbyE.X", Double.valueOf(player.getLocation().getX()));
                    plugin.getConfig().set("LobbyE.Y", Double.valueOf(player.getLocation().getY()));
                    plugin.getConfig().set("LobbyE.Z", Double.valueOf(player.getLocation().getZ()));
                    plugin.saveConfig();
                    player.sendMessage(plugin.getConfig().getString("Messages.spawnsetado").replace("&","§"));
                }
                if(args[0].equalsIgnoreCase("iniciar")){

                    final Player pf = player;
                    IsEnable ativar = new IsEnable();// ativando comando
                    ativar.setEnable(true);
                    final int taskID =  sh.scheduleSyncRepeatingTask(plugin, new Runnable() {
                        int iniciador = 31;

                        @Override
                        public void run() {
                            if(iniciador > 0){
                                iniciador--;
                            }
                            if(iniciador%5==0 && iniciador != 0){
                                getServer().broadcastMessage(mensagemInicial + iniciador + mensagemFinal);
                            }
                            if(iniciador == 0){
                                getServer().broadcastMessage(iniciar);
                                IsEnable ativar = new IsEnable();
                                ativar.setEnable(false); //desativando entrada do evento
                                sh.cancelTask(task.get(pf));
                            }
                        }
                    },0,time);

                    task.put(player,taskID);
                }
                if(args[0].equalsIgnoreCase("setsaida") && player.isOp()){
                    plugin.getConfig().set("SaidaE.World", player.getLocation().getWorld().getName());
                    plugin.getConfig().set("SaidaE.X", Double.valueOf(player.getLocation().getX()));
                    plugin.getConfig().set("SaidaE.Y", Double.valueOf(player.getLocation().getY()));
                    plugin.getConfig().set("SaidaE.Z", Double.valueOf(player.getLocation().getZ()));
                    plugin.saveConfig();
                    player.sendMessage(plugin.getConfig().getString("Messages.saidasetado"));
                }
            }

        return true;
    }

}
