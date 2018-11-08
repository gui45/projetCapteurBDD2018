package model;

public class Dashboard {

    private double min;
    private double max;
    private double average;
    private double mode;
    private double median;
    private double hours;
    private double intakes;

    public Dashboard(double min, double max, double average, double mode, double median, double hours, double intakes){
        this.min=min;
        this.max=max;
        this.average=average;
        this.mode=mode;
        this.median = median;
        this.hours=hours;
        this.intakes=intakes;
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

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getMode() {
        return mode;
    }

    public void setMode(double mode) {
        this.mode = mode;
    }

    public double getMedian() {
        return median;
    }

    public void setMedian(double median) {
        this.median = median;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getIntakes() {
        return intakes;
    }

    public void setIntakes(double intakes) {
        this.intakes = intakes;
    }
}
