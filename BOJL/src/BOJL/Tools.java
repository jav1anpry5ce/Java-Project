// 20182855
package BOJL;

import java.util.ArrayList;
import java.util.Random;

public class Tools {
    static Random random = new Random();
    static ArrayList<String> Ids = new ArrayList<>();

    public static String generateId() {
        String generatedId;
        int num = random.nextInt((9999 - 100) + 1) + 5;
        generatedId = String.format("%04d", num);
        for (int i = 1; i < Ids.size(); i++) {
            if (Ids.contains(generatedId)) {
                System.out.println("HI");
                generateId();
            }
                //generatedId = String.format("%04d", num);
            else
                Ids.add(generatedId);
        }

        return generatedId;
    }

    public static int generateTrees() {
        return random.nextInt(2000 - 150 + 1) + 150;
    }

    public static int generateMarketingOfficer() {
        return random.nextInt(7 - 1 + 1) + 1;
    }

    public static int overtimeRate() {
        return random.nextInt(1000 - 650 + 1) + 650;
    }

    public static int overTimeHours() {
        return random.nextInt(25 - 1 + 1) + 1;
    }

    public static double markMoney() { return random.nextInt(576500 - 90597 + 1) + 90597;}

    public static double generateInvestment() {return random.nextInt(5762580 - 755014 + 1) + 755014;}

}
