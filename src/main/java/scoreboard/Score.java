package scoreboard;

import java.util.Comparator;

public class Score {
    protected String name;
    protected Integer score;
    protected String level;
    protected String mode;

    public Score() {
        this.name = "DF";
        this.score = 0;
        this.level = "normal";
        this.mode = "regul";
    }

    public String getName(){
        return name;
    }

    public Integer getScore(){
        return score;
    }

    public String getLevel(){
        return level;
    }

    public String getMode(){
        return mode;
    }

    public Score(String name, Integer score, String level,String mode) {
        this.name = name;
        this.score = score;
        this.level = level;
        this.mode = mode;
    }

    public String toWritableString(){
        return "|   " + String.format("%-4s", this.name) + "   "
                + String.format("%05d", this.score) + "   " + String.format("%-7s", this.level)
                + String.format("%7s", this.mode) + "\n";
    }

}
class ScoreComparator implements Comparator<Score> {
    public int compare(Score arg0, Score arg1) {
        return arg1.score.compareTo(arg0.score);
    }
}