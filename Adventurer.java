import java.util.Random;
import java.util.ArrayList;
public abstract class Adventurer{
  private String name;
  private int HP,maxHP;
  private ArrayList<Adventurer> Enemies;
  private ArrayList<Adventurer> Team;

  //Abstract methods are meant to be implemented in child classes.
  /*
  all adventurers must have a custom special
  consumable resource (mana/rage/money/witts etc)
  */

  //give it a short name (fewer than 13 characters)
  public abstract String getSpecialName();
  //accessor methods
  public abstract int getSpecial();
  public abstract int getSpecialMax();
  public abstract void setSpecial(int n);

  //concrete method written using abstract methods.
  //refill special resource by amount, but only up to at most getSpecialMax()
  public int restoreSpecial(int n){
    if( n > getSpecialMax() - getSpecial()){
      n = getSpecialMax() - getSpecial();
    }
    setSpecial(getSpecial()+n);
    return n;
  }

  /*
  all adventurers must have a way to attack enemies and
  support their allys
  */
  //hurt or hinder the target adventurer
  public abstract String attack(Adventurer other);

  /*This is an example of an improvement that you can make to allow
   * for more flexible targetting.
   */
  //heal or buff the party
  //public abstract String support(ArrayList<Adventurer> others);

  //heal or buff the target adventurer
  public abstract String support(Adventurer other);

  //heal or buff self
  public abstract String support();

  //hurt or hinder the target adventurer, consume some special resource
  public abstract String specialAttack(Adventurer other);

  /*
  standard methods
  */

  public void applyDamage(int amount){
    this.HP -= amount;
  }

  //You did it wrong if this happens.
  public Adventurer(){
    this("Lester-the-noArg-constructor-string");
  }

  public Adventurer(String name){
    this(name, 10);
  }

  public Adventurer(String name, int hp){
    this.name = name;
    this.HP = hp;
    this.maxHP = hp;
    Enemies = new ArrayList<Adventurer>();
    Team = new ArrayList<Adventurer>();
  }

  //toString method
  public String toString(){
    return this.getName();
  }

  //Get Methods
  public String getName(){
    return name;
  }

  public int getHP(){
    return HP;
  }

  public int getmaxHP(){
    return maxHP;
  }
  public void setmaxHP(int newMax){
    maxHP = newMax;
  }

  public ArrayList<Adventurer> getEnemies(){
    return Enemies;
  }
  public Adventurer getEnemy(int n){
    return Enemies.get(n);
  }
  public int getEnemiesSize(){
    return Enemies.size();
  }

  public ArrayList<Adventurer> getTeam(){
    return Team;
  }
  public Adventurer getTeam(int n){
    return Team.get(n);
  }
  public int getTeamSize(){
    return Team.size();
  }

  //Set Methods
  public void setHP(int health){
    if(health > maxHP){
      this.HP = maxHP;
    }
    else{
      this.HP = health;
    }
  }

  public void setName(String s){
    this.name = s;
  }

  public void setTeam(ArrayList<Adventurer> Team){
    this.Team = Team;
  }
  public void addToTeam(Adventurer other){
    Team.add(other);
  }
  public void removeFromTeam(Adventurer other){
    Team.remove(other);
  }

  public void setEnemies(ArrayList<Adventurer> Enemies){
    this.Enemies = Enemies;
  }
  public void addToEnemies(Adventurer other){
    Enemies.add(other);
  }
  public void removeFromEnemies(Adventurer other){
    Enemies.remove(other);
  }

  //others
  public boolean inEnemies(Adventurer target){
    return Enemies.indexOf(target) != -1;
  }
}
