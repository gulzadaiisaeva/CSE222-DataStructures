package Q2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashtableChainTest {
    HashtableChain<Integer> hash=new HashtableChain<>();
    @Test
    void add() {
        assertEquals(true,hash.add(10));
    }
    @Test
    void contains() {
        hash.add(45);
        assertEquals(true,hash.contains(45));
    }
    @Test
    void isEmpty() {
        hash.add(34);
        assertEquals(false,hash.isEmpty());
    }
    @Test
    void size() {
    }

}