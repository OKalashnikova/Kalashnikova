package task9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class AnimalDao {
    protected List<Animal> arrayAnimal = new ArrayList<>();
    public int sizeArrayAnimal = 0;


    public boolean add(Animal animal) {
        int index = getIndex(animal.getId());
        if (index >= 0) {
            System.out.println("Животное с таким id существует");
            return false;
        } else {
            insertAnimal(animal);
//            arrayAnimal.set(sizeArrayAnimal, animal);
            sizeArrayAnimal++;
            return true;
        }
    }


    public boolean remove(long animalId) {
        int index = getIndex(animalId);
        if (index < 0) {
            System.out.println("Животного с таким id не существует");
            return false;
        } else {
            arrayAnimal.remove(index);
            sizeArrayAnimal--;
            return true;
        }
    }

    public boolean update(Animal animal) {
        int index = getIndex(animal.getId());
        if (index<0){
            System.out.println("Животного с таким id не существует");
            return false;
        }else {
            arrayAnimal.set(index, animal);
        }
        return true;
    } //<- обновление по id.

    public Animal findById(long animalId) {
        int index = getIndex(animalId);
        if (index<0){
            System.out.println("Животного с таким id не существует");
            return null;
        }else
        return arrayAnimal.get(index);
    }

    public List<Animal> findAll() {
        return arrayAnimal.stream()
                .limit(sizeArrayAnimal)
                .collect(Collectors.toList());
    }

    public List<Animal> findByType(Object type) {
        return arrayAnimal.stream()
                .filter(obj -> obj.getClass().equals(type))
                .collect(Collectors.toList());
    }


    ///--------------------another methods


    public int getSizeArrayAnimal() {
        return sizeArrayAnimal;
    }

    public int getIndex(long id) {
        for (int i = 0; i < getSizeArrayAnimal(); i++) {
            if (id == ((int) arrayAnimal.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }

    public void insertAnimal(Animal animal) {
        arrayAnimal.add(getSizeArrayAnimal(), animal);
        System.out.println("Animal " + animal.toString());
    }

}
