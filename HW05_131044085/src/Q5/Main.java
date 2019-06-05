package Q5;

/**
 * Tester class which tests worst-case time of each algorithm
 */
public class Main {


    public static void main(String[] args) {
        System.out.println("#################   TESTING Q5    ######################");
        MergeSort merge=new MergeSort();
        InsertionSort insert=new InsertionSort();
        QuickSort quick=new QuickSort();
        HeapSort heap=new HeapSort();
        MergeSortForDLL mergeDLL = new MergeSortForDLL();
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        Long[] time=new Long[50];
        int i;

        Integer[] array=new Integer[100];
        Integer[] sort=new Integer[100];
        generateArray(array,100);
        sorts(array,sort,heap,insert,merge,quick,list,mergeDLL,100,time,0);
        printTime(time,100,0);

        Integer[] array2=new Integer[1000];
        Integer[] sort2=new Integer[1000];
        generateArray(array2,1000);
        //////print(array2,500);
        list.root=null;
        sorts(array2,sort2,heap,insert,merge,quick,list,mergeDLL,1000,time,1);
        printTime(time,1000,1);


        Integer[] array3=new Integer[5000];
        Integer[] sort3=new Integer[5000];
        generateArray(array3,5000);
        //////print(array3,1000);
        list.root=null;
        sorts(array3,sort3,heap,insert,merge,quick,list,mergeDLL,5000,time,2);
        printTime(time,5000,2);

        Integer[] array4=new Integer[10000];
        Integer[] sort4=new Integer[10000];
        generateArray(array4,10000);
        ////print(array4,2000);
        list.root=null;
        sorts(array4,sort4,heap,insert,merge,quick,list,mergeDLL,10000,time,3);
        printTime(time,10000,3);


        Integer[] array5=new Integer[15000];
        Integer[] sort5=new Integer[15000];
        generateArray(array5,15000);
        ////print(array5,4000);
        list.root=null;
        sorts(array5,sort5,heap,insert,merge,quick,list,mergeDLL,15000,time,4);
        printTime(time,15000,4);


    }
    public static void print(Integer[] arr,int size)
    {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void copyArray(Integer[] original,Integer[] copy,int size){
        for (int i = 0; i < size; i++) {
            copy[i]=original[i];
        }
    }
    public static void generateArray(Integer[] arr,int size){
        int counter=0;
        for (int i = size; i >0 ; i--) {
            arr[counter]=i;
            counter++;
        }
    }

    public static void addToDoubleLL(DoubleLinkedList<Integer> dll,Integer[] arr, int size)
    {
        for (int i = 0; i <size ; i++) {
            dll.add(arr[i]);
        }
    }

    public static void sorts(Integer[] array,Integer[] sort,HeapSort heap,InsertionSort insert,
                             MergeSort merge, QuickSort quick,DoubleLinkedList<Integer> dll,MergeSortForDLL mergeDLL,int size,Long[] vec,int i)
    {
        long startTime,endTime,duration;
        //merge sort
        copyArray(array,sort,size);
        startTime = System.nanoTime();
        merge.sort(sort);
        endTime = System.nanoTime();
        duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        vec[i]=duration;
        //print(sort,size);


       //insertion sort
        copyArray(array,sort,size);
        startTime = System.nanoTime();
        insert.sort(sort);
        endTime = System.nanoTime();
        duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        vec[i+10]=duration;
        //print(sort,size);


        //quicksort
        copyArray(array,sort,size);
        startTime = System.nanoTime();
        quick.sort(sort);
        endTime = System.nanoTime();
        duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        vec[i+20]=duration;
        //print(sort,size);

        //heapsort
        copyArray(array,sort,size);
        startTime = System.nanoTime();
        heap.sort(sort);
        endTime = System.nanoTime();
        duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        vec[i+30]=duration;
        //print(sort,size);

        //mergedoubled
        addToDoubleLL(dll,array,size);
        startTime = System.nanoTime();
        mergeDLL.sort(dll);
        endTime = System.nanoTime();
        duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        vec[i+40]=duration;
        //System.out.println(dll.toString());



    }

    public static void printTime(Long[] time, int size,int index){
        System.out.println("\n##############   Size of array: "+size+" #####################");
        System.out.println("Time of Merge  Sort:    "+ time[index]);
        System.out.println("Time of Insert Sort:    "+time[index+10]);
        System.out.println("Time of Quick Sort:     "+ time[index+20]);
        System.out.println("Time of Heap Sort:      "+ time[index+30]);
        System.out.println("Time of MergeDLL Sort:  "+ time[index+40]);
    }
}
