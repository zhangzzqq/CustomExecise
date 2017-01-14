package com.example.zq.test2.utils;

import android.content.Context;

import com.example.zq.App;

import java.io.InputStream;
import java.math.BigInteger;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.interfaces.RSAPublicKey;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import cn.edu.zafu.bmobdemo.R;
import okhttp3.OkHttpClient;

/**
 * Created by stevenZhang on 2017/1/13.
 */

public class SslFactory {


    public static SSLSocketFactory getSSLSocketFactory() throws Exception {
        // Create a trust manager that does not validate certificate chains
        final TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            //证书中的公钥
            public static final String PUB_KEY =
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

            @Override
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] chain,
                    String authType) throws CertificateException {


            }

            //客户端并为对ssl证书的有效性进行校验
            @Override
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] chain,
                    String authType) throws CertificateException {
                if (chain == null) {
                    throw new IllegalArgumentException("checkServerTrusted:x509Certificate array isnull");
                }

                if (!(chain.length > 0)) {
                    throw new IllegalArgumentException("checkServerTrusted: X509Certificate is empty");
                }

                if (!(null != authType && authType.equalsIgnoreCase("RSA"))) {
                    throw new CertificateException("checkServerTrusted: AuthType is not RSA");
                }

                // Perform customary SSL/TLS checks
                try {
                    TrustManagerFactory tmf = TrustManagerFactory.getInstance("X509");
                    tmf.init((KeyStore) null);
                    for (TrustManager trustManager : tmf.getTrustManagers()) {
                        ((X509TrustManager) trustManager).checkServerTrusted(chain, authType);
                    }
                } catch (Exception e) {
                    throw new CertificateException(e);
                }
                // Hack ahead: BigInteger and toString(). We know a DER encoded Public Key begins
                // with 0×30 (ASN.1 SEQUENCE and CONSTRUCTED), so there is no leading 0×00 to drop.
                RSAPublicKey pubkey = (RSAPublicKey) chain[0].getPublicKey();

                String encoded = new BigInteger(1 /* positive */, pubkey.getEncoded()).toString(16);
                // Pin it!
                final boolean expected = PUB_KEY.equalsIgnoreCase(encoded);

                if (!expected) {
                    throw new CertificateException("checkServerTrusted: Expected public key: "
                            + PUB_KEY + ", got public key:" + encoded);
                }

            }


            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[0];
            }
        }};

        // Install the all-trusting trust manager
        final SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustAllCerts,
                new java.security.SecureRandom());
        // Create an ssl socket factory with our all-trusting manager
        return sslContext
                .getSocketFactory();
    }


    /**
     * 证书验证
     */


    protected static SSLSocketFactory getSSLSocketFactory(Context context, int[] certificates) {

        if (context == null) {
            throw new NullPointerException("context == null");
        }

        //CertificateFactory用来证书生成
        CertificateFactory certificateFactory;
        try {
            certificateFactory = CertificateFactory.getInstance("X.509");
            //Create a KeyStore containing our trusted CAs
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);

            for (int i = 0; i < certificates.length; i++) {
                //读取本地证书
                InputStream is = context.getResources().openRawResource(certificates[i]);
                keyStore.setCertificateEntry(String.valueOf(i), certificateFactory.generateCertificate(is));

                if (is != null) {
                    is.close();
                }
            }
            //Create a TrustManager that trusts the CAs in our keyStore
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);

            //Create an SSLContext that uses our TrustManager
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());
            return sslContext.getSocketFactory();

        } catch (Exception e) {

        }
        return null;
    }


    //用自定义TrustManager代替系统默认的信任管理器

    private void onHttpCertficates(OkHttpClient.Builder builder) {
        int[] certficates = new int[]{R.raw.service};
        builder.socketFactory(getSSLSocketFactory(App.getContext(), certficates));
    }




}
