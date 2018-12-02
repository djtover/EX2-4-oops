package File_format;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import GIS.GisElement;
import GIS.metaData;
import Geom.Point3D;
/**
 * This is a class to to convert a csv file to a kml file
 * @author David Tover
 *
 */

public class Csv2kml {
	private ArrayList<String> AL = new ArrayList();
	private int columns;
	/**
	 * This is the constructor for converting a csv file to a kml file
	 * @param csvFileName is the name of the csv file that you are looking to convert to a kml file
	 */
	public Csv2kml(String csvFileName) {
    	String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFileName))) 
        {
        	
        	br.readLine();
        	br.readLine();
        	while((line = br.readLine()) != null) {
                String[] userInfo = line.split(csvSplitBy);
                columns = userInfo.length;
                

                
                for(int i=0 ; i<userInfo.length;i++)
                AL.add(userInfo[i]);
        	}  
        	
        	File f = new File(csvFileName.replace(".csv",".kml"));
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
                
        String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
        		"<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>\r\n" + 
        		"";
        bw.write(header);
        for(int i=0; i<AL.size();i+=11) {
           String mac = AL.get(i);
           String name = AL.get(i+1);
           String auth = AL.get(i+2);
           String date = AL.get(i+3);
           String lat = AL.get(i+6);
           String lon = AL.get(i+7);
           Date d = new Date();
   		   long time = d.getTime();
   		   String timeStamp = Long.toString(time);
           
           
           String context = "<Placemark>\r\n" + 
           		"<name><![CDATA["+name+"]]></name>\r\n" + 
           		"<description><![CDATA[BSSID: <b>"+mac+"</b><br/>Capabilities: <b>"+auth+"</b><br/>Timestamp: <b>"+timeStamp+"</b><br/>Date: <b>"+date+"</b>]]></description><styleUrl>#red</styleUrl>\r\n" + 
           		"<Point>\r\n" + 
           		"<coordinates>"+lon+","+lat+"</coordinates></Point>\r\n" + 
           		"</Placemark>\r\n" ;
               bw.write(context);
        }
        String closer = "</Folder>\r\n" + 
        		"</Document></kml>";
        	bw.write(closer);
                bw.close();

                
        	
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
      
        
        
    	
    }
	public ArrayList<String> getAL() {
		return AL;
	}
	public void setAL(ArrayList<String> aL) {
		AL = aL;
	}
	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}
	public String toString() {
		String s = "";
		for(int i=0; i < AL.size();i++) {
			s+=AL.get(i)+",";
			if((i+1)%columns==0)
				s+="\n";
		}
		return s;
	}
//	public static void main(String[] args) {
//		Csv2kml c = new Csv2kml("C:\\Users\\djtov\\eclipse-workspace\\ProjectEx2-4\\src\\GIS\\WigleWifi_20171201110209.csv");
//		System.out.println(c);

//	}
}
