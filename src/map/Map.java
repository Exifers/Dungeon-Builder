package map;

import java.util.ArrayList;
import java.util.Random;
import math.Vector;

import config.Config;

public class Map extends ArrayList<Room>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Map() {
		for (int i=0 ; i<Config.numberOfRooms ; i++) {
			this.addRandomRoom();
		}
	}

	private void addRandomRoom() {
		// TODO Auto-generated method stub
		if (this.size()==0) {
			this.add(new Room(0,new Vector(0,0)));
		}
		else {
			ArrayList<Room> free_rooms = this.getFreeRooms();
			Random rd = new Random();
			Room root_room = free_rooms.get(rd.nextInt(free_rooms.size()));
			ArrayList<Door> free_doors = this.getFreeDoors(root_room);
			Door root_door = free_doors.get(rd.nextInt(free_doors.size()));
			
			Vector leaf_room_pos = root_room.getNeighbourPos(root_door);
			Room leaf_room = new Room(this.size(),leaf_room_pos);
			this.add(leaf_room);
			
			root_door.setTargetRoom(leaf_room);
			Door leaf_door = leaf_room.getTargetDoor(root_door.getId());
			leaf_door.setTarget(true);
		}
	}

	private ArrayList<Door> getFreeDoors(Room room) {
		// TODO Auto-generated method stub
		ArrayList<Door> free_doors = new ArrayList<Door>();
		for (Door door : room.getDoors()) {
			if (!this.hasRoomAt(room.getNeighbourPos(door))) {
				free_doors.add(door);
			}
		}
		return free_doors;
	}

	private ArrayList<Room> getFreeRooms() {
		// TODO Auto-generated method stub
		ArrayList<Room> free_rooms = new ArrayList<Room>();
		for (Room room : this) {
			int x = room.getPos().get(0);
			int y = room.getPos().get(1);
			if (!this.hasRoomAt(new Vector(x+1,y))) {
				free_rooms.add(room);
			}
			else if (!this.hasRoomAt(new Vector(x-1,y))) {
				free_rooms.add(room);
			}
			else if (!this.hasRoomAt(new Vector(x,y+1))) {
				free_rooms.add(room);
			}
			else if (!this.hasRoomAt(new Vector(x,y-1))) {
				free_rooms.add(room);
			}
		}
		return free_rooms;
	}

	private boolean hasRoomAt(Vector pos) {
		// TODO Auto-generated method stub
		for (Room room : this) {
			if (room.getPos().isEqualTo(pos)) {
				return true;
			}
		}
		return false;
	}

	public void print() {
		// TODO Auto-generated method stub
		for (Room room : this) {
			room.print();
		}
	}

}
