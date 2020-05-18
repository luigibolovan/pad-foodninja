package ro.upt.foodninja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class DashboardActivity extends AppCompatActivity {
    private String mUsersAPI = "https://userapi20200513114529.azurewebsites.net/api/users";
    private String mAlimentsAPI = "https://foodapi20200513104945.azurewebsites.net/api/aliments";
    private TextView mUsersTextView;
    private TextView mAliemntsTextView;
    private RequestQueue mQueue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
//
////        mUsersTextView = findViewById(R.id.tv_users);
////        mAliemntsTextView = findViewById(R.id.tv_aliments);
//
//        mQueue = Volley.newRequestQueue(this);
//
//        JsonArrayRequest myUserRequest = new JsonArrayRequest(Request.Method.GET, mUsersAPI, null, new Response.Listener<JSONArray>() {
//
//            @Override
//            public void onResponse(JSONArray response) {
//                mUsersTextView.setText("Users:" + response.toString());
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                mUsersTextView.setText("ERROR");
//            }
//        });
//
//        JsonArrayRequest myAlimentRequest = new JsonArrayRequest(Request.Method.GET, mAlimentsAPI, null, new Response.Listener<JSONArray>() {
//
//            @Override
//            public void onResponse(JSONArray response) {
//                mAliemntsTextView.setText("Aliments:" + response.toString());
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                //nothing
//                mAliemntsTextView.setText("ERROR");
//            }
//        });
//
//        mQueue.add(myUserRequest);
//        mQueue.add(myAlimentRequest);
    }
}
