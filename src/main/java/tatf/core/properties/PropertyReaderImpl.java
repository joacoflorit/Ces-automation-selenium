package tatf.core.properties;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertyReaderImpl implements IPropertyReader {
    private final Properties properties;

    public PropertyReaderImpl(String filePath, String fileName) {
        this.properties = this.create(filePath, fileName);
    }

    @Override
    public String getValue(String key) {
        return getProp(this.properties, key);
    }

    //#region Private method

    private Properties create(String filePath, String fileName) {
        File file = new File(filePath + fileName);
        Properties p = new Properties();

        try (FileReader fileReader = new FileReader(file, StandardCharsets.ISO_8859_1)) {
            p.load(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return p;
    }

    private static String getProp(Properties p, String key) {
        return p.getProperty(key);
    }
    //#endregion
}