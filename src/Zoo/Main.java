package Zoo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int[] results = new int[scan.nextInt()];
//        for (int i = 0; i < results.length; i++) {
//            results[i] = (int) (Math.random() * 6) + 1;
//            System.out.println("Würfelergenbnis " + i + " = " + results[i]);
//        }
////////////////////////////////////////////////////////////////////////
//        int[][] multipTable = new int[10][10];
//        for (int i = 0; i < multipTable.length; i++) {
//            for (int j = 0; j < multipTable[i].length; j++) {
//                multipTable[i][j] = (i + 1) * (j + 1);
//            }
//        }
//        printTable(multipTable);
//    }
//
//    public static void printTable(int[][] ar) {
//        for (int[] Array : ar) {
//            System.out.println();
//            for (int aInt : Array) {
//                System.out.printf("%3d ", aInt);
//            }
//        }

        /////////////////////////////////////////////////////////
        Animal tier1 = new Cat(7.5d, 0.5, 0.75, true, "Garfield");
//        Katzenhalter ich = new Katzenhalter();
//        ich.meineKatzen = new Cat[]{new Cat("Garfield"), new Cat("Tom"),new Cat("Jerry")};
//        Arrays.stream(ich.meineKatzen).forEach(Cat::toString);
        System.out.println(tier1);
    }
}