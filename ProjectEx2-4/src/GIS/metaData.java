package GIS;

import Geom.Point3D;
import java.util.*;
/**
 * This is a class that represents the metaData of the csv files
 * @author djtov
 *
 */
public class metaData implements Meta_data {
    private String date;
    private String authmode;
    private String type,mac,name;
    private String channel ,rssi,accuracy;
    private long time;
 
/**
 * This is a constructor for the metaData
 * @param Mac
 * @param Name
 * @param AuthMode
 * @param d
 * @param Channel
 * @param Rssi
 * @param Acc
 * @param Type
 */
	public metaData(String Mac,String Name, String AuthMode, String d, String Channel, String Rssi,String Acc, String Type) {
    	mac = Mac;
    	name = Name;
    	authmode = AuthMode;
    	date = d;
    	channel = Channel;
    	rssi = Rssi;
    	accuracy = Acc;
    	type = Type;
    	Date  t= new Date();
		this.time = t.getTime();
    	
    }
	/**
	 * This is a constructor for an default metaData
	 */
	public metaData() {
		Date  t= new Date();
		this.time = t.getTime();
	}
    public String getAuthMode() {
		return authmode;
	}
	public void setAuthMode(String authMode) {
		authmode = authMode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getRssi() {
		return rssi;
	}
	public void setRssi(String rssi) {
		this.rssi = rssi;
	}
	public String getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	   public String getDate() {
			return date;
		}
	
	@Override
	/**
	 * This method returns the time in milliseconds
	 */
	public long getUTC() {
		// TODO Auto-generated method stub
		
		return this.time;
	}
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Point3D get_Orientation() {
		// TODO Auto-generated method stub
		return null;
	}
   public String toString() {
	   return mac+name+authmode+date+channel+rssi+accuracy+type;
   }
}
