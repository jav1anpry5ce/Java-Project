// 20182855
package BOJL;

import java.text.DecimalFormat;

public class Accountant extends Employee implements PayMethods {
    private double pay;
    private static int numOfTrees = 0;
    DecimalFormat dt = new DecimalFormat(",000.00");

    public Accountant(int trees) {
        super(Tools.generateId(), "Accountant");
        this.pay = 65000.00;
        numOfTrees = trees;
    }

    public static double calculateCoordinatorPay(double BasePay) {
        double FinalPay = BasePay;
        if (numOfTrees > 1200) {
            double deduction = 0.2 * BasePay;
            FinalPay = BasePay - deduction;
        }
        return FinalPay;
    }

    public static double calculateDirectorPay(double BasePay){
        double commission = 0.07 * Tools.generateInvestment();
        BasePay += commission;
        double FinalPay = BasePay;
        if (numOfTrees > 1200) {
            double deduction = 0.2 * FinalPay;
            FinalPay -= deduction;
            return FinalPay;
        }
        return FinalPay;
    }

    public static double calculateSeasonalPay(double BasePay){
        double overtime = Tools.overtimeRate() * Tools.overTimeHours();
        double FinalPay = BasePay + overtime;
        return FinalPay;
    }

    public static double calculateMarketingOfficerPay(double BasePay){
        double commission = 0.15 * Tools.markMoney();
        double FinalPay = BasePay + commission;
        return FinalPay;
    }

    public static double calculateAccountantPay(double BasePay) {
        double FinalPay = BasePay + 0;
        return FinalPay;
    }

    public void calculatePay() {
        pay = calculateAccountantPay(this.pay);
    }

    public double getPay() {
        return pay;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Monthly salary: $" + dt.format(pay);
    }
}
