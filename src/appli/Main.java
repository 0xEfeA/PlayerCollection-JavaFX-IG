package appli;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public  class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/Vue_Globale.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Collection Joueur de Football");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

    }

}
