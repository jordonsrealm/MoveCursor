package configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class ConfigurationGetPropertyValues {
	
	public static final String TIMER_PERIOD = "TIMER_PERIOD";
	public static final String FRAME_WIDTH = "FRAME_WIDTH";
	public static final String FRAME_HEIGHT = "FRAME_HEIGHT";
	public static final String FRAME_TITLE = "FRAME_TITLE";
 
	
	public Map<String, String> getPropValues() throws IOException {
		Properties prop = new Properties();
		String propFileName = "config.properties";
		
		HashMap<String, String> newHash = null;
		
		try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName)) {

			prop.load(inputStream);
 
			newHash = new HashMap<>();
			
			newHash.put(TIMER_PERIOD, prop.getProperty(TIMER_PERIOD));
			newHash.put(FRAME_WIDTH, prop.getProperty(FRAME_WIDTH));
			newHash.put(FRAME_HEIGHT, prop.getProperty(FRAME_HEIGHT));
			newHash.put(FRAME_TITLE, prop.getProperty(FRAME_TITLE));
			
		} catch (Exception e) {
			// no logging at the moment
		}
		
		return newHash;
	}
}
