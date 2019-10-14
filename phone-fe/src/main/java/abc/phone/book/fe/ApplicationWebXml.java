package abc.phone.book.fe;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class ApplicationWebXml extends SpringBootServletInitializer {

	public ApplicationWebXml() {
		// TODO Auto-generated constructor stub
	}

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        /*
          set a default to use when no profile is configured.
         */
        //DefaultProfileUtil.addDefaultProfile(application.application());
        return application.sources(PhoneBookApplication.class);
    }
}
