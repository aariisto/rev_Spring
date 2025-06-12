//java

String = "yannel,habin"
Straing tab[] = String.split(","); // [yannel, habin]

String a = " yannel et habib ";
a.trim(); // "yannel et habib";

lE STABLAUX CLASSIQUES : tb[]
int tab1[];
int [] tab2;
tab1= new int[4]; // tableau de 4 entiers
tab1 = new int[] {4, 2}; // tableau de 2 entiers
int tab1[] = {5, 5}; // tableau de 2 entiers initialisés
access au tableau : tab1[0] = 5; // affectation
parcours d'un tableau :

for (int i = 0; i < tab1.length; i++) {
System.out.println(tab1[i]);
}

Tablaux particuliers : vecteur, ArrayLista
creation d'un ArrayList de String: ArrayList<String> liste = new ArrayList<String>(); // O(n)
ArrayList liste = new ArrayList(); // sans type
liste.add(0,"a"); // ajout d'un élément
liste.remove(0); // suppression d'un élément
liste.size(); // taille du tableau
liste.get(0); // accès à l'élément d'indice 0
parcours d'un ArrayList :

for (int i = 0; i < liste.size(); i++) {
System.out.println(liste.get(i));
}

for (String s : liste) {
System.out.println(s);
}

Tablaux Interface : HashSet, TreeSet ecrassement de la valeur si existe déjà
HashSet = tableaux de hashage O(1) // pas trié
TreeSet = tableau trié (arbre binaire de recherche) O(log n)

HashSet<String> liste = new HashSet<String>();
liste.add("a"); // ajout d'un élément
liste.remove("a"); // suppression d'un élément
liste.contains("a"); // vérification de la présence d'un élément
liste.get("a"); // accès à l'élément
liste.size(); // taille du tableau
parcours d'un HashSet :

for (String s : liste) {
System.out.println(s);
}

HashMap TreeMap : ecrassement de la valeur si la clé existe déjà
HashMap<String, String> liste = new HashMap<String, String>();
liste.put("a", "b"); // ajout d'un élément
liste.remove("a"); // suppression d'un élément
liste.get("a"); // accès à l'élément
liste.containsKey("a"); // vérification de la présence d'une clé
liste.keySet(); // accès aux clés

for (String key : liste.keySet()) {
System.out.println(key + " : " + liste.get(key));
}

Lecture d'un fichier texte en Java :

```java
try {
    InputStream inStream = new FileInputStream("donnee.txt");
    InputStreamReader streamReader = new InputStreamReader(inStream);
    BufferedReader reader = new BufferedReader(streamReader);
    String ligne;
    while ((ligne = reader.readLine()) != null) {
        System.out.println(ligne);
    }
    reader.close();
} catch (Exception x) {
    System.out.println("Erreur d'ouverture du fichier : " + x.getMessage());
}
```

=================================================

Ecriture dans un fichier texte en Java :

```java
try {
    OutputStream outStream = new FileOutputStream("donnee.txt", true);
    OutputStreamWriter streamWriter = new OutputStreamWriter(outStream);
    String donnee = "Data , newdata\n";
    streamWriter.write(donnee);
    streamWriter.close();
} catch (Exception x) {
    System.out.println("Erreur d'ouverture du fichier : " + x.getMessage());
}
```

======================================================================================================================================================================================================================================================================================================

build.gradle : fichier specifique à Gradle pour la configuration du projet Java - Bibliotheques, dépendances, plugins, etc.

appli.properties : fichier de configuration de l'application Spring Boot - Port, nom de l'application, variable, etc.

AnnotationApplication : classe principale de l'application Spring Boot - Annotation @SpringBootApplication, méthode

Controler : classe de contrôleur Spring Boot - Annotation @RestController, méthode @GetMapping, etc.

````java
@RestController
public class ImplementationCtrl implements InterfaceCtrl{
    @Value("${message}")
    private String message;

    private ArrayList<Joueur> listeJoueurs;
    ...... // Initialisation de la liste de joueurs

```java
    @GetMapping("/joueurs")
    public ArrayList<Joueur> getJoueurs() {
        return listeJoueurs;
    }

    @GetMapping("/message")
    public String getMessage() {
        return message;
    }
}
````

```java
  @Value("${message}")
    private String message;
    // Injection de la variable message depuis le fichier application.properties
```

```java
    @GetMapping("/bienvenue/{nom}")
    public String nom (@PathVariable String nom){
        System.out.println("nom = " + nom);
        return message+ " : " + nom;
    }
    // Méthode pour afficher un message de bienvenue avec le nom passé en paramètre
```

```java
@Data
public class Joueur {
    private String nom;
    private String equipier;
    private String contact;
    private ArrayList<Joueur> ArrayJoueur;
    // @Data est une annotation Lombok qui génère automatiquement les getters, setters, toString

    // Joueur.getNom()
```

```java
// application.properties :
iut=IUT de Vannes

// dans une class :
    @Value("${iut}")
    private String iut; // IUT de Vannes
```

==================================================================================================================================================================================

```java
@Service
@ComponentScan("fr.info")
public class Services {
    private List<Catalogue> catalogues = new ArrayList<>();
    public Catalogue selection() {
        Catalogue catalogue = new Catalogue();
        catalogue.init("Astérix, Le Bouclier Arverne", "R. Goscinny, A. Uderzo", "bande dessinée");
        return catalogue;
    }
    // @Service est une annotation Spring qui indique que cette classe est un service
    // service est une classe qui contient la logique métier de l'application
    // @ComponentScan est une annotation Spring qui permet de scanner les classes dans le package spécifié
```

```java
 @Autowired
    public Controleur(Services services) {
        this.services = services;
    }
    //autowired est une annotation Spring qui permet d'injecter une dépendance dans une classe , comme faire un new
```

```java
    @GetMapping("/selection") // => localhost:8090/selection
    public String selection(Model model) {
        model.addAttribute("menu", "selection"); // Update the menu attribute to "selection"
        model.addAttribute("catalogue", services.selection());
        return "catalogue"; // charge le fichier "catalogue.html"
    }

    // Model est un objet Spring qui permet de passer des données à la vue
    // model.addAttribute("catalogue", services.selection()) : injecte le catalogue sélectionné dans le modèle

```

```html
<link rel="stylesheet" type="text/css" th:href="@{/css/catalogue.css}" />

// th:href="@{/css/catalogue.css}" : permet de lier le fichier CSS catalogue.css
à la vue
```

```html
<span
  class="attributtexte"
  th:text="*{catalogue.getTitre()}"
  name="titre"
></span>
# th:text="*{catalogue.getAuteur()}" : receper le titre du catalogue ett
afficher dans la vue
```

```html
                <span th:if="${catalogue != null}">
                <span class="attributtexte" th:text="*{catalogue.getTitre()}" name="titre"></span>
            </div>
            </span>
            th:if ="${catalogue != null}" : vérifie si le catalogue n'est pas nul avant d'afficher les attributs
```

```html
<tbody>
  <tr th:each="catalogue : ${liste}">
    <td th:text="*{catalogue.getTitre()}" name="id_titre"></td>
    <td th:text="*{catalogue.getAuteur()}" name="id_auteur"></td>
    <td th:text="*{catalogue.getCategorie()}" name="id_categorie"></td>
  </tr>
</tbody>
th:each="catalogue : ${liste}" : permet de parcourir la liste des catalogues et
d'afficher les attributs dans le tableau
```

```java
    @GetMapping("/ajouter")
    public String ajouter(@ModelAttribute("catalogue") Catalogue catalogue, Model model) {
        model.addAttribute("catalogue", services.ajouterCatalogue(catalogue));
        return "redirect:/catalogue";
    }
    // @ModelAttribute("catalogue") Catalogue catalogue : permet de récupérer les données du formulaire et de les injecter dans l'objet Catalogue
```

```html
<form th:action="@{/ajouter}" th:object="${catalogue}" method="GET">
  <span>Titre :</span>
  <input
    class="titre"
    type="text"
    th:value="${titre}"
    placeholder="Entrez le texte"
    name="titre"
  />

  <span>Auteur :</span>
  <input
    class="auteur"
    type="text"
    th:value="${auteur}"
    placeholder="Qui est l’auteur ?"
    name="auteur"
  />

  <span>Categorie :</span>
  <input
    class="categorie"
    type="text"
    th:value="${categorie}"
    placeholder="Quelle categorie ?"
    name="categorie"
  />

  <input type="submit" value="Ajouter" />
</form>

// th:action="@{/ajouter}" : permet de spécifier l'URL de la requête GET pour
ajouter un catalogue // th:object="${catalogue}" : permet de lier l'objet
Catalogue au formulaire // th:value="${titre}" : permet de pré-remplir le champ
titre avec la valeur de l'attribut titre de l'objet Catalogue
```

```java
    @GetMapping("/ajouter")
    public String ajouter(@ModelAttribute("catalogue") Catalogue catalogue, Model model) {
        model.addAttribute("catalogue", services.ajouterCatalogue(catalogue));
        return "redirect:/catalogue";
    }
    // redirect:/catalogue : redirige vers la la route "/catalogue" après l'ajout du catalogue
```

```html
<a
  th:href="@{/accueil}"
  type="submit"
  class="btn btn-light btn-lg btn-outline-dark px-2"
  target="iframe_a"
  role="button"
  >Accueil</a
>
* th:href="@{/accueil}" : permet de spécifier l'URL de la requête GET pour
afficher la page d'accueil
```

```java
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("menu", menu); // Add the global variable to the model
    }
    // @ModelAttribute : permet d'ajouter des attributs au modèle avant l'exécution de la méthode
```
