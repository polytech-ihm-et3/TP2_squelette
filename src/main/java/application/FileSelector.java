package application;

import javafx.scene.control.DialogPane;
import java.io.File;
import java.util.ArrayList;

public class FileSelector extends DialogPane {
	private ArrayList<String> listContent;
	private ArrayList<String> listParentDirectories;

	public FileSelector() {
		super();
		listParentDirectories = new ArrayList<>();
		listContent = new ArrayList<>();
	}

	/**
	 * Cette méthode permet de récupérer l'ensemble des dossiers parents
	 * d'un dossier courant.
	 * 
	 * @param path Le chemin vers le dossier courant
	 * @return La liste des dossiers parents
	 */
	public ArrayList<String> getListParentDirectories(String path) {
		// On crée le dossier à partir du chemin passé en paramètre
		File pathDirectory = new File(path);

		// S'il n'existe aucun dossier correspondant à ce chemin
		if (!pathDirectory.exists() || !pathDirectory.isDirectory()) {
			return null;
		}

		String parentDirectoryPath = "";
		listParentDirectories.clear();

		// On divise le chemin grâce à un séparateur
		String[] directories = path.split("\\" + File.separator); // Version Windows
		// String[] directories = path.split(File.separator); // Version Mac/Linux

		// On récupère les dossiers parents en ajoutant les éléments du chemin au fur et
		// à mesure
		for (String directory : directories) {
			parentDirectoryPath += directory + File.separator;
			listParentDirectories.add(parentDirectoryPath);
		}

		return listParentDirectories;
	}

	/**
	 * Cette méthode permet de récupérer l'ensemble des éléments
	 * présents dans un dossier courant.
	 * 
	 * @param path Le chemin vers le dossier courant
	 * @return La liste des éléments présents dans le dossier courant
	 */
	public ArrayList<String> getContent(String path) {
		// On crée le dossier à partir du chemin passé en paramètre
		File pathDirectory = new File(path);

		// S'il n'existe aucun dossier correspondant à ce chemin
		if (!pathDirectory.exists() || !pathDirectory.isDirectory()) {
			return null;
		}

		// On liste les éléments du dossier
		String[] files = pathDirectory.list();

		if (files != null) {
			listContent.clear();

			// On parcourt les éléments du dossier
			for (int i = 0; i < files.length; i++) {
				File file = new File(path, files[i]);

				// Si l'élément est un dossier, on ajoute un séparateur
				if (file.isDirectory()) {
					files[i] = files[i] + File.separator;
					listContent.add(file.getName() + File.separator);
				} else if (file.isFile()) {
					listContent.add(file.getName());
				}
			}
		}

		return listContent;
	}
}