package appli.outil;


import appli.modele.CollectionJoueur;
import appli.modele.Joueur;
import org.json.*;


import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Sources pour la création de ce lecteur :
 * https://labex.io/tutorials/java-how-to-read-json-file-from-relative-path-in-java-417587
 * https://www.baeldung.com/java-org-json
 */
public class LecteurJson {

    private LecteurJson(){}

    /**
     * Lit le fichier Json et rempli la collection de joueur
     * @param chemin
     * @return
     * @throws IOException
     */
    public static CollectionJoueur lire(String chemin) throws IOException {

        CollectionJoueur collection = new CollectionJoueur();
     try (InputStream inputStream = LecteurJson.class.getClassLoader().getResourceAsStream(chemin)){  //récupération depuis les ressources


         if (inputStream == null) {
             throw new IllegalArgumentException("Fichier JSON introuvable"+" : "+chemin);
         }
         String data = new String(inputStream.readAllBytes());
         // Parsing en tableau de joueur
         JSONArray joueurs = new JSONArray(data);
         //Parcours de chaque joueurs
         for (int i = 0; i < joueurs.length(); i++) {
             JSONObject objet = joueurs.getJSONObject(i);
             String nom = objet.getString("nom");
             String prenom = objet.getString("prenom");
             String date_naissance = objet.getString("date_naissance");
             String nationalite = objet.getString("nationalite");
             String position = objet.getString("position");
             String club = objet.getString("club");
             String lien = objet.getString("lien_transfermarkt");
             String image = objet.getString("image");
             int age = objet.getInt("age");
             Set<String> motcles= new HashSet<>();
             objet.getJSONArray("motcles").forEach(motcle -> motcles.add(motcle.toString()));

             Joueur joueur = new Joueur(nom, prenom, date_naissance, nationalite, position, club, lien, motcles, image, age);
             collection.ajouterJoueur(joueur);
         }
         return collection;

     }catch (Exception e){
         throw new IOException("Erreur lors de la lecture du fichier JSON",e);
     }


    }

}
