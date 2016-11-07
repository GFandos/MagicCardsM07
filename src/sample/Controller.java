package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javax.swing.text.html.ListView;

public class Controller {


    public javafx.scene.control.ListView cardsListView;

    public void getNewCards(ActionEvent actionEvent) {

        MagicTGGetAllCardsApi api = new MagicTGGetAllCardsApi();

        ObservableList<Card> cards = api.getCards();
        ObservableList<Card> cardNames = FXCollections.observableArrayList ();
        for(int i = 0; i < cards.size(); ++i) {
        //    cardNames.set(cards.get(i).getName()) = ;
        }


        cardsListView.setItems(cards);

    }
}
