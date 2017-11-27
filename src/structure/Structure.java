package structure;

import java.util.ArrayList;
import java.util.Collection;

import map.Door;
import map.Map;
import map.Room;
import math.Range;
import math.Vector;

public class Structure extends ArrayList<Block>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Structure(Map map) {
		for (Room room : map) {
			this.addAll(room.toStructure());
			for (Door door : room.getDoors()) {
				if (door.getTargetRoom()!=null) {
					this.addAll(room.getCorridorStructure(door.getId()));
				}
				this.addAirBlocks(room.getDoorPos(door.getId()), room.getDoorDim(door.getId()));
				//this.addAirBlocks(door.getTargetRoom().getDoorPos(door.getId()), door.getTargetRoom().getDoorDim(door.getId()));
			}
		}
	}

	public static Collection<? extends Block> getOuset(Vector pos, Vector dim) {
		// TODO Auto-generated method stub
		ArrayList<Block> outSet = new ArrayList<Block>();
		int start_x = pos.get(0);
		int end_x = start_x+dim.get(0)-1;
		int start_y = pos.get(1);
		int end_y = start_y+dim.get(1)-1;
		int start_z = 0;
		int end_z = dim.get(2)-1;
		Range rg = new Range();
		for (int x : rg.getRange(start_x,end_x)) {
			for (int y : rg.getRange(start_y,end_y)) {
				for (int z : rg.getRange(start_z,end_z)) {
					if (x==start_x || x==end_x || y==start_y || y==end_y || z==start_z || z==end_z) {
						outSet.add(new Block(new Vector(x,y,z),1));
					}
				}
			}
		}
		return outSet;
	}
	
	public void addAirBlocks(Vector pos, Vector dim) {
		int start_x = pos.get(0);
		int end_x = start_x+dim.get(0)-1;
		int start_y = pos.get(1);
		int end_y = start_y+dim.get(1)-1;
		int start_z = 0;
		int end_z = dim.get(2)-1;
		Range rg = new Range();
		for (int x : rg.getRange(start_x,end_x)) {
			for (int y : rg.getRange(start_y,end_y)) {
				for (int z : rg.getRange(start_z,end_z)) {
					this.add(new Block(new Vector(x,y,z),0));
				}
			}
		}
	}
}
