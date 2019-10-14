package abc.phone.book;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import abc.phone.book.controller.AbstractController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select() //
				.apis(RequestHandlerSelectors.basePackage(AbstractController.class.getPackage().getName())) //
				.paths(PathSelectors.any()) //
				.build() //
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		final String version = PhoneBookServiceApplication.class.getPackage().getImplementationVersion();
		return new ApiInfoBuilder() //
				.title("Abc Phone Book REST API") //
				.description("Provides create, retrieve, restore and delete " //
						+ " Operations for Phone book. ")
				.termsOfServiceUrl("Terms of service") //
				.contact(new Contact("Abc Team", //
						"https://abc.org/to-be-determined", //
						"contact@abc.org")) //
				.license("Abc 2.0 License").licenseUrl("http://www.Abc.org/licenses/LICENSE-2.0") //
				.version(version == null ? "version not available" : version) //
				.build();
	}
}
