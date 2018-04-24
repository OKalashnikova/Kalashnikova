import task3.Animal;
import task3.Cat;
import task3.Dog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main7 {


    public static void main(String[] args) {

        //Создать функциональный интерфейс, который содержит метод,
        // принимающий массив строк и возвращающий int.
        // Реализовать данный интерфейс с помощью лямбды.
        // Метод должен возвращать сумму кол-ва символов во всех строках.
        System.out.println();
        System.out.println("Задание 1");
        String[] array = new String[4];
        array[0] = "функциональный интерфейс";
        array[1] = "содержит метод";
        array[2] = "принимающий массив строк";
        array[3] = "возвращающий int";


        Count consumer = (String[] arr) -> {
            int sum = 0;
            for (String s : arr) sum += s.length();
            return sum;
        };
        System.out.println("Колличество символов во всех строках массива " + consumer.count(array));


        // Написать метод, который принимает на вход массив животных и возвращает первые 5 животных,
        // чей возраст не больше 5 лет и имя начинается на a,b или c в отсортированном по возрасту виде.
        // Использовать stream api
        System.out.println();
        System.out.println("Задание 2");
        Animal[] arrayAnimals = {
                new Cat("Alice", 4),
                new Dog("Bob", 2),
                new Dog("Martin", 1),
                new Cat("Carry", 6),
                new Cat("Adam", 4),
                new Cat("Billy", 2),
                new Dog("Sam", 9),
                new Dog("Tom", 7),
                new Cat("Catty", 1),
                new Cat("Antuanetta", 3)
        };


        System.out.println(Arrays.stream(arrayAnimals)
                .filter((obj) -> obj.getName().charAt(0) == 'A' || obj.getName().charAt(0) == 'B' || obj.getName().charAt(0) == 'C')
                .filter((obj) -> obj.getAge() < 5)
                .limit(5)
                .sorted((obj1, obj2) -> Integer.compare((int) obj1.getAge(), (int) obj2.getAge()))
                .collect(Collectors.toList()));


        //Написать метод, который принимает на вход массив положительных int,
        // и возвращает коллекцию животных, возраст которых будет равнятся значению из переданного извне массива.
        // Животное должно быть котом, если число четное, в противном случае - собакой.
        // Имя может быть произвольным. Использовать stream api
        System.out.println();
        System.out.println("Задание 3");
        int[] arrayInt = {2, 1, 4, 5, 6, 8, 9, 3};
        System.out.println(returnCollection(arrayInt));

        System.out.println();
        System.out.println("Задание 4");
        System.out.println("Имя потока " + Thread.currentThread().getName());

    }

    @FunctionalInterface
    interface Count {
        int count(String[] string);
    }

    public static ArrayList<Animal> returnCollection(int[] arrayInt) {
        List<Animal> animals = new ArrayList<>();

        Arrays.stream(arrayInt).forEach(value -> {
            if (value % 2 == 0) animals.add(new Cat("Cat", value));
            else animals.add(new Dog("Dog", value));
        });

        return (ArrayList<Animal>) animals;
    }
}
