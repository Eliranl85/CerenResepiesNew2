package il.co.beeart.cerenresepies;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {RecipesTopics.class}, version=1,exportSchema = true)
public abstract class AppDataBaseTopics extends RoomDatabase {
    public abstract TopicDao topicDao();
}