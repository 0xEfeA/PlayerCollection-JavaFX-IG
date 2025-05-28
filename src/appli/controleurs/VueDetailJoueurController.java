package appli.controleurs;

import appli.modele.CollectionJoueur;
import appli.modele.Joueur;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



import java.io.File;
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
        Image image = chargerImage(chemin);
        photo.setImage(image);


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
