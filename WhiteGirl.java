public class WhiteGirl extends Adventurer{

  //name, HP, and maxHP inheritted
  private boolean haveStarbucks;
  private in StarbucksOwned;

  //constructor
  public WhiteGirl(String name){
    super(name, 30);
    haveStarbucks = false;
    StarbucksOwned = 0;
  }

  //special resources
  public String getSpecialName(){
    return "haveStarbucks";
  }
  public int getSpecial(){return StarbucksOwned;}
  public boolean getSpecial(){
    return haveStarbucks;
  }
  public int getSpecialMax(){return 2;}//at most two startbucks
  public void setSpecial(int n){StarbucksOwned = n;}

  //atk, support, special
  public String attack(Adventurer other){
    
  }
}
