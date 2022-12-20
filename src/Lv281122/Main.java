package Lv281122;

public class Main {
    public static void main(String[] args) {

        VerketteteListe liste = new VerketteteListe();
        liste.addToBeginn(3);
        liste.addToBeginn(5);
        liste.addToBeginn(6);
        System.out.println(liste);
        System.out.println(liste.laenge());
        System.out.println(liste.summe());
        System.out.print("[");
        for (int i = 0; i < liste.makeArray().length; i++) {
            System.out.printf("%3d", liste.makeArray()[i]);
        }
        System.out.print("]\n");

        liste.addAtIndex(12, 0);
        liste.addAtIndex(12, 3);

        System.out.println(liste);

        liste.delValues(12);
        System.out.println(liste);

    }
}

//////////////////////////////////////////////////////

//    Scanner scan = new Scanner(System.in);
//        int[] array = new int[1];
//
//        while(true){
//            int input =  scan.nextInt();
//            if(input == 0){
//                break;
//            }
//            int[] arrayTemp = new int[array.length+1];
//            array[array.length-1] = input;
//            for (int i = 0; i < array.length; i++) {
//                arrayTemp[i] = array[i];
//                System.out.printf(" " + arrayTemp[i]);
//            }
//            array = arrayTemp;
//        }
//////////////////////////////////////////////////////