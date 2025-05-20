package appli.controleurs;

import appli.modele.Joueur;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

public class VueGlobaleController {
    @FXML
    private HBox vueEdition;
    @FXML
    private ListView<Joueur> vueJoueur;
    @FXML
    private HBox vueRecherche;
    public VueGlobaleController() {}
}