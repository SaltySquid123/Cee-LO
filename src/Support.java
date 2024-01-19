public class Support {
    public Support() {};
    public static boolean contains(final int[] array, final int key) {
        for (final int i : array) {
            if (i == key) {
                return true;
            }
        }
        return false;
    }
    public static boolean checkRolls456(int roll1, int roll2, int roll3){
       if (roll1 == 4 && roll2 == 5 && roll3 == 6){
           return true;
       }
       else if (roll1 == 4 && roll3 == 5 && roll2 == 6){
           return true;
       }
       else if (roll2 == 4 && roll1 == 5 && roll3 == 6){
           return true;
       }
       else if (roll2 == 4 && roll3 == 5 && roll1 == 6){
           return true;
       }
       else if (roll3 == 4 && roll1 == 5 && roll2 == 6){
           return true;
       }
       else if (roll3 == 4 && roll2 == 5 && roll1 == 6){
           return true;
       }
       else {
           return false;
       }
    }
    public static boolean checkRolls123(int roll1, int roll2, int roll3){
       if (roll1 == 1 && roll2 == 2 && roll3 == 3){
           return true;
       }
       else if (roll1 == 1 && roll3 == 2 && roll2 == 3){
           return true;
       }
       else if (roll2 == 1 && roll1 == 2 && roll3 == 3){
           return true;
       }
       else if (roll2 == 1 && roll3 == 2 && roll1 == 3){
           return true;
       }
       else if (roll3 == 1 && roll1 == 2 && roll2 == 3){
           return true;
       }
       else if (roll3 == 1 && roll2 == 2 && roll1 == 3){
           return true;
       }
       else {
           return false;
       }
    }
    public static boolean getRollsBooleanXXY(int roll1, int roll2, int roll3){
        if (roll1 == roll2){
            return true;
        }
        else if (roll1 == roll3){
            return true;
        }
        else if (roll2 == roll3){
            return true;
        }
        else{
            return false;
        }
    }
    public static int getRollsXXY(int roll1, int roll2, int roll3){
        if (roll1 == roll2){
            return roll3;
        }
        else if (roll1 == roll3){
            return roll2;
        }
        else if (roll2 == roll3){
            return roll1;
        }
        else {
            return 0;
        }
    }
    public static String highestChips(Player p1, Player p2, Player p3){
        String name;
        if (p1.getChips() == p2.getChips() || p2.getChips() == p3.getChips() || p1.getChips() == p3.getChips()) {
            double random = Math.random();
            if (random > .66) {
                name = p1.getName();
            } else if (random < .66 && random > .33) {
                name = p2.getName();
            } else {
                name = p3.getName();
            }
        }
        if (p1.getChips() > p2.getChips() && p1.getChips() > p3.getChips()){
            name = p1.getName();
        }
        else if (p2.getChips() > p1.getChips() && p2.getChips() > p3.getChips()){
            name = p2.getName();
        }
        else {
            name = p3.getName();
        }
        return name;
    }
}
