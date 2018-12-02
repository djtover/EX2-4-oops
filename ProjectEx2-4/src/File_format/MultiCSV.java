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

import GIS.GIS_element;
import GIS.GIS_layer;
import GIS.GisElement;
import GIS.GisLayer;
import GIS.GisProject;
import GIS.metaData;
import Geom.Point3D;
/**
 * This is a class to build multiple kml files from csv files
 * @author David Tover
 *
 */
public class MultiCSV {
	private GisElement ge;
	private GisLayer gl;
	private GisProject gp;
	private metaData md;
	private Point3D p;
	private int columns;
	/**
	 * This is the constructor on building multiple kml files from multiple csv files
	 * @param folderName is the name of the folder in which we want to check to see if it has csv files and if it does then convert them to kml files
	 */
	public MultiCSV(String folderName) {
		String line = "";
		String csvSplitBy = ",";

		ArrayList<GIS_layer> algp = new ArrayList();
		gp = new GisProject(algp);
		File folder = new File(folderName);
		File[] listOfFiles = folder.listFiles();
		for(int i=0;i<listOfFiles.length;i++) {
			if(listOfFiles[i].toString().contains(".csv")) {
				String csvFileName=listOfFiles[i].toString();
				try (BufferedReader br = new BufferedReader(new FileReader(csvFileName))) 
				{
					ArrayList<GIS_element> algl = new ArrayList();

					br.readLine();
					br.readLine();
					while((line = br.readLine()) != null) {
						String[] userInfo = line.split(csvSplitBy);
						columns = userInfo.length;

						String mac = userInfo[0];
						String name = userInfo[1];
						String auth=userInfo[2];
						String date = userInfo[3];
						String channel = userInfo[4];
						String rssi = userInfo[5];
						double lat = Double.parseDouble(userInfo[6]);
						double lon = Double.parseDouble(userInfo[7]);
						double alt = Double.parseDouble(userInfo[8]);
						String acc = userInfo[9];
						String type = userInfo[10];
						p = new Point3D(lon,lat,alt);
						md = new metaData(mac,name,auth,date,channel,rssi,acc,type);
						ge = new GisElement(p,md);


						algl.add(ge);


					}  
					gl = new GisLayer(algl);

					gp.add(gl);
				

					File f = new File(csvFileName.replace(".csv",".kml"));
					FileWriter fw = new FileWriter(f);
					BufferedWriter bw = new BufferedWriter(fw);

					String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
							"<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>\r\n" + 
							"";
					bw.write(header);

					Iterator <GIS_element> itr = gl.iterator();
					while(itr.hasNext()) {
						GisElement g=(GisElement)itr.next();
						metaData m=(metaData)(g.getData());
						Point3D p = g.getGeom();
						String mac = m.getMac();
						String name = m.getName();
						String auth = m.getAuthMode();
						String date = m.getDate();
						long time = m.getUTC();
						String timeStamp = Long.toString(time); 
						double lon = p.x();
						double lat = p.y();

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
		}

	}
	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}
	public String toString() {
		String s = "";
		Iterator <GIS_element> itr = gl.iterator();
		
		int i = 0;
		while(itr.hasNext()) {
			
			itr.next();
			s+=itr.toString();
			if((i+1)%columns==0)
				s+="\n";
			i++;
		}
		return s;
	}
	public static void main(String[] args) {
		MultiCSV c = new MultiCSV("C:\\Users\\djtov\\eclipse-workspace\\ProjectEx2-4\\src\\GIS");
//		MultiCSV c = new MultiCSV("C:\\Users\\djtov\\Downloads");
	}
}

