package Fightclub;

import Fightclub.Characters.Player;
import Fightclub.Enums.EnumRace;
import Fightclub.Enums.EnumRarity;
import Fightclub.Enums.EnumType;
import Fightclub.Objects.*;

import java.util.Scanner;

public class TestStuff {
    public static void main(String[] args) throws InterruptedException {

        Scanner scan = new Scanner(System.in);
        Player player = new Player("player1", 100, false, new Weapon[3], new Weapon[3], 100.0d, 1, EnumRace.HUMAN);
        System.out.println("Player 1 name: ");
        player.setName(scan.nextLine());
        System.out.println("Player 1 is named " + player.getName());
        Weapon basicSword = new Sword("Basic Sword", 10, 5, 100, 1.0d, EnumType.SWORD, EnumRarity.BASIC, 1, 20d);
        Weapon basicSpear = new Bow("Basic Spear", 10, 5,100, 1.0d, EnumType.SPEAR, EnumRarity.BASIC, 1, 20d);
        Weapon basicBow = new Spear("Basic Bow", 10, 5, 100, 1.0d, EnumType.BOW, EnumRarity.BASIC, 1, 20d);

        Weapon[] basicWeapons = {basicSpear, basicBow, basicSword};
        player.setActiveWeapons(basicWeapons);
        player.setAllItems(basicWeapons);
        Game game = new Game(player.getLvl(), player);

//        InvObject.printMultInvObjects(player.getAllItems());
//        InvObject[] reward = Game.createReward(4);
//        InvObject.printMultInvObjects(reward);
//        System.out.println("------------------------------------------------------------------------------------------");
//        player.addAllInvObject(reward);
//        InvObject.printMultInvObjects(player.getAllItems());




//        System.out.println(m.createMonsterName());

//        for (int i = 0; i < 10; i++) {
//            Weapon w = new Weapon();
//            System.out.println(w.toString());
//        }
//        Weapon w = new Weapon(1);
//        for (String s : w.invObjectStringToArray()) {
//            System.out.println(s);
//        }
//        Weapon[] weapons = {new Weapon(1), new Weapon(2), new Weapon(2)};
//        Weapon.printMultInvObjects(weapons);

//        System.out.println();
//
//        InvObject[] items = {
//                new Potion(),
//                new Weapon(3),
//                new Weapon(2),
//                new Potion(),
//        };
//        InvObject.printMultInvObjects(items);


    }
}


//printing ATTRIBUTE, ELEMENT And RACE
//
//        System.out.printf(m.getAttribute().toString().charAt(0) + m.getAttribute().toString().substring(1).toLowerCase(Locale.ROOT ) + " ");
//        System.out.printf(m.getElement().toString().charAt(0) + m.getElement().toString().substring(1).toLowerCase(Locale.ROOT) + " ");
//        System.out.printf(m.getRace().toString().charAt(0) + m.getRace().toString().substring(1).toLowerCase(Locale.ROOT) + " ");


//Create random Generator for Attributes
//        for (int i = 0; i < 20; i++) {
//            System.out.println(((int) (Math.random() * EnumAttribute.values().length))+1);
//        }