package appli.controleurs;

import appli.modele.Joueur;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class CompoCell extends ListCell<Joueur> {
    private HBox listJoueurs;
    private CompoCellController controller;

    public CompoCell(){
        try {
            //Chargement du fichier fxml représentant la cellule
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/compoCell.fxml"));
            listJoueurs = loader.load();
            controller = loader.getController();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void updateItem(Joueur item, boolean empty) {
        super.updateItem(item, empty);
        if(empty || item == null){
            setGraphic(null);
        }else{
            controller.setJoueur(item);
            setGraphic(listJoueurs);
        }
    }
}
