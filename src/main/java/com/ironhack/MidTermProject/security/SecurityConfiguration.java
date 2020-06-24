package com.ironhack.MidTermProject.security;


import com.ironhack.MidTermProject.service.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.savedrequest.NullRequestCache;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.httpBasic();

        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
                .mvcMatchers("*").hasAuthority("ADMIN")
//                .mvcMatchers("/SalesRep/byId").hasAuthority("ROLE_SALESREP")
//                .mvcMatchers(HttpMethod.POST,"/SalesRep/Create").hasAuthority("ROLE_ADMIN")
//                .mvcMatchers(HttpMethod.PUT,"/SalesRep/Update").hasAuthority("ROLE_ADMIN")
//                .mvcMatchers(HttpMethod.PATCH,"/SalesRep/UpdateName").hasAuthority("ROLE_ADMIN")
//                .mvcMatchers(HttpMethod.DELETE,"/SalesRep/Delete").hasAuthority("ROLE_ADMIN")
                // endregion
                .and().requestCache().requestCache(new NullRequestCache()).and().httpBasic().and().cors().and().csrf().disable();


    }
}