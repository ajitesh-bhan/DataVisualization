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

public class PclassSexAgeWiseSurvival {
	
public PclassSexAgeWiseSurvival(Stage stage) throws Exception {
		// Pclass And Sex Wise Survival And Dead no of people
		stage.setTitle("Bar Chart Sample");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> barchart = 
            new BarChart<String,Number>(xAxis,yAxis);
        barchart.setTitle("Pclass And Age Group And Sex Wise Survival");
        
        xAxis.setLabel("Pclass");
        yAxis.setLabel("Total Number");
 
        XYChart.Series malesurvival= new XYChart.Series();
        malesurvival.setName("Male Survival");
        ReadCSV dao = new ReadCSV();
        List<CSVData> listData = dao.readAll();
        
     
        List<CSVData> malesurvival1group = listData.stream()
			    .filter(fetching_data -> fetching_data.getPclass() == 1 && fetching_data.getSex().equals("male") && fetching_data.getSurvived() == 1).collect(Collectors.toList());
        
        List<CSVData> malesurvival2group = listData.stream()
			    .filter(fetching_data -> fetching_data.getPclass() == 2 && fetching_data.getSex().equals("male") && fetching_data.getSurvived() == 1).collect(Collectors.toList());
        
        List<CSVData> malesurvival3group = listData.stream()
			    .filter(fetching_data -> fetching_data.getPclass() == 3 && fetching_data.getSex().equals("male") && fetching_data.getSurvived() == 1).collect(Collectors.toList());
        
        malesurvival.getData().add(new XYChart.Data("1", malesurvival1group.size()));
        malesurvival.getData().add(new XYChart.Data("2",malesurvival2group.size()));
        malesurvival.getData().add(new XYChart.Data("3", malesurvival3group.size()));
       
        
        List<CSVData> femalesurvival1group = listData.stream()
			    .filter(fetching_data -> fetching_data.getPclass() == 1 && fetching_data.getSex().equals("female") && fetching_data.getSurvived() == 1).collect(Collectors.toList());
        
        List<CSVData> femalesurvival2group = listData.stream()
			    .filter(fetching_data -> fetching_data.getPclass() == 2 && fetching_data.getSex().equals("female") && fetching_data.getSurvived() == 1).collect(Collectors.toList());
        
        List<CSVData> femalesurvival3group = listData.stream()
			    .filter(fetching_data -> fetching_data.getPclass() == 3 && fetching_data.getSex().equals("female") && fetching_data.getSurvived() == 1).collect(Collectors.toList());
        
        
        
        XYChart.Series femalesurvival = new XYChart.Series();
        femalesurvival.setName("Female Survival");
        femalesurvival.getData().add(new XYChart.Data("1", femalesurvival1group.size()));
        femalesurvival.getData().add(new XYChart.Data("2", femalesurvival2group.size()));
        femalesurvival.getData().add(new XYChart.Data("3", femalesurvival3group.size()));
        
        
        
        List<CSVData> malede1gr = listData.stream()
			    .filter(fetching_data -> fetching_data.getPclass() == 1 && fetching_data.getSex().equals("male") && fetching_data.getSurvived() == 0).collect(Collectors.toList());
        
        List<CSVData> malede2gr = listData.stream()
			    .filter(fetching_data -> fetching_data.getPclass() == 2 && fetching_data.getSex().equals("male") && fetching_data.getSurvived() == 0).collect(Collectors.toList());
        
        List<CSVData> malede3gr = listData.stream()
			    .filter(fetching_data -> fetching_data.getPclass() == 3 && fetching_data.getSex().equals("male") && fetching_data.getSurvived() == 0).collect(Collectors.toList());
        
        XYChart.Series maledead = new XYChart.Series();
        maledead.setName("Male Death");
        maledead.getData().add(new XYChart.Data("1", malede1gr.size()));
        maledead.getData().add(new XYChart.Data("2", malede2gr.size()));
        maledead.getData().add(new XYChart.Data("3", malede3gr.size()));
        
        List<CSVData> femalde1gr = listData.stream()
			    .filter(fetching_data -> fetching_data.getPclass() == 1 && fetching_data.getSex().equals("female") && fetching_data.getSurvived() == 0).collect(Collectors.toList());
        
        List<CSVData> femalede2gr = listData.stream()
			    .filter(fetching_data -> fetching_data.getPclass() == 2 && fetching_data.getSex().equals("female") && fetching_data.getSurvived() == 0).collect(Collectors.toList());
        
        List<CSVData> femalede3gr = listData.stream()
			    .filter(fetching_data -> fetching_data.getPclass() == 3 && fetching_data.getSex().equals("female") && fetching_data.getSurvived() == 0).collect(Collectors.toList());
        
        XYChart.Series femaledead = new XYChart.Series();
        femaledead.setName("Female Death");
        femaledead.getData().add(new XYChart.Data("1", femalde1gr.size()));
        femaledead.getData().add(new XYChart.Data("2", femalede2gr.size()));
        femaledead.getData().add(new XYChart.Data("3", femalede3gr.size()));
        
        Scene scene  = new Scene(barchart,800,600);
        barchart.getData().addAll(malesurvival,femalesurvival,maledead,femaledead);
        stage.setScene(scene);
        stage.show();
		
	}

}
