package cl.gob.scj.pruebanodos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cl.gob.scj.pruebanodos.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        Contact contact = new Contact("José Riffo", "", "jriffo.toro@gmail.com");
        return new ApiInfoBuilder()
                .title("API TEST SCJ")
                .description("API TEST SCJ")               
                .contact(contact)
                .license("GNU General Public License v3.0")
                .licenseUrl("https://www.gnu.org/licenses/gpl-3.0.html")
                .version("1.0.0")
                .build();
    }
     

}