package com.leafsoft.hospital.configuration;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.leafsoft.hospital.extractor.custom.CustomAuthoritiesExtractor;
import com.leafsoft.hospital.extractor.custom.CustomPrincipalExtractor;

@Configuration
@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/login**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().disable();
    }

    @Bean
    public PrincipalExtractor baeldungPrincipalExtractor() {
        return new CustomPrincipalExtractor();
    }

    @Bean
    public AuthoritiesExtractor baeldungAuthoritiesExtractor() {
        return new CustomAuthoritiesExtractor();
    }

}