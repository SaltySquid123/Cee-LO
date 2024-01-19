public class Player {
    private String name;
    private int chips;
    private int wager;
    private String status;
    private boolean inRound;
    private int score;
    private int roll1;
    private int roll2;
    private int roll3;


    public Player(String name, int chips){
        this.chips = chips;
        this.name = name;
    }
    public String getStatus(){
        return status;
    }
    public String getName(){
        return name;
    }
    public int getChips() {
        return chips;
    }
    public int getWager(){
        return wager;
    }
    public void setWager(int wagerNew){
        wager = wagerNew;
    }
    public int getScore(){
        return score;
    }
    public String getRolls(){
        return "" + roll1 + " " + roll2 + " " + roll3;
    }
    public void roll() {
        roll1 = Die.roll();
        roll2 = Die.roll();
        roll3 = Die.roll();

        if (roll1 == roll2 && roll1 == roll3){
            status = "win";
            inRound = true;
        }
        else if (Support.checkRolls456(roll1, roll2, roll3)) {
            status = "win";
            inRound = true;
        }
        else if (Support.checkRolls123(roll1, roll2, roll3)){
            status = "lose";
            inRound = false;
        }
        else if (Support.getRollsBooleanXXY(roll1, roll2, roll3)){
            status = "score";
            score = Support.getRollsXXY(roll1, roll2, roll3);
            inRound = true;
        }
        else {
            status = "reroll";
        }
    }
    public void payBanker(Banker banker, int amt){
        banker.increaseChips(amt);
        if (chips >= amt) {
            chips -= amt;
        }
        else {
            banker.increaseChips(chips);
            chips = 0;
        }
        if (chips == 0){
            System.out.println(getName() + " you ran out of chips! You're out of the game.");
            inRound = false;
        }
    }
    public void increaseChips(int amt){
        chips += amt;
    }
    public boolean checkInGame(){
        if (chips <= 0){
            return false;
        }
        else {
            return true;
        }
    }
}
