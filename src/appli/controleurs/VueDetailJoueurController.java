package appli.controleurs;

import appli.modele.CollectionJoueur;
import appli.modele.Joueur;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.InputStream;

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

    private CollectionJoueur collection;
    public VueDetailJoueurController(CollectionJoueur collection){
        this.collection = collection;
    }

    /**
     * Affiche les attributs du joueur J
     * @param j
     */
    public void setJoueur(Joueur j){
        String chemin = j.getImage();
        InputStream photoressource = getClass().getResourceAsStream(chemin);
        //Image par défaut si pas d'image
        if ( photoressource == null ) {
            photoressource = getClass().getResourceAsStream("/image/default.png");
        }
        assert photoressource != null;

        // Affichage attributs
        photo.setImage(new javafx.scene.image.Image(photoressource));
        lien.setText(j.getLien_transfermakt());
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



}
