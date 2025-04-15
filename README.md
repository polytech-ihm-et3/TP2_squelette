Programmation Java @ Et3\
Polytech Paris-Saclay | 2024-25
___

# TP2

L'objectif de ce TP est de créer un sélecteur de fichiers, avec une interface proche de la figure suivante :

<br><div align="center"><img src="images/fileselector.jpg" width="150"></img></div><br>

L'interface de ce sélecteur de fichier doit contenir : 
  - un menu déroulant (cf. [*ComboBox*](https://openjfx.io/javadoc/17/javafx.controls/javafx/scene/control/ComboBox.html)), contenant une liste de tous les dossiers parents du dossier courant.
  - une liste navigable (cf. [*ListView*](https://openjfx.io/javadoc/17/javafx.controls/javafx/scene/control/ListView.html)), qui montre le contenu du dossier courant (les noms des sous-dossiers sont suivis pas un slash `/`). 
  - deux boutons (cf. [*Button*](https://openjfx.io/javadoc/17/javafx.controls/javafx/scene/control/Button.html)), "Cancel" (pour fermer l'application) et "Open" (pour ouvrir un dossier sélectionné).

---

1. [*Scene Builder*](https://gluonhq.com/products/scene-builder/) est un programme permet de créer des fenêtres JavaFX plus facilement. Suivez ces instructions (https://github.com/polytech-ihm-et3/HowToUseSceneBuilderWithIDE) pour l'installer et le configurer avec votre IDE.

2. Clonez ce projet et configurez votre IDE de la même manière que le TP1, en suivant les instructions sur https://github.com/polytech-ihm-et3/HowToUseJavaFxWithIDE.

    **Il est normal que le projet ne compile pas pour l'instant car *window.fxml* est vide**.

    Le projet est structuré ainsi :
   - les fichiers de code sont localisés dans le dossier *src/main/java/application*, dans lequel il y a deux fichiers :
     - *Main.java*, qui est le point d'entrée de l'application JavaFX et qui contient le code minimal pour charger le graphe de scène de l'application (précisé dans *window.fxml*) et l'afficher.
     - *FileSelector.java*, qui vous servira plus tard dans le TP.
   - les fichiers utilisés par le code, qui ne sont pas des fichiers Java sont localisés dans le dossier *src/main/resources/application*, dans lequel il y a un fichier :
     - *window.fxml*, qui contient le graphe de scène de l'application (pour l'instant vide).

3. Éditez le fichier *window.fxml* avec *Scene Builder*. Créez alors votre fenêtre pour qu'elle ressemble au maximum à l'image présentée ci-dessus (Vous pouvez vous aider du tutoriel dans le dossier *slides*).

4. Ajoutez une classe "*Controller*" à votre projet et déclarez celle-ci comme étant le contrôleur du fichier *fxml*.

    > Créez une classe "*Controller*" et liez les éléments modifiables de l'interface à des attributs de cette classe en utilisant l'annotation [*@FXML*](https://docs.oracle.com/javafx/2/get_started/fxml_tutorial.htm). Les noms des attributs doivent correspondre aux noms indiqués dans les champs *fx:id*, lors de la création de la fenêtre. Il vous faudra aussi lier une méthode "*Initialize()*".
    > Ajoutez un champ *fx:controller="[chemin jusqu'au].Controller"* à l'intérieur de la balise correspondant au [*Pane*](https://openjfx.io/javadoc/17/javafx.graphics/javafx/scene/layout/Pane.html) principal (Vous pouvez vous aider du tutoriel dans le dossier *slides*).

5. Examinez le contenu du fichier *FileSelector.java*.

    > On remarquera que la classe *FileSelector* possède deux méthodes intéressantes :
    >   - La méthode *getListParentRepositories(String path)* : cette méthode renvoie une [*ArrayList*](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ArrayList.html) contenant les chemins des dossiers parents d'un dossier courant, indiqué en paramètre. Par exemple, pour un dossier *C:\rep1\rep2\rep3\*, la méthode renverra les chemins suivants : *C:\*, *C:\rep1\* et *C:\rep1\rep2\*
    >   - La méthode *getContent(String path)* : cette méthode renvoie une [*ArrayList*](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ArrayList.html) contenant les différents éléments présents dans un dossier courant, indiqué en paramètre.

6. Implémentez dans la méthode *initialize()* ce à quoi ressemblent le menu déroulant (combo box) et la liste navigable (view list) au démarrage de l'application (à savoir qu'ils indiquent le dossier de l'utilisateur actuel de l'ordinateur, obtenable avec `System.getProperty("user.home")`).

7. En modifiant la méthode "*initialize()*", faites en sorte que lorsque l'utilisateur sélectionne un dossier dans le menu déroulant (combo box), la liste navigable et le menu déroulant se mettent bien à jour (ils doivent alors représenter le nouveau dossier courant).

8. Faites en sorte que le bouton "*Open*" ne soit cliquable qu'à condition que l'un des éléments de la liste navigable soit sélectionné.

9. Assurez-vous que, si l'utilisateur clique sur le bouton "*Cancel*", la fenêtre se ferme.

10. Faites en sorte qu'après avoir sélectionné un élément de la liste navigable, un clic sur le bouton "*Open*" déclenche une des actions suivantes :
    - si l'élément sélectionné est un répertoire : celui-ci devient le répertoire courant. L'interface doit alors se mettre à jour.
    - si l'élément sélectionné n'est pas un répertoire (si c'est un fichier par exemple) : aucun effet.

11. Améliorez votre implémentation pour qu'un double clic sur un élément de la liste navigable ait le même effet qu'un clic sur le bouton "Open", après avoir sélectionné ce même élément.