package fr.epita.ajitesh.csvdata;

import java.util.List;
import java.util.stream.Collectors;

import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class AgeGroupANdSexData {
	
	// Divide Age in 4 group and get survival and dead no of people

	@SuppressWarnings("unchecked")
	public AgeGroupANdSexData(Stage stage) throws Exception {

		final String maleSurvival = "Male Survival";
		final String femaleSurvival = "Female Survival";
		final String maledeath = "Male Death";
		final String femaledeath = "Female Death";

		final String zertotoeight = "0-18";
		final String nignetofourteen = "19-40";
		final String fourtytosixt = "41-60";
		final String sixtyonetoeighteen = "61-80";

		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();

		final XYChart.Series<String, Number> msurvival = new XYChart.Series<>();
		final XYChart.Series<String, Number> fsurvival = new XYChart.Series<>();
		final XYChart.Series<String, Number> mdead = new XYChart.Series<>();
		final XYChart.Series<String, Number> fdead = new XYChart.Series<>();

		stage.setTitle("Line Chart");
		final LineChart<String, Number> linechart = new LineChart<>(xAxis, yAxis);
		linechart.setTitle("Age Group And Sex Wise Survival");
		
		xAxis.setLabel("Category");
		yAxis.setLabel("Total Number");
		ReadCSV dao = new ReadCSV();
		List<CSVData> listdata = dao.readAll();
		
		List<CSVData> maleSurvivalzero = listdata.stream()
			    .filter(p -> (p.getAge() <= 18 && p.getAge() > 0) && p.getSex().equals("male") && p.getSurvived() == 1).collect(Collectors.toList());
		
		List<CSVData> maleSurvivalningthy = listdata.stream()
			    .filter(p -> (p.getAge() <= 40 && p.getAge() >= 19) && p.getSex().equals("male") && p.getSurvived() == 1).collect(Collectors.toList());
		
		List<CSVData> maleSurvivalfortyone = listdata.stream()
			    .filter(p -> (p.getAge() <= 60 && p.getAge() >= 41) && p.getSex().equals("male") && p.getSurvived() == 1).collect(Collectors.toList());
		
		List<CSVData> malesurvivalSiztyone = listdata.stream()
			    .filter(p -> (p.getAge() <= 80 && p.getAge() >= 61) && p.getSex().equals("male") && p.getSurvived() == 1).collect(Collectors.toList());
		
		msurvival.setName(maleSurvival);
		addDataItem(msurvival, zertotoeight, maleSurvivalzero.size());
		addDataItem(msurvival, nignetofourteen, maleSurvivalningthy.size());
		addDataItem(msurvival, fourtytosixt, maleSurvivalfortyone.size());
		addDataItem(msurvival, sixtyonetoeighteen, malesurvivalSiztyone.size());
		
		
		List<CSVData> femaleSurvivalzero = listdata.stream()
			    .filter(p -> (p.getAge() <= 18 && p.getAge() > 0) && p.getSex().equals("female") && p.getSurvived() == 1).collect(Collectors.toList());
		
		List<CSVData> femaleSurvivalningthy = listdata.stream()
			    .filter(p -> (p.getAge() <= 40 && p.getAge() >= 19) && p.getSex().equals("female") && p.getSurvived() == 1).collect(Collectors.toList());
		
		List<CSVData> femaleSurvivalfortyone = listdata.stream()
			    .filter(p -> (p.getAge() <= 60 && p.getAge() >= 41) && p.getSex().equals("female") && p.getSurvived() == 1).collect(Collectors.toList());
		
		List<CSVData> femalesurvivalSiztyone = listdata.stream()
			    .filter(p -> (p.getAge() <= 80 && p.getAge() >= 61) && p.getSex().equals("female") && p.getSurvived() == 1).collect(Collectors.toList());
		
		fsurvival.setName(femaleSurvival);
		addDataItem(fsurvival, zertotoeight, femaleSurvivalzero.size());
		addDataItem(fsurvival, nignetofourteen, femaleSurvivalningthy.size());
		addDataItem(fsurvival, fourtytosixt, femaleSurvivalfortyone.size());
		addDataItem(fsurvival, sixtyonetoeighteen, femalesurvivalSiztyone.size());

		
		List<CSVData> maledeathzero = listdata.stream()
			    .filter(p -> (p.getAge() <= 18 && p.getAge() > 0) && p.getSex().equals("male") && p.getSurvived() == 0).collect(Collectors.toList());
		
		List<CSVData> maledeathningthy = listdata.stream()
			    .filter(p -> (p.getAge() <= 40 && p.getAge() >= 19) && p.getSex().equals("male") && p.getSurvived() == 0).collect(Collectors.toList());
		
		List<CSVData> maledeathfortyone = listdata.stream()
			    .filter(p -> (p.getAge() <= 60 && p.getAge() >= 41) && p.getSex().equals("male") && p.getSurvived() == 0).collect(Collectors.toList());
		
		List<CSVData> maledeathSiztyone = listdata.stream()
			    .filter(p -> (p.getAge() <= 80 && p.getAge() >= 61) && p.getSex().equals("male") && p.getSurvived() == 0).collect(Collectors.toList());
		
		mdead.setName(maledeath);
		addDataItem(mdead, zertotoeight, maledeathzero.size());
		addDataItem(mdead, nignetofourteen, maledeathningthy.size());
		addDataItem(mdead, fourtytosixt, maledeathfortyone.size());
		addDataItem(mdead, sixtyonetoeighteen, maledeathSiztyone.size());
		
		List<CSVData> femaledeathzero = listdata.stream()
			    .filter(p -> (p.getAge() <= 18 && p.getAge() > 0) && p.getSex().equals("female") && p.getSurvived() == 0).collect(Collectors.toList());
		
		List<CSVData> femaledeathningthy = listdata.stream()
			    .filter(p -> (p.getAge() <= 40 && p.getAge() >= 19) && p.getSex().equals("female") && p.getSurvived() == 0).collect(Collectors.toList());
		
		List<CSVData> femaledeathfortyone = listdata.stream()
			    .filter(p -> (p.getAge() <= 60 && p.getAge() >= 41) && p.getSex().equals("female") && p.getSurvived() == 0).collect(Collectors.toList());
		
		List<CSVData> femaledeathSiztyone = listdata.stream()
			    .filter(p -> (p.getAge() <= 80 && p.getAge() >= 61) && p.getSex().equals("female") && p.getSurvived() == 0).collect(Collectors.toList());
		fdead.setName(femaledeath);
		addDataItem(fdead, zertotoeight, femaledeathzero.size());
		addDataItem(fdead, nignetofourteen, femaledeathningthy.size());
		addDataItem(fdead, fourtytosixt, femaledeathfortyone.size());
		addDataItem(fdead, sixtyonetoeighteen, femaledeathSiztyone.size());
		
		Scene scene = new Scene(linechart, 800, 600);
		linechart.getData().addAll(msurvival,fsurvival,mdead,fdead);
		stage.setScene(scene);
		stage.show();
	}

	public void addDataItem(XYChart.Series<String, Number> series,
            String x, Number y) {
        series.getData().add(new XYChart.Data<>(x, y));
    }
}
