package fr.epita.ajitesh.csvdata;

public class CSVData {
	int Survived,pclass,sibling,parent;
	public int getSurvived() {
		return Survived;
	}
	public void setSurvived(int survived) {
		Survived = survived;
	}
	public int getPclass() {
		return pclass;
	}
	public void setPclass(int pclass) {
		this.pclass = pclass;
	}
	public int getSibling() {
		return sibling;
	}
	public void setSibling(int sibling) {
		this.sibling = sibling;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	double age,fare;
	String name,sex;
	public CSVData() {
		
	}

}
