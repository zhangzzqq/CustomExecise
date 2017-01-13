package com.example.zq.eventdispatch.encrypt;

import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

/**
 * Created by stevenZhang on 2017/1/12.
 */

public class Rsa {
    private static final String RSA_PUBLICE =
            "MIIFlDCCBHygAwIBAgIQaHNM6T6UrKd0EJMfX58D9TANBgkqhkiG9w0BAQsFADCB\n" +
                    "lDELMAkGA1UEBhMCVVMxHTAbBgNVBAoTFFN5bWFudGVjIENvcnBvcmF0aW9uMR8w\n" +
                    "HQYDVQQLExZTeW1hbnRlYyBUcnVzdCBOZXR3b3JrMR0wGwYDVQQLExREb21haW4g\n" +
                    "VmFsaWRhdGVkIFNTTDEmMCQGA1UEAxMdU3ltYW50ZWMgQmFzaWMgRFYgU1NMIENB\n" +
                    "IC0gRzEwHhcNMTcwMTEyMDAwMDAwWhcNMTgwMTEyMjM1OTU5WjAeMRwwGgYDVQQD\n" +
                    "DBN3d3cubWVpeWFvbmkuY29tLmNuMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIB\n" +
                    "CgKCAQEAztHe28sz+QIz5OrCmXd68fCqBmZMvYNLyI9Ht5YIJXfUMRoPRvX1B7t+\n" +
                    "8rg9DiEaib/Ywl8PjhOeTiFbezGl8Y2g0P8SPYMJOeDdmqChfPucjzREDmW++1P4\n" +
                    "LTPgh2vQMwy2/kGyllkUwcGCyjkvpZh6co16rcxkleJXBQ1lzfL/GWXT2+OajdLy\n" +
                    "PT6oaCch93nORZmdmAFHJ6Rbb4nBdZYy3Unwoi9bpOzDqYtcKXZfo9Vxl0aDsU1e\n" +
                    "1D34j+WnYvY7zg8lAj1I/YXC+5hibfgVX4auofPAtsXXO1dpTlZtkeHZ2t0iKJYP\n" +
                    "+bAlotXwn2pYR84gsrRb2FLz2A6VXQIDAQABo4ICVTCCAlEwLwYDVR0RBCgwJoIT\n" +
                    "d3d3Lm1laXlhb25pLmNvbS5jboIPbWVpeWFvbmkuY29tLmNuMAkGA1UdEwQCMAAw\n" +
                    "YQYDVR0gBFowWDBWBgZngQwBAgEwTDAjBggrBgEFBQcCARYXaHR0cHM6Ly9kLnN5\n" +
                    "bWNiLmNvbS9jcHMwJQYIKwYBBQUHAgIwGQwXaHR0cHM6Ly9kLnN5bWNiLmNvbS9y\n" +
                    "cGEwHwYDVR0jBBgwFoAUXGGesHZBqWqqQwvhx24wKW6xzTYwDgYDVR0PAQH/BAQD\n" +
                    "AgWgMB0GA1UdJQQWMBQGCCsGAQUFBwMBBggrBgEFBQcDAjBXBggrBgEFBQcBAQRL\n" +
                    "MEkwHwYIKwYBBQUHMAGGE2h0dHA6Ly9oYy5zeW1jZC5jb20wJgYIKwYBBQUHMAKG\n" +
                    "Gmh0dHA6Ly9oYy5zeW1jYi5jb20vaGMuY3J0MIIBBQYKKwYBBAHWeQIEAgSB9gSB\n" +
                    "8wDxAHcA3esdK3oNT6Ygi4GtgWhwfi6OnQHVXIiNPRHEzbbsvswAAAFZkISIegAA\n" +
                    "BAMASDBGAiEAizv2efMP9vQhZiJFu8DNcVyEGvvFy0N+AOwCYUOaNpkCIQDg9szg\n" +
                    "64JuM5uEkhNIupHOlN/ehKXl+McAtiWS2dFjCQB2AKS5CZC0GFgUh7sTosxncAo8\n" +
                    "NZgE+RvfuON3zQ7IDdwQAAABWZCEiKoAAAQDAEcwRQIgCssMFB6sftfERFl8Yj5Z\n" +
                    "A4vbXre8wY1skNxorL1yyEgCIQDGuzmq9DJu1x0JhyNMjcM1a08VMmX0QOFz9+NI\n" +
                    "jlMKqTANBgkqhkiG9w0BAQsFAAOCAQEAfYifw+m8wumPJwNbYIcusKgTnaPK/lzF\n" +
                    "3VkoWSHBUp5vcMCFEgANzqhVruupk3zHymIJisCW1BPsoBMG5e+x0F4HyHLtlmKK\n" +
                    "BXFQI7hzrOiMzIc9oaflpLBp/5HAnrDqEMuAaCLrxCbWePtfOLXhxxKnp2d6buR0\n" +
                    "KCvsfPL+3qx4NYoJUjgNFgXfm96FDbsMPCTpLUAtJLY+xnSwXP7Z6Is78n7CMBzi\n" +
                    "drKXw5qzrGx2BxrH2VKCgARsF3l7Pky1Sdmipma5DLbgKgOUT/awz/ILklZtXpF4\n" +
                    "H0YR4vz0t9yxkL0XyWWHrJWCPwxaomi4C0sSuDI9lEdkmpBLrrqYbg==";
    private static final String ALGORITHM = "RSA";

    /**
     * 得到公钥
     * @param algorithm
     * @param bysKey
     * @return
     */
    private static PublicKey getPublicKeyFromX509(String algorithm,
                                                  String bysKey) throws NoSuchAlgorithmException, Exception {
        byte[] decodedKey = Base64.decode(bysKey,Base64.DEFAULT);
        X509EncodedKeySpec x509 = new X509EncodedKeySpec(decodedKey);

        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        return keyFactory.generatePublic(x509);
    }

    /**
     * 使用公钥加密
     * @param content
     * @para key
     * @return
     */
    public static String encryptByPublic(String content) {
        try {
            PublicKey pubkey = getPublicKeyFromX509(ALGORITHM, RSA_PUBLICE);

            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, pubkey);

            byte plaintext[] = content.getBytes("UTF-8");
            byte[] output = cipher.doFinal(plaintext);

            String s = new String(Base64.encode(output,Base64.DEFAULT));

            return s;

        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 使用公钥解密
     * @param content 密文
     * @para key 商户私钥
     * @return 解密后的字符串
     */
    public static String decryptByPublic(String content) {
        try {
            PublicKey pubkey = getPublicKeyFromX509(ALGORITHM, RSA_PUBLICE);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, pubkey);
            InputStream ins = new ByteArrayInputStream(Base64.decode(content,Base64.DEFAULT));
            ByteArrayOutputStream writer = new ByteArrayOutputStream();
            byte[] buf = new byte[128];
            int bufl;
            while ((bufl = ins.read(buf)) != -1) {
                byte[] block = null;
                if (buf.length == bufl) {
                    block = buf;
                } else {
                    block = new byte[bufl];
                    for (int i = 0; i < bufl; i++) {
                        block[i] = buf[i];
                    }
                }
                writer.write(cipher.doFinal(block));
            }
            return new String(writer.toByteArray(), "utf-8");
        } catch (Exception e) {
            return null;
        }
    }

}
