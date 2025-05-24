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

    public void setJoueur(Joueur j){
        String chemin = j.getImage();
        InputStream photoressource = getClass().getResourceAsStream(chemin);
        if ( photoressource == null ) {
            photoressource = getClass().getResourceAsStream("/image/default.png");
        }
        assert photoressource != null;
        photo.setImage(new javafx.scene.image.Image(photoressource));
        lien.setText(j.getLien_transfermakt());
        StringBuilder sbage = new StringBuilder();
        sbage.append("Age : ").append(j.getAge());
        age.setText(sbage.toString());
        StringBuilder sbposte = new StringBuilder();
        sbposte.append("Poste : ").append(j.getPosition());
        poste.setText(sbposte.toString());
        StringBuilder sborigine = new StringBuilder();
        sborigine.append("Origine : ").append(j.getNationalite());
        origine.setText(sborigine.toString());
        StringBuilder sbclub = new StringBuilder();
        sbclub.append("Club : ").append(j.getClub());
        club.setText(sbclub.toString());

        StringBuilder motcles = new StringBuilder();
        motcles.append("Mot clés : ");
        for(String motcle : j.getMotcles()){
            motcles.append(motcle).append(" ");
        }
        MotCles.setText(motcles.toString());
    }



}
