package il.co.beeart.cerenresepies;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.view.View;

@Entity(tableName = "Recipe")
public class Recipe {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name="recipe name")
    private String name;
    @ColumnInfo(name = "recipe body")
    private String body;
   /* @ColumnInfo(name = "recipe image")
    int recipeImage;*/

    public Recipe(String name, String body) {
        this.name = name;
        this.body = body;
        //this.recipeImage = recipeImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*
    public int getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(int recipeImage) {
        this.recipeImage = recipeImage;
    }*/

}
