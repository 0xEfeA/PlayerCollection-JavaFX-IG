package appli.controleurs;

import appli.modele.Joueur;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.InputStream;

public class CompoCellController {
    @FXML
    private ImageView photoJoueur;
    @FXML
    private Label nomJoueur;
    @FXML
    private HBox Compocell;

    /**
     * Affiche les informations du joueur j dans la cellule
     * @param j joueur
     */
    public void setJoueur(Joueur j){
        String image = j.getImage();
        InputStream photo = getClass().getResourceAsStream(image);
        //Affiche image défaut si pas d'image du joueur
        if(photo == null){
            photo = getClass().getResourceAsStream("/image/default.png");
        }
        //Charge photo dans l'imageview de la cellule
        photoJoueur.setImage(new javafx.scene.image.Image(photo));
        //Chare nom prénom dans le label de la cellule
        nomJoueur.setText(j.getNom()+" "+j.getPrenom());

    }

    public void onClick(MouseEvent mouseEvent) {
    }
}
