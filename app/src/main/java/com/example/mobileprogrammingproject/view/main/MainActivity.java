package com.example.mobileprogrammingproject.view.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.mobileprogrammingproject.R;
import com.example.mobileprogrammingproject.view.allGames.GamesFragment;
import com.example.mobileprogrammingproject.view.favoriteGames.FavoritesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import common.Dataholder;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    GamesFragment gamesFragment = new GamesFragment();
    FavoritesFragment favoritesFragment = new FavoritesFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        bottomNavigationView = findViewById(R.id.bottomNavView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.games);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.games:
                Dataholder.getInstance().isFavoritesFragment = false;
                getSupportFragmentManager().beginTransaction().replace(R.id.containerL, gamesFragment).commit();
                return true;

            case R.id.favorites:
                Dataholder.getInstance().isFavoritesFragment = true;
                getSupportFragmentManager().beginTransaction().replace(R.id.containerL, favoritesFragment).commit();
                return true;
        }
        return false;
    }
}