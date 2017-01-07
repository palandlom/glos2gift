package ru.arcticsu.moodle.glo2ast.app.view;

import java.io.File;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import ru.arcticsu.moodle.glo2ast.app.MainApp;
import ru.arcticsu.moodle.glo2ast.tool.Glossary;


public class RootController
{
	private MainApp mainApp;

	@FXML
	private void initialize()
	{
	}

	/* =======Handlers========= */
	/** == Opens an about dialog. */
	@FXML
	private void handleAbout()
	{
	    /*
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("О программе");
		alert.setHeaderText("Information Alert");

		String s = "This is an example of JavaFX 8 Dialogs... ";
		alert.setContentText(s);
		alert.show();
		*/
	}

	/* === Closes the application. */
	@FXML
	private void handleExit()
	{

		System.exit(0);
	}

	/**
	 * Обработчик открытия файла.
	 */
	@FXML
	private void handleLoadFile()
	{
		
	}
	
	
	public void setSizeBinding()
	{
	    
	}
	

	/*========GET/SETesers===============================*/
	
	public void setMainApp(MainApp mainApp)
	{
		this.mainApp = mainApp;
	}

	public MainApp getMainApp()
	{
		return mainApp;
	}

}
