package il.co.beeart.cerenresepies;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;
//
@Dao
public interface TopicDao {

    @Query("SELECT * FROM  recipetopics")
    List<RecipesTopics> getAllTopics();

    @Insert
    void insertAll(RecipesTopics... recipesTopics);

    @Update
    public void updateRecipe(RecipesTopics... topics);
//
    @Delete
    public void deleteRecipes(RecipesTopics... topics);

    @Query("DELETE FROM recipetopics")
    void deleteAll();
}
