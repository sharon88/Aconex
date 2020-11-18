package utils;

import java.util.Random;

public class Helper {

    public static int generateRandomNumber(){
        Random random = new Random();
        return random.nextInt(2000);
    }


}
