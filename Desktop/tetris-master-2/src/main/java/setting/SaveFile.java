package setting;

public class SaveFile{

    private String leftKey;
    private String rightKey;
    private String downKey;
    private String rotateKey;
    private String dropKey;
    private String pauseKey;
    private Integer initInterval;
    private Integer reduceSpeed;
    private String modeName;
    private Integer boardWidth;
    private Integer boardHeight;
    private Integer fontSize;
    private boolean isColorBlind;

    public SaveFile(){
    }

    public SaveFile(String leftKey, String rightKey, String downKey, String rotateKey, String dropKey, String pauseKey,
                    Integer initInterval, Integer reduceSpeed, String modeName, Integer boardWidth, Integer boardHeight, Integer fontSize, boolean isColorBlind) {

        this.leftKey = leftKey;
        this.rightKey = rightKey;
        this.downKey = downKey;
        this.rotateKey = rotateKey;
        this.dropKey = dropKey;
        this.pauseKey = pauseKey;
        this.initInterval = initInterval;
        this.reduceSpeed = reduceSpeed;
        this.modeName = modeName;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.fontSize = fontSize;
        this.isColorBlind = isColorBlind;
    }

    public String getLeftKey() {
        return leftKey;
    }

    public String getRightKey() {
        return rightKey;
    }

    public String getDownKey() {
        return downKey;
    }

    public String getRotateKey() {
        return rotateKey;
    }

    public String getDropKey() {
        return dropKey;
    }

    public String getPauseKey() {
        return pauseKey;
    }

    public Integer getInitInterval() {
        return initInterval;
    }

    public Integer getReduceSpeed() {
        return reduceSpeed;
    }

    public String getModeName() {
        return modeName;
    }

    public Integer getBoardWidth() {
        return boardWidth;
    }

    public Integer getBoardHeight() {
        return boardHeight;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public boolean isColorBlind() {
        return isColorBlind;
    }
}