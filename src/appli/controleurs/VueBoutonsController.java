package appli.controleurs;

import appli.modele.CollectionJoueur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.io.IOException;

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
    private ModificateurVue mv;
    public VueBoutonsController(CollectionJoueur collection){
        this.collection = collection;
    }

    public void setMv(ModificateurVue mv){
        this.mv = mv;
    }
    public void onAccueil(ActionEvent actionEvent) {
        mv.AfficherVueGlobale();
    }
}
