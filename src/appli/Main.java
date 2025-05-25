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
        CollectionJoueur collection = new CollectionJoueur();
        collection = LecteurJson.lire("joueurs.json");
        VueEditionController vueEditionController = new VueEditionController(collection);
        VueGlobaleController vueGlobaleController = new VueGlobaleController(collection);
        VueJoueurController vueJoueurController = new VueJoueurController(collection);
        VueRechercheController vueRechercheController = new VueRechercheController(collection);
        VueLabelController vueLabelController = new VueLabelController(collection);
        VueBoutonsController vueBoutonsController = new VueBoutonsController(collection);
        VueDetailJoueurController vueDetailJoueurController = new VueDetailJoueurController(collection);
        VueDetailController vueDetailController = new VueDetailController(collection,vueDetailJoueurController,vueLabelController,vueBoutonsController);

        FXMLLoader loaderGlobal = new FXMLLoader(getClass().getResource("/vue/Vue_Globale.fxml"));
        FXMLLoader loaderDetail = new FXMLLoader(getClass().getResource("/vue/Vue_Detaillee.fxml"));
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
        this.sceneGlobale = new Scene(rootGlobale,600, 800);
        this.sceneDetail = new Scene(rootDetail,600,800);
        ModificateurVue mv = new ModificateurVue(sceneGlobale,sceneDetail,this);
        vueDetailController.setMv(mv);
        vueGlobaleController.setMv(mv);
        vueBoutonsController.setMv(mv);
        this.stage = primaryStage;
        this.stage.setTitle("Collection Joueur de Football");

        this.stage.setScene(this.sceneDetail);
        this.stage.show();
    }

    public void afficherSceneGlobale(Scene sceneGlobale) {
        this.stage.setScene(sceneGlobale);
    }
    public void afficherSceneDetail(Scene sceneDetail) {
        this.stage.setScene(sceneDetail);
    }

}
