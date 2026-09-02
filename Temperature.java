package Lesson3;

public class Temperature {
    public static void main(String[] args) {
        
        boolean IsItSunny = false;
        double temperatur = -20;

        if (IsItSunny || temperatur >= 20) {
            System.out.println("it is hot");
        }else {
            System.out.println("it is cold");
        }
    }
}
