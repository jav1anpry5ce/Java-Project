// 20182855
package BOJL;

import java.text.DecimalFormat;

public class Director extends Employee implements PayMethods {
    private double pay;
    DecimalFormat dt = new DecimalFormat(",000.00");

    public Director() {
        super(Tools.generateId(), "Director");
        this.pay = 70000.00;
    }

    public void calculatePay() {
        pay = Accountant.calculateDirectorPay(this.pay);
    }

    public double getPay() {
        return pay;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Monthly salary: $" + dt.format(pay);
    }
}
