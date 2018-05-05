package task9;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.Serializable;

abstract public class Animal implements Serializable {
    String name;
    int age;
    long id;
    int type;
    static int quantity;


    public Animal(){}

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        ++quantity;
    }

    public Animal(String name, int age, long id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    abstract public void voice() throws NotImplementedException;

    public void dyingVoice() {
        System.out.println();
    }

    public static int getQuantity() {
        return quantity;
    }

    public String toString() {
        return getClass() + " " + name + " " + age + " years, id" + id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        final Animal animal = (Animal) obj;

        if (age != animal.age) return false;
        return name != null ? name.equals(animal.name) : animal.name == null;
    }

}
