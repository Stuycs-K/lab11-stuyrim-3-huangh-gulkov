import java.util.*;
public class Game{
  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.BLACK;
  private static final int BORDER_BACKGROUND = Text.WHITE + Text.BACKGROUND;

  public static void main(String[] args) {
    run();
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

  //Display the borders of your screen that will not change.
  //Do not write over the blank areas where text will appear or parties will appear.
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

  //Display a line of text starting at
  //(columns and rows start at 1 (not zero) in the terminal)
  //use this method in your other text drawing methods to make things simpler.
  public static void drawText(String s,int startRow, int startCol){
    Text.go(startRow, startCol);
    System.out.print(Text.colorize(s, Text.WHITE + Text.BRIGHT));
  }

  /*Use this method to place text on the screen at a particular location.
  *When the length of the text exceeds width, continue on the next line
  *for up to height lines.
  *All remaining locations in the text box should be written with spaces to
  *clear previously written text.
  *@param row the row to start the top left corner of the text box.
  *@param col the column to start the top left corner of the text box.
  *@param width the number of characters per row
  *@param height the number of rows
  */
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

    //return a random adventurer (choose between all available subclasses)
    //feel free to overload this method to allow specific names/stats.
    public static Adventurer createRandomAdventurer(){
      ArrayList<Adventurer> listOfAdventurer = new ArrayList<Adventurer>();
      listOfAdventurer.add(new QuietKid("Winston"));
      listOfAdventurer.add(new YoungKaren("Margaret"));
      listOfAdventurer.add(new CodeWarrior("Archibald"));
      int index = (int) (Math.random() * 3);
      return listOfAdventurer.get(index);
    }

    /*Display a List of 2-4 adventurers on the rows row through row+3 (4 rows max)
    *Should include Name HP and Special on 3 separate lines.
    *Note there is one blank row reserved for your use if you choose.
    *Format:
    *Bob          Amy        Jun
    *HP: 10       HP: 15     HP:19
    *Caffeine: 20 Mana: 10   Snark: 1
    * ***THIS ROW INTENTIONALLY LEFT BLANK***
    */

   // 28 and 26 are the dividers we used in the draw screen
    public static void drawParty(ArrayList<Adventurer> party,int startRow){
      for(int i = 0; i < party.size(); i++){
        if(party.size() > 2){
          TextBox(startRow, 2 + (28 * i), 26, 1, party.get(i).getName());
          TextBox(startRow + 1, 2 + (28 * i), 26, 1, "HP: " + party.get(i).getHP());
          TextBox(startRow + 2, 2 + (28 * i), 26, 1, party.get(i).getSpecialName() + ": " + party.get(i).getSpecial());
        }
        else{
          TextBox(startRow, 2 + (28 * i), 26, 1, party.get(i).getName());
          TextBox(startRow + 1, 2 + (28 * i), 26, 1, "HP: " + party.get(i).getHP());
          TextBox(startRow + 2, 2 + (28 * i), 26, 1, party.get(i).getSpecialName() + ": " + party.get(i).getSpecial());
        }
      }
    }


  //Use this to create a colorized number string based on the % compared to the max value.
  public static String colorByPercent(int hp, int maxHP){
    String output = String.format("%2s", hp+"")+"/"+String.format("%2s", maxHP+"");
    //COLORIZE THE OUTPUT IF HIGH/LOW:
    // under 25% : red
    // under 75% : yellow
    // otherwise : white
    return output;
  }





  //Display the party and enemies
  //Do not write over the blank areas where text will appear.
  //Place the cursor at the place where the user will by typing their input at the end of this method.
  public static void drawScreen(ArrayList<Adventurer> friend, ArrayList<Adventurer> enemy,int friendRow, int enemyRow ){
    drawBackground();
    //draw player party
    drawParty(friend, friendRow);
    //draw enemy party
    drawParty(enemy, enemyRow);
    Text.reset();
  }

  public static String userInput(Scanner in){
      //Move cursor to prompt location

      //show cursor

      String input = in.nextLine();

      //clear the text that was written

      return input;
  }

  public static void quit(){
    Text.reset();
    Text.showCursor();
    Text.go(32,1);
  }

  public static void run(){
    //Clear and initialize
    Text.hideCursor();
    Text.clear();
     long startTime = System.currentTimeMillis();
    while(System.currentTimeMillis() - startTime <= 1000){
    sparkles();
    }


    //Things to attack:
    //Make an ArrayList of Adventurers and add 1-3 enemies to it.
    //If only 1 enemy is added it should be the boss class.
    //start with 1 boss and modify the code to allow 2-3 adventurers later.
    ArrayList<Adventurer>enemies = new ArrayList<Adventurer>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    if((int) (Math.random() * 2) == 0){
      enemies.add(new Boss());
    }
    else{
      enemies.add(new CodeWarrior("Steve"));
      enemies.add(new YoungKaren("Heather"));
      enemies.add(new QuietKid("Lucas"));
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    //Adventurers you control:
    //Make an ArrayList of Adventurers and add 2-4 Adventurers to it.
    ArrayList<Adventurer> party = new ArrayList<Adventurer>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    party.add(new CodeWarrior("Boris"));
    party.add(new YoungKaren("Liz"));
    party.add(new QuietKid("Neville"));
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    //add enemies and party to all adventurers
    for(Adventurer current : enemies){
      current.setEnemies(party);
      current.setTeam(enemies);
    }
    for(Adventurer current : party){
      current.setEnemies(enemies);
      current.setTeam(party);
    }


    boolean partyTurn = true;
    int whichPlayer = 0;
    int whichOpponent = 0;
    int turn = 0;
    String input = "";//blank to get into the main loop.
    Scanner in = new Scanner(System.in);
    //Draw the window border

    //You can add parameters to draw screen!
    drawScreen(party, enemies, 4, 25 );//initial state.

    //Main loop

    //display this prompt at the start of the game.
    String preprompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
    drawText(preprompt, 22, 2);
    Text.go(23, 2);

    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){
      //Read user input
      input = userInput(in);

      //example debug statment
      TextBox(24,2,1,78,"input: "+input+" partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent );

      //display event based on last turn's input
      if(partyTurn){

        //Process user input for the last Adventurer:
        if(input.startsWith("attack ") || input.startsWith("a ")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          String result =  party.get(whichPlayer).attack(enemies.get(Integer.parseInt(input.substring(input.length() - 1, input.length()))));
          TextBox(22, 2, 78, 1, result);
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.startsWith("special ") || input.startsWith("sp ")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          if(party.get(whichPlayer) instanceof QuietKid || party.get(whichPlayer) instanceof YoungKaren){
            party.get(whichPlayer).specialAttack(party.get(whichPlayer));
          }
          else{
            party.get(whichPlayer).specialAttack(enemies.get(Integer.parseInt(input.substring(input.length() - 1, input.length()))));
          }
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        //////////////////////////////// THIS IS THE CORRECT WAY OF DOING IT ////////////////////////////////
        else if(input.startsWith("su ") || input.startsWith("support ")){
          //"support 0" or "su 0" or "su 2" etc.
          //assume the value that follows su  is an integer.
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          if(Integer.parseInt(input.substring(input.length() - 1, input.length())) == whichPlayer){
            party.get(whichPlayer).support();
          }
          else{
            party.get(whichPlayer).support(party.get(Integer.parseInt(input.substring(input.length() - 1, input.length()))));
          }
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }

        //You should decide when you want to re-ask for user input
        //If no errors:
        whichPlayer++;


        if(whichPlayer < party.size()){
          //This is a player turn.
          //Decide where to draw the following prompt:
          String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
          drawText(preprompt, 23, 2);

        }else{
          //This is after the player's turn, and allows the user to see the enemy turn
          //Decide where to draw the following prompt:
          String prompt = "press enter to see monster's turn";

          partyTurn = false;
          whichOpponent = 0;
        }
        //done with one party member
      }else{
        //not the party turn!


        //enemy attacks a randomly chosen person with a randomly chosen attack.z`
        //Enemy action choices go here!
        /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
        //YOUR CODE HERE
        /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/


        //Decide where to draw the following prompt:
        String prompt = "press enter to see next turn";

        whichOpponent++;

      }//end of one enemy.

      //modify this if statement.
      if(!partyTurn && whichOpponent >= enemies.size()){
        //THIS BLOCK IS TO END THE ENEMY TURN
        //It only triggers after the last enemy goes.
        whichPlayer = 0;
        turn++;
        partyTurn=true;
        //display this prompt before player's turn
        String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
      }

      //display the updated screen after input has been processed.
      drawScreen(party, enemies, 4, 25);


    }//end of main game loop


    //After quit reset things:
    quit();
  }
}
