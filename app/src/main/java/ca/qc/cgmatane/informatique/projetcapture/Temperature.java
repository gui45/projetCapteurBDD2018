package ca.qc.cgmatane.informatique.projetcapture;

public class Temperature {

    private String temperature;
    private String date;

    public Temperature(String temperature, String date){
        this.temperature = temperature;
        this.date = date;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
