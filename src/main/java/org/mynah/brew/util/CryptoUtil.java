package org.mynah.brew.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class CryptoUtil {

    public static final String ALGORITHM_SHA_1 = "SHA-1";
    public static final int INT_0XFF = 0XFF;

    private CryptoUtil() {
    }

    public static String digest(String password, Integer salt) throws NoSuchAlgorithmException {
        return digest(digest(password) + salt);
    }

    public static String digest(String key) throws NoSuchAlgorithmException {
        String digest = null;
        MessageDigest md = MessageDigest.getInstance(ALGORITHM_SHA_1);
        digest = byte2hex(md.digest(key.getBytes()));
        return digest.toLowerCase();
    }

    public static String byte2hex(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b != null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & INT_0XFF);
            if (stmp.length() == 1) {
                hs.append('0');
            }
            hs.append(stmp);
        }
        return hs.toString().toUpperCase();
    }
}
