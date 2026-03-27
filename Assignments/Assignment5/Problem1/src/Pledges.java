import java.time.LocalDateTime;

public class Pledges extends Donation {
  private LocalDateTime processingDateTime;

  public void setProcessingDateTime(LocalDateTime processingDateTime) {
    if (processingDateTime == null) {
      this.processingDateTime = processingDateTime;
    }
    else if (processingDateTime.isAfter(getCreatedDateTime())) {
      this.processingDateTime = processingDateTime;
    }
  }

  @Override
  public double getAmountForYear(int year) {
    if (processingDateTime != null && processingDateTime.getYear() == year) {
      return getAmount();
    }
    return 0;
  }
}
