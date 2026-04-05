package Problem2;

public class CharacterBuilder {
  private String name;
  private int health;
  private int attack;
  private int defense;
  private String type = "warrior";

  public CharacterBuilder() {}

  public CharacterBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public CharacterBuilder setHealth(int health) {
    this.health = health;
    return this;
  }

  public CharacterBuilder setAttack(int attack) {
    this.attack = attack;
    return this;
  }

  public CharacterBuilder setDefense(int defense) {
    this.defense = defense;
    return this;
  }

  public GameCharacter build() {
    switch (type.toLowerCase()) {
      case "archer":
        return new Archer(name, health, attack, defense);
      case "mage":
        return new Mage(name, health, attack, defense);
      default:
        return new Warrior(name, health, attack, defense);
    }
  }
}