package mdorokhin.dao.jdbc.utils.propertiesHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Maxim Dorokhin
 *         30.04.2016.
 */
public class DBPropertiesHandler implements PropertiesHelper {

    private static final Logger log = LoggerFactory.getLogger(DBPropertiesHandler.class);
    private Properties properties;

    public DBPropertiesHandler(String path) {
        loadProperties(path);
    }

    private void loadProperties(String path) {

        try(InputStream fis = new FileInputStream(path)){
            this.properties = new Properties();
            properties.load(fis);
            log.debug("Data base properties has loaded from: {}", path);
        }catch (IOException e) {
            log.debug("Error loading properties file from path: {}", path);
        }
    }

    @Override
    public String getProperty(String key) {
        return properties.getProperty(key)!= null ? properties.getProperty(key) : "";
    }


}
