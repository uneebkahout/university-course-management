package com.example.ucms.security;

import com.example.ucms.entity.Users;
import com.example.ucms.exception.ResourceNotFoundException;
import com.example.ucms.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private  final UserRepository userRepository;
    private  final AuthUtil authUtil;

    private final HandlerExceptionResolver handlerExceptionResolver;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

          try {

            log.info("Incoming Request :{}" , request.getRequestURI());

            final String  requestTokenHeader = request.getHeader("Authorization");

            if (requestTokenHeader ==null || !requestTokenHeader.startsWith("Bearer")){
                filterChain.doFilter(request ,response);
                return;
            }
        String token = requestTokenHeader.replace("Bearer", "").trim();
            String username=authUtil.getUserNameFromToken(token);
        log.info("TOKEN :{}",token);
            log.info("username ${}", username);

            if (username !=null && SecurityContextHolder.getContext().getAuthentication() ==null){
                Users users = userRepository.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("User Not Found"));
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(users , null , users.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            }
            filterChain.doFilter(request ,response);
          }catch (Exception e){
                    handlerExceptionResolver.resolveException(request ,response , null ,e);

          }
    }

}
