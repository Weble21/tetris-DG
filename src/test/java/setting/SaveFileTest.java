package setting;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class SaveFileTest {

    SaveFile sv = new SaveFile();
    SaveFile sv2;
     String leftKey = "p";
    String rightKey = "q";
    String downKey = "w";
    String rotateKey = "e";
    String dropKey = "r";
    String pauseKey = "t";
    Integer initInterval = 1000;
    Integer reduceSpeed = 100;
    String modeName = "EASY";
    Integer boardWidth = 100;
    Integer boardHeight = 101;
    Integer fontSize = 10;
    boolean isColorBlind = false;

    @Test
    public void SaveFile(){
        sv2 = new SaveFile(leftKey,rightKey,downKey,rotateKey,dropKey,pauseKey,initInterval,reduceSpeed,modeName,
                boardWidth,boardHeight,fontSize,isColorBlind);
        Assert.assertEquals(leftKey,sv2.getLeftKey());
        Assert.assertEquals(rightKey,sv2.getRightKey());
        Assert.assertEquals(downKey,sv2.getDownKey());
        Assert.assertEquals(rotateKey,sv2.getRotateKey());
        Assert.assertEquals(pauseKey,sv2.getPauseKey());
        Assert.assertEquals(initInterval,sv2.getInitInterval());
        Assert.assertEquals(reduceSpeed,sv2.getReduceSpeed());
        Assert.assertEquals(modeName,sv2.getModeName());
        Assert.assertEquals(boardWidth,sv2.getBoardWidth());
        Assert.assertEquals(boardHeight,sv2.getBoardHeight());
        Assert.assertEquals(fontSize,sv2.getFontSize());
        Assert.assertEquals(isColorBlind,sv2.isColorBlind());
    }

}
