package Fightclub;

import Fightclub.Characters.Player;
import Fightclub.Enums.EnumType;
import Fightclub.Objects.InvObject;
import Fightclub.Objects.Potion;
import Fightclub.Objects.Weapon;

import java.util.Locale;

public class Healer extends Merchant {

    public Healer(int lvl) {
        this.setInventory(fillInventory(lvl));
    }

    public Healer(InvObject[] inventory, EnumType[] types, double coins) {
        super(inventory, types, coins);
    }


    @Override
    public Potion[] fillInventory(int lvl) {
        Potion[] poArray = new Potion[lvl];
        for (int i = 0; i < lvl; i++) {
            poArray[i] = new Potion();
        }
        return poArray;
    }
    @Override
    public Potion buyItem(int input, Merchant merchant, Player player) {

        InvObject[] mercItemArray = merchant.getInventory();
        Potion chosenItem = (Potion) mercItemArray[input];

        if(player.getCoins() - chosenItem.getPrice() >= 0){
            player.setCoins(player.getCoins() - chosenItem.getPrice());
            mercItemArray[input] = new Potion();
            merchant.setInventory(mercItemArray);
            player.addInvObject(chosenItem);
            return chosenItem;
        }
        else{
            System.out.println("Get out of my store you cheap Weasel. You can't afford this " + chosenItem.createPotionName());
            return null;
        }
    }


}
