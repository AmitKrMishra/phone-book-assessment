package abc.phone.book.config;

import java.io.File;
import java.nio.file.Paths;
import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.MimeMappings;
import org.springframework.boot.web.servlet.ServletContextInitializer;

@EnableAutoConfiguration
public class WebConfigurer implements ServletContextInitializer, EmbeddedServletContainerCustomizer {

	public WebConfigurer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		MimeMappings mappings = new MimeMappings(MimeMappings.DEFAULT);
        mappings.add("html", "text/html;charset=utf-8");
        mappings.add("json", "text/html;charset=utf-8");
        container.setMimeMappings(mappings);

        // When running in an IDE or with ./mvnw spring-boot:run, set location of the static web assets.
        setLocationForStaticAssets(container);

	}
	
	private void setLocationForStaticAssets(ConfigurableEmbeddedServletContainer container) {
        File root;
        String prefixPath = resolvePathPrefix();
        root = new File(prefixPath + "src/main/webapp/");
        if (root.exists() && root.isDirectory()) {
            container.setDocumentRoot(root);
        }
    }
	
	private String resolvePathPrefix() {
        String fullExecutablePath = this.getClass().getResource("").getPath();
        String rootPath = Paths.get(".").toUri().normalize().getPath();
        String extractedPath = fullExecutablePath.replace(rootPath, "");
        int extractionEndIndex = extractedPath.indexOf("target/");
        if(extractionEndIndex <= 0) {
            return "";
        }
        return extractedPath.substring(0, extractionEndIndex);
    }

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		EnumSet<DispatcherType> disps = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ASYNC);
	}

}
