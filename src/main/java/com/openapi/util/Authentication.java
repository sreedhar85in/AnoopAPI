package com.openapi.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


public class Authentication {
    private static final Logger LOGGER = LoggerFactory.getLogger(Authentication.class);

    public final static String EXPIRATION = "exp";
    private static final String SECRET = "declareARandomSaltHereBro:)";

    public static AuthToken decode(String token) throws TokenExpiredException, JWTVerificationException, JWTDecodeException{
        byte[] pass= Base64.decodeBase64(SECRET);

        Algorithm algorithm = Algorithm.HMAC256(pass);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("Somnaware Ltd")
                .build();
        DecodedJWT jwt = verifier.verify(token);
        Map<String, Claim> claimMap = jwt.getClaims();

        LOGGER.info("moduleCode ********  " +claimMap.get("moduleCode").asString());

        return new AuthToken(
                claimMap.get("moduleCode").asString(),
                claimMap.get("traderId").as(Long.class),
                claimMap.get("userName").asString());
    }
}

