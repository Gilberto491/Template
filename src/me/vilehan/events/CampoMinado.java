package me.vilehan.events;

import org.bukkit.entity.Player;
import java.util.ArrayList;

/* DESENVOLVIMENTO DO MININGAME */
public class CampoMinado {

private final ArrayList<String> participantes = new ArrayList<String>();

public void addPlayerInEvent(final Player player){
    this.participantes.add(player.getName());
}

public void removePlayerInEvent(final Player player){
    this.participantes.remove(player.getName());
}

public boolean playerInEvent(final Player player){
    for(final String part: this.participantes){
        if(player.getName().equalsIgnoreCase(part)){
            return true;
        }
    }
    return false;
}

}
