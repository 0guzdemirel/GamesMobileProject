package com.example.mobileprogrammingproject.view.allGames;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileprogrammingproject.R;
import com.example.mobileprogrammingproject.model.GameModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import common.Dataholder;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {

    private List<GameModel> items = new ArrayList<>();
    Context context;
    GameClickListener gameClickListener;

    public GameAdapter(Context context, GameClickListener gameClickListener) {
        this.context = context;
        this.gameClickListener = gameClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_item_game, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GameModel item = items.get(position);
        holder.nameTV.setText("" + item.getName());
        holder.scoreTV.setText("" + item.getMetaCritic());
        holder.genreTV.setText("" + item.getGenre());
        if (!item.getPhotoUrl().isEmpty()) {
            Picasso.with(context).load(item.getPhotoUrl()).into(holder.imageIV);
        }
        if (Dataholder.getInstance().isFavoritesFragment) {
            holder.mainRL.setBackgroundColor(context.getResources().getColor(R.color.white));
        } else {
            if (item.isClicked()) {
                holder.mainRL.setBackgroundColor(context.getResources().getColor(R.color.lightGrey));
            } else {
                holder.mainRL.setBackgroundColor(context.getResources().getColor(R.color.white));
            }
        }
        holder.mainRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.setClicked(true);
                gameClickListener.onClickGame(item);
                if (!Dataholder.getInstance().isFavoritesFragment) {
                    holder.mainRL.setBackgroundColor(context.getResources().getColor(R.color.lightGrey));
                }
            }
        });
    }

    public void setList(List<GameModel> list) {
        this.items.clear();
        this.items.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout mainRL;
        TextView nameTV, scoreTV, genreTV;
        ImageView imageIV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mainRL = itemView.findViewById(R.id.mainRL);
            nameTV = itemView.findViewById(R.id.nameTV);
            scoreTV = itemView.findViewById(R.id.scoreTV);
            genreTV = itemView.findViewById(R.id.genreTV);
            imageIV = itemView.findViewById(R.id.imageIV);
        }
    }

}
