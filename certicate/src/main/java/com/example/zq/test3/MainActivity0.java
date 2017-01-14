package com.example.zq.test3;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import cn.edu.zafu.bmobdemo.R;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by stevenzhang on 2017/1/14 0014.
 */

public class MainActivity0 extends Activity implements View.OnClickListener {


    private OkHttpClient client;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_test2);
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);

//        RequestBody formBody = new FormEncodingBuilder()
//                .add("","")
//                .build();
        
    }

   private String postrun(String url) throws IOException {
       
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            Log.v("MainActivity3","==="+response.body().string());
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            
            case R.id.btn2:
//                client = new OkHttpClient();
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            postrun("https://kyfw.12306.cn/otn/");
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }).start();
                getRequest();
                break;
            
            
        }
    }

//    javax.net.ssl.SSLHandshakeException: 
// java.security.cert.CertPathValidatorException: 
// Trust anchor for certification path not found.
    private void getRequest() {
//        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
//        .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
        
        
        final Request request=new Request.Builder()
                .get()
                .tag(this)
                .url("https://kyfw.12306.cn/otn/")
        
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Response response = null;
                try {
                   client = new OkHttpClient();
                    response = client.newCall(request)
                            .execute();
                    if (response.isSuccessful()) {
                        Log.i("WY","打印GET响应的数据：" + response.body().string());
                    } else {
                        throw new IOException("Unexpected code " + response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


////    private void postRequest() {
////
////        RequestBody formBody = new FormEncodingBuilder()
////                .add("","")
////                .build();
////
////        final Request request = new Request.Builder()
////                .url("http://www.wooyun.org")
////                .post(formBody)
////                .build();
////
////        new Thread(new Runnable() {
////            @Override
////            public void run() {
////                Response response = null;
////                try {
////                    response = client.newCall(request).execute();
////                    if (response.isSuccessful()) {
////                        Log.i("WY","打印POST响应的数据：" + response.body().string());
////                    } else {
////                        throw new IOException("Unexpected code " + response);
////                    }
////                } catch (IOException e) {
////                    e.printStackTrace();
////                }
////            }
////        }).start();
////
////    }
//
//
//    public void ignoreCard(OkHttpClient client) {
//
//        SSLContext sslContext = null;
//        try {
//            sslContext = SSLContext.getInstance("TLS");
//            sslContext.init
//                    (
//                            null,
//                            new TrustManager[]{new AllX509TrustManager()},
//                            new SecureRandom()
//                    );
//            client.setSslSocketFactory(sslContext.getSocketFactory());
//            client.setHostnameVerifier(new HostnameVerifier() {
//                @Override
//                public boolean verify(String s, SSLSession sslSession) {
//                    return true;
//                }
//            });
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (KeyManagementException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public void setCard(OkHttpClient client, InputStream certificate) {
//        try {
//            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
//            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
//            keyStore.load(null);
//            String certificateAlias = Integer.toString(0);
//            keyStore.setCertificateEntry(certificateAlias, certificateFactory.generateCertificate(certificate));
//            SSLContext sslContext = SSLContext.getInstance("TLS");
//            final TrustManagerFactory trustManagerFactory =
//                    TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//            trustManagerFactory.init(keyStore);
//            sslContext.init
//                    (
//                            null,
//                            trustManagerFactory.getTrustManagers(),
//                            new SecureRandom()
//                    );
//            client.setSslSocketFactory(sslContext.getSocketFactory());
//            client.setHostnameVerifier(new HostnameVerifier() {
//                @Override
//                public boolean verify(String s, SSLSession sslSession) {
//                    return true;
//                }
//            });
//        } catch (CertificateException e) {
//            e.printStackTrace();
//        } catch (KeyStoreException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (KeyManagementException e) {
//            e.printStackTrace();
//        }
//    }
}
