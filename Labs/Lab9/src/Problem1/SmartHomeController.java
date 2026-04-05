package Problem1;

import java.util.ArrayList;
import java.util.List;

public class SmartHomeController {
  private static SmartHomeController instance;
  private List<SmartDevice> devices;

  private SmartHomeController() {
    this.devices = new ArrayList<>();
  }

  public static SmartHomeController getInstance() {
    if (instance == null) {
      instance = new SmartHomeController();
    }
    return instance;
  }

  public void addDevice(SmartDevice device) {
    devices.add(device);
  }


}