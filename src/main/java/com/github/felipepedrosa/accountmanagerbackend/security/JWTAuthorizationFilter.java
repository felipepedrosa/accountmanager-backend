package com.github.felipepedrosa.accountmanagerbackend.security;

import com.github.felipepedrosa.accountmanagerbackend.utils.StringUtilities;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class JWTAuthorizationFilter extends OncePerRequestFilter {
    /**
     * {@inheritDoc}
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = request.getHeader(JWTUtils.HEADER_AUTHORIZATION);

        if (!StringUtilities.isNullOrEmpty(token)) {
            UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(
                    JWTUtils.createObject(token).getSubject(), null, List.of());

            SecurityContextHolder.getContext().setAuthentication(userToken);
        } else {
            SecurityContextHolder.clearContext();
        }

        filterChain.doFilter(request, response);
    }
}
