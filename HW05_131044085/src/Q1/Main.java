package Q1;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static void main(String[] args){

    func1();
    func2();

    }

    public static void func1(){
        HTOpenAddressing<String,String> myMap = new HTOpenAddressing<>();
        System.out.println("#########################################################");
        System.out.println("########  TESTING Q1:DOUBLE HASHING MAP      ############");
        System.out.println("########  READS COUNTRIES/CAPITALS FROM FILE ############");
        System.out.println("########  Key: COUNTRY, Value: CAPITAL       ############");
        System.out.println("#########################################################\n");

        System.out.println("isEmpty(): "+ myMap.isEmpty()+"\n");
        try {
            String csvFile = "capitals.txt";
            String line = "";
            String cvsSplitBy = " ";
            BufferedReader in = new BufferedReader(new FileReader(csvFile));
            while ( (line = in.readLine() ) != null) {
                String[] tokens = line.split(cvsSplitBy);
                myMap.put(tokens[0],tokens[1]);
                System.out.println("Value :"+ myMap.get(tokens[0]));
            }

            System.out.println("\nisEmpty(): "+ myMap.isEmpty());
            System.out.println("size() :  "+ myMap.size());
            System.out.println("remove(Almanya): "+myMap.remove("Almanya"));
            System.out.println("remove(Kenya): "+myMap.remove("Kenya"));
            System.out.println("remove(Fas): "+myMap.remove("Fas"));
            System.out.println("get(Fas): " + myMap.get("Fas"));
            System.out.println("size() :  "+ myMap.size());



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void func2(){
        HTOpenAddressing<Integer,String> myMap2 = new HTOpenAddressing<>();
        System.out.println("################################################################");
        System.out.println("########  TESTING Q1:DOUBLE HASHING MAP      ###################");
        System.out.println("########  READS COURSENUMBER/COURSENAME FROM FILE ##############");
        System.out.println("########  Key: COURSENUMBER, Value: COURSENAME       ############");
        System.out.println("#########################################################\n");

        System.out.println("isEmpty(): "+ myMap2.isEmpty()+"\n");

        myMap2.put(100,"math");
        myMap2.put(131,"Physic");
        myMap2.put(200,"Chemistry");
        myMap2.put(145,"Biology");
        myMap2.put(101,"Computer");
        myMap2.put(567,"Laboratory");
        myMap2.put(349,"Algebra");
        myMap2.put(372,"Linear");
        myMap2.put(453,"Training");
        myMap2.put(243,"Tennis");
        myMap2.put(232,"Astronomy");
        myMap2.put(767,"Music");



        System.out.println("\nsize() :  "+ myMap2.size());
        System.out.println("isEmpty(): "+ myMap2.isEmpty());
        System.out.println("remove(100): "+myMap2.remove(100));
        System.out.println("remove(131): "+myMap2.remove(131));
        System.out.println("remove(567): "+myMap2.remove(567));
        System.out.println("get(567): " + myMap2.get(567));
        System.out.println("size() :  "+ myMap2.size());

    }

}

