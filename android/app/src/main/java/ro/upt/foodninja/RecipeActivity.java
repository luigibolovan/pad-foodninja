package ro.upt.foodninja;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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

import static ro.upt.foodninja.LoginActivity.IS_LOGGED_IN;
import static ro.upt.foodninja.LoginActivity.LOGIN_PREFERENCES;
import static ro.upt.foodninja.LoginActivity.USERNAME_KEY;
import static ro.upt.foodninja.RVFoodAdapter.SELECTED_RECIPE_KEY;

public class RecipeActivity extends AppCompatActivity {
    private Button          mAddButton;
    private RequestQueue    mQueue;

    //dialog
    private EditText recipeNameEditText;
    private EditText recipeCaloriesEditText;
    private EditText recipeProteinEditText;
    private EditText recipeFatEditText;
    private EditText recipeCarbsEditText;
    private EditText mQuantityInGrams;
    private String mRecipeName;

    //recipe
    private int mRecipeCaloriesPer100g;
    private int mRecipeProteinPer100g;
    private int mRecipeFatPer100g;
    private int mRecipeCarbsPer100g;
    private Button mButtonCheckQuantity;
    private TextView mRecipeCaloriesTextView;
    private TextView mRecipeProteinTextView;
    private TextView mRecipeFatTextView;
    private TextView mRecipeCarbsTextView;


    private TextView mLogout;


    private static final String FOOD_ENDPOINT       = "https://foodapi20200513104945.azurewebsites.net/api/aliments";
    private static final String GET_RECIPE_BY_NAME  = "https://foodapi20200513104945.azurewebsites.net/api/alimentbyname/";
    private static final int PER_100_GRAMS          = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        TextView recipeTitleTextView    = findViewById(R.id.title_recipe_name);
        mRecipeName                     = getIntent().getStringExtra(SELECTED_RECIPE_KEY);
        recipeTitleTextView.setText(mRecipeName);

        mLogout                   = findViewById(R.id.tv_recipe_logout);
        TextView loggedInTextView = findViewById(R.id.tv_dashboard_login);
        mAddButton          = findViewById(R.id.btn_dashboard_add);
        mQuantityInGrams    = findViewById(R.id.et_quantity);

        String username = getUsername();
        loggedInTextView.setText(username);

        mRecipeCaloriesTextView = (TextView)findViewById(R.id.tv_recipeCalories);
        mRecipeProteinTextView  = (TextView)findViewById(R.id.tv_protein_value);
        mRecipeFatTextView      = (TextView)findViewById(R.id.tv_fat_value);
        mRecipeCarbsTextView    = (TextView)findViewById(R.id.tv_carbs_value);
        mButtonCheckQuantity    = (Button)findViewById(R.id.btn_add_quantity);

        fetchRecipeData();
    }

    private void setStats(JSONObject response) {
        try {
            mRecipeCaloriesPer100g  = response.getInt("caloriesPer100Gram");
            mRecipeProteinPer100g   = response.getInt("proteinPer100Gram");
            mRecipeFatPer100g       = response.getInt("fatPer100Gram");
            mRecipeCarbsPer100g     = response.getInt("carbohidratesPer100Gram");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        mRecipeCaloriesTextView.setText("" + mRecipeCaloriesPer100g);
        mRecipeProteinTextView.setText("" +mRecipeProteinPer100g);
        mRecipeFatTextView.setText("" + mRecipeFatPer100g);
        mRecipeCarbsTextView.setText("" + mRecipeCarbsPer100g);
    }

    private void fetchRecipeData() {
        mQueue = Volley.newRequestQueue(this);
        String endpoint = GET_RECIPE_BY_NAME + mRecipeName;
        JsonObjectRequest recipeRequest = new JsonObjectRequest(Request.Method.GET, endpoint, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                    setStats(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mRecipeCaloriesTextView.setText(R.string.error);
                mRecipeProteinTextView.setText(R.string.error);
                mRecipeFatTextView.setText(R.string.error);
                mRecipeCarbsTextView.setText(R.string.error);
            }
        });

        mQueue.add(recipeRequest);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflateFormForAddingFood();
            }
        });

        mButtonCheckQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = Integer.parseInt(mQuantityInGrams.getText().toString());
                updateStats(quantity);
            }
        });

        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLoggedOut();
                Intent login = new Intent(RecipeActivity.this, LoginActivity.class);
                startActivity(login);
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

    private void updateStats(int quantity) {
        int recipeCaloriesAmount    = quantity * mRecipeCaloriesPer100g / PER_100_GRAMS;
        int recipeProteinAmount     = quantity * mRecipeProteinPer100g  / PER_100_GRAMS;
        int recipeFatAmount         = quantity * mRecipeFatPer100g      / PER_100_GRAMS;
        int recipeCarbsAmount       = quantity * mRecipeCarbsPer100g    / PER_100_GRAMS;

        mRecipeCaloriesTextView.setText("" + recipeCaloriesAmount);
        mRecipeProteinTextView.setText("" + recipeProteinAmount);
        mRecipeFatTextView.setText("" + recipeFatAmount);
        mRecipeCarbsTextView.setText("" + recipeCarbsAmount);

    }

    private void inflateFormForAddingFood() {
        final AlertDialog formAddFood = new AlertDialog.Builder(RecipeActivity.this).create();
        final View formDialogView = getLayoutInflater().inflate(R.layout.dialog_form_post_food_to_db, null);
        formAddFood.setView(formDialogView);

        recipeNameEditText     = formDialogView.findViewById(R.id.et_form_food_name);
        recipeCaloriesEditText = formDialogView.findViewById(R.id.et_form_calories_per_100g);
        recipeProteinEditText  = formDialogView.findViewById(R.id.et_form_protein_per_100g);
        recipeFatEditText      = formDialogView.findViewById(R.id.et_form_fat_per_100g);
        recipeCarbsEditText    = formDialogView.findViewById(R.id.et_form_carbs_per_100g);
        Button submitReceipeBtn = formDialogView.findViewById(R.id.btn_form_submit_recipe);

        submitReceipeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(recipeOk()){
                    try {
                        formAddFood.dismiss();
                        postToDataBase();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        formAddFood.show();
    }

    private void postToDataBase() throws JSONException {
        mQueue = Volley.newRequestQueue(this);
        JSONObject recipe = new JSONObject();
        recipe.put("name", recipeNameEditText.getText().toString());
        recipe.put("caloriesPer100Gram", Integer.parseInt(recipeCaloriesEditText.getText().toString()));
        recipe.put("proteinPer100Gram", Integer.parseInt(recipeProteinEditText.getText().toString()));
        recipe.put("fatPer100Gram", Integer.parseInt(recipeFatEditText.getText().toString()));
        recipe.put("carbohidratesPer100Gram", Integer.parseInt(recipeCarbsEditText.getText().toString()));

        JsonObjectRequest recipePost = new JsonObjectRequest(Request.Method.POST, FOOD_ENDPOINT, recipe, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(RecipeActivity.this, "Added recipe", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(RecipeActivity.this, R.string.error, Toast.LENGTH_SHORT).show();
            }
        });

        mQueue.add(recipePost);
    }


    private boolean recipeOk() {
        String recipeName       = recipeNameEditText.getText().toString();
        String recipeCalories   = recipeCaloriesEditText.getText().toString();
        String recipeProtein    = recipeProteinEditText.getText().toString();
        String recipeFat        = recipeFatEditText.getText().toString();
        String recipeCarbs      = recipeCarbsEditText.getText().toString();

        TextView recipeNameError        = findViewById(R.id.tv_form_foodname_errormsg);
        TextView recipeCaloriesError    = findViewById(R.id.tv_form_caloriesper100g_errormsg);
        TextView recipeProteinError     = findViewById(R.id.tv_form_proteinper100g_errormsg);
        TextView recipeFatError         = findViewById(R.id.tv_form_fatper100g_errormsg);
        TextView recipeCarbsError       = findViewById(R.id.tv_form_carbsper100g_errormsg);

        if(recipeName.length() < 2){
            recipeNameError.setText("Recipe name length should be greater or equal than 2");
            return false;
        }

        if(recipeCalories.length() == 0){
            recipeCaloriesError.setText("Enter calories");
            return false;
        }

        if(recipeProtein.length() == 0){
            recipeProteinError.setText("Enter protein");
            return false;
        }

        if(recipeFat.length() == 0){
            recipeFatError.setText("Enter fat");
            return false;
        }

        if(recipeCarbs.length() == 0){
            recipeCarbsError.setText("Enter amount of carbs");
            return false;
        }

        return true;
    }

    private String getUsername() {
        SharedPreferences loginPrefs = getSharedPreferences(LoginActivity.LOGIN_PREFERENCES, MODE_PRIVATE);
        return loginPrefs.getString(LoginActivity.USERNAME_KEY, null);
    }
}
