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
    private String keyName;
    private final String keyType;
    private final SettingItem settingItem;

    public KeySetting(String keyType, int player) throws IOException{

        settingItem = SettingItem.getInstance();
        this.keyType = keyType;

        setSize(800, 200);
        setBackground(Color.WHITE);
        setVisible(true);
        setLocationRelativeTo(null);

        String[] keyNames = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
                "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z","SPACE","ENTER"};
        int[] firstLineKey = {16, 22, 4, 17, 19, 24, 20, 8, 15};
        int[] secondLineKey = {0, 18, 3, 5, 6, 7, 9, 10, 11};
        int[] thirdLineKey = {25, 23, 2, 21, 1, 13, 12, 26};

        JButton[] keyBtns = new JButton[keyNames.length];
        for (int i = 0; i < keyNames.length; i++) {
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
        cancelBtn = new JButton("<");
        cancelBtn.addActionListener(e -> btnCancelActionPerformed());
        settingLine.add(cancelBtn);


        for(int i = 0; i < keyNames.length; i++){
            int finalI = i;
            keyBtns[i].addActionListener(e -> btnKeyActionPerformed(keyNames[finalI],player));
        }

        this.setLayout(new GridLayout(4, 0));
        this.add(firstLine);
        this.add(secondLine);
        this.add(thirdLine);
        this.add(settingLine);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void btnKeyActionPerformed(String keyName,int player) {
        this.keyName = keyName;
        switch (keyType){
            case "LEFT":
                settingItem.setLeftKey(keyName,player);
                break;
            case "RIGHT":
                settingItem.setRightKey(keyName,player);
                break;
            case "DOWN":
                settingItem.setDownKey(keyName,player);
                break;
            case "DROP":
                settingItem.setDropKey(keyName,player);
                break;
            case "ROTATE":
                settingItem.setRotateKey(keyName,player);
                break;
            default:
        }

    }

    public void btnCancelActionPerformed() {
        dispose();
    }
}