package environment.monitoring.sender;

import java.security.SecureRandom;

public class Sender {
	
	private double temperature, humidity;
	private String temperatureUnit = "C";
	private String humidityUnit = "%";
	
	public static void wait(int ms) {
	    try {
	        Thread.sleep(ms);
	    }
	    catch(InterruptedException ex) {
	        Thread.currentThread().interrupt();
	    }
	}
	
	private int generateRandomNumber() {
		SecureRandom random = new SecureRandom(); //SecureRandom is used to avoid security issues
		return random.nextInt(100); 
		
	}
	
	public void simulateSender(int records) throws InterruptedException {

        for(int i = 0; i < records ; i++) {
        	
        	this.temperature = generateRandomNumber();
        	this.humidity = generateRandomNumber();
        	
        	System.out.println("temperature="+temperature + temperatureUnit + ",humidity="+humidity+humidityUnit );
        	
        	wait(3000);
        }
		
		
	}
	
    public static void main( String[] args ) throws InterruptedException {
    	
    	Sender sender = new Sender();
    	
    	sender.simulateSender(5);
    	
    }
}
