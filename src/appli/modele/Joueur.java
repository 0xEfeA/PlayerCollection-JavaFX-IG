package appli.modele;

import java.time.LocalDate;
import java.util.Set;

public class Joueur {
   private Set<String> motcles;
   private String lien_transfermakt;
   private String nom;
   private String prenom;
   private String date_naissance;
   private int age;
   private String nationalite;
   private String position;
   private String club;
   private String image;

    public Joueur(String nom, String prenom, String date_naissance, String nationalite, String position, String club,String lien, Set<String> motcles, String image, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.nationalite = nationalite;
        this.position = position;
        this.club = club;
        this.lien_transfermakt = lien;
        this.motcles = motcles;
        this.image = image;
        this.age = age;
    }
   public Set<String> getMotcles() {
        return motcles;
    }

   public int getAge() {
        return age;
    }
   public String getNom() {
        return nom;
    }
   public String getPrenom() {
        return prenom;
    }
   public String getClub() {
        return club;
    }
   public String getPosition() {
        return position;
    }
   public String getNationalite() {
        return nationalite;
    }
   public String getLien_transfermakt() {
        return lien_transfermakt;
    }
    public String getImage() {
        return image;
    }
    public String getDate_naissance() {
        return date_naissance;
    }
}
