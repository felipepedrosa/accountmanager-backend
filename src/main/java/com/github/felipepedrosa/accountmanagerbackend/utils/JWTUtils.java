package com.github.felipepedrosa.accountmanagerbackend.utils;

import com.github.felipepedrosa.accountmanagerbackend.security.JWTObject;
import com.github.felipepedrosa.accountmanagerbackend.utils.StringUtilities;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.Date;

/**
 * Utility class for JWT.
 */
public class JWTUtils {
    public static final String KEY = "farofa";
    public static final String PREFIX = "Bearer ";
    public static final long TOKEN_EXPIRATION = 60 * 60 * 7000;
    public static final String HEADER_AUTHORIZATION = "Authorization";

    /**
     * Creates a new JWT.
     *
     * @param subject    Subject of token.
     * @param issuedAt   Creation date for token.
     * @param expiration Expiration date for token.
     * @return {@code String} containing the JWT created.
     */
    public static String createToken(String subject, Date issuedAt, Date expiration) {
        if (StringUtilities.isNullOrEmpty(subject) || issuedAt == null || expiration == null) {
            throw new IllegalArgumentException("Fields must be provided!");
        }

        return PREFIX + Jwts.builder().setSubject(subject)
                .setIssuedAt(issuedAt)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS512, KEY)
                .compact();
    }

    /**
     * Creates a new {@link JWTObject}.
     *
     * @param token JWT to be converted in {@code JWTObject}.
     * @return {@code JWTObject} created.
     */
    public static JWTObject createObject(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(KEY)
                .parseClaimsJws(token.replace(PREFIX, ""))
                .getBody();

        return new JWTObject(claims.getSubject(), claims.getExpiration(), claims.getIssuedAt());
    }
}
