package fr.epita.ajitesh.csvdata;

import java.util.List;

import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class AgeWiseFare {

	@SuppressWarnings("unchecked")
	public AgeWiseFare(Stage stage) throws Exception {
		final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();        
        final ScatterChart<Number,Number> sc = new
            ScatterChart<Number,Number>(xAxis,yAxis);
        xAxis.setLabel("Age (years)");                
        yAxis.setLabel("Fare");
        sc.setTitle("Fare According Age Analysis");
       
        XYChart.Series series1 = new XYChart.Series();
        ReadCSV dao = new ReadCSV();
		List<CSVData> listdata = dao.readAll();
        for (int i = 0; i < listdata.size(); i++) {
        series1.getData().add(new XYChart.Data(listdata.get(i).getAge(), listdata.get(i).getFare()));
        }
        sc.getData().addAll(series1);
        Scene scene  = new Scene(sc, 800, 600);
        stage.setScene(scene);
        stage.show();
	}
}
