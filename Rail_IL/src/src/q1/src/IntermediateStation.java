package src.q1.src;

public class IntermediateStation {
	
	private String name;
	private DateTime stopTime;
	
	
	public IntermediateStation(String name, DateTime stopTime) {
		this.name = name;
		this.stopTime = stopTime;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public DateTime getStopTime() {
		return stopTime;
	}


	public void setStopTime(DateTime stopTime) {
		this.stopTime = stopTime;
	}

	public String toString() {
		return name + ","+  stopTime ;
	}
	
	
	
	

}
