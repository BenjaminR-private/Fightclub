package LinkedList;

public class Main {
    public static void main(String[] args) {

        CustomLinkedList lList = new CustomLinkedList();
        lList.add(3);
        lList.add(5);
        lList.add(77);
        lList.add(5);
        lList.add(3);
        lList.add(12);
        lList.add(12);
        lList.addAtBeginning(233);
        lList.iteratePrint();
        System.out.println("-------------------------");
//        lList.removeAtIndex(6);
        lList.iteratePrint();
        System.out.println("-------------------------");
        System.out.println(lList.lengthRec());
        System.out.println("-------------------------");
        lList.iteratePrint();

//        System.out.println(lList.indexOf(new CustomNode(22)));

//        int[] array = lList.allIndicesOf(5);
//        System.out.print("[");
//        for (int i = 0; i < array.length; i++) {
//            System.out.printf("%3d", array[i]);
//        }
//        System.out.println("]");
//        System.out.println("-------------------------");
////        lList.iteratePrint();

    }
}
