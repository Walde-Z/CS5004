import java.time.LocalDateTime;

public class MonthlyDonation extends Donation{
  private LocalDateTime cancelledDateTime;

  public void setCancelledDateTime(LocalDateTime cancelledDateTime) {
    if (getCreatedDateTime().isBefore(cancelledDateTime)) {
      this.cancelledDateTime = cancelledDateTime;
    }
  }

  @Override
  public double getAmountForYear(int year) {
    if (cancelledDateTime == null) {
      if (getCreatedDateTime().getYear() < year) {
        return getAmount() * 12;
      }
      else if (getCreatedDateTime().getYear() == year) {
        return getAmount() * (13 - getCreatedDateTime().getMonthValue());
      }
      else {
        return 0;
      }
    }

    else if (cancelledDateTime.getYear() != getCreatedDateTime().getYear()) {
      if (cancelledDateTime.getYear() == year && getCreatedDateTime().getYear() != year) {
        if (cancelledDateTime.getDayOfMonth() >= getCreatedDateTime().getDayOfMonth()) {
          return getAmount() * cancelledDateTime.getMonthValue();
        }
        else {
          return getAmount() * (cancelledDateTime.getMonthValue() - 1);
        }
      }
      else if (cancelledDateTime.getYear() != year && getCreatedDateTime().getYear() == year) {
        return (13 - getCreatedDateTime().getMonthValue()) * getAmount();
      }
      else {
        return 12 * getAmount();
      }
    }

    else if (getCreatedDateTime().getYear() == cancelledDateTime.getYear() && cancelledDateTime.getYear() == year){
      if (cancelledDateTime.getDayOfMonth() >= getCreatedDateTime().getDayOfMonth()) {
        return getAmount() * (cancelledDateTime.getMonthValue() - getCreatedDateTime().getMonthValue() + 1);
      }
      else {
        return getAmount() * (cancelledDateTime.getMonthValue() - getCreatedDateTime().getMonthValue());
      }
    }
    return 0;
  }
}
