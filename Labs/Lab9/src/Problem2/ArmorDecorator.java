package Problem2;

public class ArmorDecorator implements Equipment {
  private String name;
  private int defenseBonus;

  public ArmorDecorator(String name, int defenseBonus) {
    this.name = name;
    this.defenseBonus = defenseBonus;
  }

  @Override
  public int getAttackBonus() {
    return 0;
  }

  @Override
  public int getDefenseBonus() {
    return defenseBonus;
  }

  @Override
  public String getDescription() {
    return name + " (DEF +" + defenseBonus + ")";
  }
}