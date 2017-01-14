package com.example.zq.utils;

import android.content.Context;
import android.util.Log;

import com.example.zq.App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
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
                    "MIIEpAIBAAKCAQEAztHe28sz+QIz5OrCmXd68fCqBmZMvYNLyI9Ht5YIJXfUMRoP\n" +
                            "RvX1B7t+8rg9DiEaib/Ywl8PjhOeTiFbezGl8Y2g0P8SPYMJOeDdmqChfPucjzRE\n" +
                            "DmW++1P4LTPgh2vQMwy2/kGyllkUwcGCyjkvpZh6co16rcxkleJXBQ1lzfL/GWXT\n" +
                            "2+OajdLyPT6oaCch93nORZmdmAFHJ6Rbb4nBdZYy3Unwoi9bpOzDqYtcKXZfo9Vx\n" +
                            "l0aDsU1e1D34j+WnYvY7zg8lAj1I/YXC+5hibfgVX4auofPAtsXXO1dpTlZtkeHZ\n" +
                            "2t0iKJYP+bAlotXwn2pYR84gsrRb2FLz2A6VXQIDAQABAoIBAQCemk8/WruGj+vf\n" +
                            "9zA4pGnCM/8PXVAoXRG2wjoLTaD9qsEszoE8t82qmlymIiegOD6zuE2v8VpqaB0U\n" +
                            "aXxQIyjQ7v2OiK0iQuTGX+1RcTGmOQY8w6YVLG2jKye88nWTJFjLbUq//P3JUpMa\n" +
                            "ax2zmtsxMJdmVZzovz+7uZFmLHoPzpJg24SxNG1QPeIiFgYkaRQQF4ma/SJYxTsd\n" +
                            "3itFPKEKW+YSEf2jBsvRnxEdpd7W6jzRUqHY4SlpF63T4PJtkIutnJ3NUGrVzmM2\n" +
                            "aOysqO3vmzDIeFSKi7SEbrT2+0D83o6mVj2sTdBSReASZQhHfgvV+d8YHE75MJJb\n" +
                            "73EkueIBAoGBAOnB/qN42ihbVz/IzpCW0HuVXjiutBj2mFgMCKLKsPH2WcUYc6WW\n" +
                            "ng40N9F/ZzwR5eEJ9oHdtbX+N2r6ASgbUulra1VsqcUXzu24WiVBDdE3ErOzC9cR\n" +
                            "y81MXxJCg8nHq2OVxA+hXXb0J1WZsRXuZq6AF9DQ86Ase0oMLf3C/3idAoGBAOJ/\n" +
                            "tID0oUblryl+wcZThHh5AtnNQ1ugZ0terQDoCzI36Ldp/DjydqsSIeL4tOgbrLcP\n" +
                            "4obRMgIKkeNfGR2vBhPtfwtz754MOgyO2vohfMADRUOAE80bOTPzywmGWW9rnNR5\n" +
                            "0yLp4vPKMm1GbjFPfFUKUUASIiepcXWSERxTNRPBAoGBAK4snk+v/N2VMa2VMlUK\n" +
                            "Cs4Kven+QrNXCqyQSt8BqFah+MGjNohrcdmjjvPKumFH9MF5avPY/0xb328WWUZJ\n" +
                            "Fb5XC+La1KTG2KjIdGLN1j3Ni2HaRzg5SmHuReiVJx1yaYIKVcxPsBSyV5ywqAJv\n" +
                            "YJMlXpl5GA6BFlxWNu6eHT0BAoGAcEpVx9UAG/EFHTJdiSCgvUVpN2e/LC7i5wfi\n" +
                            "B2ADJPt44W2nAOicEoXjzO32alhGEV/Ls4EFJOPuneXowsGh5sFIyfnJYva21MEC\n" +
                            "KR3vBhbZAPT/XCFSA8Kq92bm8glM8D4Rge6oeKrWwzw2pzW780ExNO2Ih1dHC73F\n" +
                            "w+AwoUECgYABsFChUkdJdep5h6ICkkjvgBbinFWv8aknOYLprMzxw0Q4DveYIVKp\n" +
                            "MQmgh2pcw7TXgat7rUCqnAQV4/P1X0nk6RkgnVSkno4wiEtX6F5H5r6cKgOxgMmo\n" +
                            "mShs2JsY17diWO9NXdVgFFwlyvOzvKPZUO0R4kgZJ3bIEqLaq0Sg9g==" ;

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
                
                if(authType!=null&&authType.equalsIgnoreCase("RSA")||authType!=null&&authType.equalsIgnoreCase("ECDHE_RSA")){
                    
                }

//                if (!(null != authType && authType.equalsIgnoreCase("RSA"))) {
//                    throw new CertificateException("checkServerTrusted: AuthType is not RSA");
//                }

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


    public static SSLSocketFactory getSSLSocketFactory(Context context, int[] certificates) {

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


    public static SSLSocketFactory getSSLSocketFactoryn() throws Exception {
        //创建一个不验证证书链的证书信任管理器。
        final TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            @Override
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] chain,
                    String authType) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] chain,
                    String authType) throws CertificateException {
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


    //使用自定义SSLSocketFactory
    private void onHttps(OkHttpClient.Builder builder) {
        try {
            builder.sslSocketFactory(getSSLSocketFactory()).hostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void initSSLALL() throws KeyManagementException, NoSuchAlgorithmException, IOException {
//        URL url = new URL("https://certs.cac.washington.edu/CAtest/");
        URL url = new URL("https://github.com");
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, new TrustManager[]{tm}, null);
        HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {

            @Override
            public boolean verify(String arg0, SSLSession arg1) {
                return true;
            }
        });
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setDoInput(true);
        connection.setDoOutput(false);
        connection.setRequestMethod("GET");
        connection.connect();
        InputStream in = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line = "";
        StringBuffer result = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }
        Log.e("TTTT", result.toString());
    }


    TrustManager tm = new X509TrustManager() {
        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
            //do nothing，接受任意客户端证书
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
            //do nothing，接受任意服务端证书
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    };

    
    public static OkHttpClient getUnsafeOkHttpClient() {

        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
                @Override
                public void checkClientTrusted(
                        java.security.cert.X509Certificate[] chain,
                        String authType) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(
                        java.security.cert.X509Certificate[] chain,
                        String authType) throws CertificateException {
                }

                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return new java.security.cert.X509Certificate[0];
                }
            } };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCerts,
                    new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext
                    .getSocketFactory();

            OkHttpClient okHttpClient = new OkHttpClient();
            okHttpClient = okHttpClient.newBuilder()
                    .sslSocketFactory(sslSocketFactory)
                    .hostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER).build();

            return okHttpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    


}
