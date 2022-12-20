package LinkedList;

public class CustomLinkedList {
    private CustomNode first = null;

    public void add(int data) {
        CustomNode newNode = new CustomNode(data);
        if (first == null) {
            first = newNode;
        } else {
            CustomNode currentNode = first;
            while (currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = newNode;
        }
    }

    public void addAtBeginning(int data) {
        CustomNode newNode = new CustomNode(data);
        if (first == null) {
            first = newNode;
        } else {
            CustomNode temp = first;
            first = newNode;
            first.nextNode = temp;
        }
    }

    public void iteratePrint() {
        CustomNode currentNode = first;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.nextNode;
        }
    }

    public int iterateCount() {
        CustomNode currentNode = first;
        int count = 0;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.nextNode;
        }
        return count;
    }

    public int indexOf(CustomNode node) {
        boolean found = false;
        CustomNode currentNode = first;
        int i = 0;
        while (!found && currentNode != null) {
            if (currentNode.data == node.data) {
                found = true;
            } else {
                currentNode = currentNode.nextNode;
                i++;
            }
        }
        if (!found) {
            return -1;
        }
        return i;
    }

    public void removeAtIndex(int index) {
        CustomNode tempNode;
        CustomNode currentNode = first;
        int i = 0;
        if (first == null || index > iterateCount()) {
            return;
        }
        if (index == 0) {
            first = first.nextNode;
        }
        while (i != index && currentNode.nextNode != null) {
            if (index == i + 1) {
                tempNode = currentNode;
                tempNode.nextNode = tempNode.nextNode.nextNode;
            }
            currentNode = currentNode.nextNode;
            i++;
        }
    }

    public int[] allIndicesOf(int number) {
        int count = iterateCount();
        int[] array = new int[count];
        CustomNode currentNode = first;
        int i = 0;
        int j = 0;
        while (i < count && currentNode != null) {
            if (currentNode.data == number) {
                array[j] = i;
                j++;
            }
            i++;
            currentNode = currentNode.nextNode;
        }
        int elements = 0;
        for (int k = 0; k < array.length; k++) {
            if (array[k] != 0) {
                elements++;
            }
        }
        int[] tempArray = new int[elements];
        System.arraycopy(array, 0, tempArray, 0, tempArray.length);
        array = tempArray;
        return array;
    }

    public int lengthRec() {
        CustomNode current = first;
        int length = 1;
        if (current.nextNode != null) {
            length = recCount(length, current.nextNode);
        }
        return length;
    }

    public int recCount(int l, CustomNode current) {
        if(current != null){
            current = first.nextNode;
            return recCount(l + 1, current);
        }
        return l - 1;
    }

}
