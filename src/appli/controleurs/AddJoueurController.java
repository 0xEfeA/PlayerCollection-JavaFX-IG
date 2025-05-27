package appli.controleurs;

import appli.modele.Joueur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
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
    public TextField champsMotCles;
    @FXML
    public Button boutonImage;

    private String cheminImage;
    private Joueur joueur;
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
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
        //Parsing des mots clés entrés
        String motCles = champsMotCles.getText();
        Scanner scanner = new Scanner(motCles);
        Set<String> motClesSet = new HashSet<>();
        while (scanner.hasNextLine()) {
            motClesSet.add(scanner.nextLine());
        }
        scanner.close();
        //Création du joueur
        joueur = new Joueur(champsNom.getText(),champsPrenom.getText(),champsDate.getText(),champsNationalite.getText(),champsPosition.getText(),champsClub.getText(),champsLien.getText(),motClesSet,cheminImage,Integer.parseInt(champsAge.getText()));
        stage.close();
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
}
