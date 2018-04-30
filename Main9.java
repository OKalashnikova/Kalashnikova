import task9.AnimalDao;
import task9.Cat;
import task9.Dog;

public class Main9 {
    public static void main(String[] args) {
        AnimalDao animalDao = new AnimalDao();
        Dog dog1 = new Dog("Sharic", 0.2, 04);

        animalDao.add(new Cat("Barsik", 9, 01));
        animalDao.add(new Cat("Tom", 1.0, 03));
        animalDao.add(new Dog("Boss", 3.0, 02));
        animalDao.add(dog1);

        System.out.println("Size " + animalDao.getSizeArrayAnimal());

        System.out.println(animalDao.findByType(Dog.class));

        dog1.setAge(7.0);
        animalDao.update(dog1);
        System.out.println(animalDao.findByType(Dog.class));

        animalDao.remove(02);
        System.out.println(animalDao.findById(03));
        System.out.println("Size " + animalDao.getSizeArrayAnimal());

    }
}
