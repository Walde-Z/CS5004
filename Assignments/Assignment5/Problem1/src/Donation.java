import java.time.LocalDateTime;

public abstract class Donation {
  private double amount;
  private LocalDateTime createdDateTime;

  public abstract double getAmountForYear(int year);

  public LocalDateTime getCreatedDateTime() {
    return createdDateTime;
  }

  public double getAmount() {
    return amount;
  }
}
