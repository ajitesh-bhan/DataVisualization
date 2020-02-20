package fr.epita.ajitesh.csvdata;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;



public class ReadCSV {
	 public List<CSVData> readAll(){
	        List<CSVData>alldata= new ArrayList<>();
	        try {
	            List<String> lines=Files.readAllLines(new File("C:\\Users\\ajite\\eclipse-workspace\\titanic-excersise\\data\\input.csv").toPath());
	            //because of headers
	            lines.remove(0);
	            for (String line:lines){
	                String[]parts=line.split(",");
	                CSVData model=new CSVData();
	                model.setSurvived(Integer.parseInt(parts[0]));
	                model.setPclass(Integer.parseInt(parts[1]));
	                model.setName(parts[2]);
	                model.setSex(parts[3]);
	                model.setAge(Double.parseDouble(parts[4]));
	                model.setSibling(Integer.parseInt(parts[5]));
	                model.setParent(Integer.parseInt(parts[6]));
	                model.setFare(Double.parseDouble(parts[7]));
	              
	                alldata.add(model);
	            }
	            return alldata;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return alldata;
	    }
}
