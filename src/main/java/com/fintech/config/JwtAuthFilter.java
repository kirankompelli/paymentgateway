package com.fintech.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fintech.entity.User;
import com.fintech.repository.UserRepository;
import com.fintech.util.JwtUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class JwtAuthFilter extends OncePerRequestFilter{
	
	@Autowired
	private JwtUtils utils;
	
	@Autowired
	private UserRepository repo;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		   String authHeader= request.getHeader(HttpHeaders.AUTHORIZATION);
		   String token; String name;
		   if(authHeader==null || !authHeader.startsWith("Bearer")) {
			   filterChain.doFilter(request, response);
			   return ;
		   }
		   token=authHeader.substring(7);
		   name=utils.extractName(token);
		   if(name !=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			   User user= repo.findByEmail(name).get();
			   UsernamePasswordAuthenticationToken authtoken=new UsernamePasswordAuthenticationToken(user,null,null);
			   authtoken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			   SecurityContextHolder.getContext().setAuthentication(authtoken);;
		   }
		
		
		
		
		
		
		
		filterChain.doFilter(request, response);
		
	}

}
