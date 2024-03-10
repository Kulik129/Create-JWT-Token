package org.example;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class SecreteKeyGeneration {
    public static Key generateKey() {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        return key;
    }
}
