package math;

import java.util.ArrayList;

public class Vector extends ArrayList<Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Vector(int x, int y) {
		super();
		this.add(x);
		this.add(y);
	}
	
	public Vector(int x, int y, int z) {
		super();
		this.add(x);
		this.add(y);
		this.add(z);
	}

	public Vector(Vector other) {
		// TODO Auto-generated constructor stub
		for (int coord : other) {
			this.add(coord);
		}
	}

	public Vector() {
		// TODO Auto-generated constructor stub
	}

	public Vector getSum(Vector other) {
		/**
		 * Returns the sum vector of this vector with the specified vector.
		 * Vectors don't need to be necessary the same size.
		 */
		Vector result = new Vector(0,0);
		int st = this.size();
		int so = other.size();
		int max = Math.max(st, so);
		for (int i=0 ; i<max ; i++) {
			if (i>=st) {
				result.add(other.get(i));
			}
			else if (i>=so) {
				result.add(this.get(i));
			}
			else {
				result.set(i,this.get(i)+other.get(i));
			}
		}
		return result;
	}
	
	public void add(Vector other) {
		/**
		 * Adds the specified vector to this vector.
		 * Vectors don't need to be necessary the same size.
		 */
		for (int i=0 ; i<other.size() ; i++) {
			if (i>=this.size()) {
				this.add(other.get(i));
			}
			else {
				this.set(i, this.get(i)+other.get(i));
			}
		}
	}

	public Vector getMultiplication(Vector other) {
		/**
		 * Returns the multiplication vector of this vector with the specified vector.
		 * Vectors don't need to be necessary the same size.
		 */
		Vector result = new Vector(0,0);
		int min = Math.min(this.size(), other.size());
		for (int i=0 ; i<min ; i++) {
			result.set(i,this.get(i)*other.get(i));
		}
		return result;
	}
	
	public void multiply(Vector other) {
		/**
		 * Multiplies the specified vector to this vector.
		 * Vectors don't need to be necessary the same size.
		 */
		for (int i=0 ; i<this.size() ; i++) {
			if (i>=other.size()) {
				this.set(i,0);
			}
			else {
				this.set(i, this.get(i)*other.get(i));
			}
		}
	}
	
	public Vector getSubtraction(Vector other) {
		/**
		 * Returns the subtraction vector of this vector with the specified vector.
		 * Vectors don't need to be necessary the same size.
		 */
		Vector result = new Vector(0,0);
		int st = this.size();
		int so = other.size();
		int max = Math.max(st, so);
		for (int i=0 ; i<max ; i++) {
			if (i>=st) {
				result.add(-other.get(i));
			}
			else if (i>=so) {
				result.add(this.get(i));
			}
			else {
				result.set(i,this.get(i)-other.get(i));
			}
		}
		return result;
	}
	
	public void subtract(Vector other) {
		/**
		 * Subtracts the specified vector to this vector.
		 * Vectors don't need to be necessary the same size.
		 */
		for (int i=0 ; i<other.size() ; i++) {
			if (i>=this.size()) {
				this.add(-other.get(i));
			}
			else {
				this.set(i, this.get(i)-other.get(i));
			}
		}
	}
	
	public void rotate(int direction) {
		/**
		 * Rotates this vector in a plane perpendicular to the third coordinate in Cartesian orthogonal coordinates.
		 * The first coordinate axis is considered to point to the right and the second coordinate axis is considered
		 * to point to the top.
		 * Use direction=1 for clockwise rotation and direction=-1 for counterclockwise rotation.
		 * 
		 */
		if (direction==1) {
			int b=this.get(1);
			this.set(1, -this.get(0));
			this.set(0, b);
		}
		else if (direction==-1) {
			int b=this.get(1);
			this.set(1, this.get(0));
			this.set(0, -b);
		}
		else {
			System.out.println("[ERROR] direction not understood, can't rotate vector");
		}
	}

	public boolean isEqualTo(Vector other) {
		// TODO Auto-generated method stub
		int st = this.size();
		int so = other.size();
		int max = Math.max(st, so);
		for (int i=0 ; i<max ; i++) {
			if (i>=st) {
				if (other.get(i)!=0) {
					return false;
				}
			}
			else if (i>=so) {
				if (this.get(i)!=0) {
					return false;
				}
			}
			else {
				if (!(this.get(i)==other.get(i))) {
					return false;
				}
			}
		}
		return true;
	}

	public Vector proj(int i) {
		// TODO Auto-generated method stub
		Vector result = new Vector();
		for (int j=0 ; j<this.size() ; j++) {
			if (i==j) {
				result.add(this.get(i));
			}
			else {
				result.add(0);
			}
		}
		return result;
	}

	public Vector half() {
		// TODO Auto-generated method stub
		Vector result = new Vector();
		for (int i=0 ; i<this.size() ; i++) {
			result.add(this.get(i)/2);
		}
		return result;
	}

}
