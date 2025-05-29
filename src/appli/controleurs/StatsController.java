package appli.controleurs;

import appli.modele.CollectionJoueur;
import appli.modele.Joueur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.chart.PieChart;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StatsController {
    @FXML
    public PieChart chartPays;
    @FXML
    public PieChart chartsPoste;
    @FXML
    public PieChart chartMotcle;
    @FXML
    public PieChart chartClub;

    private CollectionJoueur collectionJoueur;

    public void setData(CollectionJoueur collectionJoueur) {
        this.collectionJoueur = collectionJoueur;
        afficherDonnees();
    }

    /**
     * Renvoie la liste de data pour les pays et leur nombres d'apparitions
     * @return
     */
    private ObservableList<PieChart.Data> paysData() {
        //Création d'un dictionnaire sous la forme {pays,nbApparition} depuis les joueurs dans le modèle comme dans le cours de gestion de collection
        Map<String, Long> propotion = collectionJoueur.getJoueurList().stream().collect(Collectors.groupingBy(Joueur::getNationalite,Collectors.counting()));
        //Pour chaque couple dans le dictionnaire on crée une nouvelle data qu'on ajoute au tableau qu'on retourne
        return FXCollections.observableArrayList(propotion.entrySet().stream().map(entry -> new PieChart.Data(entry.getKey(), entry.getValue())).toList());
    }
    /**
     * Renvoie la liste de data pour les clubs et leur nombres d'apparitions
     * @return
     */
    private ObservableList<PieChart.Data> clubData() {
        //Création d'un dictionnaire sous la forme {club,nbApparition} depuis les joueurs dans le modèle comme dans le cours de gestion de collection
        Map<String, Long> propotion = collectionJoueur.getJoueurList().stream().collect(Collectors.groupingBy(Joueur::getClub,Collectors.counting()));
        //Pour chaque couple dans le dictionnaire on crée une nouvelle data qu'on ajoute au tableau qu'on retourne
        return FXCollections.observableArrayList(propotion.entrySet().stream().map(entry -> new PieChart.Data(entry.getKey(), entry.getValue())).toList());
    }
    /**
     * Renvoie la liste de data pour les postes et leur nombres d'apparitions
     * @return
     */
    private ObservableList<PieChart.Data> posteData() {
        //Création d'un dictionnaire sous la forme {poste,nbApparition} depuis les joueurs dans le modèle comme dans le cours de gestion de collection
        Map<String, Long> propotion = collectionJoueur.getJoueurList().stream().collect(Collectors.groupingBy(Joueur::getPosition,Collectors.counting()));
        //Pour chaque couple dans le dictionnaire on crée une nouvelle data qu'on ajoute au tableau qu'on retourne
        return FXCollections.observableArrayList(propotion.entrySet().stream().map(entry -> new PieChart.Data(entry.getKey(), entry.getValue())).toList());
    }
    /**
     * Renvoie la liste de data pour les mots clés et leur nombres d'apparitions
     * @return
     */
    private ObservableList<PieChart.Data> motcleData() {
        //Création d'un dictionnaire sous la forme {motsCles,nbApparition} depuis les joueurs dans le modèle comme dans le cours de gestion de collection
        Map<Set<String>, Long> propotion = collectionJoueur.getJoueurList().stream().collect(Collectors.groupingBy(Joueur::getMotcles,Collectors.counting()));
        //Pour chaque couple dans le dictionnaire on crée une nouvelle data qu'on ajoute au tableau qu'on retourne
        return FXCollections.observableArrayList(propotion.entrySet().stream().map(entry -> new PieChart.Data(entry.getKey().toString(), entry.getValue())).toList());
    }

    /**
     * Charge les données des 4 Pie Charts
     */
    private void afficherDonnees(){
        chartPays.setData(paysData());
        chartClub.setData(clubData());
        chartMotcle.setData(motcleData());
        chartsPoste.setData(posteData());
    }

}
