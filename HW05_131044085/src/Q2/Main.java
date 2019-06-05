package Q2;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class Main {

    public static void main(String [] args)
    {

       System.out.println("#################   TESTING Q2    ######################");
       HashtableChain<Integer> hash=new HashtableChain<>();
       System.out.println("Is Empty:    "+hash.isEmpty());
       System.out.println("Size:        "+hash.size());
       System.out.println("Add 10:      "+ hash.add(10));
       System.out.println("Add 20:      "+hash.add(20));
       System.out.println("Add 40:      "+hash.add(40));
       System.out.println("Add 45:      "+hash.add(45));
       System.out.println("Add 55:      "+hash.add(55));
       System.out.println("Add 83:      "+hash.add(83));
       System.out.println("Add 43:      "+hash.add(43));
       System.out.println("\nAdd 10:      "+ hash.add(10));
        System.out.println("Add 43:      "+hash.add(43));
       System.out.println("\nIs Empty:    "+hash.isEmpty());
       System.out.println("\nContains 30: "+hash.contains(30));
       System.out.println("Contains 10: "+hash.contains(10));
       System.out.println("\nSize:        "+hash.size());
       Set<Integer> s=new HashSet<>();
       s.add(10);
       System.out.println("AddAll {Set s(10)} :"+hash.addAll(s));
       s.add(70);
       System.out.println("ContainsAll {Set s(10,70} :"+hash.containsAll(s));

       Set<Integer> s2=new HashSet<>();
        s2.add(50);
        s2.add(90);
        s2.add(12);
        s2.add(7);
        System.out.println("\nAddAll {Set s2} :"+hash.addAll(s2));
        System.out.println("ContainsAll {Set s2} :"+hash.containsAll(s2));
        System.out.println("Size:        "+hash.size());
    }
}
