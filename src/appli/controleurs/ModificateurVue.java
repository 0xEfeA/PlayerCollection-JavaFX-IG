package appli.controleurs;

import appli.Main;

import javafx.scene.Scene;



public class ModificateurVue {
    private Scene sceneglob;
    private Scene scenedet;
    private Main main;
    public ModificateurVue(Scene sceneglob, Scene sceneDet, Main main) {
        this.sceneglob = sceneglob;
        this.scenedet = sceneDet;
        this.main = main;
    }

    public void AfficherVueGlobale(){
        main.afficherSceneGlobale(sceneglob);
    }
    public void AfficherVueDetaillee(){
        main.afficherSceneDetail(scenedet);
    }
}
