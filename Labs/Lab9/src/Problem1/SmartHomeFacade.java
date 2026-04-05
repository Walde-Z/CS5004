package Problem1;

public class SmartHomeFacade {
  private SmartLight light;
  private SmartSpeaker speaker;
  private LegacyThermostatAdapter thermostat;

  public SmartHomeFacade(SmartLight light, SmartSpeaker speaker, LegacyThermostatAdapter thermostat) {
    this.light = light;
    this.speaker = speaker;
    this.thermostat = thermostat;
  }

  public void activateNightMode() {
    light.turnOff();
    speaker.turnOn();
    thermostat.turnOn();
  }

  public void leaveHome() {
    light.turnOff();
    speaker.turnOff();
    thermostat.turnOff();
  }
}
