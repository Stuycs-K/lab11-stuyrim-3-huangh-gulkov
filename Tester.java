public class Tester{
  public static void main(String[] args){
    QuietKid Bob= new QuietKid("Bob");
    QuietKid Max = new QuietKid("Max");
    // System.out.println(Bob.support());
    // for(int i = 0; i < 3; i++){
    //   System.out.println(Max.attack(Bob));
    // }
    // CodeWarrior Tim = new CodeWarrior("Tim");
    // CodeWarrior Andrew = new CodeWarrior("Andrew");
    // CodeWarrior Tate = new CodeWarrior("Tate");
    // CodeWarrior Derby = new CodeWarrior("Derby");
    // System.out.println(Bob.attack(Tim) + " " + Tim.getHP());
    // System.out.println(Bob.attack(Andrew));
    // System.out.println(Bob.attack(Tim));
    // System.out.println(Bob.attack(Andrew));
    // System.out.println(Bob.attack(Tate));
    // System.out.println(Bob.attack(Tim));
    // System.out.println(Bob.support(Tim) + " " + Tim.getHP());
    // System.out.println(Bob.support());
    // System.out.println(Tim.support(Bob));
    // System.out.println(Bob.getHP());
    WhiteGirl Kate = new WhiteGirl("Kate");
    System.out.println(Kate + ", " + Kate.getHP() + " , " + Kate.getSpecial());
    // System.out.println(Tim.support(Kate) + "\n" + Kate.getHP() + Kate.getSpecial());
    System.out.println(Kate.attack(Bob));
    System.out.println(Kate.specialAttack());
    System.out.println(Kate.support() + "\n" + Kate.getSpecial());
    //TEST SUPPORT SELF LATER WHEN TEAMS ARE MADE
    Kate.addToEnemies(Bob);
    Kate.addToEnemies(Max);
    System.out.println(Kate.specialAttack());
  }
}
