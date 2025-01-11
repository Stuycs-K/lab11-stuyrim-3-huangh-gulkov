import java.util.ArrayList;

public class QuietKid extends Adventurer{

  //name, HP, and maxHP inheritted
  private ArrayList<Adventurer> enemiesAttacked;
  private ArrayList<Integer> timesAttacked;
  private boolean untargetable;

  //constructor
  public QuietKid(String name){
    super(name, 25);
    enemiesAttacked = new ArrayList<Adventurer>();
    timesAttacked = new ArrayList<Integer>();
    untargetable = false;
  }

  //special resources is not needed; do need a method to check whether any of them is three
  public String getSpecialName(){return "";}//the useless methods
  public int getSpecial(){return 0;}
  public int getSpecialMax(){return 0;}
  public void setSpecial(int n){}
  public boolean enemyInBook(Adventurer enemy){//see if name already exist
    for(int i = 0; i < enemiesAttacked.size(); i++){
      if(enemiesAttacked.get(i).getName().equals(enemy.getName())){
        return true;
      }
    }
    return false;
  }
  public boolean reachedLimit(){//see if anyone has reached three
    for(int i = 0; i < enemiesAttacked.size(); i++){
      if(timesAttacked.get(i) == 3){
        return true;
      }
    }
    return false;
  }
  public void resetDeathNote(){
    enemiesAttacked = new ArrayList<Adventurer>();
    timesAttacked = new ArrayList<Integer>();
  }
  //check untargetable and adds back in
  public void targetable(){
    if(untargetable == true){
      untargetable = false;
      for(Adventurer current : getEnemies()){
        current.addToEnemies(this);
      }
    }
  }

  //atk, support, and special
  public String attack(Adventurer other){
    targetable();
    other.applyDamage(2);
    if(enemyInBook(other)){
      int index = enemiesAttacked.indexOf(other);
      timesAttacked.set(index, timesAttacked.get(index) + 1);
    }
    else{
      enemiesAttacked.add(other);
      timesAttacked.add(1);
    }
    if(reachedLimit()){
      return this + " attacks " + other + " with his silence, dealing 2 DMG. He writes down the name of the Adventurer attacked in his Death Note.\n" + specialAttack(other);
    }
    return this + " attacks " + other + " with his silence, dealing 2 DMG. He writes down the name of the Adventurer attacked in his Death Note.";
  }
  public String support(Adventurer other){
    targetable();
    other.applyDamage(2);
    return this + " can not support others. By doing so, he deals 2 DMG to the target Adventurer.";
  }
  public String support(){
    targetable();
    for(Adventurer current : getEnemies()){
      current.removeFromEnemies(this);
    }
    untargetable = true;
    return this + " pulls up his hood and erases his existence from others' perception. He becomes untargetable for one round.";
  }
  public String specialAttack(){//wrapper
    return specialAttack(this);
  }
  public String specialAttack(Adventurer other){
    targetable();
    Adventurer[] expectedTarget = new Adventurer[enemiesAttacked.size()];
    int[] expectedDMG = new int[enemiesAttacked.size()];
    for(int i = 0; i < enemiesAttacked.size(); i++){
      if(inEnemies(enemiesAttacked.get(i))){
        int expectedDamage = timesAttacked.get(i) * 5;
        expectedDMG[i] = expectedDamage;
        Adventurer target = enemiesAttacked.get(i);
        expectedTarget[i] = target;
        target.applyDamage(expectedDMG[i]);
      }
    }
    if(expectedTarget[0] == null){
      return this + " pulls out his hidden AK47, but no target found. " + this + " sadly puts it away.";
    }
    resetDeathNote();
    String result = this + " pulls out his hidden AK47 from his bag and attacks ";
    for(int i = 0; i < expectedTarget.length; i++){
      if(expectedTarget.length == 1){
        result += expectedTarget[i];
      }
      else if(expectedTarget.length == 2){
        if(i == 0){
          result += expectedTarget[i];
        }
        if(i == 1){
          result += " and " + expectedTarget[i];
        }
      }
      else if(i == expectedTarget.length - 1){
        result += "and " + expectedTarget[i];
      }
      else{
        result += expectedTarget[i] + ", ";
      }
    }
    result += ", dealing ";
    for(int i = 0; i < expectedDMG.length; i++){
      if(expectedDMG.length == 1){
        result += expectedDMG[i];
      }
      else if(expectedDMG.length == 2){
        if(i == 0){
          result += expectedDMG[i];
        }
        if(i == 1){
          result += " and " + expectedDMG[i];
        }
      }
      else if(i == expectedDMG.length - 1){
        result += "and " + expectedDMG[i];
      }
      else{
        result += expectedDMG[i] + ", ";
      }
    }
    if(expectedDMG.length == 1){
      result += " DMG. Death Note is reset";
    }
    else{
      result += " DMG each. Death Note is reset.";
    }
    return result;
  }
}
