package map;

import java.util.ArrayList;
import java.util.Collection;

import config.Config;
import structure.Block;
import structure.Structure;
import math.Vector;

public class Room {
	private int id;
	private Vector pos;
	private ArrayList<Door> doors;
	
	public Room(int id, Vector pos) {
		this.id=id;
		this.pos=pos;
		ArrayList<Door> doors = new ArrayList<Door>();
		for (int i=0 ; i<4 ; i++) {
			doors.add(new Door(i));
		}
		this.doors = doors;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vector getPos() {
		return pos;
	}

	public void setPos(Vector pos) {
		this.pos = pos;
	}

	public ArrayList<Door> getDoors() {
		return doors;
	}

	public void setDoors(ArrayList<Door> doors) {
		this.doors = doors;
	}

	public Vector getNeighbourPos(Door door) {
		// TODO Auto-generated method stub
		if (door.getId() == 0) {
			return pos.getSum(new Vector(0,-1));
		}
		else if (door.getId() == 1) {
			return pos.getSum(new Vector(-1,0));
		}
		else if (door.getId() == 2) {
			return pos.getSum(new Vector(0,1));
		}
		else if (door.getId() == 3) {
			return pos.getSum(new Vector(1,0));
		}
		return null;
	}

	public Door getTargetDoor(int root_door_id) {
		// TODO Auto-generated method stub
		for (Door door : doors) {
			if (door.getId()==(root_door_id+2)%4) {
				return door;
			}
		}
		return null;
	}

	public void print() {
		// TODO Auto-generated method stub
		System.out.println("==Room n"+id+"==");
		for (Door door : doors) {
			if (door.getTargetRoom()!=null) {
				System.out.println("Door n"+door.getId()+" reliee a Room n"+door.getTargetRoom().getId());
			}
		}
	}

	public Collection<? extends Block> toStructure() {
		// TODO Auto-generated method stub
		Vector structurePos = new Vector(pos);
		structurePos.multiply(Config.inter_room_distance);
		Vector structureDim = new Vector(Config.roomDimensions);
		return Structure.getOuset(structurePos,structureDim);
	}

	public Collection<? extends Block> getCorridorStructure(int door_id) {
		// TODO Auto-generated method stub
		Vector structureDim = new Vector(Config.corridorDimensions);
		for (int i=0 ; i<(3-door_id) ; i++) {
			structureDim.rotate(-1);
		}
		Vector structurePos = new Vector(pos);
		structurePos.multiply(Config.inter_room_distance);
		if (door_id==3) {
			structurePos.add(Config.roomDimensions.proj(0));
			structurePos.add(Config.roomDimensions.half().proj(1));
			structurePos.subtract(structureDim.half().proj(1));
		}
		else if (door_id==2) {
			structurePos.add(Config.roomDimensions.proj(1));
			structurePos.add(Config.roomDimensions.half().proj(0));
			structurePos.subtract(structureDim.half().proj(0));
		}
		else if (door_id==1) {
			structurePos.add(Config.roomDimensions.half().proj(1));
			structurePos.subtract(structureDim.half().proj(1));
		}
		else if (door_id==0) {
			structurePos.add(Config.roomDimensions.half().proj(0));
			structurePos.subtract(structureDim.half().proj(0));
		}
		return Structure.getOuset(structurePos, structureDim);
	}

	public Vector getDoorPos(int door_id) {
		// TODO Auto-generated method stub
		Vector corridorDim = new Vector(Config.corridorDimensions);
		for (int i=0 ; i<(3-door_id) ; i++) {
			corridorDim.rotate(-1);
		}
		Vector doorPos = new Vector(pos);
		doorPos.multiply(Config.inter_room_distance);
		if (door_id==3) {
			doorPos.add(Config.roomDimensions.proj(0));
			doorPos.add(Config.roomDimensions.half().proj(1));
			doorPos.subtract(corridorDim.half().proj(1));
			doorPos.set(1, doorPos.get(1)+1);
			doorPos.set(2,1);
		}
		else if (door_id==2) {
			doorPos.add(Config.roomDimensions.proj(1));
			doorPos.add(Config.roomDimensions.half().proj(0));
			doorPos.subtract(corridorDim.half().proj(0));
			doorPos.set(0, doorPos.get(0)-1);
			doorPos.set(2,1);
		}
		else if (door_id==1) {
			doorPos.add(Config.roomDimensions.half().proj(1));
			doorPos.subtract(corridorDim.half().proj(1));
			doorPos.set(1, doorPos.get(1)-1);
			doorPos.set(2,1);
		}
		else if (door_id==0) {
			doorPos.add(Config.roomDimensions.half().proj(0));
			doorPos.subtract(corridorDim.half().proj(0));
			doorPos.set(0, doorPos.get(0)+1);
			doorPos.set(2,1);
		}
		return doorPos;
	}

	public Vector getDoorDim(int door_id) {
		// TODO Auto-generated method stub
		Vector corridorDim = new Vector(Config.corridorDimensions);
		corridorDim.set(1,corridorDim.get(1)-2);
		for (int i=0 ; i<(3-door_id) ; i++) {
			corridorDim.rotate(-1);
		}
		if (door_id==3) {
			return corridorDim.proj(1);
		}
		else if (door_id==2) {
			return corridorDim.proj(0);
		}
		else if (door_id==1) {
			return corridorDim.proj(1);
		}
		else if (door_id==0) {
			return corridorDim.proj(0);
		}
		return null;
	}
	
}
