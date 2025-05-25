package appli;

import appli.controleurs.*;
import appli.modele.CollectionJoueur;
import appli.outil.LecteurJson;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public  class Main extends Application {
    private Scene sceneGlobale;
    private Scene sceneDetail;
    private Stage stage;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{

        //Chargement données dans le modèle
        CollectionJoueur collection = new CollectionJoueur();
        collection = LecteurJson.lire("joueurs.json");

        //Instanciation des Controlleurs
        //Controleur des boutons d'édition en haut dans la vue globale
        VueEditionController vueEditionController = new VueEditionController(collection);
        //Controleur de la vue globale composer de 3 autres controleurs que sont vueEditionController, vueJoueurController et vueRechercheController
        VueGlobaleController vueGlobaleController = new VueGlobaleController(collection);
        // Controleur qui gère la listview de joueur dans la vue globale
        VueJoueurController vueJoueurController = new VueJoueurController(collection);
        // Controleur qui gère la barre de recherche dans vue globale
        VueRechercheController vueRechercheController = new VueRechercheController(collection);
        // Controleur du label de nom du joueur dans la vue détaillée
        VueLabelController vueLabelController = new VueLabelController(collection);
        // Controleur des 3 boutons en bas dans la vue détaillée
        VueBoutonsController vueBoutonsController = new VueBoutonsController(collection);
        // Controleur des info, photo et lien du joueur au centre de la vue détaillée
        VueDetailJoueurController vueDetailJoueurController = new VueDetailJoueurController(collection);
        //Controleur de la vue détaillée
        VueDetailController vueDetailController = new VueDetailController(collection,vueDetailJoueurController,vueLabelController,vueBoutonsController);
        //Préchargement des Vue pour pouvoir les charger plus tard
        FXMLLoader loaderGlobal = new FXMLLoader(getClass().getResource("/vue/Vue_Globale.fxml"));
        FXMLLoader loaderDetail = new FXMLLoader(getClass().getResource("/vue/Vue_Detaillee.fxml"));
        // Controller Factory de la vue globale
        loaderGlobal.setControllerFactory(ic -> {
            if (ic == VueGlobaleController.class)return vueGlobaleController;
            else if (ic == VueEditionController.class)return vueEditionController;
            else if (ic == VueJoueurController.class)return vueJoueurController;
            else if (ic == VueRechercheController.class)return vueRechercheController;
            else if (ic == VueLabelController.class)return vueLabelController;
            else if (ic == VueBoutonsController.class)return vueBoutonsController;
            else if (ic == VueDetailController.class)return vueDetailController;
            else if (ic == VueDetailJoueurController.class)return vueDetailJoueurController;
            else return null;
        });
        // Controller factory de la vue détaillée
        loaderDetail.setControllerFactory(ic ->{
            if (ic == VueGlobaleController.class)return vueGlobaleController;
            else if (ic == VueEditionController.class)return vueEditionController;
            else if (ic == VueJoueurController.class)return vueJoueurController;
            else if (ic == VueRechercheController.class)return vueRechercheController;
            else if (ic == VueLabelController.class)return vueLabelController;
            else if (ic == VueBoutonsController.class)return vueBoutonsController;
            else if (ic == VueDetailController.class)return vueDetailController;
            else if (ic == VueDetailJoueurController.class)return vueDetailJoueurController;
            else return null;
        });

        Parent rootGlobale = loaderGlobal.load();
        Parent rootDetail = loaderDetail.load();
        // Scènes qui seront affichées selon la vue voulue
        this.sceneGlobale = new Scene(rootGlobale,600, 800);
        this.sceneDetail = new Scene(rootDetail,600,800);
        ModificateurVue mv = new ModificateurVue(sceneGlobale,sceneDetail,this);
        // Ajout du Modificateur de Vue aux Controlleur qui change les vues sur des actions
        vueDetailController.setMv(mv);
        vueGlobaleController.setMv(mv);
        vueBoutonsController.setMv(mv);
        this.stage = primaryStage;
        this.stage.setTitle("Collection Joueur de Football");

        this.stage.setScene(this.sceneDetail);
        this.stage.show();
    }

    /**
     * Affiche vue_globale
     * @param sceneGlobale
     */
    public void afficherSceneGlobale(Scene sceneGlobale) {
        this.stage.setScene(sceneGlobale);
    }

    /**
     * Affiche vue_détaillée
     * @param sceneDetail
     */
    public void afficherSceneDetail(Scene sceneDetail) {
        this.stage.setScene(sceneDetail);
    }

}
