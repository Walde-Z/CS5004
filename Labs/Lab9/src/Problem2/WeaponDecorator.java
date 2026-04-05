package Problem2;

public class WeaponDecorator implements Equipment {
  private String name;
  private int attackBonus;

  public WeaponDecorator(String name, int attackBonus) {
    this.name = name;
    this.attackBonus = attackBonus;
  }

  @Override
  public int getAttackBonus() {
    return attackBonus;
  }

  @Override
  public int getDefenseBonus() {
    return 0;
  }

  @Override
  public String getDescription() {
    return name + " (ATK +" + attackBonus + ")";
  }
}