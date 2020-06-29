package wawa.developer.saungapung.Activities;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import wawa.developer.saungapung.R;
import wawa.developer.saungapung.adapeter.BaseActivity;

public class SplashAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //if (sesi.isLogin()){
                startActivity(new Intent(c, LoginActivity.class));
                finish();
                //}else
                //startActivity(new Intent(c, MainActivity.class));
                //finish();
            }
        },3000L);
    }
}