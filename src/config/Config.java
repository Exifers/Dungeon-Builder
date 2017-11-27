package config;

import math.Vector;

public class Config {
	public static int numberOfRooms = 17;
	public static Vector roomDimensions = new Vector(10,10,6); // width,length,height
	public static Vector corridorDimensions = new Vector(7,4,4); // length,width,height
	public static Vector inter_room_distance = getInterRoomDistance();
	
	private static Vector getInterRoomDistance() {
		// TODO Auto-generated method stub
		Vector inter_room_distance = new Vector(roomDimensions);
		inter_room_distance.add(new Vector(corridorDimensions.get(0),corridorDimensions.get(0),0));
		return inter_room_distance;
	}
}
