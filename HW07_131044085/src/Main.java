import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    private static String str = "";

    public static void main(String[] args) throws IOException {

        System.out.println("############### DIRECTED GRAPH ##############################");
        GTUGraph listGraph=new GTUGraph(11,true);
        BufferedReader in = new BufferedReader(new FileReader("graph.txt"));

        listGraph.loadEdgesFromFile(in);
        listGraph.plot_graph();
        System.out.println("is_indirected : "+listGraph.is_undirected());


        if (listGraph.is_connected(3,1))
            System.out.println("Test is_connected: There is a path from " + 3 +" to " + 1);
        else
            System.out.println("Test is_connected: There is no path from " + 3 +" to " + 1);;

        System.out.println("\n################  Depth First Search Test ###############################");
        DepthFirstSearch depthFirstSearch=new DepthFirstSearch(listGraph);
        for (int i = 0; i <depthFirstSearch.getFinishOrder().length ; i++) {
            System.out.print(depthFirstSearch.getFinishOrder()[i]+" -> ");
        }

        System.out.println();
        System.out.println("################  Breadth First Search Test ###############################");
        int []finish=BreadthFirstSearch.breadthFirstSearch(listGraph,1);
        for (int i = 0; i <finish.length ; i++) {
            System.out.print(finish[i]+" -> ");
        }

        System.out.println("\n\n############### UNDIRECTED GRAPH ##############################");
        GTUGraph listGraph2=new GTUGraph(11,false);
        BufferedReader in2 = new BufferedReader(new FileReader("graph.txt"));

        listGraph2.loadEdgesFromFile(in2);
        listGraph2.plot_graph();
        System.out.println("is_indirected : "+listGraph2.is_undirected());



    }



}
