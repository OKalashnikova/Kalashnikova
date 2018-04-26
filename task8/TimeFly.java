package task8;

import task3.Animal;

public class TimeFly {
    public int years;

    public void oneYear (){
        years += 1;
    }

    public void setYears(Animal a) {
        this.years = (int) a.getAge();
    }

    public int getYears() {
        return years;
    }
}
