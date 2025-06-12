package fr.info.user_interface.controleur;

import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import fr.info.user_interface.controleur.Services;
import fr.info.user_interface.modele.Catalogue;

@Controller
@ComponentScan("fr.info")
public class Controleur {
    private final Services services;
    String menu = "catalogue";

    @Autowired
    public Controleur(Services services) {
        this.services = services;
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("menu", menu); // Add the global variable to the model
    }

    @GetMapping("/selection") // => localhost:8090/selection
    public String selection(Model model) {
        model.addAttribute("menu", "selection"); // Update the menu attribute to "selection"
        model.addAttribute("catalogue", services.selection()); // catalogue = services.selection();
        return "catalogue"; // charge le fichier "catalogue.html"
    }

    @GetMapping("/catalogue")
    public String liste(Model model) {
        model.addAttribute("liste", services.selectionN());
        return "catalogue"; // charge le fichier "catalogue.html"
}

    @GetMapping("/ajouter")
    public String ajouter(@ModelAttribute("catalogue") Catalogue catalogue, Model model) {
        model.addAttribute("catalogue", services.ajouterCatalogue(catalogue));
        return "redirect:/catalogue";
    }

    @GetMapping("/index")
    public String indexString(Model model) {
        return "index"; // charge le fichier "index.html"
    }
    @GetMapping("/accueil")
    public String accString(Model model) {       
        return "accueil";
    }

}