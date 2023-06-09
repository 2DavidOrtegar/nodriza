package app.support.utils;

import java.text.DecimalFormat;
import java.util.Random;

public class GenerateData {

    private String generatePhones() {
        Random rand = new Random();
        int num2 = rand.nextInt(743);
        int num3 = rand.nextInt(10000);

        DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
        DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros

        return "91" + df3.format(num2) + df4.format(num3);
    }

}
