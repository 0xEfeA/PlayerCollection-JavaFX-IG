package appli.controleurs;

import appli.modele.CollectionJoueur;
import appli.modele.Joueur;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


public class VueDetailJoueurController {

    @FXML
    private ImageView photo;
    @FXML
    private Label age;
    @FXML
    private Label poste;
    @FXML
    private Label origine;
    @FXML
    private Label club;
    @FXML
    private Label MotCles;
    @FXML
    private Hyperlink lien;
    private  Joueur joueur;
    private CollectionJoueur collection;
    private HostServices hostServices;
    public VueDetailJoueurController(CollectionJoueur collection){
        this.collection = collection;
    }

    /**
     * Affiche les attributs du joueur J
     * @param j
     */
    public void setJoueur(Joueur j){
        this.joueur = j;
        String chemin = j.getImage();
        InputStream photoressource = getClass().getResourceAsStream(chemin);
        //Image par défaut si pas d'image
        if ( photoressource == null ) {
            photoressource = getClass().getResourceAsStream("/image/default.png");
        }
        assert photoressource != null;

        // Affichage attributs
        photo.setImage(new javafx.scene.image.Image(photoressource));
        lien.setText("TransfertMarkt");
        age.setText("Age : " + j.getAge());
        poste.setText("Poste : " + j.getPosition());
        origine.setText("Origine : " + j.getNationalite());
        club.setText("Club : " + j.getClub());

        StringBuilder motcles = new StringBuilder();
        motcles.append("Mot clés : ");
        for(String motcle : j.getMotcles()){
            motcles.append(motcle).append(" ");
        }
        MotCles.setText(motcles.toString());

      
    }

    /**
     * Ouvre le lien tranfermakt du joueur
     * @param actionEvent click sur le lien
     */
    public void onLien(ActionEvent actionEvent) {
        hostServices.showDocument(joueur.getLien_transfermakt());
    }

    /**
     * Ajoute hostServices
     * @param hostServices
     */
    public void setHostServices(HostServices hostServices) {
        this.hostServices = hostServices;
    }
}
