package de.olivergeisel.experimenteundtests;

import org.salespointframework.EnableSalespoint;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@EnableSalespoint
public class ExperimenteUndTestsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExperimenteUndTestsApplication.class, args);
	}


	@Configuration
	@EnableWebSecurity
	public static class WebSecurityConfig {


		@Bean
		public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

			http
					.authorizeHttpRequests(requests -> requests
							.requestMatchers("/**").permitAll()
							.anyRequest().authenticated()
					)
					.formLogin(form -> form
							.loginPage("/login").permitAll().defaultSuccessUrl("/", false)
					)
					.logout(it -> it.permitAll().invalidateHttpSession(true).logoutSuccessUrl("/"));
			http.csrf(AbstractHttpConfigurer::disable);
			http.cors(AbstractHttpConfigurer::disable);
			return http.build();
		}
	}
}
