import java.util.*;
import java.io.*;

/** A GTUGraph is an extension of the AbstractGraph abstract class
*   that uses an array of lists to represent the edges.
*   @author Koffman and Wolfgang
*/

public class GTUGraph
    extends AbstractGraph {

  // Data Field
  /** An array of Lists to contain the edges that
      originate with each vertex. */
  private List < Edge > [] edges;


  /** Construct a graph with the specified number of
      vertices and directionality.
      @param numV The number of vertices
      @param directed The directionality flag
   */
  public GTUGraph(int numV, boolean directed) {
    super(numV, directed);
    edges = new List[numV];
    for (int i = 0; i < numV; i++) {
      edges[i] = new LinkedList < Edge > ();
    }
  }

  /** Determine whether an edge exists.
      @param source The source vertex
      @param dest The destination vertex
      @return true if there is an edge from source to dest
   */
  public boolean isEdge(int source, int dest) {
    return edges[source].contains(new Edge(source, dest));
  }

  /** Insert a new edge into the graph.
      @param edge The new edge
   */
  public void insert(Edge edge) {
    edges[edge.getSource()].add(edge);
    if (!isDirected()) {
      edges[edge.getDest()].add(new Edge(edge.getDest(),
                                         edge.getSource(),
                                         edge.getWeight()));
    }
  }

  public Iterator < Edge > edgeIterator(int source) {
    return edges[source].iterator();
  }

  /** Get the edge between two vertices. If an
      edge does not exist, an Edge with a weight
      of Double.POSITIVE_INFINITY is returned.
      @param source The source
      @param dest The destination
      @return the edge between these two vertices
   */
  public Edge getEdge(int source, int dest) {
    Edge target =
        new Edge(source, dest, Double.POSITIVE_INFINITY);
    for (Edge edge : edges[source]) {
      if (edge.equals(target))
        return edge; // Desired edge found, return it.
    }
    // Assert: All edges for source checked.
    return target; // Desired edge not found.
  }

  /** Load the edges of a graph from the data in an input file.
        The file should contain a series of lines, each line
        with two or three data values. The first is the source
        the second is the destination, and the optional third
        is the weight
        @param bufferedReader The BufferedReader that is connected
                              to the file that contains the data
        @throws IOException - If an I/O error occurs
   */
  public void loadEdgesFromFile(BufferedReader bufferedReader) throws
      IOException {
    /**** BEGIN EXERCISE ****/
    String line;
    Random rand = new Random(System.currentTimeMillis());
    while ( (line = bufferedReader.readLine()) != null
           && line.length() != 0) {
      Scanner sc = new Scanner(line);
      int source = sc.nextInt();
      int dest = sc.nextInt();
      double weight=0.0;
      if(isDirected()){
        weight =Math.abs(rand.nextInt(100))+1; // or long or float ...
      }
      insert(new Edge(source, dest, weight));
    }
    /**** END EXERCISE ****/
  }

    /**
     * ​ plot showing all vertices (labeled) and edges.
     */
  public void plot_graph(){

    if(isDirected()){
        for (int i = 0; i < edges.length; i++) {
          if(edges[i].size()!=0){
            System.out.print(edges[i].get(0).getSource()+" weight:"+ edges[i].get(0).getWeight());
          }
          for (int j = 0; j < edges[i].size(); j++) {
            System.out.print("  ->  "+edges[i].get(j).getDest()+" weight:"+ edges[i].get(0).getWeight());
          }
          System.out.println();
        }
    }
    else
    {
        for (int i = 0; i < edges.length; i++) {
          if(edges[i].size()!=0){
            System.out.print(edges[i].get(0).getSource());
          }
          for (int j = 0; j < edges[i].size(); j++) {
            System.out.print("  ->  "+edges[i].get(j).getDest());
          }
          System.out.println();
        }
    }

  }

    /**
     * Check if the graph object is undirected
     * @return
     */
  public boolean is_undirected(){
    return (!isDirected());
  }

    /**
     * Determine if there is any path between vertex ​ v1(s) and vertex ​ v2(d)
     * @param s
     * @param d
     * @return
     */
  public boolean is_connected(int s, int d)
  {
    LinkedList<Integer>temp;

    // Mark all the vertices as not visited(By default set
    // as false)
    boolean visited[] = new boolean[getNumV()];

    // Create a queue for BFS
    LinkedList<Integer> queue = new LinkedList<Integer>();

    // Mark the current node as visited and enqueue it
    visited[s]=true;
    queue.add(s);

    // 'i' will be used to get all adjacent vertices of a vertex
    Iterator<Edge> i;
    while (queue.size()!=0)
    {
      // Dequeue a vertex from queue and print it
      s = queue.poll();

      Edge n;
      i = edges[s].listIterator();

      // Get all adjacent vertices of the dequeued vertex s
      // If a adjacent has not been visited, then mark it
      // visited and enqueue it
      while (i.hasNext())
      {
        n = i.next();

        // If this adjacent node is the destination node,
        // then return true
        if (n.getSource()==d)
          return true;

        // Else, continue to do BFS
        if (!visited[n.getSource()])
        {
          visited[n.getSource()] = true;
          queue.add(n.getSource());
        }
      }
    }

    // If BFS is complete without visited d
    return false;
  }

}
