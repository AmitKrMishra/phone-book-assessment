package abc.phone.book.fe;

import java.lang.invoke.MethodHandles;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.ConfigurableEnvironment;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@EnableZuulProxy
public class PhoneBookApplication implements ApplicationContextAware {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public static final String CONFIG_ENV_VAR_NAME = "SPRING_APPLICATION_JSON";

	public static void main(String[] args) throws Exception {
		final String springApplicationJson = System.getenv(CONFIG_ENV_VAR_NAME);
		if (springApplicationJson != null && springApplicationJson.contains("{")) {
			final ObjectMapper mapper = new ObjectMapper();
			// ensure it's valid
			mapper.readTree(springApplicationJson);
			logger.info("main: successfully parsed configuration from environment {}", CONFIG_ENV_VAR_NAME);
		} else {
			logger.warn("main: no configuration found in environment {}", CONFIG_ENV_VAR_NAME);
		}
        SpringApplication.run(PhoneBookApplication.class, args);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		((ConfigurableEnvironment) context.getEnvironment()).setActiveProfiles("src");
	}
	
}
