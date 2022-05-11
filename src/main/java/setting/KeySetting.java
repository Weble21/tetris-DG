package setting;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class KeySetting extends JFrame{

    private JPanel firstLine;
    private JPanel secondLine;
    private JPanel thirdLine;
    private JPanel settingLine;
    private JButton cancelBtn;
    private final JButton saveBtn;
    private String keyName;
    private final String keyType;
    private final SettingItem settingItem;

    public KeySetting(String keyType) throws IOException{

        settingItem = SettingItem.getInstance();
        this.keyType = keyType;

        setSize(800, 200);
        setBackground(Color.WHITE);
        setVisible(true);
        setLocationRelativeTo(null);

        String[] keyNames = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
                "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        int[] firstLineKey = {16, 22, 4, 17, 19, 24, 20, 8, 15};
        int[] secondLineKey = {0, 18, 3, 5, 6, 7, 9, 10, 11};
        int[] thirdLineKey = {25, 23, 2, 21, 1, 13, 12};

        JButton[] keyBtns = new JButton[26];
        for (int i = 0; i < 26; i++) {
            keyBtns[i] = new JButton(keyNames[i]);
        }

        firstLine = new JPanel(new FlowLayout());
        for (int value : firstLineKey) {
            firstLine.add(keyBtns[value]);
        }

        secondLine = new JPanel(new FlowLayout());
        for (int k : secondLineKey) {
            secondLine.add(keyBtns[k]);
        }

        thirdLine = new JPanel(new FlowLayout());
        for (int j : thirdLineKey) {
            thirdLine.add(keyBtns[j]);
        }

        settingLine = new JPanel(new FlowLayout());
<<<<<<< HEAD
        cancelBtn = new JButton("Cancel");
        saveBtn = new JButton("Save");
=======
        cancelBtn = new JButton("취소");
        saveBtn = new JButton("저장");
>>>>>>> 1c68e7c98bba8b52e7ce3f6959fb66042183d6a8
        cancelBtn.addActionListener(e -> btnCancelActionPerformed());
        saveBtn.addActionListener(e -> btnSaveActionPerformed());

        settingLine.add(cancelBtn);
        settingLine.add(saveBtn);

        for(int i = 0; i < 26; i++){
            int finalI = i;
            keyBtns[i].addActionListener(e -> btnKeyActionPerformed(keyNames[finalI]));
        }

        this.setLayout(new GridLayout(4, 0));
        this.add(firstLine);
        this.add(secondLine);
        this.add(thirdLine);
        this.add(settingLine);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void btnKeyActionPerformed(String keyName) {
        this.keyName = keyName;
        switch (keyType){
            case "LEFT":
                settingItem.setLeftKey(keyName);
                break;
            case "RIGHT":
                settingItem.setRightKey(keyName);
                break;
            case "DOWN":
                settingItem.setDownKey(keyName);
                break;
            case "DROP":
                settingItem.setDropKey(keyName);
                break;
            case "ROTATE":
                settingItem.setRotateKey(keyName);
                break;
            default:
        }
    }

    public void btnCancelActionPerformed() {
        dispose();
    }
    public void btnSaveActionPerformed(){
        dispose();
    }
}