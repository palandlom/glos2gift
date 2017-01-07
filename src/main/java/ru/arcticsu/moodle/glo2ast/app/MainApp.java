package ru.arcticsu.moodle.glo2ast.app;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ru.arcticsu.moodle.glo2ast.app.view.ConverterConfController;
import ru.arcticsu.moodle.glo2ast.app.view.RootController;

public class MainApp extends Application
{
	Stage primaryStage;
	BorderPane rootView;
	AnchorPane modBranchView;
	AnchorPane chooserAxView;

	RootController rootController;
	ConverterConfController converterConfController;

	private static final Logger LOGGER = LoggerFactory.getLogger(MainApp.class);

	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Gloss2Gift");
			this.primaryStage.sizeToScene();

			/* «агружам корневой вид и подвид.. */
			initRootLayout();
			initChooserAxView();

			// √рузим иконку...
			this.primaryStage.getIcons().add(new Image(MainApp.class.getResourceAsStream("/icon.png")));

			Scene scene = new Scene(this.rootView);
			this.rootView.setCenter(this.chooserAxView);

			// √рузим оформление...
			scene.getStylesheets().add(MainApp.class.getResource("/application.css").toExternalForm());

			/* —в€зываем размеры корневого ла€ута с его дочерним... */
			this.bindRootLayaoutMinSizeWith(this.chooserAxView);

			this.primaryStage.setScene(scene);
			this.primaryStage.show();

			/* —в€зываем размеры стейджа с размерами корневого ла€ута... */
			primaryStage.minHeightProperty()
					.bind(this.rootView.minHeightProperty());
			primaryStage.minWidthProperty()
					.bind(this.rootView.minWidthProperty());
			// this.rootView.setMinSize(1000, 1000);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		launch(args);
	}

	public Icon loadIcon()
	{
		// Get current classloader
		ClassLoader cl = this.getClass().getClassLoader();
		// Create icons
		URI fileURI = null;
		try
		{
			fileURI = cl.getResource("resources/icon.png").toURI();
		} catch (URISyntaxException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ImageIcon(fileURI.toString());
	}

	public void initRootLayout()
	{
		try
		{
			// 1 грузим файло с разметкой в лоадер
			FXMLLoader loader = new FXMLLoader();
			//loader.setLocation(MainApp.class.getResource("/RootView.fxml"));
			
			//loader.setLocation(MainApp.class.getResource("view/RootView.fxml"));
			loader.setLocation(MainApp.class.getResource("/fxml/RootView.fxml"));
			//loader.setLocation( getClass().getResource("/fxml/RootView.fxml"));

			/* 2 пинаем лоадер */
			this.rootView = (BorderPane) loader.load();

			/* Ќазначаем контроллер */
			this.rootController = loader.getController();
			this.rootController.setMainApp(this);

		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * —в€зывает размеры корневого ла€ута с переданным.
	 * 
	 * @param layout
	 */
	public void bindRootLayaoutMinSizeWith(Pane layout)
	{
		this.rootView.minWidthProperty().bind(layout.minWidthProperty());
		this.rootView.minHeightProperty().bind(layout.minHeightProperty());

	}

	public void initChooserAxView()
	{
		try
		{
			// 1 грузим файло с разметкой в лоадер
			FXMLLoader loader = new FXMLLoader();
			//loader.setLocation(MainApp.class.getResource("view/ConverterConfView.fxml"));
			loader.setLocation( getClass().getResource("/fxml/ConverterConfView.fxml"));
			
			/*
			 * 2 пинаем лоадер и (зна€ что он вернет Borderpane) преобразуем то,
			 * что он возвращает
			 */
			this.chooserAxView = (AnchorPane) loader.load();

			/* Ќазначаем контроллер */
			this.converterConfController = loader.getController();
			this.converterConfController.setMainApp(this);

		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * ”танавливает ла€ут в центре корневого
	 * 
	 * @param pane
	 */
	public void setCenterPane(Pane pane)
	{
		this.rootView.setCenter(pane);
	}

	public Stage getPrimaryStage()
	{
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
	}

	public RootController getRootController()
	{
		return rootController;
	}

	public void setRootController(RootController rootController)
	{
		this.rootController = rootController;
	}

	public ConverterConfController getChooserAxController()
	{
		return converterConfController;
	}

	public void setChooserAxController(
			ConverterConfController chooserAxController)
	{
		this.converterConfController = chooserAxController;
	}

	public BorderPane getRootView()
	{
		return rootView;
	}

	public void setRootView(BorderPane rootView)
	{
		this.rootView = rootView;
	}

	public AnchorPane getModBranchView()
	{
		return modBranchView;
	}

	public void setModBranchView(AnchorPane modBranchView)
	{
		this.modBranchView = modBranchView;
	}

	public AnchorPane getChooserAxView()
	{
		return chooserAxView;
	}

	public void setChooserAxView(AnchorPane chooserAxView)
	{
		this.chooserAxView = chooserAxView;
	}

}
