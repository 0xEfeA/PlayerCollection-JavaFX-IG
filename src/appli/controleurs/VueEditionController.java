package appli.controleurs;

import appli.modele.CollectionJoueur;
import appli.modele.Joueur;
import appli.outil.LecteurJson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuButton;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class VueEditionController {
    @FXML private Button boutonAjouter;
    @FXML private Button boutonEdition;
    @FXML
    private MenuButton menuFichier;

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
           controller.setData(collection,stage);
           stage.showAndWait();
           //Création joueur avec les infos rentrés
           Joueur joueur = controller.getJoueur();
           if (joueur != null) {
               collection.ajouterJoueur(joueur);
               vueJoueurController.actualiserListView();
           }
       }catch (Exception e){
           new Alert(Alert.AlertType.ERROR, "Erreur chargement popup ajouter", ButtonType.OK).show();
       }
    }

    /**
     * Ouvre le gestionnaire de fichier puis créer la collection de joueur depuis le Json
     * @param actionEvent
     * @throws IOException
     */
    public void onChargerFichier(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Charger fichier Json");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Json files", "*.json"));
        File file = fileChooser.showOpenDialog(new Stage());
        if(file != null){
            //Création d'une nouvelle collection depuis laquelle on va modifier les attributs de l'instance de la vraie collection
            CollectionJoueur copie = LecteurJson.lire(file.getAbsolutePath());
            collection.getJoueurList().clear();
            collection.getJoueurList().addAll(copie.getJoueurList());
            collection.getMotcles().clear();
            collection.getMotcles().addAll(copie.getMotcles());
            vueJoueurController.actualiserListView();
        }

    }

    /**
     * Enregistre la collection dans le fichier json choisi
     * @param actionEvent
     * @throws IOException
     */
    public void onSauvegarder(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sauvegarder Json");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Json files", "*.json"));
        File file = fileChooser.showSaveDialog(new Stage());

        if (!file.getName().endsWith(".json")) {
            file = new File(file.getAbsolutePath() + ".json");
        }
        try{
            LecteurJson.ecrire(collection,file.getAbsolutePath());
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, "Erreur de sauvegarde", ButtonType.OK).show();
        }
    }
}
