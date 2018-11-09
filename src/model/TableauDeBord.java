package model;

public class Dashboard {

    private double min;
    private double max;
    private double moyenne;
    private double mode;
    private double mediane;
    private double heure;
    private double sauvegarde;

    public Dashboard(double min, double max, double moyenne, double mode, double mediane, double heure, double sauvegarde){
        this.min=min;
        this.max=max;
        this.moyenne = moyenne;
        this.mode=mode;
        this.mediane = mediane;
        this.heure = heure;
        this.sauvegarde = sauvegarde;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

    public double getMode() {
        return mode;
    }

    public void setMode(double mode) {
        this.mode = mode;
    }

    public double getMediane() {
        return mediane;
    }

    public void setMediane(double mediane) {
        this.mediane = mediane;
    }

    public double getHeure() {
        return heure;
    }

    public void setHeure(double heure) {
        this.heure = heure;
    }

    public double getSauvegarde() {
        return sauvegarde;
    }

    public void setSauvegarde(double sauvegarde) {
        this.sauvegarde = sauvegarde;
    }
}
