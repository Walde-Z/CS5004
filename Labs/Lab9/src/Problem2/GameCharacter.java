package Problem2;

import java.util.ArrayList;
import java.util.List;

public abstract class GameCharacter {
  protected String name;
  protected int health;
  protected int attack;
  protected int defense;
  protected List<Equipment> equipment = new ArrayList<>();

  public GameCharacter(String name, int health, int attack, int defense) {
    this.name = name;
    this.health = health;
    this.attack = attack;
    this.defense = defense;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addEquipment(Equipment e) {
    equipment.add(e);
  }

  public abstract GameCharacter clone();
  public abstract String getDescription();
}
