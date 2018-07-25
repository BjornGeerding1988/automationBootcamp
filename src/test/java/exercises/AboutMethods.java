package exercises;


import org.testng.annotations.Test;

public class AboutMethods {

    private int multiply(int a, int b) {
        return a * b;
    }

    @Test
    public void printProduct() {
        System.out.println("The product of calculation one is: " + multiply(5, 6));
        System.out.println("The product of calculation two is: " + multiply(3, 5));
    }
}