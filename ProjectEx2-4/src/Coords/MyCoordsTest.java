package Coords;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Geom.Point3D;

class MyCoordsTest {

	@Test
	void testAdd() {
		Point3D p1 = new Point3D (32.103315,35.209039,670);
		MyCoords MC= new MyCoords();
		Point3D p2 = new Point3D(32.10635199999893,35.205225000003225,650.0);
      Point3D p3 = new Point3D(-359.2492069,337.6989921,-20);
		p1=MC.add(p1,p3);
		assertEquals(p2.toString(),p1.toString());

	}

	@Test
	void testDistance3d() {
		Point3D p1 = new Point3D (32.103315,35.209039,670);
		MyCoords MC= new MyCoords();
		Point3D p2 = new Point3D (32.106352,35.205225,650);
		double d=MC.distance3d(p1, p2);
		assertEquals(493.0523318324134,d);
	}
//
	@Test
	void testVector3D() {
		Point3D p1 = new Point3D (32.103315,35.209039,670);
		Point3D p2 = new Point3D (32.106352,35.205225,650);
		MyCoords MC= new MyCoords();
		Point3D p = MC.vector3D(p1, p2);
		Point3D v = new Point3D(-359.24920693881893,337.69899206128815,-20.0);
		assertEquals(v.toString(),p.toString());
	}
//
	@Test
	void testAzimuth_elevation_dist() {
		Point3D p1 = new Point3D (32.103315,35.209039,670);
		Point3D p2 = new Point3D (32.106352,35.205225,650);
		MyCoords MC= new MyCoords();
		double arr[]= new double [3];
		arr= MC.azimuth_elevation_dist(p1, p2);
		double az = 136.77106860734574;
		double el = -2.322852232927616;
		double d = 493.45780156501763;
		assertEquals(az,arr[0]);
		assertEquals(el,arr[1]);
		assertEquals(d,arr[2]);
	}
//
	@Test
	void testIsValid_GPS_Point() {
		Point3D p1 = new Point3D (32.103315,35.209039,670);
		Point3D p2 = new Point3D (91.09394,35.209039,670);
		Point3D p3 = new Point3D (32.103315,-192.55432,670);
		Point3D p4 = new Point3D (32.103315,35.209039,-642);
		MyCoords MC= new MyCoords();
		boolean flagp1 = MC.isValid_GPS_Point(p1);
		boolean flagp2 = MC.isValid_GPS_Point(p2);
		boolean flagp3 = MC.isValid_GPS_Point(p3);
		boolean flagp4 = MC.isValid_GPS_Point(p4);
		assertEquals(true,flagp1);
		assertEquals(false,flagp2);
		assertEquals(false,flagp3);
		assertEquals(false,flagp4);
	}

}
