//package br.com.sistema.web.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
///**
// *
// * @author edmilson.reis
// *
// */
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//
//    @Autowired
//    private UserDetailsService usuarioDetailsService;
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//        http.csrf().disable()
//	        .authorizeRequests()
//	        	.antMatchers("/*/clientes*", "/*/produtos*").hasAnyAuthority("USUARIO", "ADMIN")
//	        	.antMatchers("/*/financeiro*").hasAuthority("ADMIN")
//	            .antMatchers("/plain/rest/**", "/plain/assets/**", "/plain/cadastrar-se.html", "/plain/recupera-acesso.html").permitAll()
//	            .anyRequest().authenticated()
//	         .and()
//		         .formLogin().failureUrl("/plain/login.html?auth=loginInvalido")
//		        	.defaultSuccessUrl("/page/dashboard.html", true).loginPage("/plain/login.html").
//		        	 permitAll()
//	         .and()
//		        .logout()
//		            .permitAll()
//		     .and().exceptionHandling().accessDeniedPage("/page/acesso-negado.html");
//	}
//
//    @Autowired
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//    	ShaPasswordEncoder shaPasswordEncoder = new ShaPasswordEncoder(256);
//        auth.userDetailsService(usuarioDetailsService).passwordEncoder(shaPasswordEncoder);
//    }
//
//
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//}
