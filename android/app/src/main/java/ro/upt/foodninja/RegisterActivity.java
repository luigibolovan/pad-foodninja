package ro.upt.foodninja;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    private EditText        mUsername;
    private EditText        mPassword;
    private EditText        mUserHeight;
    private EditText        mUserWeight;
    private EditText        mUserAge;
    private CheckBox        mMale;
    private CheckBox        mFemale;
    private Button          mRegisterBtn;
    private RequestQueue    mQueue;

    private static final String API_POST_ENDPOINT = "https://userapi20200513114529.azurewebsites.net/api/users";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mUsername       = findViewById(R.id.et_user_register_username);
        mPassword       = findViewById(R.id.et_user_register_password);
        mUserHeight     = findViewById(R.id.et_user_height);
        mUserWeight     = findViewById(R.id.et_user_weight);
        mUserAge        = findViewById(R.id.et_user_age);
        mMale           = findViewById(R.id.checkbox_male);
        mFemale         = findViewById(R.id.checkbox_female);
        mRegisterBtn    = findViewById(R.id.btn_register);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if(areInputsOk()) {
                    try {
                        addUser();
                        Toast.makeText(RegisterActivity.this, "Added user", Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private boolean areInputsOk() {
        TextView usernameErrTextView    = findViewById(R.id.tv_register_username_errormsg);
        TextView passwordErrTextView    = findViewById(R.id.tv_register_password_errormsg);
        TextView heightErrTextView      = findViewById(R.id.tv_register_height_errormsg);
        TextView weightErrTextView      = findViewById(R.id.tv_register_weight_errormsg);
        TextView ageErrTextView         = findViewById(R.id.tv_register_age_errormsg);
        TextView genderErrTextView      = findViewById(R.id.tv_register_gender_errormsg);

        String usernameInput    = mUsername.getText().toString();
        String passwordInput    = mPassword.getText().toString();
        String heightInput      = mUserHeight.getText().toString();
        String weightInput      = mUserWeight.getText().toString();
        String ageInput         = mUserAge.getText().toString();
        boolean isMaleChecked   = mMale.isChecked();
        boolean isFemaleChecked = mFemale.isChecked();

        if(usernameInput.length() < 3){
            usernameErrTextView.setText("Username should be at least 3 characters long");
            return false;
        }
        if(passwordInput.length() < 6){
            passwordErrTextView.setText("Password should be at least 6 characters long");
            return false;
        }


        if(heightInput.length() < 2 || heightInput.length() > 3){
            heightErrTextView.setText("Invalid height");
            return false;
        }

        if(weightInput.length() < 2 || weightInput.length() > 3){
            weightErrTextView.setText("Invalid weight");
            return false;
        }


        if(Integer.parseInt(ageInput) < 18){
            ageErrTextView.setText("You should be over 18 to have an account");
            return false;
        }

        if(Integer.parseInt(ageInput) > 90){
            ageErrTextView.setText("We doubt you're this old");
            return false;
        }

        if(!isMaleChecked && !isFemaleChecked){
            genderErrTextView.setText("Please select a gender");
            return false;
        }

        return true;
    }

    private void addUser() throws JSONException {
        mQueue = Volley.newRequestQueue(this);
        JSONObject userDetails = new JSONObject();
        userDetails.put("userName", mUsername.getText().toString());
        userDetails.put("password", mPassword.getText().toString());
        userDetails.put("height", Integer.parseInt(mUserHeight.getText().toString()));
        userDetails.put("weight", Integer.parseInt(mUserWeight.getText().toString()));
        userDetails.put("age", Integer.parseInt(mUserAge.getText().toString()));
        int gender = (mMale.isChecked()) ? 0 : 1;
        userDetails.put("gender", gender);
        
        JsonObjectRequest addUserRequest = new JsonObjectRequest(Request.Method.POST, API_POST_ENDPOINT, userDetails, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(RegisterActivity.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                Intent loginActivity = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(loginActivity);
                finish();
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RegisterActivity.this, "Error occurred when posting user", Toast.LENGTH_SHORT).show();
            }
        });
        mQueue.add(addUserRequest);
    }
}
