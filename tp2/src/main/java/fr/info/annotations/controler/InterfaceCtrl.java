package fr.info.annotations.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import fr.info.annotations.modele.Joueur;
public interface InterfaceCtrl {
    @GetMapping("/bienvenue")
        public String bienvenue();
    @GetMapping("/bienvenue/{nom}")
        public String nom (@PathVariable String nom);
    @GetMapping("bienvenue/joueur/{nom}")
        public Joueur joueur(@PathVariable String nom);

}

