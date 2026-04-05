package Problem2;

public class CharacterFactory {
  public GameCharacter createCharacter(String type) {
    switch (type.toLowerCase()) {
      case "tank":
        return new CharacterBuilder()
            .setName("tank")
            .setHealth(200)
            .setAttack(50)
            .setDefense(200)
            .build();
      case "dps":
        return new CharacterBuilder()
            .setName("dps")
            .setHealth(50)
            .setAttack(200)
            .setDefense(200)
            .build();
      case "support":
        return new CharacterBuilder()
            .setName("support")
            .setHealth(100)
            .setAttack(100)
            .setDefense(100)
            .build();
      default:
        throw new IllegalArgumentException("Unknown character type: " + type);
    }
  }
}