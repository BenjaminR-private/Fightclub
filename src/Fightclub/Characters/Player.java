package Fightclub.Characters;

import Fightclub.Enums.EnumRace;
import Fightclub.Game;
import Fightclub.Objects.InvObject;
import Fightclub.Objects.Potion;
import Fightclub.Objects.Weapon;

import static Fightclub.Game.getInteger;

public class Player extends Character {


    public Player(String name, double health, boolean ai, Weapon[] allWeapons, Weapon[] activeWeapons, double coins, int lvl, EnumRace race) {
        super(name, health, ai, allWeapons, activeWeapons, coins, lvl, race);

    }

    public Weapon[] setActiveWeaponArray() {
        Weapon[] activeWeapons = new Weapon[3];
        int choice;
        for (int i = 0; i < activeWeapons.length; i++) {
            do {
                //TODO
                //already< chosen weapons should not be choose-able
                System.out.printf("%S: Choose Weapon %d of %d from your Inventory by typing a number between 0 and %d\n",
                        this.getName(), i, activeWeapons.length, (this.getAllItems().length - 1));
                choice = getInteger();
                if (choice > this.getAllItems().length - 1 || choice < 0) {
                    System.out.println("Invalid choice, you dumb fuck");
                }
            } while (choice > this.getAllItems().length - 1 || choice < 0);
            activeWeapons[i] = (Weapon) this.getAllItems()[choice];
        }
        return activeWeapons;
    }

    public void addInvObject(InvObject item) {
        InvObject[] o = this.getAllItems();
        InvObject[] n = new InvObject[o.length + 1];
        System.arraycopy(o, 0, n, 0, o.length);
        n[n.length - 1] = item;
        this.setAllItems(n);
    }

    public void addAllInvObject(InvObject[] items) {
        InvObject[] o = this.getAllItems();
        InvObject[] n = new InvObject[o.length + items.length];
        for (int i = 0; i < n.length; i++) {
            if (i < o.length) {
                n[i] = o[i];
            } else {
                n[i] = items[i - o.length];
            }
        }
        this.setAllItems(n);
    }
}


//    public void showAActiveWeapons(Weapon[] activeWeapons) {
//        for (int i = 0; i < activeWeapons.length; i++) {
//            System.out.printf("%2d : %15S \t\tDmg: %3d \n", i, activeWeapons[i].getwName(), activeWeapons[i].getBaseDamage());
//        }
//    }

