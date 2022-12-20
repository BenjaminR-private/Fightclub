package Fightclub;

import Fightclub.Characters.Character;
import Fightclub.Characters.Monster;
import Fightclub.Characters.Player;
import Fightclub.Objects.InvObject;
import Fightclub.Objects.Potion;
import Fightclub.Objects.Weapon;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Game {
    Player player;
    Character opponent;
    Healer healer;
    Blacksmith blacksmith;

    public Game() {
    }

    public Game(int lvl, Player player) throws NoSuchElementException, InterruptedException {
        this.setPlayer(player);
        this.setBlacksmith(new Blacksmith(player.getLvl()));
        this.setHealer(new Healer(player.getLvl()));
        this.setOpponent(new Monster(player.getLvl() + (int) (Math.random() - 0.5d)));

        Scanner response = new Scanner(System.in);
        //start Gamelogic
        System.out.println(printInitialText(player));
        int input = getInteger();
        do {
            if (input == -1) {
                System.out.println(printInitialText(player));
                input = getInteger();
                if (input == -1) {
                    break;
                }
            }
            if (input < 1 || input > 4) {
                System.out.println("I couldn't understand your pathetic mumbling, try again and louder this time");
                input = getInteger();
            }
            input = textchoices(response, input);
        } while ((input < 1 || input > 4));
    }

    private int textchoices(Scanner response, int input) throws InterruptedException {
        switch (input) {
            case 1:
                //TODO
                input = prepareForFight(player, opponent);
                if (input != -1) {
                    Fight arena = new Fight(player, opponent);
                    Character winner = arena.fight(player, opponent);
                    if (winner.equals(player)) {
                        System.out.println("\nCongratulations, you had more luck than looks! You beat your opponent " + opponent.getName() + " (Lvl " + opponent.getLvl() + ")\n" +
                                "Here is your reward!:" + ((10 * opponent.getLvl()) + opponent.getCoins()) + " Coins");
                        InvObject[] reward = createReward(player.getLvl());
                        InvObject.printMultInvObjects(reward);
                        player.setLvl(player.getLvl() + 1);
                        player.setCoins(player.getCoins() + (10 * opponent.getLvl()) + opponent.getCoins());
                        player.addAllInvObject(reward);
                        opponent = new Monster(player.getLvl());
                        blacksmith = new Blacksmith(player.getLvl());
                        healer = new Healer(player.getLvl());
                        return -1;
                    } else {
                        System.out.println("Game Over, you fool!");
                    }
                }
                break;
            case 2:
                input = interactWithHealer(player, healer, response);
                break;
            case 3:
                input = interactWithBlacksmith(player, blacksmith, response);
                break;
            case 4:
                input = sellInvObjects(player, blacksmith, response);
                break;
            default:
                input = -1;
                break;
        }
        return input;
    }

    static InvObject[] createReward(int lvl) {
        InvObject[] reward = new InvObject[lvl / 2 + 1];
        for (int i = 0; i < reward.length; i++) {
            int t = (int) ((Math.random()) * 10);
            System.out.println(t);
            if (t < 7) {
                reward[i] = new Weapon(lvl);
            } else {
                reward[i] = new Potion();
            }
        }
        return reward;
    }

    private int prepareForFight(Player player, Character opponent) {
        System.out.println("\n\nIn a dark corner of the Tavern you spot a " + opponent.getName() + " giving you a challenging look.\n" +
                "Rumor has it, that your potential opponent is of Level " + opponent.getLvl() + "which poses a " +
                ((player.getLvl() > opponent.getLvl()) ? "low" : "high") + " threat to you\n" +
                " Do you want to:\n" +
                "\t[0]  spend Coins to gather further information about him from the barflies hanging around?\n" +
                "\t[1]  fight him unprepared?\n" +
                "\t[-1] back out of the fight like the little bitch you are?");
        int input = getInteger();
        while (input < -1 || input > 1) {
            System.out.println("\n\t Stop fucking around and make a decision!");
            input = getInteger();
        }
        switch (input) {
            case -1:
                return -1;
            case 0:
                if (player.getCoins() < 10) {
                    System.out.println("\n\tYou cant afford this");
                    prepareForFight(player, opponent);
                }
                player.setCoins(player.getCoins() - 10d);
                showMonsterstats(opponent);
                prepareForFight(player, opponent);
            case 1:
                //TODO
//                fight
                break;
            default:
                return -1;
        }


//        int input = response.nextInt();
        return input;
    }

    public void printMonsterstatsOptions(Character opponent) {
        System.out.println("\nWhat do you wanna know?\n");
        System.out.printf("\t[0] Health-points of %s \n", opponent.getName());
        System.out.printf("\t[1] A Weapon %s might use  [10 Coins]\n", opponent.getName());
        System.out.printf("\t[2] All Info about %s [50 Coins]\n", opponent.getName());
        System.out.println("\t[-1] Go Back");
    }

    private void showMonsterstats(Character opponent) {
        printMonsterstatsOptions(opponent);
        int input = getInteger();
        while (input != -1) {
            if (input == 0) {
                System.out.printf("\t%s has %d Health points\n", opponent.getName(), (int) opponent.getHealth());
                printMonsterstatsOptions(opponent);
            }
            if (input == 1) {
                if (player.getCoins() < 10) {
                    System.out.println("You cheap fuck, You can't afford this info. Get out of here!\n");
                    printMonsterstatsOptions(opponent);
                } else {
                    player.setCoins(player.getCoins() - 10);
                    Weapon w = opponent.getRandomWeapon();
                    Weapon[] wAr = new Weapon[1];
                    wAr[0] = w;
                    System.out.printf("\t%s might use a %s \n", opponent.getName(), w.getwName());
                    InvObject.printMultInvObjects(wAr);
                    System.out.println();
                    printMonsterstatsOptions(opponent);
                }
            }
            if (input == 2) {
                if (player.getCoins() < 50) {
                    System.out.println("You cheap fuck, You can't afford this info. Get out of here!\n");
                    printMonsterstatsOptions(opponent);
                } else {
                    player.setCoins(player.getCoins() - 50);
                    Weapon[] weapons = opponent.getOnlyWeaponsOfInventory();
                    System.out.printf("\t%s has %d Health points\n", opponent.getName(), (int) opponent.getHealth());
                    System.out.printf("\t%s might use some of the following weapons: \n", opponent.getName());
                    InvObject.printMultInvObjects(weapons);
                    //TODO weaknesses
                }
            }
            input = getInteger();
        }
    }

    private int sellInvObjects(Player player, Blacksmith blacksmith, Scanner response) {
        if (player.getAllItems().length == 0) {
            System.out.printf("\n\t You Have %.2f Coins and are Level %d", player.getCoins(), player.getLvl());
            System.out.println("\n\tYou cheap fuck, You have nothing to offer. Get out of here!\n");
            return -1;
        }
        InvObject[] items = showSellPrice(player);
        InvObject.printMultInvObjects(items);
        System.out.printf("\n\t You Have %.2f Coins and are Level %d \t['-1' to go back]\n", player.getCoins(), player.getLvl());
        int input = getInteger();
        while (input != -1) {
            //TODO heal out of fight
//            if(player.getAllItems()[input].getEnumType().equals(EnumType.POTION)){
//                Potion heal = (Potion) player.getAllItems()[input];
//                player.setHealth(player.getHealth() + heal.getHeal());
//                InvObject[] temp = player.getAllItems();
//                InvObject[] updated = removeItemFromArray(temp, input);
//                player.setAllItems(updated);
//                return -1;
//            }
            player.setCoins(player.getCoins() + (int) (items[input].getPrice() / 3));
            blacksmith.setCoins(blacksmith.getCoins() + (int) (items[input].getPrice() / 3));
            InvObject[] temp = player.getAllItems();
            InvObject[] updated = removeItemFromArray(temp, input);
            player.setAllItems(updated);
            items = showSellPrice(player);
            InvObject.printMultInvObjects(items);
            if (player.getAllItems().length == 0) {
                System.out.println("You cheap fuck, You have nothing to offer. Get out of here!\n");
                return -1;
            }
            System.out.printf("\n\t You Have %.2f Coins and are Level %d \t['-1' to go back]\n", player.getCoins(), player.getLvl());
            input = response.nextInt();
        }
        return input;
    }

    private InvObject[] showSellPrice(Player player) {
        InvObject[] items = player.getAllItems();
        for (InvObject item : items) {
            item.setPrice((int) (item.getPrice() / 3));
        }
        return items;
    }

    public InvObject[] removeItemFromArray(InvObject[] array, int input) {
        InvObject[] temp = new InvObject[array.length - 1];
        array[input] = null;
        int j = 0;
        for (InvObject invObject : array) {
            if (invObject != null) {
                temp[j] = invObject;
                j++;
            }
        }
        return temp;
    }


    private int interactWithHealer(Player player, Healer healer, Scanner response) {
        System.out.println("The Healer gives you a pittyful glance and offers his wares to you:\n");
        InvObject.printMultInvObjects(healer.getInventory());
        System.out.println("Anything you can afford?, the Healer asks, sceptically watching you..\n");
        System.out.printf("\n\t You Have %.2f Coins and are Level %d \t['-1' to go back]\n", player.getCoins(), player.getLvl());

        int input = response.nextInt();
        do {
            if (input > healer.getInventory().length || input < 0) {
                System.out.println("\t\tTake the dick out of your mouth, when you speak with me, i couldn't understand a word");
                input = response.nextInt();
            }
            if (input < healer.getInventory().length && input >= 0) {
                healer.buyItem(input, healer, player);
                System.out.println("Anything else? Otherwise, stop lingering!!\n");
                System.out.printf("\n\t You Have %.2f Coins and are Level %d \t['-1' to go back]\n", player.getCoins(), player.getLvl());
                InvObject.printMultInvObjects(healer.getInventory());
                input = response.nextInt();
            }
        } while (input != -1);
        return input;
    }

    private int interactWithBlacksmith(Player player, Blacksmith blacksmith, Scanner response) {
        System.out.println("You struggle to get the Blacksmiths attention, because of your feeble appearance.\n");
        InvObject.printMultInvObjects(blacksmith.getInventory());
        System.out.println("\n\t\tAnything you can afford?, the Blacksmith asks, not letting you out of his eyesight..\n");
        System.out.printf("\n\t You Have %.2f Coins and are Level %d \t['-1' to go back]\n", player.getCoins(), player.getLvl());
        int input = response.nextInt();
        while (input != -1) {
            if (input > blacksmith.getInventory().length || input < 0) {
                System.out.println("\t\tI couldn't understand your pathetic mumbling, try again and louder this time");
                input = response.nextInt();
            }
            if (input < blacksmith.getInventory().length && input >= 0) {
                blacksmith.buyItem(input, blacksmith, player);
                System.out.println("Anything else? Otherwise stop wasting my time!!\t['-1' to go back]\n");
                System.out.printf("\n\t You Have %.2f Coins and are Level %d \t['-1' to go back]\n", player.getCoins(), player.getLvl());
                InvObject.printMultInvObjects(blacksmith.getInventory());
                input = response.nextInt();
            }
        }
        return input;
    }

    private String printInitialText(Player player) {
        return "Greetings nerdy Warrior, who goes by the name of " + player.getName() + "! What brings you to the shabby Tavern of PimpleTown?\n" +
                " There is a lot to do for a person with your challenged eyesight.. \n" +
                "[1] Do you want to increase your sweat stench by fighting in our arena?\n" +
                "[2] Has your nimble body recently suffered in an embarrassing fight and needs tending?\n" +
                "[3] Do you want to buy weapons that you later brag about in front of your equally nerdy friends... online?\n" +
                "[4] Do you want to dare to look in the mirror to see your equipment and maybe sell items\n";
    }

    public Game(Player player, Character opponent, Healer healer, Blacksmith blacksmith) {
        this.player = player;
        this.opponent = opponent;
        this.healer = healer;
        this.blacksmith = blacksmith;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Character getOpponent() {
        return opponent;
    }

    public void setOpponent(Character opponent) {
        this.opponent = opponent;
    }

    public Healer getHealer() {
        return healer;
    }

    public void setHealer(Healer healer) {
        this.healer = healer;
    }

    public Blacksmith getBlacksmith() {
        return blacksmith;
    }

    public void setBlacksmith(Blacksmith blacksmith) {
        this.blacksmith = blacksmith;
    }

    // Nur für die anzeige in git

    public static Integer getInteger() {
        do {
            try {
                Scanner scan = new Scanner(System.in);
                String string = scan.nextLine();
                scan.close();
                return Integer.parseInt(string);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        } while (true);
    }
}


/////////////////////////DEPRICATED//////////////////////////////////////

//        switch (input) {
//            case 1:
//                //TODO
////                fight
//            case 2:
//                interactWithHealer(player,healer,response,input);
//                break;
//            case 3:
//                interactWithBlacksmith(player, blacksmith, response, input);
//                break;
//            case 4:
//                InvObject.printMultInvObjects(player.getAllItems());
//                break;
//            default:
//                break;
//        }
//        System.out.println(printInitialText(player));
//        input = response.nextInt();
//        do {
//            if (input < 1 || input > 4) {
//                System.out.println("I couldn't understand your pathetic mumbling, try again and louder this time");
//                input = response.nextInt();
//            }
//        } while (input < 1 || input > 4);