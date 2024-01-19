public class Banker {

    private int chips;
    private int wager;
    private String status;
    private boolean inRound;
    private int score;
    private int roll1;
    private int roll2;
    private int roll3;

    public Banker(int chips) {
        this.chips = chips;
    }
    public int getChips() {
        return chips;
    }
    public int getScore() {
        return score;
    }
    public int getWager() {
        return wager;
    }
    public String getStatus() {
        return status;
    }
    public boolean isInRound() {
        return inRound;
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
        }
        else if (Support.checkRolls456(roll1, roll2, roll3)) {
            status = "win";
        }
        else if (Support.checkRolls123(roll1, roll2, roll3)){
            status = "lose";
        }
        else if (Support.getRollsBooleanXXY(roll1, roll2, roll3)){
            status = "score";
            score = Support.getRollsXXY(roll1, roll2, roll3);
        }
        else {
            status = "reroll";
        }
    }
    public void increaseChips(int xChips){
        chips += xChips;
    }
    public void payPlayer(Player player, int amt){
        player.increaseChips(amt);
        if (chips >= amt) {
            chips -= amt;
        }
        else {
            player.increaseChips(chips);
            chips = 0;
        }
    }
}
