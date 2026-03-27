import java.util.ArrayList;

public class NonProfit {
  private String name;
  private ArrayList<Donation> donations;

  public NonProfit(String name) {
    this.name = name;
    this.donations = new ArrayList<>();
  }

  public NonProfit(String name, ArrayList<Donation> donations) {
    this.name = name;
    this.donations = donations;
  }

  public String getName() {
    return name;
  }

  public void addDonations(Donation donation) {
    donations.add(donation);
  }

  public double getTotalDonationsForYear(int year) {
    double total = 0;
    for (Donation d: donations) {
      total += d.getAmountForYear(year);
    }
    return total;
  }
}
