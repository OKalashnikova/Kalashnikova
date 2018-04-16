import task5.User;
import task6.CountLitters;
import task6.UserHashMap;

public class Main6 {

    public static UserHashMap<String, User> userHash = new UserHashMap<String, User>(50);
    public static User user1 = new User("Vasya", 01);
    public static User user2 = new User("Inna", 02);
    public static User user3 = new User("Ganna", 03);
    public static User user4 = new User("Stas", 04);
    public static User user5 = new User("Tolik", 05);



    public static void main(String[] args) {

        System.out.println();
        System.out.println("Задание 1");
        System.out.println("-----------");
        userHash.put("one", user2);
        userHash.put("two", user1);
        userHash.put("three", user3);
        userHash.put("four", user4);
        userHash.put("five", user5);
        userHash.put("three", new User("Tom", 07));

        System.out.println();
        System.out.println("Размер таблицы: " + userHash.getThreshold());
        System.out.println();
        System.out.println("Колличество добавленных элементов: " + userHash.getCountKeys());
        System.out.println();
        System.out.println("Достаем объект из таблицы с заданным ключем: " );
        System.out.println(userHash.get("three"));
        System.out.println();


        System.out.println();
        System.out.println("Задание 2");
        System.out.println("-----------");
        System.out.println("Находим уникальные буквы");
        CountLitters.countLitters("Находим уникальные буквы");

    }
}
