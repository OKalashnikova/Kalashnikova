import task3.*;

import javax.xml.bind.SchemaOutputResolver;
import java.lang.reflect.Array;

public class Main3 {
    static int quantity;
    public static char[] litter = new char[]{'Б', 'В', 'Г', 'Д', 'Ж', 'З', 'Й', 'К', 'Л', 'М', 'Н', 'П', 'Р', 'С', 'Т', 'Ф', 'Х', 'Ц', 'Ч', 'Щ', 'ь', 'ъ', 'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'щ'};
    public static int nullCount;

    public static void main(String[] args) {
        System.out.println("Задание 1");
        Cat cat = new Cat("Васька", 2.0);
        cat.voice();
        System.out.println("Кот по имени " + cat.getName() + ", возраст " + cat.getAge());
        Cat cat2 = new Cat("Пират", 1.4);
        System.out.println("Кот по имени " + cat2.getName() + ", возраст " + cat2.getAge());
        Cat cat3 = new Cat("Кустик", 9.0);
        System.out.println("Кот по имени " + cat3.getName() + ", возраст " + cat3.getAge());
        Cat cat4 = new Cat("Пушок", 0.6);
        System.out.println("Кот по имени " + cat4.getName() + ", возраст " + cat4.getAge());
        Dog dog = new Dog("Барбос", 4.0);
        dog.voice();
        System.out.println("Пес по имени " + dog.getName() + ", возраст " + dog.getAge());
        Dog dog2 = new Dog("Бетховен", 5.0);
        System.out.println("Пес по имени " + dog2.getName() + ", возраст " + dog2.getAge());
        Dog dog3 = new Dog("Тузик", 15.0);
        System.out.println("Пес по имени " + dog3.getName() + ", возраст " + dog3.getAge());

        quantity = Animal.getQuantity();
        System.out.println("Всего животных " + quantity);

        System.out.println();
        System.out.println("Задание 2");

        Animal[] array = new Animal[7];
        array[0] = cat;
        array[1] = cat2;
        array[2] = dog;
        array[3] = dog2;
        array[4] = dog3;
        array[5] = cat3;
        array[6] = cat4;

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].toString() + " " + array[i].getClass() + "\n");
        }


        System.out.println();
        System.out.println("Задание 3");
        arrayPet(array); // выполняем проверку и для котов и вобак, которые не соответствуют условиям
        Animal[] array2 = new Animal[array.length - nullCount]; // избаляемся от null в массиве, создав новый
        transformArray(array, array2, nullCount);
        System.out.println("В массиве остались такие животные: ");
        for(Animal a : array2){
            System.out.println(a.toString());
        }


        System.out.println();
        System.out.println("Задание 4");

        Pitomnik pitomnik = new Pitomnik();
        System.out.println("Создаем питомник с таким колличеством мест для животных " + pitomnik.getSize());
        pitomnik.addAnimalToPitomnik(cat);
        pitomnik.addAnimalToPitomnik(cat2);
        pitomnik.addAnimalToPitomnik(cat3);
        pitomnik.addAnimalToPitomnik(dog);
        pitomnik.addAnimalToPitomnik(dog2);
        pitomnik.addAnimalToPitomnik(dog3);

        pitomnik.printMassive();
        System.out.println();
        pitomnik.getAnimalFromArray(Cat.class, 2, 10);
        System.out.println("- - - -");
        pitomnik.getAnimalFromArray(Dog.class, 9, 19);


        System.out.println();
        System.out.println();
        System.out.println("Задание 5");
        ArrayCreator zadacha = new ArrayCreator();
        zadacha.arrayConvert(zadacha.arrayCreat(9));
        System.out.println();
        System.out.println("Вариант без вложенных циклов");
        zadacha.preobrazArr(zadacha.arrayCreat(8));

    }


    // Задание 3 - метод, который из созданного в п.2 массива удалит всех котов младше 1 года или старше 8 лет,
    // а также всех собак, чьё имя содержит больше 4 согласных букв.
    private static void arrayPet(Animal[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].getClass().equals(Cat.class)) {
                if (array[i].getAge() < 1.0 || array[i].getAge() > 8) {
                    System.out.println("Кот " + array[i].getName() + " будет удален из массива");
                    array[i] = null;
                    nullCount += 1;
                }
            } else {
                int count = countLitters(array[i].getName(), litter);
                if (count > 4) {
                    System.out.println("Пес " + array[i].getName() + " будет удален из массива");
                    array[i] = null;
                    nullCount += 1;
                }
            }
        }
    }


    public static Animal[] transformArray(Animal[] mass, Animal[] mass2, int nullCount) {
        int j = 0;
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] != null) {
                mass2[j] = mass[i];
                j++;
            }
        }
        return mass2;
    }


// Метод по поиску согласных букв в слове для 3-го задания

    public static int countLitters(String name, char[] litter) {
        int count = 0;
        for (int i = 0; i < name.length(); i++) {
            for (int j = 0; j < litter.length; j++) {
                if (name.charAt(i) == litter[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
