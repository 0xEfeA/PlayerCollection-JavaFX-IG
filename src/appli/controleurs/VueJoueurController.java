package appli.controleurs;

import appli.modele.CollectionJoueur;
import appli.modele.Joueur;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class VueJoueurController {
    @FXML
    private ListView<Joueur> vueJoueur;
    private CollectionJoueur collection;
    public VueJoueurController(CollectionJoueur collection) {
        this.collection = collection;
    }

    @FXML
    /**
     * Initialise la listview
     */
    public void initialize(){
        this.collection.getJoueurList().forEach(j -> vueJoueur.getItems().add(j));
        vueJoueur.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        vueJoueur.setCellFactory(lv -> new CompoCell());


    }
}
