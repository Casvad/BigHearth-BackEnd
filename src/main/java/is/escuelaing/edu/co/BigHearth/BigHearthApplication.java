package is.escuelaing.edu.co.BigHearth;

import is.escuelaing.edu.co.BigHearth.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;

@SpringBootApplication
public class BigHearthApplication {

	@Bean
	public FilterRegistrationBean jwtFilter()
	{
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter((Filter) new JwtFilter());
		registrationBean.addUrlPatterns( "/api/*" );

		return registrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(BigHearthApplication.class, args);
	}
}
