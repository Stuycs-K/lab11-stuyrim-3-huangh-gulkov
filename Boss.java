public class Boss extends Adventurer{

  //name, HP, maxHP, Enemies, Team inheritted
  private int Wage;

  //constructor
  public Boss(){
    super("The Lady", 50);
    Wage = 15;
  }

  //specials
  public String getSpecialName(){
    return "Wage";
  }
  public int getSpecial(){
    return Wage;
  }
  public int getSpecialMax(){
    return 20;
  }
  public void setSpecial(int n){
    Wage = n;
  }

  //atk/sup/special
  public String attack(Adventurer other){
    if(checkWage){
      return specialAttack(getEnemies.getEnemy((int) (Math.random() * getEnemies.getEnemiesSize())));
    }
    other.applyDamage(5);
    reduceWage();
    return this + " whacked " + other + " with their ladle, dealing 5 DMG.";
  }
  public String support(Adventurer other){return "";}//only boss no others
  public String support(){
    if(checkWage){
      return specialAttack(Enemies.getEnemy((int) (Math.random() * Enemies.getEnemiesSize())));
    }
    reduceWage();
    setHP(get() + 10);
    return this + " ate a platter of grains, proteins, vegetables, fruits, and drinked a carton of dairy, restoring 10 HP to themselves.";
  }
  public String specialAttack(Adventurer other){//can not be manually called
    other.applyDamage(10);
    setSpecial(15);
    return this + " is unsatisfied with not being paid for their work. They morph into Mr. Moran and ";
  }

  //helper func
  public void reduceWage(){
    setSpecial(getSpecial() - 5);
  }
  public boolean checkWage(){
    return Wage <= 0;
  }
}
