public class WhiteGirl extends Adventurer{

  //name, HP, and maxHP inheritted
  private boolean haveStarbucks;
  private int StarbucksOwned;

  //constructor
  public WhiteGirl(String name){
    super(name, 30);
    haveStarbucks = false;
    StarbucksOwned = 0;
  }

  //special resources
  public String getSpecialName(){
    return "StarbucksOwned";
  }
  public int getSpecial(){return StarbucksOwned;}
  public int getSpecialMax(){return 2;}//at most two startbucks
  public void setSpecial(int n){StarbucksOwned = n;}
  //for boolean
  public boolean ownStarbucks(){return haveStarbucks;}
  public void setHaveStarbucks(boolean b){haveStarbucks = b;}


  //atk, support, special
  public String attack(Adventurer other){
    other.applyDamage(4);
    return this + " accidentally drops her metal HydroFlask, dealing 4 DMG to " + other + ".";
  }
  public String support(Adventurer other){//EXACTLY HOW WE DO THIS IS AN ISSUE
    return this + " sprays herself with perfume, making her more susceptible to enemy attacks.";
  }
  public String support(){
    restoreSpecial(1);
    haveStarbucks = true;
    String[] StarbucksDrink = {"Brown Sugar Oatmilk Shaken Espresso with Vanilla Cold Foam", "Mango Dragonfruit Refresher with Lemonade with Matcha Cold Foam", "Brown Sugar Oatmilk Short Cortado with Extra Cinnamon", "Black Tea (Half Lemonade, 2 Pumps of Sugarfree Vanilla Syrup)"};
    String drink = StarbucksDrink[(int) Math.random() * 4];
    return this + " buys herself a " + drink + ".";
  }
  public String specialAttack(Adventurer other){
    if(haveStarbucks){
      restoreSpecial(-1);
      Adventurer Target = getEnemy(((int) Math.random() * getEnemiesSize()));
      Target.applyDamage(10);
      return Target + " robbed " + this + "'s Starbucks. " + this + " becomes furious and attacks " + Target + ", dealing 10 DMG.";
    }
    return this + " doesn't have any Starbucks. " + this + " must have at least one Starbucks drink to use the special Attack.";
  }
}
