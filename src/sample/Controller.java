package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javax.swing.text.html.ListView;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Controller {


    public javafx.scene.control.ListView cardsListView;

    public void getNewCards(ActionEvent actionEvent) {

        MagicTGGetAllCardsApi api = new MagicTGGetAllCardsApi();

        ArrayList<Card> cards = api.getCards();

        ObservableList<String> cardNames = FXCollections.observableArrayList ();
        for(int i = 0; i < cards.size(); ++i) {
            cardNames.add(cards.get(i).getName());
        }


        cardsListView.setItems(cardNames);

    }
}
