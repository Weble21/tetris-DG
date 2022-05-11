package setting;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import setting.SaveFile;
import setting.SettingItem;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoadFileTest {

    SettingItem settingItem = SettingItem.getInstance();
    ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public LoadFileTest() throws IOException {
    }

    @Test
    void loadFileTest() throws IOException {
        TypeReference<HashMap<String, String>> typeReference = new TypeReference<HashMap<String, String>>() {};
        HashMap<String, String> fileMap = objectMapper.readValue(new File("savefile.json"), typeReference);
        System.out.println(fileMap);
    }
}
