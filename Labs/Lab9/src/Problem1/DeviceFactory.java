package Problem1;

public class DeviceFactory {
  public SmartDevice createDevice(String type) {
    switch (type.toLowerCase()) {
      case "light":
        return new SmartLight();
      case "speaker":
        return new SmartSpeaker();
      default:
        throw new IllegalArgumentException("Unknown device type.");
    }
  }
}