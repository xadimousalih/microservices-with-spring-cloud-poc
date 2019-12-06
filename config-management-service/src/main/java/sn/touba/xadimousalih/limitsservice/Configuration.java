package sn.touba.xadimousalih.limitsservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 * @author xadimouSALIH
 * @note: Application configuration file using the application properties to create a configuration and pick up the value.
 */

@Component
@ConfigurationProperties("config-management-service")
public class Configuration {

	private int minimum;
	private int maximum;

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public int getMaximum() {
		return maximum;
	}

}