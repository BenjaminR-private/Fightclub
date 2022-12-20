package Fightclub.Objects;

import Fightclub.Enums.EnumSize;
import Fightclub.Enums.EnumType;

import java.util.Locale;

public class Potion extends MiscObject{
    private EnumSize size;
    private int heal;

    public Potion(EnumSize size, int heal) {
        this.size = size;
        this.heal = heal;
        this.setEnumType(EnumType.POTION);
    }

    public Potion() {
        this.setSize(randomSize());
        this.setHeal(initPotion());
        this.setEnumType(EnumType.POTION);
    }

    public EnumSize getSize() {
        return size;
    }
    protected EnumSize randomSize() {
        int i;
        do {
            i = (int) (Math.random() * EnumSize.values().length - 1);
        } while (i > 2);
        for (EnumSize a : EnumSize.values()) {
            if (a.ordinal() == i) {
                return a;
            }
        }
        return null;
    }

    public String createPotionName() {
        return this.getSize().name().charAt(0) + this.getSize().name().substring(1).toLowerCase(Locale.ROOT)
                + " " +
                this.getEnumType().name().charAt(0) + this.getEnumType().name().substring(1).toLowerCase(Locale.ROOT);
    }

    public int initPotion(){
        EnumSize size = this.getSize();
        switch (size) {
            case SMALL -> {
                heal = 25;
                this.setPrice(15d);
                return 25;
            }
            case MEDIUM -> {
                heal = 50;
                this.setPrice(25d);
                return 50;
            }
            case LARGE -> {
                heal = 100;
                this.setPrice(40d);
                return 100;
            }
            default -> {
            }
        }
        return 0;
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public void setSize(EnumSize size) {
        this.size = size;
    }
    public int drinkPotion(Potion potion){
        return potion.getHeal();
    }

    public String printPotion(){
        return (this.getSize().toString().charAt(0) +
                this.getSize().toString().substring(1).toLowerCase() +
                " " + this.getEnumType().toString().charAt(0) +
                this.getEnumType().toString().substring(1).toLowerCase());
    }
    @Override
    public String[] invObjectStringToArray() {
        String[] stringArray = new String[7];
        stringArray[0] = String.format("\t\t\t '%10s'\t\t", printPotion());
        stringArray[1] = "\t\t\t\t    :\t\t\t";
        stringArray[2] = "\t\t\t\t    :\t\t\t";
        stringArray[3] = String.format("\t\tHeal \t\t: %10d", this.getHeal());
        stringArray[4] = "\t\t\t\t    :\t\t\t";
        stringArray[5] = "\t\t\t\t    :\t\t\t";
        stringArray[6] = String.format("\t\tPrice \t\t: %10s", (int) this.getPrice());

        return stringArray;
    }
}
