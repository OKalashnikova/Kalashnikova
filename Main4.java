import task4.Fish;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import task3.Animal;
import task3.Cat;
import task3.Dog;

public class Main4 {

    public static void main(String[] args) throws NotImplementedException {
        System.out.println("Задание 1");
        System.out.println("----------");
        //Сделать так, чтобы животные одинакового типа и с одинаковым возрастом и именем
        // при проверке на equals были распознаны, как одинаковые.

        Cat cat8 = new Cat("Барбарис", 1.2);
        Cat cat9 = new Cat("Барбарис", 1.2);
        System.out.println("Имена одного кота " + cat8.getName() + " и второго " + cat9.getName() + " а так же их возраст " +
                cat8.getAge() + " и " + cat9.getAge() + " являются " + cat8.equals(cat9));

        Dog dog4 = new Dog("Атос", 5.8);
        Dog dog5 = new Dog("Атос", 5.8);
        System.out.println("Имена одной собаки " + dog4.getName() + " и второй " + dog5.getName() + " а так же их возраст " +
                dog4.getAge() + " и " + dog5.getAge() + " являются " + dog4.equals(dog5));

        System.out.println("");
        System.out.println("Задание 2");
        System.out.println("----------");
        // Реализовать метод toString() в супертипе, чтобы он печатал информацию о типе животного, возрасте и имени
        Cat cat10 = new Cat("Молекула", 3.2);
        Dog dog6 = new Dog("Сапер", 4.0);
        System.out.println(cat10.toString());
        System.out.println(dog6.toString());


        System.out.println();
        System.out.println("Задание 3");
        System.out.println("----------");
        //Создать реализации метода void dyingVoice() в Cat и Dog.
        // Метод должен печатать на консоль звук, издаваемый животным перед смертью(можно выбрать любой).
        // Сделать так, чтобы метод вызывался на животном перед его уничтожением сборщиком мусора.
        // Спровоцировать выполнение сборщика мусора(создать очень много объектов, на которые нет ссылок).
        // Убедиться, что животных слышно перед смертью.
//        for (int i=0; i<1000000; i++){
//            new Cat("Pufic", 0.1);
//            new Dog("Artemon", 15.0);
//        }

        System.out.println();
        System.out.println("Задание 4");
        System.out.println("----------");
        //Создать статический метод, который принимает на вход объект,
        // и возвращает строку, содержащую имя класса данного объекта.
        System.out.println("Животное c именем " + cat8.getName() + " относится к такому классу " + getType(cat8));
        System.out.println("Животное c именем " + dog6.getName() + " относится к такому классу " + getType(cat8));


        System.out.println();
        System.out.println("Задание 5");
        System.out.println("----------");
        //Создать класс Fish, который будет наследовать Animal.
        // При вызове метода voice, рыба должна выбрасывать NotImplementedException.
        // Добавить несколько рыб в массив с разными животными.
        // Проитерироваться по массиву, и вызвать метод voice на каждом животном.
        // Подсчитать, сколько раз выпадет NotImplementedException, и вывести кол-во на консоль.

        Fish fish1 = new Fish("Bul Bul", 1.0);
        Fish fish2 = new Fish("Ocean", 1.4);
        Fish fish3 = new Fish("Полосатик", 0.6);

        Animal[] array = {dog4, cat8, cat10, fish1, fish2, dog6, fish3};

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            try {
                array[i].voice();
            } catch (NotImplementedException e) {
                count++;
            }
        }
        System.out.println("Попытки заговорить с рыбой были " + count + " раза");

    }


    public static Class<?> getType(Object o) {
        return o.getClass();
    }

}


//http://qaru.site/questions/15992/why-does-notimplementedexception-exist