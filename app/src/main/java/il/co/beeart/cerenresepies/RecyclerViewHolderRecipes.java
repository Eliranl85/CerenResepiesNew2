package il.co.beeart.cerenresepies;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewHolderRecipes extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{
    private LinearLayout item;
    private static final String TAG = "RecyclerViewHolder";
    public TextView txt_descriptionName,txt_descriptionPhone;
    public ItemClickListener itemClickListener;

    public RecyclerViewHolderRecipes(View itemView) {
        super(itemView);
        item = itemView.findViewById(R.id.lstTopics);
        txt_descriptionName = itemView.findViewById(R.id.txt_description_name);

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.OnClick(v,getAdapterPosition(),false);
        Log.d(TAG,"ONCLICK:WORK!!!");
    }

    @Override
    public boolean onLongClick(View v) {
        itemClickListener.OnClick(v,getAdapterPosition(),true);
        return true;
    }
}
//Todo Adapter for tournament -------------------------------------------------------------!!!
class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolderRecipes>  {
    private final static String TAG = null;
    private List<RecipesTopics> listData = new ArrayList();
    private Context context;




    public RecyclerAdapter(List<RecipesTopics> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolderRecipes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.text_name_of_recycler_topics,parent,false);
        return new RecyclerViewHolderRecipes(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolderRecipes holder, int position) {
        holder.txt_descriptionName.setText(listData.get(position).getName());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void OnClick(View view, int position, boolean isLongClick) {
                String inputName = listData.get(position).getName();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    {

    }

    ///////////////////////////////////////////////////////////////////


}