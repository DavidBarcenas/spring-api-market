package com.apimarket.web.security.filter;

import com.apimarket.domain.service.MarketUserDetailService;
import com.apimarket.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilterRequest extends OncePerRequestFilter {
    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private MarketUserDetailService marketUserDetailService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer")) {
           String token = authorizationHeader.substring(7);
           String username = jwtUtil.extractUsername(token);

           if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
               UserDetails userDetails =  marketUserDetailService.loadUserByUsername(username);

               if (jwtUtil.validateToken(token, userDetails)) {
                   UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                           userDetails,
                           null, userDetails.
                           getAuthorities()
                   );
                   authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                   SecurityContextHolder.getContext().setAuthentication(authToken);
               }
           }
        }

        filterChain.doFilter(request, response);
    }
}
