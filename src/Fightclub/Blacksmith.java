package Fightclub;

import Fightclub.Characters.Player;
import Fightclub.Enums.EnumType;
import Fightclub.Objects.InvObject;
import Fightclub.Objects.Weapon;

import static Fightclub.Enums.EnumType.*;

public class Blacksmith extends Merchant {

    EnumType[] t = {SWORD, BOW, SPEAR, SHIELD};


    public Blacksmith() {
    }

    public Blacksmith(int lvl) {
        super();
        this.setTypes(t);
        this.setCoins((Math.random() + 1) * (lvl * lvl) + 150);
        this.setInventory(fillInventory(lvl));
    }


    public Blacksmith(InvObject[] inventory, EnumType[] types, double coins) {
        super(inventory, types, coins);
    }

    //TODO
    @Override
    public Weapon[] fillInventory(int lvl) {
        Weapon[] wpArray = new Weapon[5];
        for (int i = 0; i < 5; i++) {
            wpArray[i] = new Weapon(lvl);
        }
        return wpArray;
    }

    @Override
    public Weapon buyItem(int input, Merchant merchant, Player player) {

        InvObject[] mercItemArray = merchant.getInventory();
        Weapon chosenItem = (Weapon) mercItemArray[input];

        if(player.getCoins() - chosenItem.getPrice() >= 0){
            player.setCoins(player.getCoins() - chosenItem.getPrice());
            mercItemArray[input] = new Weapon(player.getLvl());
            merchant.setInventory(mercItemArray);
            player.addInvObject(chosenItem);
            return chosenItem;
        }
        else{
            System.out.println("Get out of my store you cheap Weasel. You can't afford this " + chosenItem.getwName());
            return null;
        }
    }

}
