package appli.controleurs;

import appli.modele.CollectionJoueur;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class VueLabelController {
    @FXML
    private Label nomJoueur;

    public VueLabelController(){

    }

    /**
     * Changer le nom du joueur
     * @param nom
     */
    public void setNom(String nom){
        nomJoueur.setText(nom);
    }
}
