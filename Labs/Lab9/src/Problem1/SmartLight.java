package Problem1;

public class SmartLight implements SmartDevice{
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
    return isOn ? "Light is ON." : "Light is OFF.";
  }
}