public class Boss extends Adventurer{

  //name, HP, maxHP, Enemies, Team inheritted
  private int Wage;
  private boolean buff;
  private final String demorphMSG = this + " demorphs back into their original self.";

  //constructor
  public Boss(){
    super("The Lady", 50);
    Wage = 15;
    buff = false;
  }

  //specials
  public String getSpecialName(){
    return "Wage";
  }
  public int getSpecial(){
    return Wage;
  }
  public int getSpecialMax(){
    return 40;
  }
  public void setSpecial(int n){
    Wage = n;
  }

  //atk/sup/special
  public String attack(Adventurer other){
    String result = "";
    int dmgDealt;
    if(checkWage()){
      int randomEnemy = (int) (Math.random() * getEnemiesSize());
      return specialAttack(getEnemy(randomEnemy));
    }
    if(buff){
      result += demorphMSG;
      dmgDealt = 10;
      other.applyDamage(10);
      buff = false;
    }
    else{
      dmgDealt = 5;
      other.applyDamage(5);
    }
    reduceWage();
    buff = false;
    return this + " whacked " + other + " with their ladle, dealing " + dmgDealt + " DMG. " + result;
  }
  public String support(Adventurer other){return "";}//only boss no others
  public String support(){
    String result = "";
    if(checkWage()){
      return specialAttack(getEnemy((int) (Math.random() * getEnemiesSize())));
    }
    restoreSpecial(20);
    setHP(getHP() + 10);
    if(buff){
      result += demorphMSG;
    }
    buff = false;
    return this + " ate a platter of grains, proteins, vegetables, fruits, and drinked a carton of dairy, restoring 10 HP to themselves. " + result;
  }
  public String specialAttack(Adventurer other){//can not be manually called
    other.applyDamage(10);
    setSpecial(15);
    buff = true;
    return this + " is unsatisfied with not being paid for their work. They morph into Mr. Moran and scream at " + other + " for having their earbuds in, dealing 10 DMG. " + this + " gains a DMG buff, increasing their DMG by 5. Lasts one round.";
  }
  public String specialAttack2(Adventurer other){
    if(Wage > 25){
      String result = "";
      int actualDMG = 0;
      if(buff){
        actualDMG = 25;
        other.applyDamage(25);
        result += demorphMSG;
      }
      else{
        actualDMG = 20;
        other.applyDamage(20);
      }
      setSpecial(0);
      buff = false;
      return this + " got so rich that they buried " + other + " under a pile of cash, dealing " + actualDMG + " DMG. " + result;
    }
    return this + "tried to bury " + other + " with money, but was too poor.";
  }

  //helper func
  public void reduceWage(){
    setSpecial(getSpecial() - 5);
  }
  public boolean checkWage(){
    return Wage <= 0;
  }
}
