package abc.phone.book.service;

import java.lang.invoke.MethodHandles;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import abc.phone.book.transport.ErrorTransport;

public abstract class AbstractPhoneDBClientConnection {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	@Autowired
	private Environment env;

	public void setEnvironment(Environment env1) {
		env = env1;
	}

	/*public RestHighLevelClient restHighLevelClientConnection() {

		String elk_host_ip =  getHostIP(env.getProperty("elk.host.url"));
		int elk_elasticssearch_port = Integer.valueOf(env.getProperty("elk.elasticssearch.port"));

		RestHighLevelClient client = new RestHighLevelClient(
				RestClient.builder(new HttpHost(elk_host_ip, elk_elasticssearch_port, "http")));
		return client;
	}
*/
	private String getHostIP(String url) {
		try {
            InetAddress host = InetAddress.getByName(url);
            System.out.println(host.getHostAddress());
            logger.debug("Elasticssearch Host IP:", host.getHostAddress());
            return host.getHostAddress();
        } catch (UnknownHostException ex) {
            logger.error("UnknownHostException:", ex);
            throw new ErrorTransport("Unable to connect Elasticserach");
        }
	}
	
	

}
