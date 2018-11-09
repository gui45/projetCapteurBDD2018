package model;

public class Temperature {
	
	protected int idTemperature;
	protected float minimum;
	protected float maximum;
	protected float moyenne;
	protected float mode;
	protected float mediane;
	
	
	public Temperature() {
		
		minimum = 0;
		maximum = 0;
		moyenne = 0;
		mode = 0;
		mediane = 0;
		
	}


	public int getIdTemperature() {
		return idTemperature;
	}


	public void setIdTemperature(int idTemperature) {
		this.idTemperature = idTemperature;
	}


	public float getMinimum() {
		return minimum;
	}


	public void setMinimum(float minimum) {
		this.minimum = minimum;
	}


	public float getMaximum() {
		return maximum;
	}


	public void setMaximum(float maximum) {
		this.maximum = maximum;
	}


	public float getMoyenne() {
		return moyenne;
	}


	public void setMoyenne(float moyenne) {
		this.moyenne = moyenne;
	}


	public float getMode() {
		return mode;
	}


	public void setMode(float mode) {
		this.mode = mode;
	}


	public float getMediane() {
		return mediane;
	}


	public void setMediane(float mediane) {
		this.mediane = mediane;
	}
	
	

}
