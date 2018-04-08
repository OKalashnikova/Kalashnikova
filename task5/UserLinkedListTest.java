package task5;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserLinkedListTest {
    private UserLinkedList<User> listTest;
    private User user1 = new User("Vasya", 01);
    private User user2 = new User("Inna", 02);

    @Before
    public void load() {
        UserLinkedList.size = 0;
        listTest = new UserLinkedList<>();
        listTest.add(user1);
        listTest.add(user2);
    }

    @After
    public void end(){
        listTest = null;
    }


    @Test
    public void add() throws Exception {
        Assert.assertNotNull(listTest.getElementByIndex(1));
    }

    @Test
    public void contains() throws Exception {
        boolean u = listTest.contains(user1);
        assertTrue(u);
    }



    @Test
    public void isEmpty() throws Exception {
        boolean result = listTest.isEmpty();
        assertEquals(false, result);
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals (2, listTest.size());
    }

    @Test
    public void remove() throws Exception {
        boolean remove = listTest.remove(user2);
        assertTrue(remove);
    }
}