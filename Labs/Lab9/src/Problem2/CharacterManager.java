package Problem2;

public class CharacterManager {
  public static void main(String[] args) {
    GameCharacter custom = new CharacterBuilder()
        .setName("Custom")
        .setHealth(200)
        .setAttack(100)
        .setDefense(50)
        .build();

    CharacterFactory factory = new CharacterFactory();
    GameCharacter tank = factory.createCharacter("tank");
    GameCharacter dps = factory.createCharacter("dps");
    GameCharacter clone = tank.clone();
    clone.setName("clone");

    tank.addEquipment(new WeaponDecorator("Sword", 20));
    tank.addEquipment(new ArmorDecorator("Shield", 30));

    dps.addEquipment(new WeaponDecorator("Bow", 10));
    dps.addEquipment(new ArmorDecorator("Shield", 20));

    System.out.println(custom.getDescription());

    System.out.println(tank.getDescription());
    for (Equipment e : tank.equipment) {
      System.out.println(e.getDescription());
    }

    System.out.println(dps.getDescription());
    for (Equipment e : dps.equipment) {
      System.out.println(e.getDescription());
    }

    System.out.println(clone.getDescription());
    for (Equipment e : clone.equipment) {
      System.out.println(e.getDescription());
    }
  }
}
