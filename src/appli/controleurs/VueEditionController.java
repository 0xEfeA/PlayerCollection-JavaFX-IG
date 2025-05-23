package appli.controleurs;

import appli.modele.CollectionJoueur;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class VueEditionController {
    @FXML private Button boutonAjouter;
    @FXML private Button boutonEdition;
    @FXML
    private Button boutonTrier;

    private CollectionJoueur collection;
    public VueEditionController(CollectionJoueur collection) {
        this.collection = collection;
    }
}
