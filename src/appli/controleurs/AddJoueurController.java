package appli.controleurs;

import appli.modele.CollectionJoueur;
import appli.modele.Joueur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class AddJoueurController {
    @FXML
    public TextField champsNom;
    @FXML
    public TextField champsPrenom;
    @FXML
    public TextField champsAge;
    @FXML
    public TextField champsLien;
    @FXML
    public TextField champsDate;
    @FXML
    public TextField champsNationalite;
    @FXML
    public TextField champsClub;
    @FXML
    public TextField champsPosition;
    @FXML
    public ComboBox<String> comboMotcle;

    @FXML
    public Button boutonImage;

    private String cheminImage;
        private Joueur joueur;
    private Stage stage;
    private ObservableList<String> motClesSet = FXCollections.observableArrayList();
    private Set<String> motCleschoisis = new HashSet<>();
    private  CollectionJoueur collection;

    /**
     * Permet de récupérer les données utiles pour le fonctionnement du controleur
     * @param collection
     * @param stage
     */
    public void setData(CollectionJoueur collection,Stage stage){
        this.collection = collection;
        this.stage = stage;
        //Charge les motcles de la collection
        motClesSet.addAll(collection.getMotcles());
        comboMotcle.setItems(motClesSet);
    }

    /**
     * Set l'image du joueur à ajouter
     * @param cheminImage
     */
    public void setcheminImage(String cheminImage){
        this.cheminImage = cheminImage;
    }

    /**
     * Set les mots clés du joueur
     * @param motcle
     */
    public void setMotClesSet(Set<String> motcle){
        this.motCleschoisis.addAll(motcle);
    }

    /**
     * Permet de choisir l'image du joueur à ajouter
     * @param actionEvent
     */
    @FXML
    public void onImage(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisissez une image");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.jpeg"));
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            cheminImage = file.getAbsolutePath();
        }
    }

    /**
     * Créer le joueur avec les informations entrées
     * @param actionEvent
     */
    @FXML
    public void onAccepter(ActionEvent actionEvent) {
        if(verifierEntree()){
            /*Passage de cheminImage en null si pas d'image ajoutée pour éviter une erreur qui fait que le chemin est vide
            *mais pas vraiment null.Ce qui pose probleme dans ma méthode setImage dans les cellules de la listview
             */
            if(cheminImage == null || cheminImage.isBlank() ){
                cheminImage = null;
            }
            //Création du joueur
            joueur = new Joueur(champsNom.getText(),champsPrenom.getText(),champsDate.getText(),champsNationalite.getText(),champsPosition.getText(),champsClub.getText(),champsLien.getText(),motCleschoisis,cheminImage,Integer.parseInt(champsAge.getText()));
            stage.close();
        }

    }

    /**
     * Ferme la fenêtre
     * @param actionEvent
     */
    @FXML
    public void onCancel(ActionEvent actionEvent) {
        stage.close();
    }

    /**
     * Renvoie le joueur
     * @return
     */
    public Joueur getJoueur() {
        return joueur;
    }

    /**
     * Valide la saisie des champs
     * @return true si les champs sont valides, false sinon + alert erreur
     */
    private boolean verifierEntree(){
        String message = "";
        if(champsNom.getText().isBlank()){
            message += "Veuillez entrer un nom\n";
        }if(champsPrenom.getText().isBlank()){
            message += "Veuillez entrer un prénom\n";
        }
        if(champsDate.getText().isBlank()){
            message += "Veuillez entrer une date de naissance\n";
        }
        if(champsNationalite.getText().isBlank()){
            message += "Veuillez entrer une nationalité \n";
        }
        if(champsClub.getText().isBlank()){
            message += "Veuillez entrer un club\n";
        }
        if(champsLien.getText().isBlank()){
            message += "Veuillez entrer un lien\n";
        }
        if(champsAge.getText().isBlank()){
            message += "Veuillez entrer une age\n";
        }
        try{
            Integer.parseInt(champsAge.getText());

        }catch (NumberFormatException e){
            message += "Pour l'âge : Veuillez entrer un nombre\n";
        }
        if(!message.isBlank()){
            new Alert(Alert.AlertType.ERROR,message).showAndWait();
            return false;
        }
        return true;
    }

    /**
     * Ajoute des mots clés à la liste déjà existante du model
     * @param actionEvent
     */
    public void onAjouterMotcle(ActionEvent actionEvent) {
        String motcle = comboMotcle.getEditor().getText();
        if(motcle.isBlank()){
            return;
        }
        if(!motClesSet.contains(motcle)){
            motClesSet.add(motcle);
            collection.ajouterMotcle(motcle);
        }

        comboMotcle.getEditor().clear();

    }

    /**
     * Permet d'ajouter les mots clés choisis au joueur créé
     * @param actionEvent
     */
    public void onSelection(ActionEvent actionEvent) {
        String motcle = comboMotcle.getSelectionModel().getSelectedItem();
        if (!motCleschoisis.contains(motcle)){
            motCleschoisis.add(motcle);
            comboMotcle.getEditor().setText("");
        }
    }



}
