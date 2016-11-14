package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.control.ListView;
import sun.awt.image.URLImageSource;

import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class Controller {

    public Label cardName;
    public ImageView cardImg;
    public Label descriptionTxt;
    public Label rarityTxt;
    @FXML
    private ListView<Card> cardsListView;

    public void initialize() {

        cardsListView.setCellFactory((list) -> {
            return new ListCell<Card>() {
                @Override
                public void updateItem(Card item, boolean empty) {

                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {

                        setText(item.getName());
                        setGraphic(new ImageView(new Image(item.getImageUrl(), 80, 100, true, false, true)));
                    }
                }
            };
        });

        cardsListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    System.out.println("ListView Selection Changed (selected: " + newValue.toString() + ")");

                    cardName.setVisible(true);
                    cardImg.setVisible(true);
                    descriptionTxt.setVisible(true);
                    rarityTxt.setVisible(true);

                    cardName.setText(newValue.getName());
                    cardImg.setImage(new Image(newValue.getImageUrl(), 150, 180, true, false, true));
                    descriptionTxt.setText(newValue.getDescription());
                    rarityTxt.setText("Rarity: " + newValue.getRarity());

                }
        );

    }

    public void getNewCards(ActionEvent actionEvent) {

        MagicTGGetAllCardsApi api = new MagicTGGetAllCardsApi();
        ArrayList<Card> cards = api.getCards();
        ObservableList<Card> cardsObservable = FXCollections.observableArrayList ();

        for(int i = 0; i < cards.size(); ++i) {
            cardsObservable.add(cards.get(i));
        }

        cardsListView.setItems(cardsObservable);

    }


}
