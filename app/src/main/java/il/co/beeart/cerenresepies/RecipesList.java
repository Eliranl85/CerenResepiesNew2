package il.co.beeart.cerenresepies;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecipesList extends Activity{

    RecyclerView recipeRecycler;
    RecipeAdapter adapter;
    List<Recipe> recipeList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipies_list);

        recipeList = new ArrayList<>();
        recipeRecycler = findViewById(R.id.rclRecipe);
        recipeRecycler.setHasFixedSize(true);
        recipeRecycler.setLayoutManager(new LinearLayoutManager(this));

        recipeList.add(new Recipe("שיפודי עוף",
                "מרכיבים:" +
                        "חצי קילו חזה עוף (לא דפוק) חתוך לקוביות" +
                        "שמנמנות ויפות" +
                        "" +
                        "משרה:" +
                        "מיץ מחצי לימון" +
                        "כף רוטב סויה" +
                        "2 כפיות צ`לי מתוק" +
                        "כף שמן זית" +
                        "" +
                        "צלחת א`:" +
                        "2 ביצים טרופות" +
                        "כפית פפריקה" +
                        "א. מרק" +
                        "פלפל שחור גרוס" +
                        "מלח" +
                        "" +
                        "צלחת ב`:" +
                        "פירורי לחם" +
                        "שיפודי עץ" +
                        "" +
                        "הכנות:" +
                        "1. לערבב את מצרכי המשרה להוסיף את החזה עוף ולהשרות כמה שעות." +
                        "" +
                        "2. לערבב ביצים ותבלינים ולטבול את החזה עוף. בצלחת שניה לצפות את החזה עוף בפירורי לחם ולשפד על השיפודים" +
                        "" +
                        "3. לרפד תבנית בנייר אפיה משומן, לסדר את השיפודים להזליף שמן זית על השיפודים, להכניס לתנור שחומם בחום בינוני בסביבות 10 – 15 דקות כל צד או עד שמזהיב, כשהופכים להזליף שמן זית שוב. לשים לב לא ליבש את החזה." +
                        "" +
                        "4. הגשתי עם קטשופ וסלט ירקות."));
        adapter = new RecipeAdapter(this, recipeList);
        recipeRecycler.setAdapter(adapter);

    }
}
