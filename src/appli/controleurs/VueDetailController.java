package appli.controleurs;

import appli.modele.CollectionJoueur;
import appli.modele.Joueur;
import javafx.fxml.FXML;

public class VueDetailController {

    private VueDetailJoueurController vueDetailJoueurController;
    private VueLabelController vueLabelController;
    private VueBoutonsController vueBoutonsController;
    private ModificateurVue mv;
    private CollectionJoueur collection;


    public VueDetailController(CollectionJoueur collection, VueDetailJoueurController vueDetailJoueurController, VueLabelController vueLabelController, VueBoutonsController vueBoutonsController){
        this.collection = collection;
        this.vueDetailJoueurController = vueDetailJoueurController;
        this.vueLabelController = vueLabelController;
        this.vueBoutonsController = vueBoutonsController;
    }
    public void afficherJoueur(Joueur joueur){
        vueLabelController.setNom(joueur.getNom()+ " " + joueur.getPrenom());
        vueDetailJoueurController.setJoueur(joueur);
    }
    /**
     * Set modificateur vue
     * @param mv
     */
    public void setMv(ModificateurVue mv){
        this.mv = mv;
    }
    @FXML
    public void initialize(){
        String nom = collection.getJoueurList().getFirst().getNom()+" " +collection.getJoueurList().getFirst().getPrenom();
        vueLabelController.setNom(nom);
        vueDetailJoueurController.setJoueur(collection.getJoueurList().get(0));
    }
}
