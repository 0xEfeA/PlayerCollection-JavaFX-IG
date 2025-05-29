package appli.outil;


import appli.modele.CollectionJoueur;
import appli.modele.Joueur;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.*;


import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.HashSet;
import java.util.List;
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
      InputStream inputStream = LecteurJson.class.getClassLoader().getResourceAsStream(chemin); //récupération depuis les ressources
         if (inputStream == null) {
            File file = new File(chemin);
            if(!file.exists()){
                throw new FileNotFoundException("Fichier json introuvable au chemin:"+chemin);
            }
            inputStream = new FileInputStream(file);
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


    }

    /**
     * Créer un tableau json depuis la collection puis écrit dans le fichier choisi
     * @param collection
     * @throws IOException
     */
    public static void ecrire(CollectionJoueur collection, String chemin) throws IOException {
        JSONArray joueurs = new JSONArray();
        List<Joueur> joueurSet = collection.getJoueurList();
        //crée un objet pour chaque joueur et l'ajout au tableau
        for(Joueur joueur : joueurSet){
            JSONObject objet = getJsonObject(joueur);
            joueurs.put(objet);
        }
        //écrit le tableau dans le fichier en paramètre
      try(FileWriter fileWriter = new FileWriter(chemin)){
          fileWriter.write(joueurs.toString());
      }
    }

    /**
     * Renvoie l'objet avec les informations du joueur
     * @param joueur joueur
     * @return objet Json représentant le joueur
     */
    private static JSONObject getJsonObject(Joueur joueur) {
        JSONObject objet = new JSONObject();
        objet.put("nom", joueur.getNom());
        objet.put("prenom", joueur.getPrenom());
        objet.put("date_naissance", joueur.getDate_naissance());
        objet.put("nationalite", joueur.getNationalite());
        objet.put("position", joueur.getPosition());
        objet.put("club", joueur.getClub());
        objet.put("lien_transfermarkt", joueur.getLien_transfermakt());
        objet.put("image", joueur.getImage());
        objet.put("age", joueur.getAge());
        JSONArray motcles = new JSONArray();
        for (String motcle : joueur.getMotcles()) {
            motcles.put(motcle);
        }
        objet.put("motcles", motcles);
        return objet;
    }

}
