package fr.info.annotations.controler;

import fr.info.annotations.modele.Joueur;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
public class ImplementationCtrl implements InterfaceCtrl{
    @Value("${message}")
    private String message;

    private ArrayList<Joueur> listeJoueurs;

    @GetMapping("/bienvenue")
        public String bienvenue(){
        return "bienvenue";
    }
    @GetMapping("/bienvenue/{nom}")
    public String nom (@PathVariable String nom){
        System.out.println("nom = " + nom);
        return message+ " : " + nom;
    }
    @GetMapping("bienvenue/joueur/{nom}")
    public Joueur joueur(@PathVariable String nom){
        Joueur joueur = new Joueur(nom);
        return joueur;
    }
    @GetMapping("bienvenue/joueur/{nom}/{equipier}/{contact}")
        public Joueur joueur(@PathVariable String nom, @PathVariable String equipier, @PathVariable String contact){
        Joueur joueur = new Joueur(nom,equipier,contact);
        return joueur;
    }

    public void init(){
        listeJoueurs = new ArrayList<>(); // Initialiser la liste
        String [] n = {"tom","olive","tintin","asterix","lucky lake"};
        String [] e = {"jerry","popeye","milou","obélix"};

        String [] c = {"tom.jerry@gmail.com","olive.popeye@gmail.com","tintin.milou@gmail.com","asterix.obelix@gmail.com"};
        
        int taille = Math.min(n.length, Math.min(e.length, c.length));
        for (int i = 0; i < taille; i++) {
            Joueur joueur = new Joueur(n[i], e[i], c[i]);
            this.listeJoueurs.add(joueur);
        }
   }

   @GetMapping("bienvenue/joueurs")
   public ArrayList<Joueur> liste(){
    this.init();
    return listeJoueurs;
   }
}

