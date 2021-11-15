package programaCuatro;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Tiempo {
	
	private String date;
	private String milliseconds_since_epoch;
	private String time;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMilliseconds_since_epoch() {
		return milliseconds_since_epoch;
	}
	public void setMilliseconds_since_epoch(String milliseconds_since_epoch) {
		this.milliseconds_since_epoch = milliseconds_since_epoch;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	

	
	
}
