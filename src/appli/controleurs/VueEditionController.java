package appli.controleurs;

import appli.modele.CollectionJoueur;
import appli.modele.Joueur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;

import java.io.IOException;

public class VueEditionController {
    @FXML private Button boutonAjouter;
    @FXML private Button boutonEdition;
    @FXML
    private Button boutonTrier;

    private CollectionJoueur collection;
    private VueJoueurController vueJoueurController;
    public VueEditionController(CollectionJoueur collection) {
        this.collection = collection;
    }

    /**
     * Set le controleur de listview
     * @param controller
     */
    public void setVueJoueurController(VueJoueurController controller) {
        this.vueJoueurController = controller;
  }

    /**
     * Affiche le vue d'ajout de joueur
     * @param actionEvent
     * @throws IOException
     */
    public void onAjouter(ActionEvent actionEvent) throws IOException {
       try {
           //Charge la popup
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vue/AjoutJoueurPopup.fxml"));
           Parent root = fxmlLoader.load();

           Stage stage = new Stage();
           stage.setTitle("Ajouter joueur");

           stage.setScene(new Scene(root));

           AddJoueurController controller = fxmlLoader.getController();
           controller.setStage(stage);
           stage.showAndWait();
           //Création joueur avec les infos rentrés
           Joueur joueur = controller.getJoueur();
           if (joueur != null) {
               collection.ajouterJoueur(joueur);
               vueJoueurController.actualiserListView();
           }
       }catch (Exception e){
           new Alert(Alert.AlertType.ERROR, "Erreur de suppression", ButtonType.OK).show();
       }
    }
}
