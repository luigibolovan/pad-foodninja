package ro.upt.foodninja;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVFoodAdapter extends RecyclerView.Adapter<RVFoodAdapter.FoodViewHolder> {

    private List<String> mFoodNames;
    private Context mContext;
    public static final String SELECTED_RECIPE_KEY = "RECIPE_KEY";

    public RVFoodAdapter (Context context, List<String> foodNameList){
        mContext = context;
        mFoodNames = foodNameList;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View holder = inflater.inflate(R.layout.viewholder_food, parent, false);
        return new FoodViewHolder(holder);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, final int position) {
        holder.foodNameTextView.setText(mFoodNames.get(position));

        //set on click listener on this view holder :)
        holder.foodNameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dashboardIntent = new Intent(mContext, RecipeActivity.class);
                dashboardIntent.putExtra(SELECTED_RECIPE_KEY, mFoodNames.get(position));
                mContext.startActivity(dashboardIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFoodNames.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        TextView foodNameTextView;
        RelativeLayout foodNameLayout;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodNameTextView = itemView.findViewById(R.id.tv_recipe_name);
            foodNameLayout = itemView.findViewById(R.id.rl_view_holder_layout);
        }
    }
}
