package appli.controleurs;

import appli.modele.CollectionJoueur;
import javafx.event.ActionEvent;
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
    private ModificateurVue mv;
    private VueDetailController vueDetailController;
    public VueBoutonsController(CollectionJoueur collection){
        this.collection = collection;
    }

    public void setMv(ModificateurVue mv){
        this.mv = mv;
    }
    public void setVueDetailController(VueDetailController vueDetailController){
        this.vueDetailController = vueDetailController;
    }
    /**
     * Affiche la vue globale
     * @param actionEvent
     */
    public void onAccueil(ActionEvent actionEvent) {
        mv.AfficherVueGlobale();
    }

    public void onSuivant(ActionEvent actionEvent) {
        vueDetailController.suivant();
    }
    public void onPrecedent(ActionEvent actionEvent) {
        vueDetailController.precedent();
    }
}
