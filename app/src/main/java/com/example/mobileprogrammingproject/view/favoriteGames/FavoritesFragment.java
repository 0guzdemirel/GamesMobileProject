package com.example.mobileprogrammingproject.view.favoriteGames;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mobileprogrammingproject.R;
import com.example.mobileprogrammingproject.model.GameModel;
import com.example.mobileprogrammingproject.view.allGames.GameAdapter;
import com.example.mobileprogrammingproject.view.allGames.GameClickListener;
import com.example.mobileprogrammingproject.view.gameDetails.GameDetailActivity;

import java.util.ArrayList;
import java.util.List;

import common.Dataholder;
import common.Utils;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FavoritesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavoritesFragment extends Fragment implements GameClickListener {
    ProgressBar progressBar;
    RecyclerView rvList;
    TextView topBarTitle, noFavoriteTV;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FavoritesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FavoritesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FavoritesFragment newInstance(String param1, String param2) {
        FavoritesFragment fragment = new FavoritesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        bindData();
        initAdapter();
    }

    private void initViews() {
        progressBar = getView().findViewById(R.id.progressBar);
        rvList = getView().findViewById(R.id.rvList);
        topBarTitle = getView().findViewById(R.id.topBarTitle);
        noFavoriteTV = getView().findViewById(R.id.noFavoriteTV);
    }

    private void bindData() {
        if (Dataholder.getInstance().favoriteGamesList.size() == 0){
            topBarTitle.setText("Favorites");
            rvList.setVisibility(View.GONE);
            noFavoriteTV.setVisibility(View.VISIBLE);
        }else {
            topBarTitle.setText("Favorites (" + Dataholder.getInstance().favoriteGamesList.size() + ")");
            rvList.setVisibility(View.VISIBLE);
            noFavoriteTV.setVisibility(View.GONE);
        }
    }

    GameAdapter favoritesAdapter;

    private void initAdapter() {
        favoritesAdapter = new GameAdapter(getContext(), this);
        favoritesAdapter.setList(Dataholder.getInstance().favoriteGamesList);
        rvList = getView().findViewById(R.id.rvList);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
            gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
            gridLayoutManager.scrollToPosition(0);
            rvList.setLayoutManager(gridLayoutManager);

        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            linearLayoutManager.scrollToPosition(0);
            rvList.setLayoutManager(linearLayoutManager);
        }
        rvList.setHasFixedSize(true);
        rvList.setAdapter(favoritesAdapter);
        rvList.setItemAnimator(new DefaultItemAnimator());
        //swipe to delete
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(rvList);
    }

    @Override
    public void onClickGame(GameModel gameModel) {
        Dataholder.getInstance().selectedGame = gameModel;
        Utils.navigateTo(getActivity(), GameDetailActivity.class);
    }

    ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case DialogInterface.BUTTON_POSITIVE:
                            //Yes button clicked
                            Dataholder.getInstance().favoriteGamesList.get(viewHolder.getAdapterPosition()).setFavorited(false);
                            Dataholder.getInstance().favoriteGamesList.remove(viewHolder.getAdapterPosition());
                            favoritesAdapter.setList(Dataholder.getInstance().favoriteGamesList);
                            favoritesAdapter.notifyDataSetChanged();
                            bindData();
                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            favoritesAdapter.setList(Dataholder.getInstance().favoriteGamesList);
                            favoritesAdapter.notifyDataSetChanged();
                            break;
                    }
                }
            };
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setMessage("Are you sure that you want to remove this game from your favorites?").setPositiveButton("Yes", dialogClickListener)
                    .setNegativeButton("No", dialogClickListener).show();
        }
    };
}