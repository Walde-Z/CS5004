package Problem1;

public class Main {
  public static void main(String[] args) {
    DeviceFactory factory = new DeviceFactory();
    SmartDevice light = factory.createDevice("light");
    SmartDevice speaker = factory.createDevice("speaker");

    SmartHomeController controller = SmartHomeController.getInstance();
    controller.addDevice(light);
    controller.addDevice(speaker);

    LegacyThermostat legacyThermostat = new LegacyThermostat();
    LegacyThermostatAdapter adapter = new LegacyThermostatAdapter(legacyThermostat);
    adapter.turnOn();
    System.out.println(adapter.getStatus());

    SmartHomeFacade facade = new SmartHomeFacade((SmartLight) light, (SmartSpeaker) speaker, adapter);
    facade.activateNightMode();
    facade.leaveHome();
  }
}