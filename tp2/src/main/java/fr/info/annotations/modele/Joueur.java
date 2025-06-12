package fr.info.annotations.modele;
import lombok.Data;
import java.util.ArrayList;

@Data
public class Joueur {
  
    @Value("${iut}")
    private String iut; // IUT de Vannes

    private String nom;
    private String equipier;
    private String contact;
    private ArrayList<Joueur> ArrayJoueur;

    public Joueur(String nom){
        this.nom = nom;

    }
    public Joueur(String nom, String equipier, String contact){
      this.nom = nom;
      this.equipier = equipier;
      this.contact = contact;
    }
    public Joueur(ArrayList <Joueur> ArrayJ){
      this.ArrayJoueur = ArrayJ;
    }

}
