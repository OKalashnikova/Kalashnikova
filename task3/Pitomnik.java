package task3;

public class Pitomnik {
    private Animal[] pitomnik = new Animal[6];
    private static int i;

    public int getSize() {
        return pitomnik.length;
    }

    public void addAnimalToPitomnik(Animal animal) {
        pitomnik[i] = animal;
        i++;
    }

    public void printMassive(){
        for (int k = 0; k<pitomnik.length; k++){
            System.out.println(pitomnik[k].toString());
        }
    }

    public void getAnimalFromArray(Object o, int start, int end) {
        System.out.println("Мы выводим вот таких животных: ");
        for (int j = 0; j < pitomnik.length; j++) {
            if (pitomnik[j].getClass().equals(o)) {
                double age = pitomnik[j].getAge();
                while(age >= start && age <= end) {
                    System.out.println(pitomnik[j].toString());
                    break;
                }
            }
        }
    }

}

