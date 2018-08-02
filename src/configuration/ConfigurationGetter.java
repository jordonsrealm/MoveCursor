package configuration;

import java.io.IOException;
import java.util.Map;


public class ConfigurationGetter {
	
	private Map<String, String> properties;
	
	
	public ConfigurationGetter() throws IOException {
		setPropertyValues();
	}
	
	private void setPropertyValues() throws IOException {
		ConfigurationGetPropertyValues propertiesValue = new ConfigurationGetPropertyValues();
		this.properties = propertiesValue.getPropValues();
	}
	
	public int getTimerPeriod() {
		return Integer.parseInt(properties.get(ConfigurationGetPropertyValues.TIMER_PERIOD));
	}

	public int getFrameWidth() {
		return Integer.parseInt(properties.get(ConfigurationGetPropertyValues.FRAME_WIDTH));
	}

	public int getFrameHeight() {
		return Integer.parseInt(properties.get(ConfigurationGetPropertyValues.FRAME_HEIGHT));
	}
	
	public String getTitle() {
		return properties.get(ConfigurationGetPropertyValues.FRAME_TITLE);
	}
}
