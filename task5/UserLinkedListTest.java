package task5;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserLinkedListTest {

    private UserLinkedList<User> listTest;

    @Before
    public void initTest() {
        listTest = new UserLinkedList<User>();
        listTest.add(user1);
    }

    // Dorabotat s iteratorom i udaleniem
    @After
    public void afterTest() {
        listTest = null;
    }

    User user1 = new User("Vasya", 01);
    User user2 = new User("Inna", 02);
    User user3 = new User("Ganna", 03);

    @Test
    public void contains(){
        Assert.assertEquals(user1, listTest.contains(user1));
    }

}