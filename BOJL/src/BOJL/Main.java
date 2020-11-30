// 20182855
package BOJL;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Coordinator> coordinator = new ArrayList<>();
    static ArrayList<MarketingOfficer> marketingOfficer = new ArrayList<>();
    static ArrayList<Seasonal> seasonalEmp = new ArrayList<>();
    static ArrayList<Director> directors = new ArrayList<>();
    static ArrayList<Accountant> accountants = new ArrayList<>();
    static DecimalFormat dt = new DecimalFormat(",000.00");
    static int trees = Tools.generateTrees();
    static int seasonalEmployee = ((trees / 10) * 2) + 1;
    static int coordinators = (seasonalEmployee / 20) + 1;
    static int marketingOfficers = Tools.generateMarketingOfficer();

    public static void main(String[] args) {
        boolean running = true;
        for (int i = 1; i <= coordinators; i++)
            coordinator.add(new Coordinator());

        for (int i = 1; i <= marketingOfficers; i++)
            marketingOfficer.add(new MarketingOfficer());

        for (int i = 1; i <= seasonalEmployee; i++)
            seasonalEmp.add(new Seasonal());

        for (int i = 1; i <= 2; i++)
            directors.add(new Director());

        for (int i = 1; i <= 3; i++)
            accountants.add(new Accountant(trees));

        for (Coordinator pay : coordinator)
            pay.calculatePay();

        for (MarketingOfficer pay : marketingOfficer)
            pay.calculatePay();

        for (Seasonal pay : seasonalEmp)
            pay.calculatePay();

        for (Director pay : directors)
            pay.calculatePay();

        for (Accountant pay : accountants)
            pay.calculatePay();

        while (running) {
            try {
                Scanner input = new Scanner(System.in);
                int selectedOption;
                System.out.println("Please enter the number that co-relate to the operation you would like to perform.");
                System.out.println("1. Get total salaries for each category of employees.");
                System.out.println("2. Get total to be paid out to all employees.");
                System.out.println("3. See salary that each employee will receive.");
                System.out.println("4. See company statics.");
                System.out.println("5. Exit");
                System.out.print("Enter: ");
                selectedOption = input.nextByte();

                switch (selectedOption) {
                    case 1 -> totalSalariesCategory();
                    case 2 -> total();
                    case 3 -> eachSalary();
                    case 4 -> companyStats();
                    case 5 -> running = false;
                    default -> {
                        System.out.println("Invalid option!");
                        pressEnterToContinue();
                    }
                }
            }
            catch(Exception e) {
                System.out.println("Expected int got string!");
                pressEnterToContinue();
            }
        }
    }
    public static void totalSalariesCategory() {
        double totalSalariesCoordinators = 0;
        double totalSalariesMarketingOfficers = 0;
        double totalSalariesSeasonal = 0;
        double totalSalariesDirectors = 0;
        double totalSalariesAccountants = 0;

        for (Coordinator value : coordinator)
            totalSalariesCoordinators += value.getPay();

        for (MarketingOfficer value : marketingOfficer)
            totalSalariesMarketingOfficers += value.getPay();

        for (Seasonal value : seasonalEmp)
            totalSalariesSeasonal += value.getPay();

        for (Director value : directors)
            totalSalariesDirectors += value.getPay();

        for (Accountant value : accountants)
            totalSalariesAccountants += value.getPay();

        System.out.println("Coordinators: $" + dt.format(totalSalariesCoordinators));
        System.out.println("Marketing Offices: $" + dt.format(totalSalariesMarketingOfficers));
        System.out.println("Seasonal Employees: $" + dt.format(totalSalariesSeasonal));
        System.out.println("Directors: $" + dt.format(totalSalariesDirectors));
        System.out.println("Accountants: $" + dt.format(totalSalariesAccountants));
        pressEnterToContinue();
    }
    public static void total() {
        double total = 0;

        for (Coordinator value : coordinator)
            total += value.getPay();

        for (MarketingOfficer value : marketingOfficer)
            total += value.getPay();

        for (Seasonal value : seasonalEmp)
            total += value.getPay();

        for (Director value : directors)
            total += value.getPay();

        for (Accountant value : accountants)
            total += value.getPay();

        System.out.println("Total salaries to be paid out: $" + dt.format(total));
        pressEnterToContinue();
    }
    public static void eachSalary() {
        for (Coordinator coordinator : coordinator)
            System.out.println(coordinator + "\n");

        for (MarketingOfficer marketingOfficer : marketingOfficer)
            System.out.println(marketingOfficer + "\n");

        for (Director director : directors)
            System.out.println(director + "\n");

        for (Accountant accountant : accountants)
            System.out.println(accountant + "\n");

        for (Seasonal seasonal : seasonalEmp)
            System.out.println(seasonal + "\n");

        pressEnterToContinue();
    }
    public static void companyStats() {
        System.out.println("Trees: " + trees);
        System.out.println("Seasonal Employees: " + seasonalEmployee);
        System.out.println("Coordinators: " + coordinators);
        System.out.println("Marketing Officers: " + marketingOfficers);
        System.out.println("Directors: 2");
        System.out.println("Accounting Officers: 3");
        pressEnterToContinue();
    }
    public static void pressEnterToContinue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press enter to continue...");
        scanner.nextLine();
        System.out.println("\n");
    }
}
