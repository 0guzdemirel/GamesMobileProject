package common;

import com.example.mobileprogrammingproject.model.GameModel;

import java.util.ArrayList;
import java.util.List;

public class Dataholder {
    private static class InstanceHolder {
        public static Dataholder instance = new Dataholder();
    }
    public static Dataholder getInstance() {
        return InstanceHolder.instance;
    }

    public GameModel selectedGame;
    public List<GameModel> favoriteGamesList = new ArrayList<>();
    public boolean isFavoritesFragment;
}
