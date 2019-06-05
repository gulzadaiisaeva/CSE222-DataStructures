package Q3;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        Integer[] array=new Integer[50];
        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i <50 ; i++) {
            int x=Math.abs(rand.nextInt(50)); // or long or float ...
            array[i]=x;
        }
        for (int i = 0; i < 50; i++) {
            list.add(array[i]);
        }
        System.out.println("#################   TESTING Q3    ######################");
        System.out.println("\n ORIGINAL ARRAY \n");
        System.out.println(list.toString());
        MergeSortForDLL obj = new MergeSortForDLL();

        System.out.println("\n SORTED ARRAY \n");
        obj.sort(list);
        System.out.println(list.toString());
    }
}
