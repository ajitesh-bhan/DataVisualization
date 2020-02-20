package fr.epita.ajitesh.csvdata;

import java.util.List;
import java.util.stream.Collectors;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PclassAndSexWiseVisualization {
	
public PclassAndSexWiseVisualization(Stage stage) throws Exception {
		// Pclass And Sex Wise Total No Of People
		stage.setTitle("Area Chart Sample");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> ac =   new BarChart<String,Number>(xAxis,yAxis);
        ac.setTitle("Pclass Wise Male And Female");
        xAxis.setLabel("Pclass");
		yAxis.setLabel("Total Number");
        XYChart.Series seriesmale= new XYChart.Series();
        seriesmale.setName("Male");
        ReadCSV dao = new ReadCSV();
        List<CSVData> listData = dao.readAll();
      
        List<CSVData> maleSurvivaloneclass = listData.stream()
			    .filter(fetching_data -> fetching_data.getPclass() == 1 && fetching_data.getSex().equals("male")).collect(Collectors.toList());
        
        List<CSVData> maleSurvivaltwoclass = listData.stream()
			    .filter(fetching_data -> fetching_data.getPclass() == 2 && fetching_data.getSex().equals("male")).collect(Collectors.toList());
        
        List<CSVData> maleSurvivalthreeclass = listData.stream()
			    .filter(fetching_data -> fetching_data.getPclass() == 3 && fetching_data.getSex().equals("male")).collect(Collectors.toList());
        
        seriesmale.getData().add(new XYChart.Data("1", maleSurvivaloneclass.size()));
        seriesmale.getData().add(new XYChart.Data("2",maleSurvivaltwoclass.size()));
        seriesmale.getData().add(new XYChart.Data("3", maleSurvivalthreeclass.size()));
       
        
        List<CSVData> femaleSurvivaloneclass = listData.stream()
			    .filter(fetching_data -> fetching_data.getPclass() == 1 && fetching_data.getSex().equals("female")).collect(Collectors.toList());
        
        List<CSVData> femaleSurvivaltwoclass = listData.stream()
			    .filter(fetching_data -> fetching_data.getPclass() == 2 && fetching_data.getSex().equals("female")).collect(Collectors.toList());
        
        List<CSVData> femaleSurvivalthreeclass = listData.stream()
			    .filter(fetching_data -> fetching_data.getPclass() == 3 && fetching_data.getSex().equals("female")).collect(Collectors.toList());
        
        
        
        XYChart.Series seriesFemale = new XYChart.Series();
        seriesFemale.setName("Female");
        seriesFemale.getData().add(new XYChart.Data("1", femaleSurvivaloneclass.size()));
        seriesFemale.getData().add(new XYChart.Data("2", femaleSurvivaltwoclass.size()));
        seriesFemale.getData().add(new XYChart.Data("3", femaleSurvivalthreeclass.size()));
        
        
  
        
        Scene scene  = new Scene(ac,800,600);
        ac.getData().addAll(seriesmale,seriesFemale);
        stage.setScene(scene);
        stage.show();
		
	}

}
