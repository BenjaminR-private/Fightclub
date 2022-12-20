package Fightclub.Objects;

import Fightclub.Enums.EnumRarity;
import Fightclub.Enums.EnumType;
import Fightclub.Objects.Weapon;

public class Sword extends Weapon {
//    private final EnumType enumType;

    public Sword(String wName, int baseDamage, int baseDefence, double wDurability, double dmgModifier, EnumType enumType, EnumRarity rarity, int lvl, double price) {
        super(wName, baseDamage, baseDefence, wDurability, dmgModifier, enumType, rarity, lvl, price);
//        this.enumType = enumType;
    }
//    public EnumType getType() {
//        return enumType;
//    }
}
