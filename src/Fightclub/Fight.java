package Fightclub;

import Fightclub.Characters.Character;
import Fightclub.Enums.EnumType;
import Fightclub.Objects.Weapon;

import java.util.Scanner;

public class Fight {

    Character player1;
    Character player2;


    public void printNoDmg(Character playerAtt, Character playerDef, int arrayIndex) {
        System.out.printf("%S doesn't deal any Dmg to %S, because %S doesn't do shit and hides behind his %S like a coward \n",
                playerAtt.getName(), playerDef.getName(),
                playerDef.getName(), playerDef.getActiveWeapons()[arrayIndex].getwName());
    }


    public void chooseWeapons(Character player1, Character player2) {
        player1.showAllWeapons(player1);
        player1.setActiveWeapons(player1.setActiveWeaponArray());
        player1.showAActiveWeapons(player1.getActiveWeapons());
        if (!player2.isAi()) {
            for (int i = 0; i < 25; i++) {
                System.out.println();
            }
            player2.showAllWeapons(player2);
            player2.setActiveWeapons(player2.setActiveWeaponArray());
            player2.showAActiveWeapons(player2.getActiveWeapons());
        }
    }

    public Fight(Character player1, Character player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    private double calcDmg(Character att, Character def, int arrayIndex, double random, double mod) {
        double modifier = (1.0d + random) * mod;
        return Math.abs((mod == 0.5d) ? ((att.getActiveWeapons()[arrayIndex].getBaseDamage() * modifier) - (def.getActiveWeapons()[arrayIndex].getBaseDefence())) / 2 :
                (att.getActiveWeapons()[arrayIndex].getBaseDamage() * modifier) - (def.getActiveWeapons()[arrayIndex].getBaseDefence()));
    }

    public void printDmg(Character att, Character def, int arrayIndex, double dmg, double mod) {
        System.out.printf("%S deals %2.1f Damage with a %S to %S, reducing %S's Health from %2.1f to %2.1f. %d Dmg were blocked by %S's %S.\n",
                att.getName(),
                dmg, att.getActiveWeapons()[arrayIndex].getwName(), def.getName(), def.getName(), def.getHealth(),
                (def.getHealth() - dmg), def.getActiveWeapons()[arrayIndex].getBaseDefence(), def.getName(), def.getActiveWeapons()[arrayIndex].getwName());
        if (mod == 0.5d) {
            System.out.printf("Additionally the Damage was halved, due to %s fighting against %s\n",
                    att.getActiveWeapons()[arrayIndex].getType(), def.getActiveWeapons()[arrayIndex].getType());
        }
    }

    public Character fight(Character player1, Character player2) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        while (player1.getHealth() > 0 && player2.getHealth() > 0) {
            chooseWeapons(player1, player2);
            Weapon[] pl1Wpns = player1.getActiveWeapons();
            Weapon[] pl2Wpns = player2.getActiveWeapons();
            if (player2.isAi()) {
                player2.setActiveWeapons(randomiseAvailWpns(player2));
            }
            for (int i = 0; i < 3; i++) {
                System.out.println("Round " + (i + 1) + " of 3");

                //Same Weapons
                if (pl1Wpns[i].getType() == pl2Wpns[i].getType()) {
                    //att -> def
                    double random = Math.random() * (player1.getLvl());
                    double dmg = calcDmg(player1, player2, i, random, 1d);
                    printDmg(player1, player2, i, dmg, 1.0d);
                    player2.setHealth(player2.getHealth() - dmg);
                    //def -> att
                    random = Math.random() + Math.random() * (player2.getLvl());
                    dmg = calcDmg(player2, player1, i, random, 1d);
                    printDmg(player2, player1, i, dmg, 1.0d);
                    player1.setHealth(player1.getHealth() - dmg);
                } else {
                    // Players use different Weapons
                    if ((pl1Wpns[i].getType() == EnumType.SWORD && pl2Wpns[i].getType() == EnumType.SPEAR)) {
                        //TODO
                        //SCHERE doesn't deal dmg against STEIN, so player 1 receives half dmg
                        //att -> def
                        double random = Math.random() * (player1.getLvl());
                        double dmg = calcDmg(player1, player2, i, random, 1d);
                        printDmg(player1, player2, i, dmg, 1.0d);
                        player2.setHealth(player2.getHealth() - dmg);
                        //def -> att
                        random = Math.random() + Math.random() * (player2.getLvl());
                        dmg = calcDmg(player2, player1, i, random, 0.5d);
                        printDmg(player2, player1, i, dmg, 0.5d);
                        player1.setHealth(player1.getHealth() - dmg);
                    } else if (pl1Wpns[i].getType() == EnumType.SWORD && pl2Wpns[i].getType() == EnumType.BOW) {
                        //TODO
                        //STEIN doesn't deal dmg against PAPIER, so player 2 receives half dmg
                        //att -> def
                        double random = Math.random() * (player1.getLvl());
                        double dmg = calcDmg(player1, player2, i, random, 0.5d);
                        printDmg(player1, player2, i, dmg, 0.5d);
                        player2.setHealth(player2.getHealth() - dmg);
                        //def -> att
                        random = Math.random() + Math.random() * (player2.getLvl());
                        dmg = calcDmg(player2, player1, i, random, 1d);
                        printDmg(player2, player1, i, dmg, 1.0d);
                        player1.setHealth(player1.getHealth() - dmg);
                    } else if (pl1Wpns[i].getType() == EnumType.SPEAR && pl2Wpns[i].getType() == EnumType.SWORD) {
                        //TODO
                        //SCHERE doesn't deal dmg against STEIN, so player 2 receives half dmg
                        double random = Math.random() * (player1.getLvl());
                        double dmg = calcDmg(player1, player2, i, random, 0.5d);
                        printDmg(player1, player2, i, dmg, 0.5d);
                        player2.setHealth(player2.getHealth() - dmg);
                        //def -> att
                        random = Math.random() + Math.random() * (player2.getLvl());
                        dmg = calcDmg(player2, player1, i, random, 1d);
                        printDmg(player2, player1, i, dmg, 1.0d);
                        player1.setHealth(player1.getHealth() - dmg);
                    } else if (pl1Wpns[i].getType() == EnumType.SPEAR && pl2Wpns[i].getType() == EnumType.BOW) {
                        //TODO
                        //PAPIER doesn't deal dmg against SCHERE, so player 1 receives half dmg
                        //att -> def
                        double random = Math.random() * (player1.getLvl());
                        double dmg = calcDmg(player1, player2, i, random, 1d);
                        printDmg(player1, player2, i, dmg, 1.0d);
                        player2.setHealth(player2.getHealth() - dmg);
                        //def -> att
                        random = Math.random() + Math.random() * (player2.getLvl());
                        dmg = calcDmg(player2, player1, i, random, 0.5d);
                        printDmg(player2, player1, i, dmg, 0.5d);
                        player1.setHealth(player1.getHealth() - dmg);
                    } else if (pl1Wpns[i].getType() == EnumType.BOW && pl2Wpns[i].getType() == EnumType.SWORD) {
                        //TODO
                        //STEIN doesn't deal dmg against PAPIER, so player 1 receives half dmg
                        //att -> def
                        double random = Math.random() * (player1.getLvl());
                        double dmg = calcDmg(player1, player2, i, random, 1d);
                        printDmg(player1, player2, i, dmg, 1.0d);
                        player2.setHealth(player2.getHealth() - dmg);
                        //def -> att
                        random = Math.random() + Math.random() * (player2.getLvl());
                        dmg = calcDmg(player2, player1, i, random, 0.5d);
                        printDmg(player2, player1, i, dmg, 0.5d);
                        player1.setHealth(player1.getHealth() - dmg);
                    } else if (pl1Wpns[i].getType() == EnumType.BOW && pl2Wpns[i].getType() == EnumType.SPEAR) {
                        //TODO
                        //PAPIER doesn't deal dmg against SCHERE, so player 2 receives half dmg
                        double random = Math.random() * (player1.getLvl());
                        double dmg = calcDmg(player1, player2, i, random, 0.5d);
                        printDmg(player1, player2, i, dmg, 0.5d);
                        player2.setHealth(player2.getHealth() - dmg);
                        //def -> att
                        random = Math.random() + Math.random() * (player2.getLvl());
                        dmg = calcDmg(player2, player1, i, random, 1d);
                        printDmg(player2, player1, i, dmg, 1.0d);
                        player1.setHealth(player1.getHealth() - dmg);
                    } else if (pl1Wpns[i].getType() == EnumType.SHIELD && pl2Wpns[i].getType() != EnumType.SHIELD) {
                        //only player 2 deals dmg because player 1 uses shield
                        double random = Math.random() + Math.random() * (player2.getLvl());
                        double dmg = calcDmg(player2, player1, i, random, 0.25d);
                        printDmg(player2, player1, i, dmg, 0.25d);
                        player1.setHealth(player1.getHealth() - dmg);
                        printNoDmg(player1, player2, i);
                    } else if (pl1Wpns[i].getType() != EnumType.SHIELD && pl2Wpns[i].getType() == EnumType.SHIELD) {
                        //only player 2 deals dmg because player 1 uses shield
                        double random = Math.random() + Math.random() * (player1.getLvl());
                        double dmg = calcDmg(player1, player2, i, random, 0.25d);
                        printDmg(player1, player2, i, dmg, 0.25d);
                        player2.setHealth(player2.getHealth() - dmg);
                        printNoDmg(player2, player1, i);
                    }
                }
                //TODO
                //Test if one of the players died after an attack
//            if(player1.getHealth() || player2)
                if (player1.getHealth() <= 0 && player2.getHealth() <= 0) {
                    return null;
                } else if (player1.getHealth() <= 0) {
                    System.out.printf("%S has %2.2f Health and died", player1.getName(), player1.getHealth());
                    return player2;
                } else if (player2.getHealth() <= 0) {
                    System.out.printf("%S has %2.2f Health and died", player2.getName(), player2.getHealth());
                    return player1;
                }
                Thread.sleep(2500);
            }
            //Show Health stats
            System.out.printf("%s has %.2f Health left   ||   %s has %.2f Health left \nPrepare for the next round..." +
                            "\n\n\n",
                    player1.getName(), player1.getHealth(), player2.getName(), player2.getHealth());
            boolean cont = false;
            while (!cont) {
                System.out.println("Press 'y' to choose Weapons or 'n' to flee from battle");
                String input = scan.nextLine();
                if (input.equalsIgnoreCase("n")) {
                    return player2;
                } else if (input.equalsIgnoreCase("y")) {
                    cont = true;
                    countdown(3);
                }
            }
        }
        scan.close();
        return player1;
    }

    private Weapon[] randomiseAvailWpns(Character character) {
        Weapon[] monsterWpns = character.getOnlyWeaponsOfInventory();
        int first = (int) (Math.random() * monsterWpns.length) ;
        int second = (int) (Math.random() * monsterWpns.length);
        while (first == second) {
            second = (int) (Math.random() * monsterWpns.length);
        }
        int third = (int) (Math.random() * monsterWpns.length);
        while (third == first || third == second){
            third = (int) (Math.random() * monsterWpns.length);
        }
        Weapon[] noDoubleWpnArr = new Weapon[3];
        noDoubleWpnArr[0] = monsterWpns[first];
        noDoubleWpnArr[1] = monsterWpns[second];
        noDoubleWpnArr[2] = monsterWpns[third];
        return noDoubleWpnArr;
    }

    //TODO implement
//    public Player checkHealth(Player player1, Player player2) {
//        Player winner = null;
//        if (player1.getHealth() <= 0 && player2.getHealth() <= 0) {
//            return null;
//        } else if (player1.getHealth() <= 0) {
//            System.out.printf("%S has %2.2f Health and died", player1.getName(), player1.getHealth());
//            return player2;
//        } else if (player2.getHealth() <= 0) {
//            System.out.printf("%S has %2.2f Health and died", player2.getName(), player2.getHealth());
//            return player1;
//        }
//        return winner;
//    }

    private void countdown(int sekunden) throws InterruptedException {
        for (int i = 0; i < sekunden; i++) {
            System.out.println(sekunden - i + "\n\n\n");
            Thread.sleep(1000);
        }
        System.out.println("\n\n\nG");
    }
}

/// OLD VERSIONS

//printDmg()
//                System.out.printf("%S deals %2.1f Damage to %S, reducing %S's Health from %2.1f to %2.1f\n",
//                        player1.getName(),
//                        (pl1Wpns[i].getBaseDamage() * (Math.random() + 1)),
//                        player2.getName(), player2.getName(), player2.getHealth(),
//                        (player2.getHealth() - (pl1Wpns[i].getBaseDamage() * (Math.random() + 1))));

//                System.out.printf("%S deals %2.1f Damage to %S, reducing %S's Health from %2.1f to %2.1f\n",
//                        player2.getName(),
//                        (pl2Wpns[i].getBaseDamage() * (Math.random() + 1)),
//                        player1.getName(), player1.getName(), player1.getHealth(),
//                        (player1.getHealth() - (pl2Wpns[i].getBaseDamage() * (Math.random() + 1))));
