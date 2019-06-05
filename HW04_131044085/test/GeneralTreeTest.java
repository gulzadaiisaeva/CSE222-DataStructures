import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneralTreeTest {

    private GeneralTree<Integer> general=new GeneralTree<>(1);
    @Test
    void add() {
        assertEquals(true,general.add(1,2));
    }

    @Test
    void postOrderSearch() {
        assertEquals(null,general.postOrderSearch(general.root,3));
    }

    @Test
    void levelOrderSearch() {
        general.add(1,2);
        assertEquals(true,general.LevelOrderSearch(general.root,2));
    }


}