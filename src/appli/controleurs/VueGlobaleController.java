package appli.controleurs;

import appli.modele.Joueur;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;

import javax.swing.text.html.ImageView;

public class VueGlobaleController {
    @FXML
    private ListView<Joueur> listViewJoueur;
    @FXML
    private Button boutonAjouter;
    @FXML
    private Button boutonEdition;
    @FXML
    private Button boutonTrier;
    @FXML
    private ImageView iconeRecherche;
    @FXML
    private TextField rechercheText;
    public VueGlobaleController(){}

    }
}
