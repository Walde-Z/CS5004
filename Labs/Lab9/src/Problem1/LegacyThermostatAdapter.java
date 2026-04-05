package Problem1;

public class LegacyThermostatAdapter implements SmartDevice {
  private LegacyThermostat thermostat;

  public LegacyThermostatAdapter(LegacyThermostat thermostat) {
    this.thermostat = thermostat;
  }

  @Override
  public void turnOn() {
    thermostat.activate();
  }

  @Override
  public void turnOff() {
    thermostat.deactivate();
  }

  @Override
  public String getStatus() {
    return "Thermostat temperature: " + thermostat.getCurrentTemp() + "°C.";
  }
}
