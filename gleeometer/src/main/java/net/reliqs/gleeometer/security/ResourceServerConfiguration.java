package net.reliqs.gleeometer.security;

import net.reliqs.gleeometer.errors.CustomAuthenticationEntryPoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

	public ResourceServerConfiguration(CustomAuthenticationEntryPoint customAuthenticationEntryPoint) {
		this.customAuthenticationEntryPoint = customAuthenticationEntryPoint;
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId("api");
	}


}