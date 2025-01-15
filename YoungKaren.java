public class YoungKaren extends Adventurer{

  //name, HP, and maxHP inheritted
  private int StarbucksOwned;
  private boolean moreTargetable;

  //constructor
  public YoungKaren(String name){
    super(name, 30);
    StarbucksOwned = 0;
    moreTargetable = false;
  }

  //special resources
  public String getSpecialName(){
    return "Starbucks";
  }
  public int getSpecial(){return StarbucksOwned;}
  public int getSpecialMax(){return 2;}//at most two startbucks
  public void setSpecial(int n){StarbucksOwned = n;}


  //atk, support, special
  public String attack(Adventurer other){
    lessTargetable();
    other.applyDamage(4);
    return this + " accidentally drops her metal HydroFlask, dealing 4 DMG to " + other + ".";
  }
  public String support(Adventurer other){
    lessTargetable();
    moreTargetable = true;
    for(Adventurer current : getEnemies()){
      current.addToEnemies(this);
      current.addToEnemies(this);
    }
    return this + " sprays herself with perfume, making her more susceptible to enemy attacks. Lasts one round.";
  }
  public String support(){
    lessTargetable();
    restoreSpecial(1);
    String[] StarbucksDrink = {"Brown Sugar Oatmilk Shaken Espresso with Vanilla Cold Foam", "Mango Dragonfruit Refresher with Lemonade with Matcha Cold Foam", "Brown Sugar Oatmilk Short Cortado with Extra Cinnamon", "Black Tea (Half Lemonade, 2 Pumps of Sugarfree Vanilla Syrup)"};
    String drink = StarbucksDrink[(int) (Math.random() * 4)];
    return this + " buys herself a " + drink + ".";
  }
  public String specialAttack(Adventurer other){
    lessTargetable();
    if(StarbucksOwned > 0){
      restoreSpecial(-1);
      Adventurer Target = getEnemy((int) (Math.random() * getEnemiesSize()));
      Target.applyDamage(10);
      return Target + " robbed " + this + "'s Starbucks. " + this + " becomes furious and attacks " + Target + ", dealing 10 DMG.";
    }
    return this + " doesn't have any Starbucks. " + this + " must have at least one Starbucks drink to use the special Attack.";
  }

  //others
  public void lessTargetable(){
    moreTargetable = false;
    for(Adventurer current : getEnemies()){
      current.removeFromEnemies(this);
      current.removeFromEnemies(this);
    }
  }
}
