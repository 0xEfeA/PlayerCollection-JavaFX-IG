package appli.controleurs;

import appli.modele.CollectionJoueur;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class VueLabelController {
    @FXML
    private Label nomJoueur;

    private CollectionJoueur collection;
    public VueLabelController(CollectionJoueur collection){
        this.collection = collection;
    }

    /**
     * Changer le nom du joueur
     * @param nom
     */
    public void setNom(String nom){
        nomJoueur.setText(nom);
    }
}
