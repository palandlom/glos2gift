package ru.arcticsu.moodle.glo2ast.app.view;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import ru.arcticsu.moodle.glo2ast.app.MainApp;
import ru.arcticsu.moodle.glo2ast.tool.*;


public class ConverterConfController
{

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ConverterConfController.class);

	@FXML
	private Label glossLabel;
	
	@FXML
	private Label glossFilePathLabel;

	@FXML
	private Label testfileLabel;
	
	@FXML
	private Label testFilePathLabel;


	@FXML
	private CheckBox useMask;

	@FXML
	private CheckBox includeSynonyms;

	@FXML
	private Button openGlossFileButton;

	@FXML
	private Button genGiftTestButton;

	private MainApp MainApp;

	private File glossXMLFile;

	private Glossary gloss;

	// Таблица AllAxioms
	@FXML
	private void initialize()
	{
		this.genGiftTestButton.setDisable(true);
		
		

		/* Определяем обозреваемые источники данных для таблиц... */
		// this.branches = FXCollections.observableList(new
		// ArrayList<Branch>());

		/* Включаем множественный выбор в таблицах... */
		// this.allBranchesTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		// Определяем набор данных таблицы..
		// this.allBranchesTable.setItems(this.branches);

		// Определяем источник данных для колонки...
		// this.allBranchesColumn.setCellValueFactory(listItem -> new
		// ReadOnlyObjectWrapper<String>(listItem.getValue().toString()));

	}

	public void loadPatternBraches(File CDPfile)
	{
		/* Загружаем паттерн.. */
		// Ontology PatternOnt = new Ontology(CDPfile, true, true);

	}

	/* ====== HAndlers =============== */

	/**
	 * Обработчик открытия файла.
	 */
	@FXML
	private void handleLoadFile()
	{
		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter(
				"XML files (*.xml)", "*.xml");

		fileChooser.getExtensionFilters().addAll(filter);
		fileChooser.setInitialDirectory(new File("./"));

		File file = fileChooser
				.showOpenDialog(this.getMainApp().getPrimaryStage());
		this.setGlossXMLFile(file);

		/* Загружаем глоссарий.. */
		Glossary gloss = new Glossary(this.getGlossXMLFile());
		gloss.init();
		this.setGloss(gloss);

		this.glossLabel
				.setText("Glossariy have been loaded. Number of defenitions: "
						+ this.getGloss().getDefenitionSet().size());
		
		this.genGiftTestButton.setDisable(false);
		this.glossFilePathLabel.setText("Path: "+this.getFullRealFilePath(file));
	}
	
	
	private String getFullRealFilePath(File file)
	{
		try
		{
			return file.getCanonicalPath();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@FXML
	private void handleGenerateGIFTFile()
	{
		GiftTest gTest = new GiftTest(gloss.getOpenQuestionList());
		gTest.setUseMaskedAnswers(this.useMask.isSelected());
		gTest.setIncludeAliasAnswers(this.includeSynonyms.isSelected());
		
		String fileName = this.getGlossXMLFile().getName();
		fileName = fileName.substring(0, fileName.lastIndexOf('.'))+".gift";
		String giftFilePath = this.getGlossXMLFile().getParent() + fileName; 
		
		gTest.toFile(giftFilePath);
		this.testfileLabel.setText("File has been generated. Number of questions:"+gTest.getQuestions().size());
		
		this.testFilePathLabel.setText("Path: "+giftFilePath);
		

	}

	public MainApp getMainApp()
	{
		return MainApp;
	}

	public void setMainApp(MainApp mainApp)
	{
		MainApp = mainApp;
	}

	public File getGlossXMLFile()
	{
		return glossXMLFile;
	}

	public void setGlossXMLFile(File glossXMLFile)
	{
		this.glossXMLFile = glossXMLFile;
	}

	public Glossary getGloss()
	{
		return gloss;
	}

	public void setGloss(Glossary gloss)
	{
		this.gloss = gloss;
	}

}
