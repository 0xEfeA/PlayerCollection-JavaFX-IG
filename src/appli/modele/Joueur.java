package appli.modele;

import java.time.LocalDate;
import java.util.Set;

public class Joueur {
   private Set<String> motcles;
   private String lien_transfermakt;
   private String nom;
   private String prenom;
   private LocalDate date_naissance;
   private String nationalite;
   private String position;
   private String club;

    public Joueur(String nom, String prenom, LocalDate date_naissance, String nationalite, String position, String club,String lien, Set<String> motcles) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.nationalite = nationalite;
        this.position = position;
        this.club = club;
        this.lien_transfermakt = lien;
        this.motcles = motcles;
    }
   public Set<String> getMotcles() {
        return motcles;
    }

   public int getAge() {
        return LocalDate.now().getYear() - date_naissance.getYear();
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
}
