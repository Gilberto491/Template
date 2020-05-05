package me.vilehan;

import me.vilehan.commands.AdmCommand;
import me.vilehan.commands.PlayerCommand;
import me.vilehan.events.Evento;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Main extends JavaPlugin implements Listener{

    public static BukkitScheduler sc = Bukkit.getScheduler();
    public static Main plugin;

    @Override
    public void onEnable() {
        carregarConfig();
        registrarEventos();
        registrarComandos();
        sc = Bukkit.getScheduler();
        plugin = this;
    }


    public void registrarComandos(){
        //getCommand("evento").setExecutor(new PlayerCommand());
        getCommand("cm").setExecutor(new AdmCommand());
        getCommand("evento").setExecutor(new PlayerCommand());
    }
    private void carregarConfig(){
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }
    public void  registrarEventos(){
        Bukkit.getPluginManager().registerEvents(new Evento(),this);
    }
}