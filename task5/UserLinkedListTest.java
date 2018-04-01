package task5;

import org.junit.Assert;
import org.junit.Test;

public class UserLinkedListTest {
    private UserLinkedList listTest = new UserLinkedList<User>();

    User user1 = new User("Vasya", 01);
    User user2 = new User("Inna", 02);
    User user3 = new User("Ganna", 03);

//    @Test
//    public void contains() throws Exception {
//    }
//
//    @Test
//    public void size() throws Exception {
//    }

    @Test
    public void add() throws Exception {
        listTest.add(user1);
        Assert.assertNotNull(listTest);
    }

//    @Test
//    public void remove() throws Exception {
//    }

}