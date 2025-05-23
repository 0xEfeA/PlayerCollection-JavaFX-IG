package appli.controleurs;

import appli.modele.CollectionJoueur;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class VueRechercheController {
    @FXML
    private ImageView iconeRecherche;
    @FXML
    private TextField texteRecherche;

    CollectionJoueur collection;
    public VueRechercheController(CollectionJoueur collection) {
        this.collection = collection;
    }

}
