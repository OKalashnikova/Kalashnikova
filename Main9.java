import task9.AnimalDao;
import task9.Cat;
import task9.Dog;

import java.sql.SQLException;
import java.util.List;

public class Main9 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Cat cat = new Cat("Murchik", 4);
        Dog dog = new Dog("Kirry", 11);
        Cat cat2 = new Cat("Finik", 3);
        Cat cat3 = new Cat("Ali", 9);
        Dog dog2 = new Dog("Barry", 1);

        AnimalDao animalDao = new AnimalDao();

// PART 1
        // --Добавляем животных
        animalDao.add(cat);
        animalDao.add(cat2);
        animalDao.add(cat3);
        animalDao.add(dog);
        animalDao.add(dog2);


// PART 2
        //--Удаляем животное
        animalDao.remove(18);


// PART3
        //--Обновляем животное
        animalDao.update(new Dog("Kirri_new_name", 16, 19));

// PART4
        //--Найти животное по id
        System.out.println("Животное с id " + 7);
        System.out.println(animalDao.findById(7).toString());

// PART5
        //--Достать всех животных из таблицы
        for(Object a : animalDao.findAll()){
            System.out.println(a.toString() + "\n");
        }

// PART6
        //--Достать всех животных одного заданного класса
        List l = animalDao.findByType(Dog.class);
        for (Object a : l) {
            System.out.println(a.toString() + "\n");
        }

    }
}
