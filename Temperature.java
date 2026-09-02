package Lesson3;

public class Temperature {
    public static void main(String[] args) {
        
        boolean IsItSunny = true;
        double temperature = -20;
        int a = 13;

        if (IsItSunny || temperature >= 20) {
            System.out.println("it is hot");
        }else {
            System.out.println("it is cold");
        }
    }
}