package appli.controleurs;

import appli.Main;

import javafx.scene.Scene;



public class ModificateurVue {
    private Scene sceneglob;
    private Scene scenedet;
    private Main main;

    /**
     * Constructeur
     * @param sceneglob
     * @param sceneDet
     * @param main
     */
    public ModificateurVue(Scene sceneglob, Scene sceneDet, Main main) {
        this.sceneglob = sceneglob;
        this.scenedet = sceneDet;
        this.main = main;
    }

    /**
     * Affiche vue globale
     */
    public void AfficherVueGlobale(){
        main.afficherSceneGlobale(sceneglob);
    }

    /**
     * Affiche vue détaillée
     */
    public void AfficherVueDetaillee(){
        main.afficherSceneDetail(scenedet);
    }
}
