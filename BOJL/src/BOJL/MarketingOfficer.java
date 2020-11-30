// 20182855
package BOJL;

import java.text.DecimalFormat;

public class MarketingOfficer extends Employee implements PayMethods {
    private double pay;
    DecimalFormat dt = new DecimalFormat(",000.00");

    public MarketingOfficer() {
        super(Tools.generateId(), "Marketing Officer");
        this.pay = 68000.00;
    }

    public void calculatePay() {
        pay = Accountant.calculateMarketingOfficerPay(this.pay);
    }

    public double getPay() {
        return pay;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Monthly salary: $" + dt.format(pay);
    }
}
