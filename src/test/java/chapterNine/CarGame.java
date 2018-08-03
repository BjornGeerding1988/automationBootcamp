package chapterNine;

import org.testng.annotations.Test;

public class CarGame {

//    @Test
//    public void autoOne() {
//        Auto autoOne = new Auto();
//
//        autoOne.setBrand("Renault");
//        autoOne.amountDoors("5");
//        autoOne.setEngine("Electric");
//        autoOne.calculateTorque(2,8);
//    }

    @Test
    public void autoTwo() {
        AutoAdvanced autoTwo = new AutoAdvanced("Renault", 1,2);
    }
}
