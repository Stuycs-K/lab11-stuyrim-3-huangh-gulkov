public class Tester{
  public static void main(String[] args){
    Adventurer Bob= new QuietKid("Bob");
    Adventurer Tim = new CodeWarrior("Tim");
    Adventurer Andrew = new CodeWarrior("Andrew");
    Adventurer Tate = new CodeWarrior("Tate");
    Adventurer Derby = new CodeWarrior("Derby");
    System.out.println(Bob.attack(Tim) + " " + Tim.getHP());
    System.out.println(Bob.attack(Andrew));
    System.out.println(Bob.attack(Tim));
    System.out.println(Bob.attack(Andrew));
    System.out.println(Bob.attack(Tate));
    System.out.println(Bob.attack(Tim));
    System.out.println(Bob.support(Tim) + " " + Tim.getHP());
    System.out.println(Bob.support());
    System.out.println(Tim.support(Bob));
  }
}
