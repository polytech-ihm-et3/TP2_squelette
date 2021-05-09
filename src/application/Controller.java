package application;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class Controller 
{
	@FXML
    private Button btnCancel;

    @FXML
    private Button btnOpen;

    @FXML
   private  ListView listViewFile;

    @FXML
   private ComboBox<String> comboxRep;
    
    private FileSelector fileSelector = new FileSelector();
    
    @FXML
    public void initialize()
    {
    	//Obtenir le chemin vers le repertoire "home" de l'utilisateur
    	String path = System.getProperty("user.home");

    	//Mettre à jour la ComboBox
        majComboBox(path);
        
    	//Mettre à jour la ListView
    	majListView(path);
    	
    	//Créer un EventListener pour la sélection d'un répertoire dans la ComboBox
    	comboxRep.setOnAction(event ->  
    	{
    		majListView(comboxRep.getSelectionModel().getSelectedItem());
        });
    	
    	//Créer un EventListener pour la selection d'un item dans la ListView
    	listViewFile.setOnMouseClicked(event ->  
    	{
    		//Activer le Bouton "Open"
    		btnOpen.setDisable(false);
    		
    		if(event.getClickCount() == 2)
    		{
                btnOpen.fire();
            }
        });
    	
    	//Créer un EventListener pour le clic sur le Bouton "Cancel"
    	btnCancel.setOnAction(event ->  
    	{
    		System.exit(0);
        });
    	
    	//Créer un EventListener pour le clic sur le Bouton "Open"
    	btnOpen.setOnAction(event ->  
    	{
    		//Récupérer l'élément que l'on souhaite ouvrir
    		File element = new File(comboxRep.getValue() + listViewFile.getSelectionModel().getSelectedItem());
    		
    		//Si l'élément est un fichier
    		if(element.isFile())
    		{
    			//Faire quelque chose
    		}
    		else if(element.isDirectory())
    		{
    			majComboBox(element.getAbsolutePath());
    		}
    		else
    		{
    			//Faire quelque chose
    		}
        });
    }
    
    //Mettre à jour la ComboBox
    public void majComboBox(String path)
    {
    	//Récupérer les repertoires à afficher dans la ComboBox
		ObservableList<String> itemsComboRep =  FXCollections.observableArrayList(fileSelector.getListRepParent(path));
		
		//Changer les items de la ComboBox
		comboxRep.setItems(itemsComboRep);
		
		//Selectionner un item pour l'initialisation
		comboxRep.getSelectionModel().selectLast();
    }
    
    //Mettre à jour la ListView
    public void majListView(String path)
    {
    	if (comboxRep.getSelectionModel().getSelectedItem() != null )
    	{
	    	//Récupérer les éléments à afficher dans la ListView
			ObservableList<String> itemsListView = FXCollections.observableArrayList(fileSelector.getListFile(path));
			
			//Changer les items de la ListView
			listViewFile.setItems(itemsListView);
			
			//Desactiver le Bouton "Open"
	    	btnOpen.setDisable(true);
    	}	
    }

}
