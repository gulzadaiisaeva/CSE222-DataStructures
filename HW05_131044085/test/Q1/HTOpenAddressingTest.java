package Q1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HTOpenAddressingTest {

    protected  HTOpenAddressing<Integer,String> myMap = new HTOpenAddressing<>();


    @Test
    void isEmpty() {
        assertEquals(true,myMap.isEmpty());
    }
    @Test
    void get() {
        myMap.put(1,"Iisaeva");
        assertEquals("Iisaeva",myMap.get(1));
    }

    @Test
    void remove() {
        myMap.remove(1);
        assertEquals(true,myMap.isEmpty());
    }

}