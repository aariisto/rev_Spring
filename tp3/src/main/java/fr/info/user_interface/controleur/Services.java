package fr.info.user_interface.controleur;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;

import fr.info.user_interface.modele.Catalogue;

@Service
@ComponentScan("fr.info")
public class Services {
    private List<Catalogue> catalogues = new ArrayList<>();
    public Catalogue selection() {
        Catalogue catalogue = new Catalogue();
        catalogue.init("Astérix, Le Bouclier Arverne", "R. Goscinny, A. Uderzo", "bande dessinée");
        return catalogue;
    }


    public List<Catalogue> selectionN() {

        
        Catalogue catalogue1 = new Catalogue();
        catalogue1.init("Astérix, Le Bouclier Arverne", "R. Goscinny, A. Uderzo", "bande dessinée");
        if(!catalogues.contains(catalogue1)){
        catalogues.add(catalogue1);
        }
        Catalogue catalogue2 = new Catalogue();
        catalogue2.init("Tintin, Le Lotus Bleu", "Hergé", "bande dessinée");
        if(!catalogues.contains(catalogue2)){
        catalogues.add(catalogue2);
        }

        return catalogues;
    }

    public Catalogue ajouterCatalogue(Catalogue catalogue) {
        catalogues.add(catalogue);
        return catalogue;
        
    }
}