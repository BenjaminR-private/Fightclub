package Fightclub.Objects;

import Fightclub.Enums.EnumRarity;
import Fightclub.Enums.EnumType;
import Fightclub.Objects.Weapon;

public class Spear extends Weapon {
//    private final EnumType enumType;
    public Spear(String wName, int baseDamage, int baseDefence, double wDurability, double dmgModifier, EnumType enumType, EnumRarity rarity, int lvl, double price) {
        super(wName, baseDamage, baseDefence, wDurability, dmgModifier, enumType, rarity, lvl, price);
//        this.enumType = enumType;
    }
}

