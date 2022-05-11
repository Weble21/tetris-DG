package setting;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class SettingMenuTest {
    SettingMenu menu;

    @Test
    public void SettingMenu()
    {
        try {
            menu = new SettingMenu();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
