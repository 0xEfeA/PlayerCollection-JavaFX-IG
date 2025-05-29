import appli.modele.CollectionJoueur;
import appli.outil.LecteurJson;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


class LecteurJsonTest {
    @Test
    public void testLecture(){
        CollectionJoueur collection = new CollectionJoueur();
        try {
            collection = LecteurJson.lire("joueurs.json");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(31,collection.getNbJoueurs());
        System.out.println(collection.toString());
    }


}