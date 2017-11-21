package com.accenture.tudorckalisch.cardealership;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class StartActivity extends AppCompatActivity {
    public static final String TAG = StartActivity.class.getSimpleName();
    private Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.fragment_mail);
        handler = new Handler();

//        try{
//            Log.d(TAG, "onCreate: Waiting 3 sec");
//            synchronized (this){
//                this.wait(3000);
//                Intent intent = new Intent(this,MainActivity.class);
//                Log.d(TAG, "onCreate: Start MainActivity");
//                startActivity(intent);
//            }
//        } catch (InterruptedException e){
//            Log.d(TAG, "onCreate: "+ e.toString());
//        }
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(StartActivity.this, MainActivity.class);
//                Log.d(TAG, "onCreate: Start MainActivity");
//                startActivity(intent);
//                finish();
//            }
//        }, 3000);
//
//    }
}
