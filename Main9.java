import task9.AnimalDao;
import task9.Cat;
import task9.Dog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main9 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");

        Cat cat = new Cat("Murchik", 4);
        Dog dog = new Dog("Kirry", 11);

        AnimalDao animalDao = new AnimalDao(con);

// PART 1
        // --Добавляем животных
        //animalDao.add(cat);
        //animalDao.add(dog);


// PART 2
        //--Удаляем животное
        //animalDao.remove(8);

// PART3
        //--Обновляем животное
        //animalDao.update(new Dog("Kirri_new_name", 16, 9));

// PART4
        //--Найти животное по id
//        System.out.println("Животное с id " + 7);
//        System.out.println(animalDao.findById(7).toString());

// PART5
        //--Достать всех животных из таблицы
//        for(Object a : animalDao.findAll()){
//            System.out.println(a.toString() + "\n");
//        }

// PART6
        //--Достать всех животных одного заданного класса
//        List l = animalDao.findByType(Dog.class);
//        for (Object a : l) {
//            System.out.println(a.toString() + "\n");
//        }


    }
}
