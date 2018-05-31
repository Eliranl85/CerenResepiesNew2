package il.co.beeart.cerenresepies;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class MainMenu extends Activity {


    RecyclerView recyclerView;
    Button BtnAddTopic, BtnOk;
    EditText txtAddNewTopic;
    private RecyclerView.LayoutManager layoutManager;
    //String[] topicsNames = {"Deserts", "Bakery", "Main Courses", "Breakfasts", "Salads", "soups"};
    List<RecipesTopics> listData = new ArrayList();
    AppDataBaseTopics db;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_layout);
        BtnAddTopic = findViewById(R.id.BtnAddTopic);
        BtnOk = findViewById(R.id.BtnOk);
        txtAddNewTopic = findViewById(R.id.txtAddTopic);

        db = Room.databaseBuilder(MainMenu.this, AppDataBaseTopics.class, "topics")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        listData = db.topicDao().getAllTopics();

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        final RecyclerView.Adapter adapter = new RecyclerAdapter(listData, this);
        recyclerView.setAdapter(adapter);


        BtnAddTopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtAddNewTopic.setVisibility(View.VISIBLE);
                BtnOk.setVisibility(View.VISIBLE);
            }
        });

        BtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtAddNewTopic.getText().toString().equals("")) {
                    String input = txtAddNewTopic.getText().toString();
                    db.topicDao().insertAll(new RecipesTopics(input.toString()));
                    Toast.makeText(MainMenu.this, "Topic Add", Toast.LENGTH_SHORT).show();
                    adapter.notifyDataSetChanged();
                    txtAddNewTopic.setVisibility(View.INVISIBLE);
                    BtnOk.setVisibility(View.INVISIBLE);
                }
                else
                    Toast.makeText(MainMenu.this, "must write something",
                            Toast.LENGTH_SHORT).show();
            }
        });

    }
}

