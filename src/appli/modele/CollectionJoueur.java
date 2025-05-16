package appli.modele;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionJoueur {
    private   List<Joueur> joueurList;
    private Set<String> motcles;

    public CollectionJoueur(){
        joueurList = new ArrayList<Joueur>();
        motcles = new HashSet<String>();
    }
    public Set<String> getMotcles() {
        return motcles;
    }
    public List<Joueur> getJoueurList() {
        return joueurList;
    }

    /**
     * Ajoute le joueur si il n'existe pas encore
     * @param joueur
     */
    void ajouterJoueur(Joueur joueur) {
        boolean joueurExiste = false;
        for (Joueur j : joueurList){
            if(j.getNom().equals(joueur.getNom()) && j.getPrenom().equals(joueur.getPrenom())){
                joueurExiste = true;
                break;
            }

    } if(!joueurExiste){// Si joueur pas dans la liste l'ajoute
            joueurList.add(joueur);
            // Ajoute les mots clés associés au joueur
            motcles.addAll(joueur.getMotcles());
        }

    }

    /**
     * Supprime le joueur et ses mot clés s'ils ne sont associés qu'à lui
     * @param joueur
     */
    void supprimerJoueur(Joueur joueur) {
        joueurList.remove(joueur);
        for (String mot : joueur.getMotcles()) {
            boolean motAutreJoueur = false;
            for (Joueur j : joueurList) {
                if (j.getMotcles().contains(mot)) {
                    motAutreJoueur = true;
                    break;
                }
            }
            if (!motAutreJoueur) {
                motcles.remove(mot);
            }
        }
    }
    int getNbJoueurs() {
        return joueurList.size();
    }

}
