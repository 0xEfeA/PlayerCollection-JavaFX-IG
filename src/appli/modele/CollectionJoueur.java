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
    public void ajouterJoueur(Joueur joueur) {
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
     * Test la présence d'un joueur
     * @param joueur
     * @return
     */
    public boolean joueurExiste(Joueur joueur) {

            for (Joueur j : joueurList){
                if(j.getNom().equals(joueur.getNom()) && j.getPrenom().equals(joueur.getPrenom())){
                    return true;
                }

    }
        return false;
    }

    /**
     * Supprime le joueur et ses mot clés s'ils ne sont associés qu'à lui
     * @param joueur
     */
  public   void supprimerJoueur(Joueur joueur) {
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
  public  int getNbJoueurs() {
        return joueurList.size();
    }

    @Override
    public String toString(){
      StringBuilder sb = new StringBuilder();
      sb.append("Collection de joueurs : \n");
      for (Joueur j : joueurList){
          sb.append(j.getPrenom()).append(" ").append(j.getNom()).append(": ").append(j.getMotcles()).append(j.getLien_transfermakt()).append(" ").append("/").append(j.getImage()).append(" ").append(j.getAge()).append(" ").append(j.getNationalite()).append(" ").append(j.getPosition()).append(" ").append(j.getClub());
          sb.append("\n");
      }
      return sb.toString();
    }

    public void ajouterMotcle(String motcle){
        motcles.add(motcle);
    }
    public void supprimerMotcle(String motcle){
        motcles.remove(motcle);
    }
    public boolean motcleExiste(String motcle){
        return motcles.contains(motcle);
    }

}
