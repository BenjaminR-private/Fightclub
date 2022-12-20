package Fightclub.Objects;

import Fightclub.Enums.EnumRarity;
import Fightclub.Enums.EnumType;
import Fightclub.Objects.Weapon;

public class Bow extends Weapon {
//    private final EnumType enumType;

    public Bow(String wName, int baseDamage, int baseDefence, double wDurability, double dmgModifier, EnumType enumType, EnumRarity rarity, int lvl, double price) {
        super(wName, baseDamage, baseDefence, wDurability, dmgModifier, enumType, rarity, lvl, price);
//        this.enumType = enumType;
    }
}
