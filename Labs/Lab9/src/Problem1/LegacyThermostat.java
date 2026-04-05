package Problem1;

public class LegacyThermostat {
  private boolean isOn;
  private int currentTemp = 25;

  public void activate() {
    isOn = true;
  }

  public void deactivate() {
    isOn = false;
  }

  public int getCurrentTemp() {
    return currentTemp;
  }
}