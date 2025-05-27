package appli.controleurs;

import appli.modele.CollectionJoueur;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class VueRechercheController {
    @FXML
    public HBox vueRecherche;
    @FXML
    private ImageView iconeRecherche;
    @FXML
    private TextField texteRecherche;

    CollectionJoueur collection;
    public VueRechercheController(CollectionJoueur collection) {
        this.collection = collection;
    }

}
