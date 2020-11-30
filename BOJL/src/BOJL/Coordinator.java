// 20182855
package BOJL;

import java.text.DecimalFormat;

public class Coordinator extends Employee implements PayMethods {
    private double pay;
    DecimalFormat dt = new DecimalFormat(",000.00");

    public Coordinator() {
        super(Tools.generateId(), "Coordinator");
        this.pay = 60000.00;
    }

    public void calculatePay() {

        pay = Accountant.calculateCoordinatorPay(this.pay);
    }

    public double getPay() {
        return pay;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Monthly salary: $" + dt.format(pay);
    }
}
