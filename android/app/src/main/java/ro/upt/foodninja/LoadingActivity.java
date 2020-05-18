package ro.upt.foodninja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class LoadingActivity extends AppCompatActivity {
    private final static int FAKE_LOADING_TIME_VALUE    = 5000;
    private CountDownTimer mDummyLoadingTimer           = new CountDownTimer(FAKE_LOADING_TIME_VALUE, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            //nada
        }

        @Override
        public void onFinish() {
            Intent nextActivityIntent = new Intent(LoadingActivity.this, DashboardActivity.class);
            startActivity(nextActivityIntent);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        mDummyLoadingTimer.start();
    }
}
