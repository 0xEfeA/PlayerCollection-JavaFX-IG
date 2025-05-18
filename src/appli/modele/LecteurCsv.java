package appli.modele;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * J'utilise un lecteur CSV au lieu de Json pour le moment car je n'ai pas réussi
 * à installer une librairie pour le faire fonctionner.
 * Source pour créer le lecteur : https://labex.io/tutorials/java-reading-a-csv-file-117982
 */
public class LecteurCsv {

    private LecteurCsv(){}

    /**
     * Lit le fichier CSV et retourne une collection de joueurs.
     * @param cheminFichier
     * @return
     * @throws FileNotFoundException
     */
    public static CollectionJoueur lire(String cheminFichier) throws FileNotFoundException {
        CollectionJoueur collectionJoueur = new CollectionJoueur();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))){
            String ligne = bufferedReader.readLine(); //Passe la premiere ligne avec les titres des colonnes
            while((ligne= bufferedReader.readLine()) != null){
                String[] colonnes = ligne.split(",");
                Set<String> motcles = new HashSet<>(List.of(colonnes[7].split(";")));
                Joueur joueur = new Joueur(colonnes[0],colonnes[1],colonnes[2],colonnes[3],colonnes[4],colonnes[5],colonnes[6],motcles,colonnes[8],Integer.parseInt(colonnes[9]));
                collectionJoueur.ajouterJoueur(joueur);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return collectionJoueur;
    }
}