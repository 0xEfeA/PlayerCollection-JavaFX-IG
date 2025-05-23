package appli;

import appli.controleurs.VueEditionController;
import appli.controleurs.VueGlobaleController;
import appli.controleurs.VueJoueurController;
import appli.controleurs.VueRechercheController;
import appli.modele.CollectionJoueur;
import appli.outil.LecteurJson;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public  class Main extends Application {
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

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/Vue_Globale.fxml"));

        loader.setControllerFactory(ic -> {
            if (ic == VueGlobaleController.class)return vueGlobaleController;
            else if (ic == VueEditionController.class)return vueEditionController;
            else if (ic == VueJoueurController.class)return vueJoueurController;
            else if (ic == VueRechercheController.class)return vueRechercheController;
            else return null;
        });

        Parent root = loader.load();
        primaryStage.setTitle("Collection Joueur de Football");
        primaryStage.setScene(new Scene(root, 600, 800));
        primaryStage.show();

    }

}
