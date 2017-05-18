package com.example.zq.test3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

import cn.edu.zafu.bmobdemo.R;
import okhttp3.Call;

/**
 * Created by stevenzhang on 2017/2/21 0021.
 */

public class HttpsTestActivity extends Activity {
    
    /** Called when the activity is first created. */
    
    private TextView text;
    public static final String TAG = "HttpsTestActivity";
    
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        text=(TextView)findViewById(R.id.textView1);
        GetHttps();
    }

    private void GetHttps(){
        
        final String https = "https://meiyaoni.com.cn/index.php/WebService?action=1021&key=111";
        
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try{
//                    SSLContext sc = SSLContext.getInstance("TLS");
//                    sc.init(null, new TrustManager[]{new MyTrustManager()}, new SecureRandom());
//                    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
//                    HttpsURLConnection.setDefaultHostnameVerifier(new MyHostnameVerifier());
//                    HttpsURLConnection conn = (HttpsURLConnection)new URL(https).openConnection();
//                    conn.setDoOutput(true);
//                    conn.setDoInput(true);
//                    conn.connect();
//                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                    final StringBuffer sb = new StringBuffer();
//                    String line;
//                    while ((line = br.readLine()) != null)
//                        sb.append(line);
//                    
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            text.setText(sb.toString());
//                        }
//                    });
//                 
//                }catch(Exception e){
//                    Log.e(TAG, e.toString());
//                }
//            }
//        }).start();


        OkHttpUtils.get().url(https).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                System.out.println("resule=="+e.toString());
            }

            @Override
            public void onResponse(String response, int id) {

//                response.toString();
                System.out.println("resultokhttpszhy=="+response.toString());
            }
        });
        
    }
    

    private class MyHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            // TODO Auto-generated method stub  
            return true;
        }

    }

    private class MyTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
            // TODO Auto-generated method stub    
        }
        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType)

                throws CertificateException {
            // TODO Auto-generated method stub      
        }
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            // TODO Auto-generated method stub  
            return null;
        }

    }
}  
