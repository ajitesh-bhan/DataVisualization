package fr.epita.ajitesh.csvdata;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		//AgeGroupANdSexData agesex=new AgeGroupANdSexData(stage);
		//PclassAndSexWiseVisualization pclass=new PclassAndSexWiseVisualization(stage);
		//AgeWiseFare agefare=new AgeWiseFare(stage);
		PclassSexAgeWiseSurvival pagesex=new PclassSexAgeWiseSurvival(stage);
		
	}

	public static void main(String[] args) {
		launch(args);
		
	}
}
