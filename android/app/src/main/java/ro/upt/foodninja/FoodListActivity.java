package ro.upt.foodninja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static ro.upt.foodninja.LoginActivity.IS_LOGGED_IN;
import static ro.upt.foodninja.LoginActivity.LOGIN_PREFERENCES;
import static ro.upt.foodninja.LoginActivity.USERNAME_KEY;

public class FoodListActivity extends AppCompatActivity {
    private RequestQueue mQueue;
    private List<String> mFoodNamesList = new ArrayList<>();
    private EditText mFoodEditText;
    private RecyclerView mRecipesRecyclerView;
    private TextView mUsername;
    private TextView mLogout;

    private static final String FOOD_ENDPOINT = "https://foodapi20200513104945.azurewebsites.net/api/aliments";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        mFoodEditText           = findViewById(R.id.et_list_food_name);
        mRecipesRecyclerView    = findViewById(R.id.recyclerview_food);
        mUsername               = findViewById(R.id.tv_list_username);
        mLogout                 = findViewById(R.id.tv_list_logout);
        mUsername.setText(getUsername());
        getFood();
        updateList(mFoodNamesList);
    }


    @Override
    protected void onResume() {
        super.onResume();
        updateList(mFoodNamesList);
        mFoodEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //all good
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String input = s.toString();

                List<String> findings = new ArrayList<>();

                for(String name : mFoodNamesList){
                    if(name.startsWith(input)){
                        findings.add(name);
                    }
                }
                updateList(findings);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLoggedOut();
                Intent loginIntent = new Intent(FoodListActivity.this, LoginActivity.class);
                startActivity(loginIntent);
                finish();
            }
        });
    }

    private void setLoggedOut() {
        SharedPreferences loginPreferences = getSharedPreferences(LOGIN_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor logineditor = loginPreferences.edit();
        logineditor.putBoolean(IS_LOGGED_IN, false);
        logineditor.putString(USERNAME_KEY, null);

        logineditor.apply();
    }

    private void updateList(List<String> findings) {
        mRecipesRecyclerView.setAdapter(new RVFoodAdapter(this, findings));
        mRecipesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getFood() {
        mQueue = Volley.newRequestQueue(this);

        JsonArrayRequest foodRequest = new JsonArrayRequest(Request.Method.GET, FOOD_ENDPOINT, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i = 0; i < response.length(); i++){
                    try {
                        mFoodNamesList.add((String)response.getJSONObject(i).get("name"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(FoodListActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        mQueue.add(foodRequest);
    }

    private String getUsername() {
        SharedPreferences loginPrefs = getSharedPreferences(LOGIN_PREFERENCES, MODE_PRIVATE);
        return loginPrefs.getString(LoginActivity.USERNAME_KEY, null);
    }
}
