package GIS;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * This is a class that implements the interface GIS_layer that is made up of GIS_elements and also has a metadata
 * @author djtov
 *
 */
public class GisLayer implements GIS_layer {
    private ArrayList<GIS_element> GL;
    private metaData md;
    /**
     * This is the constructor for the GisLayer
     * @param gl is the ArrayList that the GisLayer will equal to
     */
    public GisLayer(ArrayList<GIS_element> gl) {
     	md= new metaData();
     	this.GL=gl;
    }
	@Override
	/**
	 * This is method to add a GIS_element to the Gislayer, if it returns true then it has been added , if it returns false then the Gislayer already has that GIS_element so it wont be added
	 */
	public boolean add(GIS_element arg0) {
		// TODO Auto-generated method stub
		
		return GL.add(arg0);
		
	}

	@Override
	/**
	 * This is a method to a collection of GIS_elements to the GisLayer
	 */
	public boolean addAll(Collection<? extends GIS_element> arg0) {
		// TODO Auto-generated method stub
		return GL.addAll(arg0);
	}

	@Override
	/**
	 * This is a method to clear the GisLayer
	 */
	public void clear() {
		// TODO Auto-generated method stub
		GL.clear();

	}

	@Override
	/**
	 * This is a method to see if the Gislayer contains a certain object
	 */
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		
		return GL.contains(arg0);
	}

	@Override
	/**
	 * This is a method to see if the GisLayer contains a certain collection
	 */
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return GL.containsAll(c);
	}

	@Override
	/**
	 * This is a method to see if the GisLayer is empty
	 */
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		
		return GL.isEmpty();
	}

	@Override
	/**
	 * This is method that returns an iterator for the GisLayer
	 */
	public Iterator<GIS_element> iterator() {
		// TODO Auto-generated method stub
		return GL.iterator();
	}

	@Override
	/**
	 * This is a method to remove a certain object from the GisLayer
	 */
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return GL.remove(o);
		
	}

	@Override
	/**
	 * This is a method to remove a certain collection of objects 
	 */
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
			return GL.removeAll(c);
	}

	@Override
	/**
	 * This is a method to retain a certain collection of elements
	 */
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return GL.retainAll(c);
	}

	@Override
	/**
	 * This is a method that returns the size of the Gislayer
	 */
	public int size() {
		// TODO Auto-generated method stub
		return GL.size();
	}

	@Override
	/**
	 * This is a method to to turn the Gislayer into an Array
	 */
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return GL.toArray();
	}

	@Override
	/**
	 * This is a method to turn the GisLayer into an array of a certain type
	 */
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return GL.toArray(a);
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
	 * To String method
	 */
	public String toString() {
		String s = "";
		for( int i=0;i<GL.size();i++) {
			s+= GL.get(i).toString();
		}
		return s;
	}

}
