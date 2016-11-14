package sample;

//import java.net.URI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

/**
 * Created by 47989768s on 19/10/16.
 */

public class MagicTGGetAllCardsApi {

    private static String url="https://api.magicthegathering.io/v1/cards?page=5&pageSize=100";


        public ArrayList<Card> getCards() {

        ArrayList<Card> cards = new ArrayList<> ();

        try {

            JSONObject jsonO = new JSONObject(HttpUtils.get(url));
            JSONArray  jsonCards = jsonO.getJSONArray("cards");
            String name, type, imageUrl, cardColor, rarity;

            for (int i = 0; i < jsonCards.length(); ++i) {

                JSONObject object = jsonCards.getJSONObject(i);

                name = object.getString("name");
                System.out.println("name:" + name);
                rarity = object.getString("rarity");
                type = object.getString("type");
                //cardColor = object.getString("colors");
                imageUrl = object.getString("imageUrl");

                Card c = new Card(name, rarity, type, imageUrl, "null");
                cards.add(c);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return cards;

    }

}
