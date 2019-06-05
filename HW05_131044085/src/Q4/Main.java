package Q4;

import java.util.Random;

/**
 * Tester class which tests average time of each algorithm
 */
public class Main {


    public static void main(String[] args) {
        System.out.println("#################   TESTING Q4    ######################");
        MergeSort merge=new MergeSort();
        InsertionSort insert=new InsertionSort();
        QuickSort quick=new QuickSort();
        HeapSort heap=new HeapSort();
        MergeSortForDLL mergeDLL = new MergeSortForDLL();
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        Long[] time=new Long[50];
        int i;

        Integer[] array=new Integer[200];
        Integer[] sort=new Integer[200];
        //////print(array,200);
        randomGenerate(array,200);
        repeat10times(array,sort,heap,insert,merge,quick,list,mergeDLL,200,time,0);
        printAverage(time);

        Integer[] array2=new Integer[500];
        Integer[] sort2=new Integer[500];
        //////print(array2,500);
        list.root=null;
        randomGenerate(array2,500);
        repeat10times(array2,sort2,heap,insert,merge,quick,list,mergeDLL,500,time,1);
        printAverage(time);



        Integer[] array3=new Integer[1000];
        Integer[] sort3=new Integer[1000];
        //////print(array3,1000);
        list.root=null;
        randomGenerate(array3,1000);
        repeat10times(array3,sort3,heap,insert,merge,quick,list,mergeDLL,1000,time,2);
        printAverage(time);


        Integer[] array4=new Integer[1500];
        Integer[] sort4=new Integer[1500];
        ////print(array4,2000);
        list.root=null;
        randomGenerate(array4,1500);
        repeat10times(array4,sort4,heap,insert,merge,quick,list,mergeDLL,1500,time,3);
        printAverage(time);



        Integer[] array5=new Integer[2000];
        Integer[] sort5=new Integer[2000];
        ////print(array5,4000);
        list.root=null;
        randomGenerate(array5,2000);
        repeat10times(array5,sort5,heap,insert,merge,quick,list,mergeDLL,2000,time,4);
        printAverage(time);


        Integer[] array6=new Integer[2500];
        Integer[] sort6=new Integer[2500];
        ////print(array6,8000);
        list.root=null;
        randomGenerate(array6,2500);
        repeat10times(array6,sort6,heap,insert,merge,quick,list,mergeDLL,2500,time,5);
        printAverage(time);


        Integer[] array7=new Integer[3000];
        Integer[] sort7=new Integer[3000];
        //print(array7,16000);
        list.root=null;
        randomGenerate(array7,3000);
        repeat10times(array7,sort7,heap,insert,merge,quick,list,mergeDLL,3000,time,6);
        printAverage(time);


        Integer[] array8=new Integer[3500];
        Integer[] sort8=new Integer[3500];
        //print(array8,30000);
        list.root=null;
        randomGenerate(array8,3500);
        repeat10times(array8,sort8,heap,insert,merge,quick,list,mergeDLL,3500,time,7);
        printAverage(time);


        Integer[] array9=new Integer[4000];
        Integer[] sort9=new Integer[4000];
        //print(array9,40000);
        list.root=null;
        randomGenerate(array9,4000);
        repeat10times(array9,sort9,heap,insert,merge,quick,list,mergeDLL,4000,time,8);
        printAverage(time);


        Integer[] array10=new Integer[4500];
        Integer[] sort10=new Integer[4500];
        //print(array10,50000);
        list.root=null;
        randomGenerate(array10,4500);
        repeat10times(array10,sort10,heap,insert,merge,quick,list,mergeDLL,4500,time,9);
        printAverage(time);



    }

    /**
     * Printing average time of each algorithm after calculation for given array
     * @param time
     */
    public static void printAverage(Long[] time)
    {
        System.out.println("\nAverage time of Merge Sort:      "+ calculateTime(time,0,9) + "    nanosecond");
        System.out.println("Average time of Insert Sort:     "+ calculateTime(time,10,19)+ "     nanosecond");
        System.out.println("Average time of Quick Sort:      "+ calculateTime(time,20,29)+ "    nanosecond");
        System.out.println("Average time of Heap Sort:       "+ calculateTime(time,30,39)+ "    nanosecond");
        System.out.println("Average time of MergeDLL Sort:   "+ calculateTime(time,40,49)+ "    nanosecond");

    }

    /**
     * Calls sort function ten times for each algorithm
     * @param array
     * @param sort
     * @param heap
     * @param insert
     * @param merge
     * @param quick
     * @param dll
     * @param mergeDLL
     * @param size
     * @param vec
     * @param i
     */
    public static void repeat10times(Integer[] array,Integer[] sort,HeapSort heap,InsertionSort insert,
                                     MergeSort merge, QuickSort quick,DoubleLinkedList<Integer> dll,MergeSortForDLL mergeDLL,int size,Long[] vec,int i){
        System.out.println("\n\n#####################   Array size: "+size+"  ################################");
        for (int j = 0; j < 10; j++) {
            sorts(array,sort,heap,insert,merge,quick,dll,mergeDLL,size,vec,j);
        }
    }

    /**
     * Printing array to the screen
     * @param arr
     * @param size
     */
    public static void print(Integer[] arr,int size)
    {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    /**
     * Copy original random array to the array which will sorted
     * @param original
     * @param copy
     * @param size
     */
    public static void copyArray(Integer[] original,Integer[] copy,int size){
        for (int i = 0; i < size; i++) {
            copy[i]=original[i];
        }
    }

    /**
     * Generate random array
     * @param arr
     * @param size
     */
    public static void randomGenerate(Integer[] arr,int size){
        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i <size ; i++) {
            int x=Math.abs(rand.nextInt(size)); // or long or float ...
            arr[i]=x;
        }
    }

    /**
     * Copy original array to double linked list
     * @param dll
     * @param arr
     * @param size
     */
    public static void addToDoubleLL(DoubleLinkedList<Integer> dll,Integer[] arr, int size)
    {
        for (int i = 0; i <size ; i++) {
            dll.add(arr[i]);
        }
    }

    /**
     * Sorts the given array by using all given algorithms
     * @param array
     * @param sort
     * @param heap
     * @param insert
     * @param merge
     * @param quick
     * @param dll
     * @param mergeDLL
     * @param size
     * @param vec
     * @param i
     */
    public static void sorts(Integer[] array,Integer[] sort,HeapSort heap,InsertionSort insert,
                             MergeSort merge, QuickSort quick,DoubleLinkedList<Integer> dll,MergeSortForDLL mergeDLL,int size,Long[] vec,int i)
    {
        long startTime,endTime,duration;


        //MERGE SORT
        copyArray(array,sort,size);
        startTime = System.nanoTime();
        merge.sort(sort);
        endTime = System.nanoTime();
        duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        vec[i]=duration;
        //System.out.println("Time of Merge Sort       : "+duration);
        //print(sort,size);


        //insertion
        copyArray(array,sort,size);
        startTime = System.nanoTime();
        insert.sort(sort);
        endTime = System.nanoTime();
        duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        vec[i+10]=duration;
        //System.out.println("Time of Insertion Sort   : "+duration);
        //print(sort,size);


        //quick sort
        copyArray(array,sort,size);
        startTime = System.nanoTime();
        quick.sort(sort);
        endTime = System.nanoTime();
        duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        vec[i+20]=duration;
        //System.out.println("Time of Quick  Sort      : "+duration);
        //print(sort,size);

        //heap
        copyArray(array,sort,size);
        startTime = System.nanoTime();
        heap.sort(sort);
        endTime = System.nanoTime();
        duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        vec[i+30]=duration;
        //System.out.println("Time of Heap Sort        : "+duration);
        //print(sort,size);

        //mergeDLL
        addToDoubleLL(dll,array,size);
        startTime = System.nanoTime();
        mergeDLL.sort(dll);
        endTime = System.nanoTime();
        duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        vec[i+40]=duration;
        //System.out.println("Time of MergeDll  Sort   : "+duration);
        //System.out.println(dll.toString());



    }

    /**
     * Calculates the average time
     * @param time
     * @param start
     * @param end
     * @return
     */
    public static long calculateTime(Long[] time, int start, int end){
        long result=0;
        for (int i=start;i<=end;i++) {
            result += time[i];
        }
        return result/10;
    }


}
