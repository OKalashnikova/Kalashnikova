package task5;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserSearchTreeTest {
    private UserSearchTree<User> userTree;
    User user3 = new User("Ganna", 03);
    User user4 = new User("Stas", 04);
    User user5 = new User("Tolik", 05);

    @Before
    public void load() {

        userTree = new UserSearchTree<>();
        userTree.add(7, user3);
        userTree.add(11, user4);
        userTree.add(2, user5);
    }

    @After
    public void end(){
        userTree = null;
    }


    @Test
    public void add() throws Exception {
        User u = userTree.getValue(userTree.getRoot(), 11);
        assertEquals(user4, u);
    }

    @Test
    public void contains() throws Exception {
        boolean u = userTree.contains(userTree.getRoot(),2);
        assertTrue(u);
    }

    @Test
    public void isEmpty() throws Exception {
        boolean result = userTree.isEmpty();
        Assert.assertEquals(false, result);
    }

    @Test
    public void remove() throws Exception {
        boolean r = userTree.remove(11);
        Assert.assertEquals(true, r);
        User u = userTree.getValue(userTree.getRoot(), 11);
        assertEquals(null, u);
    }

    @Test
    public void findRightLeaf() throws Exception {
        int max = userTree.findRightLeaf(userTree.getRoot());
        Assert.assertEquals(11, max);
    }

    @Test
    public void findLeftLeaf() throws Exception {
        int min = userTree.findLeftLeaf(userTree.getRoot());
        Assert.assertEquals(2, min);
    }



    @Test
    public void size() throws Exception {
        assertEquals(3, userTree.size());
    }

}