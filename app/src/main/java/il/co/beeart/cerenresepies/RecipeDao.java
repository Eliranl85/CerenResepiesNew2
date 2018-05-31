package il.co.beeart.cerenresepies;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface RecipeDao {

    @Query("SELECT * FROM recipe")
    List<Recipe> getAllRecipes();

    @Insert
    void insertAll(Recipe... recipes);

    @Update
    public void updateRecipe(Recipe... recipes);

    @Delete
    public void deleteRecipes(Recipe... recipes);

    @Query("DELETE FROM recipe")
    void deleteAll();
}
