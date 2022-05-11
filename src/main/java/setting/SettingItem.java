package setting;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import file.ScoreBoardFile;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SettingItem {

    private ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    private static SettingItem instance;

    static {
        try {
            instance = new SettingItem();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String leftKey;
    private String rightKey;
    private String downKey;
    private String rotateKey;
    private String dropKey;
    private String pauseKey;
    private int boardWidth;
    private int boardHeight;
    private int fontSize;
    private int initInterval;
    private String modeName;
    private boolean isColorBlind;
    private int reduceSpeed;
    public static boolean isItemMode;

    public static final int SMALL_WIDTH = 300;
    public static final int MEDIUM_WIDTH = 350;
    public static final int LARGE_WIDTH = 400;

    public static final int SMALL_HEIGHT = 510;
    public static final int MEDIUM_HEIGHT = 593;
    public static final int LARGE_HEIGHT = 676;

    public static final int SMALL_FONT = 19;
    public static final int MEDIUM_FONT = 23;
    public static final int LARGE_FONT = 28;

    private SettingItem() throws IOException {
        Map<String, String> saveFile = loadFile();

        leftKey = saveFile.get("leftKey");
        rightKey = saveFile.get("rightKey");
        downKey = saveFile.get("downKey");
        rotateKey = saveFile.get("rotateKey");
        dropKey = saveFile.get("dropKey");
        pauseKey = saveFile.get("pauseKey");

        boardWidth = Integer.parseInt(saveFile.get("boardWidth"));
        boardHeight = Integer.parseInt(saveFile.get("boardHeight"));
        fontSize = Integer.parseInt(saveFile.get("fontSize"));

        initInterval = Integer.parseInt(saveFile.get("initInterval"));
        reduceSpeed = Integer.parseInt(saveFile.get("reduceSpeed"));
        modeName = saveFile.get("modeName");
        isColorBlind = Boolean.parseBoolean(saveFile.get("colorBlind"));
    }

    /**
     * 설정 불러오기
     */
    public Map<String, String> loadFile() throws IOException {
        TypeReference<HashMap<String, String>> typeReference = new TypeReference<HashMap<String, String>>() {
        };
        return objectMapper.readValue(new File("savefile.json"), typeReference);
    }

    /**
     * 설정 저장
     */
    public void btnSaveSettingActionPerformed() throws IOException {

        SaveFile saveFile = new SaveFile(leftKey, rightKey, downKey, rotateKey, dropKey, pauseKey,
                initInterval, reduceSpeed, modeName, boardWidth, boardHeight, fontSize, isColorBlind);
        objectMapper.writeValue(new File("savefile.json"), saveFile);
    }

    public static SettingItem getInstance() throws IOException {
        if(instance == null){
            return new SettingItem();
        }
        return instance;
    }

    public void initKeySetting(){
        leftKey = "LEFT";
        rightKey = "RIGHT";
        downKey = "DOWN";
        rotateKey = "UP";
        dropKey = "SPACE";
        pauseKey = "P";
    }

    /**
     * 화면 크기 조절
     */
    public void btnSmallBtnActionPerformed() {
        boardWidth = SMALL_WIDTH;
        boardHeight = SMALL_HEIGHT;
        fontSize = SMALL_FONT;
    }

    // default
    public void btnMediumBtnActionPerformed() {
        boardWidth = MEDIUM_WIDTH;
        boardHeight = MEDIUM_HEIGHT;
        fontSize = MEDIUM_FONT;
    }

    public void btnLargeBtnActionPerformed() {
        boardWidth = LARGE_WIDTH;
        boardHeight = LARGE_HEIGHT;
        fontSize = LARGE_FONT;
    }

    /**
     * 색맹 모드
     */
    public void btnColorBlindOnActionPerformed() {
        isColorBlind = true;
    }

    public void btnColorBlindOffActionPerformed() {
        isColorBlind = false;
    }

    /**
     * 스코어보드 초기화
     */
    public void btnInitScoreBoardActionPerformed(){
        // score board init logic
        ScoreBoardFile sb = new ScoreBoardFile();
        sb.eraseFile();
<<<<<<< HEAD
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Score Board have been reset.");
=======
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "스코어보드가 초기화 되었습니다..");
>>>>>>> 1c68e7c98bba8b52e7ce3f6959fb66042183d6a8
    }

    /**
     * 난이도 모드
     */
    public void btnEasyModeActionPerformed(){
        initInterval = 1200;
        reduceSpeed = 80;
        modeName = "EASY";
    }

    public void btnNormalModeActionPerformed(){
        initInterval = 1000;
        reduceSpeed = 100;
        modeName = "NORMAL";
    }

    public void btnHardModeActionPerformed(){
        initInterval = 800;
        reduceSpeed = 120;
        modeName = "HARD";
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

    public int getBoardWidth() {
        return boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public int getFontSize() {
        return fontSize;
    }

    public int getInitInterval() {
        return initInterval;
    }
    public int getReduceSpeed() {
        return reduceSpeed;
    }
    public String getModeName() {
        return modeName;
    }

    public boolean isColorBlind() {
        return isColorBlind;
    }

    public void setLeftKey(String leftKey) {
        this.leftKey = leftKey;
    }

    public void setRightKey(String rightKey) {
        this.rightKey = rightKey;
    }

    public void setDownKey(String downKey) {
        this.downKey = downKey;
    }

    public void setRotateKey(String rotateKey) {
        this.rotateKey = rotateKey;
    }

    public void setDropKey(String dropKey) {
        this.dropKey = dropKey;
    }

}