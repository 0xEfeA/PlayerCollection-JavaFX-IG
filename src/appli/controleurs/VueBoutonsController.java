package appli.controleurs;

import appli.modele.CollectionJoueur;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class VueBoutonsController {

    @FXML
    private Button boutonPrecedent;
    @FXML
    private Button boutonSuivant;
    @FXML
    private Button boutonAccueil;
    @FXML
    private ImageView VueBouton;

    private CollectionJoueur collection;
    public VueBoutonsController(CollectionJoueur collection){
        this.collection = collection;
    }

}
