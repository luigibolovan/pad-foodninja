package ro.upt.foodninja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;

import static ro.upt.foodninja.LoginActivity.IS_LOGGED_IN;
import static ro.upt.foodninja.LoginActivity.LOGIN_PREFERENCES;

public class LoadingActivity extends AppCompatActivity {
    private final static int FAKE_LOADING_TIME_VALUE    = 5000;
    private CountDownTimer mDummyLoadingTimer           = new CountDownTimer(FAKE_LOADING_TIME_VALUE, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            //nada
        }

        @Override
        public void onFinish() {

            Intent nextActivityIntent;
            if(isAuthenticated()){
                nextActivityIntent= new Intent(LoadingActivity.this, FoodListActivity.class);
            }else{
                nextActivityIntent = new Intent(LoadingActivity.this, LoginActivity.class);
            }
            startActivity(nextActivityIntent);
            finish();
        }
    };

    private boolean isAuthenticated() {
        SharedPreferences loginPreferences = getSharedPreferences(LOGIN_PREFERENCES, MODE_PRIVATE);
        return loginPreferences.getBoolean(IS_LOGGED_IN, false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        mDummyLoadingTimer.start();
    }
}
