package appli.controleurs;

import appli.modele.CollectionJoueur;
import appli.modele.Joueur;
import javafx.collections.FXCollections;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import javafx.scene.input.MouseButton;

import java.util.List;

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
        vueJoueur.setCellFactory(lv -> new CompoCell(collection,this));
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

    /**
     * Filtre les joueur selon l'entrée
     * @param nomJoueur
     */
    public void filtreJoueur(String nomJoueur){
        String nom = nomJoueur.toLowerCase();
        //Filtre avec stream sur les noms et prénoms
        List<Joueur> joueurs = collection.getJoueurList().stream().filter(j -> j.getNom().toLowerCase().contains(nom) || j.getPrenom().toLowerCase().contains(nom)).toList();
        //Affichage des joueurs qui répondent au filtre
        vueJoueur.setItems(FXCollections.observableArrayList(joueurs));
    }
}
