package com.example.admin.dialogtest.custom3;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;

import com.example.admin.dialogtest.R;

public class SampleActivity extends Activity implements View.OnClickListener {

    private int i = -1;
        
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_activity);
        findViewById(R.id.progress_dialog).setOnClickListener(this);
    }
        
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            
            case R.id.progress_dialog:
                final SweetAlertDialog pDialog = new SweetAlertDialog(this)
                        .setTitleText("Loading");
                pDialog.show();
                pDialog.setCancelable(false);
                new CountDownTimer(800 * 7, 800) {
                    public void onTick(long millisUntilFinished) {
                        // you can change the progress bar color by ProgressHelper every 800 millis
                        i++;
                        switch (i){
                            case 0:
                                pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.blue_btn_bg_color));
                                break;
                            case 1:
                                pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.material_deep_teal_50));
                                break;
                            case 2:
                                pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.success_stroke_color));
                                break;
                            case 3:
                                pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.material_deep_teal_20));
                                break;
                            case 4:
                                pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.material_blue_grey_80));
                                break;
                            case 5:
                                pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.warning_stroke_color));
                                break;
                            case 6:
                                pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.success_stroke_color));
                                break;
                        }
                    }

                    public void onFinish() {
                        pDialog.dismiss();
//                        i = -1;
//                        pDialog.setTitleText("Success!")
//                                .setConfirmText("OK")
//                                .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                    }
                }.start();
                break;
        }
    }
}
