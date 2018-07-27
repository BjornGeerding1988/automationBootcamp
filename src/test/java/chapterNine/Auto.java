package chapterNine;

public class Auto {

    public void setColour(String carColour) {
        System.out.println("The colour of the car is " + carColour);
    }

    public void setBrand(String carBrand) {
        System.out.println("The brand of the car is " + carBrand);
    }

    public void amountDoors(String carDoors) {
        System.out.println("The car has " + carDoors + " doors");
    }

    public void setEngine(String carEngine) {
        System.out.println("The engine of the car is " + carEngine);
    }

    public void calculateTorque(int force, int rpm) {
        int torgue = (force * 5252) / rpm;
        System.out.println("The torgue of the car is (" + force + " x " + " 5252) / " + rpm + " = " + torgue);
    }
}