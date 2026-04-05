package Problem1;

public class SmartSpeaker implements SmartDevice{
  private boolean isOn;

  @Override
  public void turnOn() {
    isOn = true;
  }

  @Override
  public void turnOff() {
    isOn = false;
  }

  @Override
  public String getStatus() {
    return isOn ? "Speaker is ON." : "Speaker is OFF.";
  }
}
