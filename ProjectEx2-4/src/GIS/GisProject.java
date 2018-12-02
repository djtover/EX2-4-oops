package GIS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
/**
 * This is a class that implements the interface GIS_project that is made up of GIS_layers and also has a metadata
 * @author David Tover
 *
 */
public class GisProject implements GIS_project {
    private ArrayList<GIS_layer> GP;
    private metaData md;
	
    /**
     * This is the constructor for the GisProject
     * @param gp is the ArrayList that the GisProject will equal to
     */
	public GisProject(ArrayList <GIS_layer> gp) {
		this.GP=gp;
		md = new metaData();
	}
	@Override
	/**
	 * This is method to add a GIS_layer to the Gisproject, if it returns true then it has been added , if it returns false then the GisProject already has that GIS_layer so it wont be added
	 */
	public boolean add(GIS_layer e) {
		// TODO Auto-generated method stub
		return GP.add(e);
	}

	@Override
	/**
	 * This is a method to a collection of GIS_layers to the GisProject
	 */
	public boolean addAll(Collection<? extends GIS_layer> c) {
		// TODO Auto-generated method stub
		return GP.addAll(c);
	}

	@Override
	/**
	 * This is a method to clear the GisProject
	 */
	public void clear() {
		// TODO Auto-generated method stub
     GP.clear();
	}

	@Override
	/**
	 * This is a method to see if the Gisproject contains a certain object
	 */
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return GP.contains(o);
	}

	@Override
	/**
	 * This is a method to see if the GisProject contains a certain collection
	 */
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return GP.containsAll(c);
	}

	@Override
	/**
	 * This is a method to see if the GisProject is empty
	 */
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return GP.isEmpty();
	}

	@Override
	/**
	 * This is method that returns an iterator for the Gisproject
	 */
	public Iterator<GIS_layer> iterator() {
		// TODO Auto-generated method stub
		return GP.iterator();
	}

	@Override
	/**
	 * This is a method to remove a certain object from the GisProject
	 */
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return GP.remove(o);
	}

	@Override
	/**
	 * This is a method to remove a certain collection of objects 
	 */
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return GP.removeAll(c);
	}

	@Override
	/**
	 * This is a method to retain a certain collection of elements
	 */
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return GP.retainAll(c);
	}

	@Override
	/**
	 * This is a method that returns the size of the GisProject
	 */
	public int size() {
		// TODO Auto-generated method stub
		return GP.size();
	}

	@Override
	/**
	 * This is a method to to turn the GisProject into an Array
	 */
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return GP.toArray();
	}

	@Override
	/**
	 * This is a method to turn the GisProject into an array of a certain type
	 */
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return GP.toArray(a);
	}

	@Override
	/**
	 * Returns the metadata
	 */
	public Meta_data get_Meta_data() {
		// TODO Auto-generated method stub
		return md;
	}
	/**
	 * toString method
	 */
	public String toString() {
		String s = "";
		for( int i=0;i<GP.size();i++) {
			s+= GP.get(i).toString();
		}
		return s;
	}
}
