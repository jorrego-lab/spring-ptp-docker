package com.gvscolombia.placetopay.utils;

import com.gvscolombia.placetopay.models.Autenticacion;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Locale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuthUtils {

    @Value("${propiedades.placetopay.login}")
    private String login;

    @Value("${propiedades.placetopay.trankey}")
    private String trankey;

    public Autenticacion generarAutenticacion() {

        String nonce = getNonce();
        String seed = getSeed();
        String nonceBase64 = Base64.getEncoder().encodeToString(nonce.getBytes());

        return Autenticacion
                .builder()
                .login(login)
                .tranKey(generarTrankey(nonce, seed, trankey))
                .seed(seed)
                .nonce(nonceBase64)
                .build();
    }


    private String getNonce() {
        return new BigInteger(130, new SecureRandom()).toString(16);
    }

    private String getSeed() {
        return (new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ", Locale.getDefault())).format(new Date());
    }

    private String generarTrankey(String nonce, String seed, String trankey) {

        try {
            MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
            byte[] digest = mDigest.digest((nonce+seed+trankey).getBytes(StandardCharsets.UTF_8));
            byte[] encodedBytes = (Base64.getEncoder()).encode(digest);
            return new String(encodedBytes);
        } catch (Exception ex) {
            log.error("Error: {}", ex);
        }
        return null;
    }
}
