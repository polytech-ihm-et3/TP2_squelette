Programmation Java @ Et3
<br>
Polytech Paris-Saclay | 2020-21

___

# TP1

L'objectif de ce TP est de créer un sélecteur de fichiers, avec une interface proche de la figure suivante :

<br><div align="center"><img src="images/fileselector.jpg" width="150"></img></div><br>

L'interface de ce sélecteur de fichier doit contenir : 
  - un menu déroulant (cf. [*ComboBox*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ComboBox.html)), contenant une liste de tous les dossiers parents du dossier courant;
  - une liste navigable (cf. [*ListeView*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ListView.html)), qui montre le contenu du dossier courant (les noms des sous-dossiers sont suivis pas un slash `/`); 
  - deux boutons (cf. [*Button*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html)), "Cancel" (pour fermer l'application) et "Open" (pour ouvrir un dossier sélectionné).

<br><div align="center"><img src="images/tempconvH.jpg" width="300"></img></div><br>

1. Télécharger [*Scene Builder*](https://gluonhq.com/products/scene-builder/). Ce programmee permet de creer des fenêtres JavaFX plus facilement.

> Une fois le programme téléchargé, une simple manipuulation vous permet de l'appeler depuis votre IDE.

> Pour associer *Scene Builder* à Eclipse, suivez les étapes suivantes :
>   1) Ouvrez la fenêtre des préférences (*Window* > *Preferences*);
>   2) Sélectionnez l'onglet *JavaFX*;
>   3) Dans *SceneBuilder executable*, entrez le chemin jusqu'à l'éxécutable de *Scene Builder*;
>   4) Validez en cliquant sur *Apply and Close*;
>   
> Il vous suffira alors d'effectuer un clic droit sur un fichier *fxml*, puis de cliquer sur *Open with SceneBuilder* pour éditer votre fichier avec *Scene Builder*.

> Pour associer *Scene Builder* à IntelliJ, suivez les étapes suivantes :
>   1) Ouvrez la fenêtre des paramètres (*File* > *Settings...*);
>   2) Sélectionnez l'onglet *Languages & Frameworks*, puis l'onglet *JavaFX*;
>   3) Dans *Path to SceneBuilder:*, entrez le chemin jusqu'à l'éxécutable de *Scene Builder*;
>   4) Validez en cliquant sur *Apply*, puis sur *OK*;
>   
> Il vous suffira alors d'effectuer un clic droit sur un fichier *fxml*, puis de cliquer sur *Open In SceneBuilder* pour éditer votre fichier avec *Scene Builder*.

2. Créez un projet javaFX.

> Dans Eclipse, allez dans *File* > *New* > *Project...* et selectionnez *JavaFX Project*, dans le répertoire "JavaFX".

> Dans IntelliJ, allez dans *File* > *New* > *Project...* et selectionnez *JavaFX Application*, dans l'onglet "JavaFX".

3. Créez un nouveau fichier "window.fxml", puis éditez-le avec *Scene Builder*. Créez alors votre fenêtre pour qu'elle ressemble au maximum à l'image présentée ci-dessus (Vous pouvez vous aider de ce [*tutoriel*]()).

4. Ajoutez une classe "Controller à votre projet et déclarez celle-ci comme étant le controlleur du fichier *fxml*" "controller" comme controlleur de votre application.
{ Donner un fx:id au dierente parties composant votre Vue (boutton,
comboBox, etc..).

3. Assurez-vous que les éléments graphiques sont correctement alignés et que leurs positions sont cohérentent avec la photo suivante lorsque vous changez la taille de la fenêtre.

<br><div align="center"><img src="images/tempconvV.jpg" width="150"></img></div><br>

4. Le `textFieldCListener` réalise les actions suivantes si l'utilisateur appuie sur la touche *ENTRÉE*, alors que le focus est sur textFieldC :

 - lire la valeur indiquée dans le champs de texte correspondant à la valeur en *Celsius*;
 - transformer cette valeur en float (attention à la gestion des exceptions !);
 - convertir cette valeur en *Fahrenheit*;
 - écrire cette nouvelle valeur dans le champs de texte correspondant à la valeur en *Fahrenheit*.

    Associez le `textFieldCListener` au champs de texte correspondant à la valeur en *Celsius*.

> Ici, le listener en question surveille les touches du clavier. Il s'agit donc d'un [*EventHandler*](https://docs.oracle.com/javase/8/javafx/api/javafx/event/EventHandler.html) qui surveille les [*KeyEvents*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/KeyEvent.html). On peut créer ce listener en utilisant :
> ```Java
> textFieldFListener = new EventHandler<KeyEvent>() 
> {
>    @Override
>    public void handle(KeyEvent e) 
>    {
>       //Ce que fait le listener en cas de KeyEvent
>    }
> ```
> Pour associer un Listener à un champs de texte, vous pouvez utiliser la méthode [*setOnKeyPressed*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Node.html#setOnKeyPressed-javafx.event.EventHandler-).

5. Implémentez le `textFieldFListener` pour qu'il réalise les actions suivantes si l'utilisateur appuie sur la touche *ENTRÉE*, alors que le focus est sur textFieldF :

 - lire la valeur indiquée dans le champs de texte correspondant à la valeur en *Fahrenheit*;
 - transformer cette valeur en float (attention à la gestion des exceptions !);
 - convertir cette valeur en *Celsius*;
 - écrire cette nouvelle valeur dans le champs de texte correspondant à la valeur en *Celsius*.

    Associez le `textFieldFListener` au champs de texte correspondant à la valeur en *Fahrenheit*.

6. Le `buttonCloseListener` quitte l'application . Associez-le au bouton *Close*.

> Ici, le listener en question surveille l'action liée à un bouton. Il s'agit donc d'un [*EventHandler*](https://docs.oracle.com/javase/8/javafx/api/javafx/event/EventHandler.html) qui surveille les [*ActionEvents*](https://docs.oracle.com/javase/8/javafx/api/javafx/event/ActionEvent.html).

7. Implémentez le `buttonResetListener` pour qu'il vide les deux champs de texte. Associez-le au bouton *Reset*.

8. (Bonus) Associez un [*TextFormatter*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextFormatter.html) aux deux champs de texte pour qu'ils n'acceptent que des entrées valides (e.g. 23, 23.345, -21, 3E -02).
