import task9.AnimalDao;
import task9.Cat;
import task9.Dog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main9 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");

        Cat cat = new Cat("Despasito", 2);
        Dog dog = new Dog("Kirry", 10);

        AnimalDao animalDao = new AnimalDao(con);
        //animalDao.add(cat);
          //animalDao.add(dog);
         //animalDao.remove(8);
        //System.out.println(dog.getId());
        //animalDao.update(new Cat ("Name", 7, 9));
        //System.out.println(cat.getName() + cat.getAge());
//        Animal a = animalDao.findById(5);
//        System.out.println(a.toString());



//        for(Object a : animalDao.findAll()){
//            System.out.println(a.toString() + "\n");
//        }

        List l = animalDao.findByType(Cat.class);
        for(Object a : l){
            System.out.println(a.toString() + "\n");
        }



//        AnimalDao animalDao = new AnimalDao();
//        Dog dog1 = new Dog("Sharic", 0.2, 04);
//
//        animalDao.add(new Cat("Barsik", 9, 01));
//        animalDao.add(new Cat("Tom", 1.0, 03));
//        animalDao.add(new Dog("Boss", 3.0, 02));
//        animalDao.add(dog1);
//
//        System.out.println("Size " + animalDao.getSizeArrayAnimal());
//
//        System.out.println(animalDao.findByType(Dog.class));
//
//        dog1.setAge(7.0);
//        animalDao.update(dog1);
//        System.out.println(animalDao.findByType(Dog.class));
//
//        animalDao.remove(02);
//        System.out.println(animalDao.findById(03));
//        System.out.println("Size " + animalDao.getSizeArrayAnimal());

    }
}
