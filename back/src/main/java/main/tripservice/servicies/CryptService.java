package main.tripservice.servicies;

import main.tripservice.exception.EncryptException;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Service
public class CryptService {

    public byte[] encryption(String data) {
        String key = "-----BEGIN RSA PUBLIC KEY-----\n" +
                "MIIBojANBgkqhkiG9w0BAQEFAAOCAY8AMIIBigKCAYEAsLRuFOnrtPU81TkI6TltbKkLmcbJ0qTmD/zmbx7Cj1rKK1x7+PVa8uLT+XgJ4cqCV8Z7Hy/rXqWpARSdVzNZaXNleCtz0fgdu7GYGJNPFja0EB6OsnJIaOYKuWaNSZpQsjtd0FxrLzSUOAJofCGopzxOc9NtBg9b2H51n8NpTzYzQ3m6PuW/D0Yj6UacgS/XhqcivbFFpFirdeDOm37e7D6sq8pUZTlPUFUIZt+ZbtknzNee6FhK/xIVFOLeo4GxSo0w0BTU+A9+JY2dlLM26WiJaa4b2LV9l7SQRE2fMn3HjyQxIvbbCC6JPTTOFIj9WIZ/+NQPTEkfdT2qxvbAvYkYUvxwbdOohigcOT66BrgMH4ESAgtY8Cx9VKHWRKHL0R2pIMaadcSCFtLWreh7avi+8VVZTVIy8tyU4c17xGx60XnC5BkS6kHYvkxCEPpQ/A7HzC1XFRpg6grq/k6hhkfSBL9tgDfO67SbWv/uUQq2ByQRPqL+oxAtmZbLfZGtAgMBAAE=\n" +
                "-----END RSA PUBLIC KEY-----\n";


        String keypemPublic = key
                .replace("-----BEGIN RSA PUBLIC KEY-----", "")
                .replaceAll("\n", "")
                .replace("-----END RSA PUBLIC KEY-----", "");


        try {
            byte[] encoded = Base64.getDecoder().decode(keypemPublic);

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keySpec1 = new X509EncodedKeySpec(encoded);

            Key publicKey = (Key) keyFactory.generatePublic(keySpec1);

            Cipher encryptCipher = Cipher.getInstance("RSA");
            encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);

            byte[] secretMessageBytes = data.getBytes(StandardCharsets.UTF_8);
            byte[] encryptedMessageBytes = encryptCipher.doFinal(secretMessageBytes);

            return encryptedMessageBytes;
        }catch (Exception e){
            throw new EncryptException("Encryption of data failed");
        }

    }

    public String decryption(byte[] data) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String key = "-----BEGIN RSA PRIVATE KEY-----\n" +
                "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\n" +
                "-----END RSA PRIVATE KEY-----\n";


        String keypemPrivate = key
                .replace("-----BEGIN RSA PRIVATE KEY-----", "")
                .replaceAll("\n", "")
                .replace("-----END RSA PRIVATE KEY-----", "");

        try {
            byte[] encoded = Base64.getDecoder().decode(keypemPrivate);

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);

            Key privateKey = (Key) keyFactory.generatePrivate(keySpec);

            Cipher decryptCipher = Cipher.getInstance("RSA");
            decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);

            byte[] decryptedMessageBytes = decryptCipher.doFinal(data);
            String decryptedMessage = new String(decryptedMessageBytes, StandardCharsets.UTF_8);

            return decryptedMessage;
        }catch (Exception e){
            throw new EncryptException("Decryption of data failed");
        }

    }

}
