import task5.BinarySearch;
import task5.User;
import task5.UserLinkedList;
import task5.UserSearchTree;


public class Main5 {

    public static void main(String[] args) throws Exception {

        //Написать алгоритм бинарного поиска:
        //int binarySearch(int [] data, int element); <- Ищет элемент element в data, возвращает индекс искомого элемента,
        // или в случае отсутствия: -1. Массив data заходит уже отсортированным.

        System.out.println();
        System.out.println("Задание 1");
        System.out.println("-----------");
        int[] array = new int[25];
        System.out.println("Заполняем массив: ");
        BinarySearch.fillArray(array);
        for (int i : array) System.out.print(i + " ");
        System.out.println();
        System.out.println("Ищем индекс в массиве числа 22, если таковое имеется: ");
        System.out.println(BinarySearch.binarySearch(array, 22));

        //Создать класс UserLinkedList. Класс должен содержать методы:
        //boolean add(Object element) <- добавление в конец списка.
        //boolean contains(Object element) <- проверка на наличие.
        //int size() <- возвращает размер списка.
        //boolean isEmpty() <- возвращает true, если список пустой.
        //boolean remove(Object element) <- удаление элемента.
        System.out.println();
        System.out.println("Задание 2");
        System.out.println("-----------");
        UserLinkedList<User> list = new UserLinkedList();
        User user1 = new User("Vasya", 01);
        User user2 = new User("Inna", 02);
        User user3 = new User("Ganna", 03);
        User user4 = new User("Stas", 04);
        User user5 = new User("Tolik", 05);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);

        System.out.println("Существует ли в списке такой пользователь: " + user3.toString() + " " + list.contains(user3));
        System.out.println("Размер списка " + list.size());
        System.out.println("Удаление  из списка пользователя " + user4.toString() + " " + list.remove(user4));
        System.out.println("Размер списка " + list.size());
        System.out.println("Вызываем метод isEmpty? " + list.isEmpty());
        System.out.println("В списке остались такие объекты: ");
        for(User u : list)
        System.out.println(u.toString());

        System.out.println();
        System.out.println("Задание 3");
        System.out.println("-----------");
        System.out.println("Тесты находятся в пакете task5, класс - UserLinkedListTest");


        System.out.println();
        System.out.println("Задание 4");
        System.out.println("-----------");

        UserSearchTree<User> tree = new UserSearchTree();
        System.out.println("Пустое ли дерево? " + tree.isEmpty());
        System.out.println();
        System.out.println("Добавляем элементы: ");
        System.out.println(tree.add(3, user1));
        System.out.println(tree.add(2, user2));
        System.out.println(tree.add(4, user3));
        System.out.println(tree.add(-5, user5));
        tree.print();

        System.out.println();
        System.out.println("Проверяем на наличие такого элемента " + user3.toString());
        System.out.println(tree.contains(user3));

        System.out.println();
        System.out.println("Проверяем на наличие такого элемента " + user4.toString());
        System.out.println(tree.contains(user4));

        System.out.println();
        System.out.println("Размер бинарного дерева " + tree.size());

        System.out.println("\n" + "Пустое ли дерево? " + tree.isEmpty());

        System.out.println("Удаляем объект " + tree.remove(2));
        System.out.println("Размер бинарного дерева после удаления объекта " + tree.size());

    }
}
