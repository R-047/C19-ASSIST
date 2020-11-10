package application;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class data {
    private final SimpleStringProperty city; 
    private final SimpleIntegerProperty cases, deaths, activecases;
    private final SimpleDoubleProperty recoveryrate;
   public data(String in_city, int in_cases, int in_activecases, int in_deaths, double in_recoveryrate){
        super();
        this.city = new SimpleStringProperty(in_city);
        this.cases = new SimpleIntegerProperty(in_cases);
        this.activecases = new SimpleIntegerProperty(in_activecases);
        this.deaths = new SimpleIntegerProperty(in_deaths);
        this.recoveryrate = new SimpleDoubleProperty(in_recoveryrate);
    }

    public String getCity(){
        return city.get();
    }

    public Integer getCases(){
        return cases.get();
    }

    public Integer getActivecases(){
        return activecases.get();
    }
  
    public Integer getDeaths(){
        return deaths.get();
    }

    public Double getRecoveryrate(){
        return recoveryrate.get();
    }
    

}
