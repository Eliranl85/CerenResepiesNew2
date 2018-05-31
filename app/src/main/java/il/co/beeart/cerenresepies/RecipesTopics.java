package il.co.beeart.cerenresepies;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "RecipeTopics")
public class RecipesTopics {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "topic name")
    //private List<Recipe> recipes;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RecipesTopics(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
