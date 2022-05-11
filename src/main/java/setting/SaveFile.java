package setting;

public class SaveFile{

    private String leftKey;
    private String rightKey;
    private String downKey;
    private String rotateKey;
    private String dropKey;
    private String p1LeftKey;
    private String p1RightKey;
    private String p1DownKey;
    private String p1RotateKey;
    private String p1DropKey;
    private String p2LeftKey;
    private String p2RightKey;
    private String p2DownKey;
    private String p2RotateKey;
    private String p2DropKey;
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


    public SaveFile(String leftKey, String rightKey, String downKey, String rotateKey, String dropKey, String pauseKey, Integer initInterval, Integer reduceSpeed, String modeName, Integer boardWidth, Integer boardHeight, Integer fontSize, boolean isColorBlind) {
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


    public SaveFile(String leftKey, String rightKey, String downKey, String rotateKey, String dropKey, String pauseKey,
                    Integer initInterval, Integer reduceSpeed, String modeName, Integer boardWidth, Integer boardHeight, Integer fontSize, boolean isColorBlind,
                    String p1Left, String p1Right,String p1Down, String p1Rotate, String p1Drop,String p2Left, String p2Right,String p2Down, String p2Rotate, String p2Drop) {

        this.leftKey = leftKey;
        this.rightKey = rightKey;
        this.downKey = downKey;
        this.rotateKey = rotateKey;
        this.dropKey = dropKey;
        this.p1LeftKey = p1Left;
        this.p1RightKey = p1Right;
        this.p1DownKey = p1Down;
        this.p1RotateKey = p1Rotate;
        this.p1DropKey = p1Drop;
        this.p2LeftKey = p2Left;
        this.p2RightKey = p2Right;
        this.p2DownKey = p2Down;
        this.p2RotateKey = p2Rotate;
        this.p2DropKey = p2Drop;
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

    public String getP1LeftKey() {
        return p1LeftKey;
    }

    public String getP1RightKey() {
        return p1RightKey;
    }

    public String getP1DownKey() {
        return p1DownKey;
    }

    public String getP1RotateKey() {
        return p1RotateKey;
    }

    public String getP1DropKey() {
        return p1DropKey;
    }

    public String getP2LeftKey() {
        return p2LeftKey;
    }

    public String getP2RightKey() {
        return p2RightKey;
    }

    public String getP2DownKey() {
        return p2DownKey;
    }

    public String getP2RotateKey() {
        return p2RotateKey;
    }

    public String getP2DropKey() {
        return p2DropKey;
    }
}