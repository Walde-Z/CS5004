import java.time.LocalDateTime;

public class OneTimeDonation extends Donation {
  @Override
  public double getAmountForYear(int year) {
    if (getCreatedDateTime().getYear() == year) {
      return getAmount();
    }
    return 0;
  }
}
