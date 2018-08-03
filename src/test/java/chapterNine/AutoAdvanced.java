package chapterNine;

public class AutoAdvanced {

    public String brand;
    public int force;
    public int rpm;

    public AutoAdvanced(String brand, int force, int rpm) {
        this.brand = brand;
        this.force = force;
        this.rpm = rpm;

        System.out.println("Brand of your car is " + brand);

        int torgue = (force * 5252) / rpm;
        System.out.println("The torgue of the car is (" + force + " x " + " 5252) / " + rpm + " = " + calculateTorque(force, rpm));
    }

    public int calculateTorque(int force, int rpm) {
        return (force * 5252) / rpm;
    }
}
