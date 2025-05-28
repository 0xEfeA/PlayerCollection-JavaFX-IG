package appli.controleurs;

import appli.modele.CollectionJoueur;
import appli.modele.Joueur;
import javafx.fxml.FXML;

import java.util.List;

public class VueDetailController {

    private VueDetailJoueurController vueDetailJoueurController;
    private VueLabelController vueLabelController;
    private VueBoutonsController vueBoutonsController;
    private CollectionJoueur collection;
    private Joueur joueurActuel;

    public VueDetailController(CollectionJoueur collection, VueDetailJoueurController vueDetailJoueurController, VueLabelController vueLabelController, VueBoutonsController vueBoutonsController){
        this.collection = collection;
        this.vueDetailJoueurController = vueDetailJoueurController;
        this.vueLabelController = vueLabelController;
        this.vueBoutonsController = vueBoutonsController;
    }
    public void afficherJoueur(Joueur joueur){
        joueurActuel = joueur;
        vueLabelController.setNom(joueur.getNom()+ " " + joueur.getPrenom());
        vueDetailJoueurController.setJoueur(joueur);

    }


    /**
     * Affiche le joueur précédent
     */
    public void precedent(){
        List<Joueur> list = collection.getJoueurList();
        int indice = list.indexOf(joueurActuel);
        if(indice >0){
            afficherJoueur(list.get(indice-1));
        }else {
            afficherJoueur(list.getLast());

        }
    }
    /**
     * Affiche le joueur suivant
     */
    public void suivant(){
        List<Joueur> list = collection.getJoueurList();
        int indice = list.indexOf(joueurActuel);
        if(indice < list.size()-1){
            afficherJoueur(list.get(indice +1));
        }else {
            afficherJoueur(list.getFirst());

        }
    }

}
