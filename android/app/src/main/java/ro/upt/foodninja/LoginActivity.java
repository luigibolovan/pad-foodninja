package ro.upt.foodninja;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private EditText        mUsername;
    private EditText        mPassword;
    private Button          mLoginBtn;
    private Button          mRegisterBtn;
    private RequestQueue    mQueue;
    private boolean         isValid;

    public  final static String USERNAME_KEY        = "USRNAME_K";
    private final static String USER_ENDPOINT_ROOT  = "https://userapi20200513114529.azurewebsites.net/api/usernames/";
    public  final static String LOGIN_PREFERENCES   = "LOGINPREFERENCES";
    public  final static String IS_LOGGED_IN        = "LOGGED";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsername       = findViewById(R.id.et_user_login_username);
        mPassword       = findViewById(R.id.et_user_login_password);
        mLoginBtn       = findViewById(R.id.btn_login);
        mRegisterBtn    = findViewById(R.id.btn_signup);
        isValid         = false;
    }

    @Override
    protected void onResume() {
        super.onResume();

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                String usernameInput = mUsername.getText().toString();
                String passwordInput = mPassword.getText().toString();
                //add rules for password maybe
                if(userIsValid(usernameInput, passwordInput)){
                    //successfully logged in
                    setLoggedInState(usernameInput);

                    Intent dashboardIntent = new Intent(LoginActivity.this, DashboardActivity.class);
                    dashboardIntent.putExtra(USERNAME_KEY, usernameInput);
                    startActivity(dashboardIntent);
                    finish();
                } else {
                    mUsername.setBackgroundTintList(ColorStateList.valueOf(R.color.colorRed));
                    mPassword.setBackgroundTintList(ColorStateList.valueOf(R.color.colorRed));
                    Toast.makeText(LoginActivity.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //poor man doesn't have an account
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
                finish();
            }
        });
    }

    private void setLoggedInState(String username) {
        SharedPreferences userSharedPreferences = getApplication().getSharedPreferences(LOGIN_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor userSharedPreferencesEditor = userSharedPreferences.edit();

        userSharedPreferencesEditor.putBoolean(IS_LOGGED_IN, true);
        userSharedPreferencesEditor.putString(USERNAME_KEY, username);
        userSharedPreferencesEditor.apply();
    }

    private boolean userIsValid(String usernameInput, final String passwordInput) {
        String usernameEndpoint = USER_ENDPOINT_ROOT + usernameInput;

        mQueue = Volley.newRequestQueue(this);

        JsonObjectRequest myUserRequest = new JsonObjectRequest(Request.Method.GET, usernameEndpoint, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //verify password because there is an user with the entered username
                try {
                    String userPasswordFromDB = response.getString("password");
                    isValid = userPasswordFromDB.equals(passwordInput);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                isValid = false;
            }
        });

        mQueue.add(myUserRequest);

        return isValid;
    }
}
