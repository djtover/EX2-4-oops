package GIS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Coords.MyCoords;
import Geom.Point3D;

/**
 * This is a class that represents a GIS element which is built from a Point3d and metadata and it implements the interface of GIS_element
 * @author David Tover
 *
 */
public class GisElement implements GIS_element {
    private Point3D p3d;
    private metaData md;
    /**
     * This is a constructor to build the element
     * @param p is initializing the point3d that is in the element
     * @param MD is initializing the metadata that is in the element
     */
    public GisElement(Point3D p, metaData MD) {
    	this.p3d = p;
    	this.md = MD;
    }
	@Override
	/**
	 * This is a method to get the Point3d 
	 */
	public Point3D getGeom() {
		// TODO Auto-generated method stub
		return p3d;
	}
	@Override
	/**
	 * This is a method to get the metadata 
	 */
	public Meta_data getData() {
		// TODO Auto-generated method stub
		return md;
	}

	@Override
	/**
	 * This is a method that you want to translate the coordinates of the element by adding a vector to it
	 */
	public void translate(Point3D vec) {
		// TODO Auto-generated method stub
     MyCoords mc = new MyCoords();
     p3d = mc.add(p3d, vec);
	}
	public String toString() {
		return p3d.toString()+md.toString();
	}

}
