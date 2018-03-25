package task3;

abstract public class Animal {
    String name;
    double age;
    static int quantity;


    public Animal(String name, double age) {
        this.name = name;
        this.age = age;
        ++quantity;
    }

    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }


    abstract public void voice();

    public void dyingVoice() {
        System.out.println();
    }

    public static int getQuantity() {
        return quantity;
    }

    public String toString() {
        return getClass() + " " + name + " " + age;
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
