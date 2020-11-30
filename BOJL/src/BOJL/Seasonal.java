// 20182855
package BOJL;

import java.text.DecimalFormat;

public class Seasonal extends Employee implements PayMethods {
    private double pay;
    DecimalFormat dt = new DecimalFormat(",000.00");


    public Seasonal() {
        super(Tools.generateId(), "Seasonal");
        this.pay = 40000.00;
    }

    public void calculatePay() {

        pay = Accountant.calculateSeasonalPay(this.pay);
    }

    public double getPay() {
        return pay;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Monthly salary: $" + dt.format(pay);
    }
}
