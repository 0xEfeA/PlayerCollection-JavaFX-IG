package appli.controleurs;

import appli.modele.CollectionJoueur;
import appli.modele.Joueur;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseButton;

public class VueJoueurController {
    @FXML
    private ListView<Joueur> vueJoueur;
    private CollectionJoueur collection;

    private ModificateurVue mv;
    private VueDetailController vueDetailController;
    public VueJoueurController(CollectionJoueur collection) {
        this.collection = collection;
    }

    public void setMv(ModificateurVue mv) {
        this.mv = mv;
    }
    public void setVueDetailController(VueDetailController vueDetailController) {
        this.vueDetailController = vueDetailController;
    }
    @FXML
    /**
     * Initialise la listview et ajoute écouteur
     */
    public void initialize(){
      actualiserListView();
      EcouteurCellule();

    }

    /**
     * Actualise la listview
     */
    public void actualiserListView(){
        vueJoueur.getItems().clear();
        vueJoueur.getItems().addAll(collection.getJoueurList());
    }

    /**
     * Configue la méthode de sélection
     */
    public void EcouteurCellule(){
        vueJoueur.setCellFactory(lv -> new CompoCell());
        vueJoueur.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                Joueur selection = vueJoueur.getSelectionModel().getSelectedItem();
                if (selection != null) {
                    vueDetailController.afficherJoueur(selection);
                    mv.AfficherVueDetaillee();
                }
            }
        });
    }
}
