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
    private VueJoueurController vueJoueurController;

    public VueRechercheController() {

    }
    public void setVueJoueurController(VueJoueurController vueJoueurController) {
        this.vueJoueurController = vueJoueurController;
    }
    @FXML
    private void initialize() {
        texteRecherche.textProperty().addListener((observable, oldValue, newValue) -> {
            vueJoueurController.filtreJoueur(newValue);
        });
    }

}
