package common;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.example.mobileprogrammingproject.model.GameModel;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static void navigateTo(Context context, Class<?> activity) {
        Intent intent = new Intent(context, activity);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void openWebBrowserIntent(Activity context, String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setPackage("com.android.chrome");
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            intent.setPackage(null);
            context.startActivity(intent);
        }
    }

    public static List<GameModel> dataInit() {
        List<GameModel> gamesList = new ArrayList<>();
        gamesList.add(new GameModel(
                3498,
                "Grand Theft Auto 5",
                "https://media.rawg.io/media/games/456/456dea5e1c7e3cd07060c14e96612001.jpg",
                95,
                "Action",
                "Rockstar Games went bigger, since their previous installment of the series. You get the complicated and realistic world-building from Liberty City of GTA4 in the setting of lively and diverse Los Santos, from an old fan favorite GTA San Andreas. 561 different vehicles (including every transport you can operate) and the amount is rising with every update. Simultaneous storytelling from three unique perspectives: Follow Michael, ex-criminal living his life of leisure away from the past, Franklin, a kid that seeks the better future, and Trevor, the exact past Michael is trying to run away from. GTA Online will provide a lot of additional challenge even for the experienced players, coming fresh from the story mode. Now you will have other players around that can help you just as likely as ruin your mission. Every GTA mechanic up to date can be experienced by players through the unique customizable character, and community content paired with the leveling system tends to keep everyone busy and engaged.",
                "https://www.reddit.com/r/GrandTheftAutoV/",
                "http://www.rockstargames.com/V/"));
        gamesList.add(new GameModel(
                3328,
                "Witcher 3",
                "https://media.rawg.io/media/games/618/618c2031a07bbff6b4f611f10b6bcdbc.jpg",
                98,
                "Action, Drama",
                "The third game in a series, it holds nothing back from the player. Open world adventures of the renowned monster slayer Geralt of Rivia are now even on a larger scale. Following the source material more accurately, this time Geralt is trying to find the child of the prophecy, Ciri while making a quick coin from various contracts on the side. Great attention to the world building above all creates an immersive story, where your decisions will shape the world around you. CD Project Red are infamous for the amount of work they put into their games, and it shows, because aside from classic third-person action RPG base game they provided 2 massive DLCs with unique questlines and 16 smaller DLCs, containing extra quests and items. Players praise the game for its atmosphere and a wide open world that finds the balance between fantasy elements and realistic and believable mechanics, and the game deserved numerous awards for every aspect of the game, from music to direction.",
                "https://www.reddit.com/r/thewitcher3/",
                "https://thewitcher.com/en/witcher3"));
        gamesList.add(new GameModel(
                4200,
                "Portal 2",
                "https://media.rawg.io/media/games/328/3283617cb7d75d67257fc58339188742.jpg",
                91,
                "Puzzle",
                "Portal 2 is a first-person puzzle game developed by Valve Corporation and released on April 19, 2011 on Steam, PS3 and Xbox 360. It was published by Valve Corporation in digital form and by Electronic Arts in physical form. Its plot directly follows the first game's, taking place in the Half-Life universe. You play as Chell, a test subject in a research facility formerly ran by the company Aperture Science, but taken over by an evil AI that turned upon its creators, GladOS. After defeating GladOS at the end of the first game but failing to escape the facility, Chell is woken up from a stasis chamber by an AI personality core, Wheatley, as the unkempt complex is falling apart. As the two attempt to navigate through the ruins and escape, they stumble upon GladOS, and accidentally re-activate her... Portal 2's core mechanics are very similar to the first game's ; the player must make their way through several test chambers which involve puzzles. For this purpose, they possess a Portal Gun, a weapon capable of creating teleportation portals on white surfaces. This seemingly simple mechanic and its subtleties coupled with the many different puzzle elements that can appear in puzzles allows the game to be easy to start playing, yet still feature profound gameplay. The sequel adds several new puzzle elements, such as gel that can render surfaces bouncy or allow you to accelerate when running on them. The game is often praised for its gameplay, its memorable dialogue and writing and its aesthetic. Both games in the series are responsible for inspiring most puzzle games succeeding them, particularly first-person puzzle games. The series, its characters and even its items such as the portal gun and the companion cube have become a cultural icon within gaming communities. Portal 2 also features a co-op mode where two players take on the roles of robots being led through tests by GladOS, as well as an in-depth level editor.",
                "https://www.reddit.com/r/Portal/",
                "http://www.thinkwithportals.com/"));
        gamesList.add(new GameModel(
                5286,
                "Tomb Raider (2013)",
                "https://media.rawg.io/media/games/021/021c4e21a1824d2526f925eff6324653.jpg",
                89,
                "Action RPG",
                "A cinematic revival of the series in its action third person form, Tomb Rider follows Lara in her least experience period of life – her youth. Heavily influenced by Naughty Dog’s “Uncharted”, the game is a mix of everything, from stealth and survival to combat and QTE action scenes. Young Lara Croft arrives on the Yamatai, lost island near Japan, as the leader of the expedition in search of the Yamatai Kingdom, with a diverse team of specialists. But shipwreck postponed the successful arrival and seemingly forgotten island is heavily populated with hostile inhabitants, cultists of Solarii Brotherhood. The game will be graphic at times, especially after failed QTE’s during some of the survival scenes, but overall players will enjoy classic action adventure, reminiscent of the beginning of the series. This game is not a direct sequel or continuation of existing sub-series within the franchise, but a reboot, setting up Tomb Raider to represent modern gaming experience. The game has RPG elements and has a world, which you can explore during the story campaign and after the completion. As well as multiplayer mode, where 2 teams (4 scavengers and 4 survivors) are clashing in 3 game modes while using weapons and environments from the single-player campaign.",
                "https://www.reddit.com/r/TombRaider/",
                "http://www.tombraider.com"));
        gamesList.add(new GameModel(
                4291,
                "Counter-Strike: Global Offensive",
                "https://media.rawg.io/media/games/736/73619bd336c894d6941d926bfd563946.jpg",
                96, "Competitive, Online",
                "Counter-Strike is a multiplayer phenomenon in its simplicity. No complicated narratives to explain the source of the conflict, no futuristic and alien threats, but counter-terrorists against terrorists. Arena shooter at its core, CS:GO provides you with various methods of disposing enemies and reliant on cooperation within the team. During the round of the classical clash mode, you will gradually receive currency to purchase different equipment. Each player can carry a primary weapon, secondary pistol, knife and a set of grenades, which all can change the battle if wielded by the skilled player. Objectives are clear and vary from map to map, from game mode to game mode. Stop the terrorists from planting explosives, stop the counter-terrorist from retrieving the hostages, kill everyone who isn’t you and just perform the best with. CS:GO is one of the major cybersport discipline, which makes playing it more exciting to some players. Aside from purchasing the game, CS:GO is infamous for its loot case system, that requires players to purchase keys, in order to open said cases. Customization items consist of weapon skins, weapon stickers, and sprays that do not affect gameplay and have purely visual value to the player.",
                "https://www.reddit.com/r/GlobalOffensive/",
                "http://blog.counter-strike.net/"));
        gamesList.add(new GameModel(
                5679,
                "The Elder Scrolls V: Skyrim",
                "https://media.rawg.io/media/games/7cf/7cfc9220b401b7a300e409e539c9afd5.jpg",
                88,
                "RPG",
                "The fifth game in the series, Skyrim takes us on a journey through the coldest region of Cyrodiil. Once again player can traverse the open world RPG armed with various medieval weapons and magic, to become a hero of Nordic legends –Dovahkiin, the Dragonborn. After mandatory character creation players will have to escape not only imprisonment but a fire-breathing dragon. Something Skyrim hasn’t seen in centuries. After Oblivion, the magic system was reworked, in order to show players more aggressive and direct combat. As a Dragonborn, your character will be able to use the powerful magic of dragon shouts, powered, upgraded and researched with the souls of the dragons that will be randomly encountered by players, while traveling. Hundreds of sidequests will invite players to discover every part of the newly introduced land. Aside from already filled with guilds, Daedra and steampunk Dwemer ruins, Skyrim has additional DLC content that not only brings Solstheim island and vampire conclave but gives players the ability to build their own homes, instead of buying pre-made ones.",
                "https://www.reddit.com/r/skyrim/",
                "http://elderscrolls.com/"));
        gamesList.add(new GameModel(
                28,
                "Red Dead Redemption 2",
                "https://media.rawg.io/media/games/511/5118aff5091cb3efec399c808f8c598f.jpg",
                95,
                "RPG, Story",
                "America, 1899. The end of the wild west era has begun as lawmen hunt down the last remaining outlaw gangs. Those who will not surrender or succumb are killed. After a robbery goes badly wrong in the western town of Blackwater, Arthur Morgan and the Van der Linde gang are forced to flee. With federal agents and the best bounty hunters in the nation massing on their heels, the gang must rob, steal and fight their way across the rugged heartland of America in order to survive. As deepening internal divisions threaten to tear the gang apart, Arthur must make a choice between his own ideals and loyalty to the gang who raised him. From the creators of Grand Theft Auto V and Red Dead Redemption, Red Dead Redemption 2 is an epic tale of life in America at the dawn of the modern age.",
                "https://www.reddit.com/r/Red_Dead_Redemption_2/",
                "https://www.rockstargames.com/reddeadredemption2/"));
        return gamesList;
    }
}
