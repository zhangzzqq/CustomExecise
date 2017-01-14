package com.example.zq.test3;

/**
 * Created by stevenzhang on 2017/1/14 0014.
 */

public class sdg {

//    private static TrustManager[]getWrappedTrustManagers(TrustManager[] trustManagers) {
//
//        finalX509TrustManager originalTrustManager = (X509TrustManager) trustManagers[0];
//
//        return newTrustManager[]{
//
//            newX509TrustManager() {
//
//                publicX509Certificate[]getAcceptedIssuers() {
//
//                    returnoriginalTrustManager.getAcceptedIssuers();
//
//                }
//
//                public voidcheckClientTrusted(X509Certificate[] certs, String authType) {
//
//                    try{
//
//                        originalTrustManager.checkClientTrusted(certs, authType);
//
//                    }catch(CertificateException e) {
//
//                        e.printStackTrace();
//
//                    }
//
//                }
//
//                public void checkServerTrusted(X509Certificate[] certs, String authType) {
//
//                    try{
//
//                        originalTrustManager.checkServerTrusted(certs, authType);
//
//                    }catch(CertificateException e) {
//
//                        e.printStackTrace();
//
//                    }
//
//                }
//
//            }
//
//        };
//
//    }

//
//    private static SSLSocketFactory getSSLSocketFactory_Certificate(Context context, String keyStoreType, int keystoreResId)
//
//    throws CertificateException, KeyStoreException, IOException, NoSuchAlgorithmException, KeyManagementException
//
//    {
//
//        CertificateFactory cf = CertificateFactory.getInstance("X.509");
//
//        InputStream caInput = context.getResources().openRawResource(keystoreResId);
//
//        Certificate ca = cf.generateCertificate(caInput);
//
//        caInput.close();
//
//        if(keyStoreType ==null|| keyStoreType.length() ==0) {
//
//            keyStoreType = KeyStore.getDefaultType();
//
//        }
//
//        KeyStore keyStore = KeyStore.getInstance(keyStoreType);
//
//        keyStore.load(null,null);
//
//        keyStore.setCertificateEntry("ca", ca);
//
//        String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
//
//        TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
//
//        tmf.init(keyStore);
//
//        TrustManager[] wrappedTrustManagers =getWrappedTrustManagers(tmf.getTrustManagers());
//
//        SSLContext sslContext = SSLContext.getInstance("TLS");
//
//        sslContext.init(null, wrappedTrustManagers,null);
//
//        return sslContext.getSocketFactory();
//
//    }
}
