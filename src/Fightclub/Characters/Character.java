package Fightclub.Characters;

import Fightclub.Enums.EnumRace;
import Fightclub.Enums.EnumType;
import Fightclub.Objects.InvObject;
import Fightclub.Objects.Weapon;

import static Fightclub.Game.getInteger;

public class Character {
    private String name;
    private double health;
    private boolean ai;
    private InvObject[] allItems;
    private Weapon[] activeWeapons;
    private double coins;
    private int lvl;
    private EnumRace race;

    public Character(String name, double health, boolean ai, Weapon[] allItems, Weapon[] activeWeapons, double coins, int lvl, EnumRace race) {
        this.name = name;
        this.health = health;
        this.ai = ai;
        this.allItems = allItems;
        this.activeWeapons = activeWeapons;
        this.coins = coins;
        this.lvl = lvl;
        this.race = race;
    }

    public Character() {
    }

    public EnumRace getRace() {
        return race;
    }

    public void setRace(EnumRace race) {
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public boolean isAi() {
        return ai;
    }

    public void setAi(boolean ai) {
        this.ai = ai;
    }

    public InvObject[] getAllItems() {
        return allItems;
    }

    public void setAllItems(InvObject[] allItems) {
        this.allItems = allItems;
    }

    public Weapon[] getActiveWeapons() {
        return activeWeapons;
    }

    public void setActiveWeapons(Weapon[] activeWeapons) {
        this.activeWeapons = activeWeapons;
    }

    public double getCoins() {
        return coins;
    }

    public void setCoins(double coins) {
        this.coins = coins;
    }

    public void showAllWeapons(Character player) {
        for (int i = 0; i < player.getAllItems().length; i++) {
            if (player.getAllItems()[i].getEnumType() == EnumType.SPEAR || player.getAllItems()[i].getEnumType() == EnumType.BOW ||
                    player.getAllItems()[i].getEnumType() == EnumType.SWORD || player.getAllItems()[i].getEnumType() == EnumType.SHIELD) {
                Weapon w = (Weapon) player.getAllItems()[i];
                System.out.printf("%2d : %15S \t\tDmg: %3d \n", i, w.getwName(), w.getBaseDamage());
            }
        }
    }

    public Weapon[] setActiveWeaponArray() {
        Weapon[] activeWeapons = new Weapon[3];
        int choice;
        boolean used = false;
        for (int i = 0; i < activeWeapons.length; i++) {
            do {
                //TODO
                //already< chosen weapons should not be chose-able
                System.out.printf("%S: Choose Weapon %d of %d from your Inventory by typing a number between 0 and %d\n",
                        this.getName(), i, activeWeapons.length, (this.getAllItems().length - 1));
                choice = getInteger();
                if (choice > this.getAllItems().length - 1 || choice < 0) {
                    System.out.println("Invalid choice");
                }
                for (int j = 0; j < activeWeapons.length; j++) {
                    if(activeWeapons[i].equals(this.getAllItems()[choice])){
                        System.out.println("Weapon already added, please choose another Weapon");
                        used = true;
                    }
                    else{
                        used = false;
                    }
                }
            } while ((choice > getAllItems().length - 1 || choice < 0) || used);
            activeWeapons[i] = (Weapon) getAllItems()[choice];
        }
        return activeWeapons;
    }

    public void showAActiveWeapons(Weapon[] activeWeapons) {
        for (int i = 0; i < activeWeapons.length; i++) {
            System.out.printf("%2d : %15S \t\tDmg: %3d \n", i, activeWeapons[i].getwName(), activeWeapons[i].getBaseDamage());
        }
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public Weapon[] getOnlyWeaponsOfInventory() {
        InvObject[] objects = getAllItems();
        int count = 0;
        for (int i = 0; i < objects.length; i++) {
            if (objects[i].getEnumType().equals(EnumType.SWORD) || objects[i].getEnumType().equals(EnumType.BOW) ||
                    objects[i].getEnumType().equals(EnumType.SPEAR) || objects[i].getEnumType().equals(EnumType.SHIELD)) {
                count++;
            }
        }
        Weapon[] weapons = new Weapon[count];
        int pos = 0;
        for (int i = 0; i < objects.length; i++) {
            if ((objects[i].getEnumType().equals(EnumType.SWORD) || objects[i].getEnumType().equals(EnumType.BOW) ||
                    objects[i].getEnumType().equals(EnumType.SPEAR) || objects[i].getEnumType().equals(EnumType.SHIELD)) && pos < weapons.length) {
                weapons[pos] = (Weapon) objects[i];
                pos++;
            }
        }
        return weapons;
    }

    public Weapon getRandomWeapon() {
        Weapon[] weapons = getOnlyWeaponsOfInventory();
        int random = (int) (Math.random() * weapons.length) + 1;
        return weapons[random];
    }
}
