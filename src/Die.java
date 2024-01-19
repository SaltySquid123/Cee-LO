public class Die {
    public Die() {};
    private static int recentRoll;
    public static int roll(){
        recentRoll = (int) (Math.random() * 6) + 1;
        return recentRoll;
    }
}
