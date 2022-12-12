package com.example.mobileprogrammingproject.view.allGames;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.mobileprogrammingproject.R;
import com.example.mobileprogrammingproject.model.GameModel;
import com.example.mobileprogrammingproject.view.gameDetails.GameDetailActivity;

import java.util.ArrayList;
import java.util.List;

import common.Dataholder;
import common.Utils;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GamesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GamesFragment extends Fragment implements GameClickListener {
    ProgressBar progressBar;
    SearchView searchView;
    RecyclerView rvList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GamesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GamesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GamesFragment newInstance(String param1, String param2) {
        GamesFragment fragment = new GamesFragment();
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
        return inflater.inflate(R.layout.fragment_games, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        initAdapter();
    }

    private void initViews() {
        progressBar = getView().findViewById(R.id.progressBar);
        searchView = getView().findViewById(R.id.searchView);
        rvList = getView().findViewById(R.id.rvList);
    }

    GameAdapter gameAdapter;
    private List<GameModel> gamesList = Utils.dataInit();

    private void initAdapter() {
        gameAdapter = new GameAdapter(getContext(), this);
        gameAdapter.setList(gamesList);
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
        rvList.setAdapter(gameAdapter);
        rvList.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onClickGame(GameModel gameModel) {
        Dataholder.getInstance().selectedGame = gameModel;
        Utils.navigateTo(getActivity(), GameDetailActivity.class);
    }
}