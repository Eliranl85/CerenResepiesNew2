package il.co.beeart.cerenresepies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipesVieHolder> {

    private Context recipeContext;
    private List<Recipe> recipesList;

    public RecipeAdapter(Context recipeContext, List<Recipe> recipesList) {
        recipeContext = recipeContext;
        this.recipesList = recipesList;
    }


    @NonNull
    @Override
    public RecipesVieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(recipeContext);
        View recipeView = inflater.inflate(R.layout.recipe_list_item, null);
        return new RecipesVieHolder(recipeView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipesVieHolder holder, int position) {

        Recipe recipe = recipesList.get(position);
        holder.lblRecipeName.setText(recipe.getName());
        holder.lblRecipeBody.setText(recipe.getBody());

    }

    @Override
    public int getItemCount() {
        return recipesList.size();
    }

    class RecipesVieHolder extends RecyclerView.ViewHolder{


        TextView lblRecipeName, lblRecipeBody;



        public RecipesVieHolder(View itemView) {
            super(itemView);
        }
    }
}
