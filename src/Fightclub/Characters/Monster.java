package Fightclub.Characters;

import Fightclub.Enums.EnumAttribute;
import Fightclub.Enums.EnumElement;
import Fightclub.Enums.EnumRace;
import Fightclub.Objects.Weapon;

import java.util.Locale;

public class Monster extends Character {
    public EnumElement element;
    public EnumAttribute attribute;


    public Monster(String name, double health, boolean ai, Weapon[] allWeapons, Weapon[] activeWeapons, double coins, int lvl, EnumElement element, EnumAttribute attribute, EnumRace race) {
        super();
        this.element = element;
        this.attribute = attribute;

    }

    public Monster(int lvl) {
        super();
        this.setLvl(lvl);
        createMonster();

    }

    private void createMonster() {
        int lvl = this.getLvl();
        this.setHealth(50 * lvl);
        this.setAttribute(giveRandomAttribute());
        this.setElement(giveRandomElement());
        this.setRace(giveRandomRace());
        this.setName(createMonsterName());
        this.setAi(true);
        //give Weapons
        Weapon[] activeWpns = new Weapon[3];
        Weapon[] allWpns = new Weapon[3 + this.getLvl()];
        for (int i = 0; i < 3; i++) {
            activeWpns[i] = new Weapon(this.getLvl());
            allWpns[i] = activeWpns[i];
        }
        for (int i = 3; i < allWpns.length; i++) {
            allWpns[i] = new Weapon(this.getLvl());
        }
        //TODO create bigger Inventory to have some variety in weapon use
        this.setActiveWeapons(activeWpns);
        this.setAllItems(allWpns);

    }

    public String createMonsterName() {
        return this.getAttribute().toString().charAt(0) + this.getAttribute().toString().substring(1).toLowerCase(Locale.ROOT) + " " +
                this.getElement().toString().charAt(0) + this.getElement().toString().substring(1).toLowerCase(Locale.ROOT) + " " +
                this.getRace().toString().charAt(0) + this.getRace().toString().substring(1).toLowerCase(Locale.ROOT);
    }

    private EnumRace giveRandomRace() {
        int i = (int) (Math.random() * EnumRace.values().length - 1) + 1;
        for (EnumRace a : EnumRace.values()) {
            if (a.ordinal() == i) {
                return a;
            }
        }
        return null;
    }

    private EnumElement giveRandomElement() {
        int i = (int) (Math.random() * EnumElement.values().length - 1) + 1;
        for (EnumElement a : EnumElement.values()) {
            if (a.ordinal() == i) {
                return a;
            }
        }
        return null;
    }

    public EnumElement getElement() {
        return element;
    }

    public void setElement(EnumElement element) {
        this.element = element;
    }

    public EnumAttribute getAttribute() {
        return attribute;
    }

    public void setAttribute(EnumAttribute attribute) {
        this.attribute = attribute;
    }

    public EnumAttribute giveRandomAttribute() {
        int i = (int) (Math.random() * EnumAttribute.values().length - 1) + 1;
        for (EnumAttribute a : EnumAttribute.values()) {
            if (a.ordinal() == i) {
                return a;
            }
        }
        return null;
    }

}
