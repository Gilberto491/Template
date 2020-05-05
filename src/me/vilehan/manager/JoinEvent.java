package me.vilehan.manager;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class JoinEvent {
public int checkedArmour = 0;
public int checkItens = 0;
public boolean inventoryChecked;

    /* EVENTO(Verificando condições) */
   /* public void join(Player player) {
        player.setAllowFlight(false);
        player.setGameMode(GameMode.SURVIVAL);
    }*/

    public void setInventoryChecked(boolean inventoryChecked){
        this.inventoryChecked = inventoryChecked;
    }

    public boolean getInventoryChecked(Player player){
        for(ItemStack armour: player.getInventory().getArmorContents()){
            if(armour.getType() != Material.AIR){
                checkedArmour++;
            }
        }
        if(checkedArmour > 0){
            player.sendMessage("&6Para entrar neste evento você precisa estar sem armadura! ".replace("&","§6"));
            return false;
        }
        for(ItemStack itens : player.getInventory().getContents()){
            if(itens.getType() != null){
                checkItens++;
            }
            if(checkItens > 0){
                player.sendMessage("&6Para entrar neste evento você precisa estar com o inventário vazio! ".replace("&","§6"));
                return false;
            }
        }
        return true;
    }
}
