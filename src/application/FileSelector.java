package application;

import javafx.scene.control.DialogPane;
import java.io.File;
import java.util.ArrayList;

public class FileSelector extends DialogPane 
{
	private String currentDirectory = null ;
	private ArrayList<String> listContent;
	private ArrayList<String> listParentDirectories;
	
	public FileSelector()
	{
		super();
		listParentDirectories = new ArrayList<>();
		listContent = new ArrayList<>();
	}
	
	/**
	 * Cette m�thode permet de r�cup�rer l'ensemble des dossiers parents
	 * d'un dossier courant.
	 * @param path Le chemin vers le dossier courant
	 * @return La liste des dossiers parents
	 */
	public ArrayList<String> getListParentDirectories(String path)
	{
		//On cr�e le dossier � partir du chemin pass� en param�tre
		File pathDirectory = new File(path);
		
		//S'il n'existe aucun dossier correspondant � ce chemin
		if (!pathDirectory.exists() || !pathDirectory.isDirectory())
		{
			return null ;
		}
		
		//Si un dossier existe, on le d�finit comme dossier courant 
		currentDirectory = pathDirectory.getAbsolutePath();
		
		String parentDirectoryPath = "";
		listParentDirectories.clear();
		
		//On divise le chemin gr�ce � un s�parateur
		String[] directories = path.split("\\"+File.separator); //Version Windows
		//String[] directories = path.split(File.separator); //Version Mac/Linux
		
		//On r�cup�re les dossiers parents en ajoutant les �l�ments du chemin au fur et � mesure
		for (String directory : directories)
		{
			parentDirectoryPath += directory + File.separator;
			listParentDirectories.add(parentDirectoryPath);
		}
		
		return listParentDirectories;
	}
	
	/**
	 * Cette m�thode permet de r�cup�rer l'ensemble des �l�ments
	 * pr�sents dans un dossier courant.
	 * @param path Le chemin vers le dossier courant
	 * @return La liste des �l�ments pr�sents dans le dossier courant
	 */
	public ArrayList<String> getContent(String path)
	{
		//On cr�e le dossier � partir du chemin pass� en param�tre
		File pathDirectory = new File(path);
		
		//S'il n'existe aucun dossier correspondant � ce chemin
		if (!pathDirectory.exists() || !pathDirectory.isDirectory())
		{
			return null ;
		}
		
		//Si un dossier existe, on le d�finit comme dossier courant 
		currentDirectory = pathDirectory.getAbsolutePath();
		
		//On liste les �l�ments du dossier
		String[] files = pathDirectory.list() ;
		
		if (files != null)
		{
			listContent.clear();
			
			//On parcourt les �l�ments du dossier
			for(int i=0; i<files.length; i++)
			{
				File file = new File(path, files[i]);
				
				//Si l'�l�ment est un dossier, on ajoute un s�parateur
				if (file.isDirectory())
				{
					files[i] = files[i] + File.separator;
					listContent.add(file.getName()+ File.separator);
				}
				else if(file.isFile())
				{
					listContent.add(file.getName());
				}
			}
		}
		
		return listContent;
	}
}