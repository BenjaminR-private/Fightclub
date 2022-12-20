package Fightclub.Objects;

import Fightclub.Enums.EnumType;

public abstract class InvObject {
    double price;
    protected EnumType enumType;

    public InvObject(EnumType enumType) {
    }

    public InvObject() {

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public EnumType getEnumType() {
        return enumType;
    }

    public void setEnumType(EnumType enumType) {
        this.enumType = enumType;
    }

    protected EnumType randomWeaponType() {
        int i = 0;
        do {
            i = (int) (Math.random() * EnumType.values().length - 1);
        } while (i > 3); //TypeEnum 1-4 are Weapons
        for (EnumType a : EnumType.values()) {
            if (a.ordinal() == i) {
                return a;
            }
        }
        return null;
    }


    public String[] invObjectStringToArray() {
        String[] stringArray = new String[6];

        stringArray[5] = String.format("\tPrice \t\t: %10s", (int) this.getPrice());

        return stringArray;
    }

    @Override
    public String toString() {
        return "Type=" + enumType +
                '}';
    }

    public static int[] printMultInvObjects(InvObject[] objectArray) {
        System.out.println();
        int[] indices = new int[objectArray.length];
        String[] strings = {"", "", "", "", "", "", "", ""};
        for (int j = 0; j < objectArray.length; j++) {
            for (int i = 0; i < objectArray[j].invObjectStringToArray().length; i++) {
                strings[i] = strings[i] + objectArray[j].invObjectStringToArray()[i];
            }
            strings[7] = strings[7] + String.format("\t\t\t\t   [%d]\t\t\t", j);
            indices[j] = j;
        }
        for (String aString : strings) {
            System.out.println(aString);
        }
    return indices;
    }


}
