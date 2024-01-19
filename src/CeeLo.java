import java.util.Scanner;
public class CeeLo {
    private Player currentPlayer;
    private Player p1;
    private Player p2;
    private Player p3;
    private Banker banker;
    private int wager1;
    private int wager2;
    private int wager3;
    public CeeLo () {
        banker = null;
        p1 = null;
        p2 = null;
        p3 = null;
        currentPlayer = null;
    }
    public void play(){
       Scanner scanner = new Scanner(System.in);
       System.out.print("Player 1 please input your name: ");
       String name1 = scanner.nextLine();
       System.out.print("Player 2 please input your name: ");
       String name2 = scanner.nextLine();
       System.out.print("Player 3 please input your name: ");
       String name3 = scanner.nextLine();
       p1 = new Player(name1, 100);
       p2 = new Player(name2, 100);
       p3 = new Player(name3, 100);
       banker = new Banker(1000);

       while (!gameOver()) {
           System.out.println("_______________________________________________________________________");
           System.out.println("The banker has " + banker.getChips() + " chips left");
           if (p1.checkInGame()) {
               System.out.print(p1.getName() + ", you have " + p1.getChips() + " chips. Enter your wager: ");
               wager1 = scanner.nextInt();
               while ((wager1 < 0 || wager1 > p1.getChips())) {
                   System.out.println("Invalid input please make it a positive number or less than the chips you have.");
                   wager1 = scanner.nextInt();
               }
           } else {
               wager1 = 0;
           }
           if (p2.checkInGame()) {
               System.out.print(p2.getName() + ", you have " + p2.getChips() + " chips. Enter your wager: ");
               wager2 = scanner.nextInt();
               while ((wager2 < 0 || wager2 > p2.getChips())) {
                   System.out.println("Invalid input please make it a positive number or less than the chips you have.");
                   wager2 = scanner.nextInt();
               }
           } else {
                wager2 = 0;
           }
           if (p3.checkInGame()) {
               System.out.print(p3.getName() + ", you have " + p3.getChips() + " chips. Enter your wager: ");
               wager3 = scanner.nextInt();
               while ((wager3 < 0 || wager3 > p3.getChips())) {
                   System.out.println("Invalid input please make it a positive number or less than the chips you have.");
                   wager3 = scanner.nextInt();
               }
           } else  {
               wager3 = 0;
           }
           System.out.println("_______________________________________________________________________");
           banker.roll();
           while (banker.getStatus().equals("reroll")){
               banker.roll();
           }
           if (banker.getStatus().equals("win")){
               System.out.println("\uD83C\uDF1F" + "Banker rolled: " + banker.getRolls() + " and has won the round." + "\uD83C\uDF1F\nEach player loses their wager");
               p1.payBanker(banker, wager1);
               p2.payBanker(banker, wager2);
               p3.payBanker(banker, wager3);
           }
           else if (banker.getStatus().equals("lose")){
               System.out.println("\uD83C\uDF1F" +"Banker rolled: " + banker.getRolls() + " and has lost the round." + "\uD83C\uDF1F\nEach player receives their wager");
               banker.payPlayer(p1, wager1);
               banker.payPlayer(p2, wager2);
               banker.payPlayer(p3, wager3);
           }
           else {
               System.out.println("\uD83C\uDF1F" + "Banker rolled: " + banker.getRolls() + "\uD83C\uDF1F");
               System.out.println("Since the banker rolled 2 doubles, their score is " + banker.getScore());
               if (p1.checkInGame()) {
                   p1.roll();
                   while (p1.getStatus().equals("reroll")) {
                       p1.roll();
                   }
                   System.out.println("++++++++++++++++++++++++++++++++++++++++");
                   System.out.println("\uD83C\uDF00" + p1.getName() + " rolled: " + p1.getRolls() + "\uD83C\uDF00");
                   if (p1.getStatus().equals("win")) {
                       System.out.println(p1.getName() + " has won against the banker this round and received their wager.");
                       banker.payPlayer(p1, wager1);
                   }
                   else if (p1.getStatus().equals("lose")){
                       System.out.println(p1.getName() + " has lost against the banker this round and lost their wager.");
                       p1.payBanker(banker, wager1);
                   }
                   else if (p1.getStatus().equals("score")){
                       System.out.println(p1.getName() + " rolled 2 doubles and their score is " + p1.getScore());
                       if (p1.getScore() >= banker.getScore()){
                           System.out.println(p1.getName() + " has a higher or equal score to the banker so they win for this round, receiving their wager");
                           banker.payPlayer(p1, wager1);
                       }
                       else {
                           System.out.println(p1.getName() + " has a lower score than the banker and has lost for this round, losing their wager");
                           p1.payBanker(banker, wager1);
                       }
                   }
               }
               if (p2.checkInGame()) {
                   p2.roll();
                   while (p2.getStatus().equals("reroll")) {
                       p2.roll();
                   }
                   System.out.println("++++++++++++++++++++++++++++++++++++++++");
                   System.out.println("\uD83C\uDF00" + p2.getName() + " rolled: " + p2.getRolls() + "\uD83C\uDF00");
                   if (p2.getStatus().equals("win")) {
                       System.out.println(p2.getName() + " has won against the banker this round and received their wager.");
                       banker.payPlayer(p2, wager2);
                   }
                   else if (p2.getStatus().equals("lose")){
                       System.out.println(p2.getName() + " has lost against the banker this round and lost their wager.");
                       p2.payBanker(banker, wager2);
                   }
                   else if (p2.getStatus().equals("score")){
                       System.out.println(p2.getName() + " rolled 2 doubles and their score is " + p2.getScore());
                       if (p2.getScore() >= banker.getScore()){
                           System.out.println(p2.getName() + " has a higher or equal score to the banker so they win for this round, receiving their wager");
                           banker.payPlayer(p2, wager2);
                       }
                       else {
                           System.out.println(p2.getName() + " has a lower score than the banker and has lost for this round, losing their wager");
                           p2.payBanker(banker, wager2);
                       }
                   }
               }
               if (p3.checkInGame()) {
                   p3.roll();
                   while (p3.getStatus().equals("reroll")) {
                       p3.roll();
                   }
                   System.out.println("++++++++++++++++++++++++++++++++++++++++");
                   System.out.println("\uD83C\uDF00" + p3.getName() + " rolled: " + p3.getRolls() + "\uD83C\uDF00");
                   if (p3.getStatus().equals("win")) {
                       System.out.println(p3.getName() + " has won against the banker this round and received their wager.");
                       banker.payPlayer(p3, wager3);
                   }
                   else if (p3.getStatus().equals("lose")){
                       System.out.println(p3.getName() + " has lost against the banker this round and lost their wager.");
                       p3.payBanker(banker, wager3);
                   }
                   else if (p3.getStatus().equals("score")){
                       System.out.println(p3.getName() + " rolled 2 doubles and their score is " + p3.getScore());
                       if (p3.getScore() >= banker.getScore()){
                           System.out.println(p3.getName() + " has a higher or equal score to the banker so they win for this round, receiving their wager");
                           banker.payPlayer(p3, wager3);
                       }
                       else {
                           System.out.println(p3.getName() + " has a lower score than the banker and has lost for this round, losing their wager");
                           p3.payBanker(banker, wager3);
                       }
                   }
               }
           }
       }
        System.out.println("======================================================================");
       if (banker.getChips() == 0){
           System.out.println("The banker ran out chips so the game is over!");
           System.out.println(Support.highestChips(p1, p2, p3) + " has the most chips so they win the game! (If chips were equal, the winner was decided randomly)");
       }
       else if ((p1.getChips() == 0 && p2.getChips() == 0 && p3.getChips() == 0)){
           System.out.println("All the players are out of chips so the banker wins!");
       }
       System.out.println();
       System.out.println("Thank you for playing!");
    }
    private boolean gameOver(){
        if (banker.getChips() == 0 || (p1.getChips() == 0 && p2.getChips() == 0 && p3.getChips() == 0)){
            return true;
        }
        else {
            return false;
        }
    }

}
