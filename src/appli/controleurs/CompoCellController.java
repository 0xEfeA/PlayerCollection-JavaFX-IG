package appli.controleurs;

import appli.modele.CollectionJoueur;
import appli.modele.Joueur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.InputStream;

public class CompoCellController {
    @FXML
    public ContextMenu compoContext;
    @FXML
    public MenuItem menuSupprimer;
    @FXML
    public MenuItem menuModifier;
    @FXML
    private ImageView photoJoueur;
    @FXML
    private Label nomJoueur;
    @FXML
    private HBox Compocell;

    private Joueur joueur;
    private CollectionJoueur collectionJoueur;
    private VueJoueurController vueJoueurController;
    public CompoCellController() {}

    /**
     * PErmet de charger les données nécessaires au fonctionnement du controller
     * @param collectionJoueur collection de joueur
     * @param vueJoueurController Controller qui gère la listview
     */
    public void setDonnees(CollectionJoueur collectionJoueur,VueJoueurController vueJoueurController) {
        this.collectionJoueur = collectionJoueur;
        this.vueJoueurController = vueJoueurController;
    }


    /**
     * Affiche les informations du joueur j dans la cellule
     * @param j joueur
     */
    public void setJoueur(Joueur j){
        joueur = j;
        String image = j.getImage();
        Image photo = chargerImage(image);
        //Charge photo dans l'imageview de la cellule
        photoJoueur.setImage(photo);
        //Charge nom prénom dans le label de la cellule
        nomJoueur.setText(j.getNom()+" "+j.getPrenom());

    }
    private Image chargerImage(String image){

        //Essaye de charger l'image depuis les ressources
        if(image != null && !image.isEmpty()){

            InputStream is = getClass().getResourceAsStream(image);
            if(is != null){
                return new Image(is);
            }
            //Sinon charge depuis chemin absolu
            File file = new File(image);
            if(file.exists()){
                return new Image(file.toURI().toString(),true);
            }
        }

        //Sinon charge image par défaut
        InputStream defaut = getClass().getResourceAsStream("/image/default.png");
        return new Image(defaut);
    }

    /**
     * Fonction de suppresion dans le context menu, supprime le joueur du modèl et actualise la vue
     * @param actionEvent sur click menuItem supprimer
     */
    public void onSupprimer(ActionEvent actionEvent) {
        collectionJoueur.supprimerJoueur(joueur);
        vueJoueurController.actualiserListView();
    }

    /**
     * Ouvre une fenêtre pré remplie qui permet de modifier le joueur choisi
     * @param actionEvent
     */
    public void onModifier(ActionEvent actionEvent) {
        try {
            //Charge la popup
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vue/AjoutJoueurPopup.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Modifier joueur");

            stage.setScene(new Scene(root));

            AddJoueurController controller = fxmlLoader.getController();
            controller.setData(collectionJoueur,stage);
            //Pré remplie le champs avec les données du joueur
            controller.champsNom.setText(joueur.getNom());
            controller.champsPrenom.setText(joueur.getPrenom());
            controller.champsClub.setText(joueur.getClub());
            controller.champsAge.setText(Integer.toString(joueur.getAge()));
            controller.champsNationalite.setText(joueur.getNationalite());
            controller.champsPosition.setText(joueur.getPosition());
            controller.champsLien.setText(joueur.getLien_transfermakt());
            controller.setcheminImage(joueur.getImage());
            controller.champsDate.setText(joueur.getDate_naissance());
            controller.setMotClesSet(joueur.getMotcles());
            stage.showAndWait();
            //Création joueur avec les infos rentrés
            Joueur joueur = controller.getJoueur();
            if (joueur != null && !collectionJoueur.joueurExiste(joueur)) {
                //Ajoute le "nouveau joueur" qui est en réalité le joueur modifié
                collectionJoueur.ajouterJoueur(joueur);
                //Supprime le joueur original
                onSupprimer(actionEvent);
                vueJoueurController.actualiserListView();
            }
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, "Erreur chargement popup ajouter", ButtonType.OK).show();
        }
    }

}
