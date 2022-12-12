package com.example.mobileprogrammingproject.view.gameDetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mobileprogrammingproject.R;
import com.example.mobileprogrammingproject.model.GameModel;
import com.squareup.picasso.Picasso;

import common.Dataholder;
import common.Utils;

public class GameDetailActivity extends AppCompatActivity {
    RelativeLayout backRL, visitRedditRL, visitWebsiteRL;
    ImageView imageIV;
    TextView nameTV, descriptionTV, addToFavoritesTV, readMoreTV;
    boolean isReadMore = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail);
        initViews();
        setOnClicks();
        bindData();
    }

    private void initViews(){
        backRL = findViewById(R.id.backRL);
        visitRedditRL = findViewById(R.id.visitRedditRL);
        visitWebsiteRL = findViewById(R.id.visitWebsiteRL);
        imageIV = findViewById(R.id.imageIV);
        nameTV = findViewById(R.id.nameTV);
        descriptionTV = findViewById(R.id.descriptionTV);
        addToFavoritesTV = findViewById(R.id.addToFavoritesTV);
        readMoreTV = findViewById(R.id.readMoreTV);
    }

    private void bindData(){
        GameModel item = Dataholder.getInstance().selectedGame;
        nameTV.setText(item.getName());
        descriptionTV.setText(item.getDescription());
        if (!item.getPhotoUrl().isEmpty()){
            Picasso.with(this).load(item.getPhotoUrl()).into(imageIV);
        }
        if (item.isFavorited()){
            addToFavoritesTV.setText("Favorited");
            addToFavoritesTV.setEnabled(false);
        }else{
            addToFavoritesTV.setText("Favorite");
            addToFavoritesTV.setEnabled(true);
        }
    }

    private void setOnClicks(){
        backRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GameDetailActivity.this.onBackPressed();
            }
        });
        visitRedditRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.openWebBrowserIntent(GameDetailActivity.this, Dataholder.getInstance().selectedGame.getRedditUrl());
            }
        });
        visitWebsiteRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.openWebBrowserIntent(GameDetailActivity.this, Dataholder.getInstance().selectedGame.getWebsiteUrl());
            }
        });
        addToFavoritesTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dataholder.getInstance().selectedGame.setFavorited(true);
                Dataholder.getInstance().favoriteGamesList.add(Dataholder.getInstance().selectedGame);
                addToFavoritesTV.setText("Favorited");
                addToFavoritesTV.setEnabled(false);
            }
        });
        readMoreTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isReadMore){
                    isReadMore = true;
                    descriptionTV.setMaxLines(100);
                    readMoreTV.setText("Read Less...");
                }else{
                    isReadMore = false;
                    descriptionTV.setMaxLines(4);
                    readMoreTV.setText("Read More...");
                }
            }
        });
    }
}