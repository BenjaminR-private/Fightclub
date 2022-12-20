package Fightclub;

import Fightclub.Characters.Player;
import Fightclub.Enums.EnumType;
import Fightclub.Objects.InvObject;

public abstract class Merchant {

    InvObject[] inventory;
    EnumType[] types;
    double coins;

    public Merchant() {
    }

    public Merchant(InvObject[] inventory, EnumType[] types, double coins) {
        this.inventory = inventory;
        this.types = types;
        this.coins = coins;
    }

    public InvObject[] getInventory() {
        return inventory;
    }

    public void setInventory(InvObject[] inventory) {
        this.inventory = inventory;
    }

    public EnumType[] getTypes() {
        return types;
    }

    public void setTypes(EnumType[] types) {
        this.types = types;
    }

    public double getCoins() {
        return coins;
    }

    public void setCoins(double coins) {
        this.coins = coins;
    }
//TODO
    public InvObject[] fillInventory(int lvl){ return null;   }

    public InvObject buyItem(int input, Merchant merchant, Player player){
        return null;
    }
}
