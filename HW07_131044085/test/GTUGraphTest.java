import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GTUGraphTest {

    private GTUGraph graph= new GTUGraph(11,true);
    @Test
    void is_undirected() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("graph.txt"));
        graph.loadEdgesFromFile(in);
        assertEquals(false,graph.is_undirected());

    }

    @Test
    void is_connected() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("graph.txt"));
        graph.loadEdgesFromFile(in);
        assertEquals(false,graph.is_connected(3,1));
    }

}