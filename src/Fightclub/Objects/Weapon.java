package Fightclub.Objects;

import Fightclub.Enums.EnumRarity;
import Fightclub.Enums.EnumType;

import java.util.Locale;

public class Weapon extends InvObject {

    private String wName;
    private int baseDamage;
    private int baseDefence;
    private double wDurability;
    private double dmgModifier;
    private EnumRarity rarity;

    private int lvl;


    public Weapon(String wName, int baseDamage, int baseDefence, double wDurability, double dmgModifier, EnumType enumType, EnumRarity rarity, int lvl, double price) {
        super();
        this.wName = wName;
        this.baseDamage = baseDamage;
        this.wDurability = wDurability;
        this.dmgModifier = dmgModifier;
        this.enumType = enumType;
        this.rarity = rarity;
        this.lvl = lvl;
        this.setPrice(price);
        this.baseDefence = baseDefence;
    }

    public Weapon(int lvl) {
        super();
        this.lvl = lvl;
        this.setRarity(this.randomRarity());
        this.setType(this.randomWeaponType());
        this.setwName(createWeaponName());
        if (this.getType() == EnumType.SHIELD) {
            this.setBaseDamage(0);
        } else {
            this.setBaseDamage((int) (10 * lvl + ((Math.random() + 0.5d) - 1) * lvl));
        }
        if (this.getType() == EnumType.SHIELD) {
            this.setBaseDefence((int) (10 * lvl + (((Math.random() + 0.5d) - 1) * lvl)) + lvl);
        } else {
            this.setBaseDefence((int) (5 * lvl + (((Math.random() + 0.5d) - 1) * lvl)) - lvl);
        }

        this.setwDurability(calcDurability());
        this.setDmgModifier(calcDmgModifier());
        this.setPrice(calcPrice());
    }

    private double calcPrice() {
        return (this.getType() == EnumType.SHIELD ? this.getBaseDefence() * (((Math.random() + 1) - 0.5d) * this.getLvl()) + getLvl() :
         this.getBaseDamage() * ((Math.random() + 1) - 0.5d) * this.getLvl());
    }

    private double calcDmgModifier() {
        EnumRarity rarity = this.getRarity();
        switch (rarity) {
            case COMMON:
                return 1.2d;
            case UNCOMMON:
                return 1.4d;
            case RARE:
                return 1.6d;
            case EXCELLENT:
                return 1.8d;
            case LEGENDARY:
                return 2.0d;
            case HOLY:
                return 3.0d;
            default:
                break;
        }
        return 1.0;
    }

    private double calcDurability() {
        double durability = 100;
        EnumRarity rarity = this.getRarity();
        switch (rarity) {
            case COMMON -> durability = durability * 1.5d;
            case UNCOMMON -> durability = durability * 2.d;
            case RARE -> durability = durability * 2.5d;
            case EXCELLENT -> durability = durability * 3.0d;
            case LEGENDARY -> durability = durability * 3.5d;
            case HOLY -> durability = durability * 5.0d;
            default -> {
            }
        }
        return durability;
    }

    public String getwName() {
        return wName;
    }

    public void setwName(String wName) {
        this.wName = wName;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public double getwDurability() {
        return wDurability;
    }

    public int getBaseDefence() {
        return baseDefence;
    }

    public void setBaseDefence(int baseDefence) {
        this.baseDefence = baseDefence;
    }

    public void setwDurability(double wDurability) {
        this.wDurability = wDurability;
    }

    public double getDmgModifier() {
        return dmgModifier;
    }

    public void setDmgModifier(double dmgModifier) {
        this.dmgModifier = dmgModifier;
    }

    public EnumType getType() {
        return enumType;
    }

    public void setType(EnumType enumType) {
        this.enumType = enumType;
    }

    public EnumRarity getRarity() {
        return rarity;
    }

    public void setRarity(EnumRarity rarity) {
        this.rarity = rarity;
    }

    private EnumRarity randomRarity() {
        int i = (int) (Math.random() * EnumRarity.values().length - 1) + 1;
        int j = (int) (Math.random() * EnumRarity.values().length - 1) + 1;
        int k = (int) (Math.random() * EnumRarity.values().length - 1) + 1;
        int total = (i + j + k) / 3;
        for (EnumRarity a : EnumRarity.values()) {
            if (a.ordinal() == total) {
                return a;
            }
        }
        return null;
    }

    public String createWeaponName() {
        return this.getRarity().toString().charAt(0) + this.getRarity().toString().substring(1).toLowerCase(Locale.ROOT) + " " + this.getType().toString().charAt(0) + this.getType().toString().substring(1).toLowerCase(Locale.ROOT);
    }

    @Override
    public String[] invObjectStringToArray() {
        String[] stringArray = new String[7];
        stringArray[0] = String.format("\t\t\t '%10s'\t\t", this.getwName());
        stringArray[1] = String.format("\t\tLevel \t\t: %10s", this.getLvl());
        stringArray[2] = String.format("\t\tDamage \t\t: %10d", this.getBaseDamage());
        stringArray[3] = String.format("\t\tDefence \t: %10d", this.getBaseDefence());
        stringArray[4] = String.format("\t\tDurability \t: %10s", this.getwDurability());
        stringArray[5] = String.format("\t\tType \t\t: %10s", this.getType());
        stringArray[6] = String.format("\t\tPrice \t\t: %10s", (int) this.getPrice());

        return stringArray;
    }


    @Override
    public String toString() {
        return "'" + wName + '\'' +
                "\n\t Damage:\t" + baseDamage * dmgModifier +
                "\n\t Defence:\t" + baseDefence +
                "\n\t Durability:\t" + wDurability +
//                "\n\t, dmgModifier=" + dmgModifier +
//                "\n\t Rarity:\t" + rarity +
                "\n\t Type:\t" + enumType;
    }
}
