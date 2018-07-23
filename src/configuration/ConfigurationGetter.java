package configuration;

import java.io.IOException;
import java.util.Map;


public class ConfigurationGetter {
	
	private Map<String, String> properties;
	private static final String TIMER_PERIOD  = "TIMER_PERIOD";
	private static final String FRAME_WIDTH  = "FRAME_WIDTH";
	private static final String FRAME_HEIGHT = "FRAME_HEIGHT";
	private static final String FRAME_TITLE  = "FRAME_TITLE";
	
	
	public ConfigurationGetter() throws IOException {
		setPropertyValues();
	}
	
	private void setPropertyValues() throws IOException {
		ConfigurationGetPropertyValues propertiesValue = new ConfigurationGetPropertyValues();
		this.properties = propertiesValue.getPropValues();
	}
	
	public int getTimerPeriod() {
		return Integer.parseInt(properties.get(TIMER_PERIOD));
	}

	public int getFrameWidth() {
		return Integer.parseInt(properties.get(FRAME_WIDTH));
	}

	public int getFrameHeight() {
		return Integer.parseInt(properties.get(FRAME_HEIGHT));
	}
	
	public String getTitle() {
		return properties.get(FRAME_TITLE);
	}
}
