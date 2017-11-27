package structure;

import math.Vector;

public class Block {
	private Vector pos;
	private int id;
	public Block(Vector pos, int id) {
		super();
		this.pos = pos;
		this.id = id;
	}
	public Vector getPos() {
		return pos;
	}
	public void setPos(Vector pos) {
		this.pos = pos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String toString() {
		return "["+pos.get(0)+","+pos.get(1)+","+pos.get(2)+","+id+"]";
	}
}
