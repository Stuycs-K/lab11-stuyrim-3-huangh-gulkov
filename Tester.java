import java.util.ArrayList;
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
        ArrayList<Adventurer>enemies = new ArrayList<Adventurer>();
enemies.add(new CodeWarrior("Steve"));
      enemies.add(new YoungKaren("Heather"));
      enemies.add(new QuietKid("Lucas"));

      ArrayList<Adventurer> party = new ArrayList<Adventurer>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    party.add(new CodeWarrior("Boris"));
    party.add(new YoungKaren("Liz"));
    party.add(new QuietKid("Neville"));
     String part1 =  "\\      /";
    String part2 =  " \\    / ";
    String part3 =  "  \\/\\/";
    Text.go(15,1);
      System.out.println(part1);
            System.out.println(part2);
      System.out.println(part3);

    long startTime = System.currentTimeMillis();
    while(System.currentTimeMillis() - startTime <= 1500){
    sparkles();

   

  } 
    drawScreen(party, enemies, 4, 25);
    
  }

    public static void TextBox(int row, int col, int width, int height, String text){
    int index = 0;
    int end = 0;
    for(int i = 0; i < height; i++){
      Text.go(row + i, col);
    if(text.length() > index){
      if(index + width < text.length()){
        end = index + width;
      }
      if(index + width > text.length()){
        end = text.length();
      }
      System.out.print(text.substring(index, end));
      index = end;
    }
    int spaces = width - (end - index);
    if(spaces > 0){
      System.out.print(" ");
    }
    else{
      while(width > 0){
        System.out.print(" ");
        width--;
      }
    }

    }

  }
  public static void drawBackground(){
  Text.hideCursor();
  Text.clear();
  Text.go(1,2);
        for (int i = 0; i < 78; i++) {
            System.out.print(Text.colorize("-", Text.RED + Text.BRIGHT));
        }

for (int i = 2; i <= 29; i++) {
            Text.go(i, 1);
            System.out.print(Text.colorize("|", Text.RED + Text.BRIGHT));
            Text.go(i, 80);
      System.out.print(Text.colorize("|", Text.RED + Text.BRIGHT));
        }
        Text.go(30, 2);
        for (int i = 0; i < 78; i++) {
            System.out.print(Text.colorize("-", Text.RED + Text.BRIGHT));
        }
        for (int i = 4; i < 8; i++) {
          Text.go(i, 27);
            System.out.print(Text.colorize("|", Text.RED + Text.BRIGHT));
            Text.go(i, 54);
            System.out.print(Text.colorize("|", Text.RED + Text.BRIGHT));
        }
        Text.go(7,2);
        for (int i = 0; i < 78; i++) {
            System.out.print(Text.colorize("-", Text.RED + Text.BRIGHT));
        }
        Text.go(3,2);
        for (int i = 0; i < 78; i++) {
            System.out.print(Text.colorize("-", Text.RED + Text.BRIGHT));
        }
        Text.go(2,31);
        System.out.print("This is your party");

        for (int i = 4; i < 9; i++) {
          Text.go(i + 20, 27);
            System.out.print(Text.colorize("|", Text.RED + Text.BRIGHT));
            Text.go(i + 20, 54);
            System.out.print(Text.colorize("|", Text.RED + Text.BRIGHT));
        }
        Text.go(24,2);
        for (int i = 0; i < 78; i++) {
            System.out.print(Text.colorize("-", Text.RED + Text.BRIGHT));
        }
        Text.go(28,2);
        for (int i = 0; i < 78; i++) {
            System.out.print(Text.colorize("-", Text.RED + Text.BRIGHT));
        }
        Text.go(29,33);
        System.out.print("This is the enemy");
        Text.go(30,80);
    Text.reset();
    Text.showCursor();

  }
   
   public static void drawParty(ArrayList<Adventurer> party,int startRow){
      for(int i = 0; i < party.size(); i++){
        if(party.size() > 2){
          TextBox(startRow, 5+ (28 * i), 26, 1, party.get(i).getName());
          TextBox(startRow + 1, 5 + (28 * i), 26, 1, "HP: " + party.get(i).getHP());
          TextBox(startRow + 2, 5 + (28 * i), 26, 1, party.get(i).getSpecialName() + ": " + party.get(i).getSpecial());
        }
        else{
          TextBox(startRow, 5 + (28 * i), 26, 1, party.get(i).getName());
          TextBox(startRow + 1, 5 + (28 * i), 26, 1, "HP: " + party.get(i).getHP());
          TextBox(startRow + 2, 5 + (28 * i), 26, 1, party.get(i).getSpecialName() + ": " + party.get(i).getSpecial());
        }
      }
      Text.go(30,80);

    }
    
    public static void drawScreen(ArrayList<Adventurer> friend, ArrayList<Adventurer> enemy,int friendRow, int enemyRow ){
    drawBackground();
    //draw player party
    drawParty(friend, friendRow);
    //draw enemy party
    drawParty(enemy, enemyRow);
  }
  public static void sparkles(){
    for(int i = 0; i <200; i++){
      int y = (int)(Math.random() * 31);
      int x = (int)(Math.random() * 81);
      int color = (int)(Math.random() * 68 - 30);
      Text.go(y,x);
      System.out.print(Text.colorize(".", color));
    }
    Text.clear();
  }
  

  }
