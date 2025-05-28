package appli.controleurs;

import appli.modele.Joueur;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.File;
import java.io.InputStream;
import java.util.Objects;

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
        Image photo = chargerImage(image);
        //Charge photo dans l'imageview de la cellule
        photoJoueur.setImage(photo);
        //Chare nom prénom dans le label de la cellule
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
}
