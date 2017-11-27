package math;

import java.util.ArrayList;

public class Range extends ArrayList<Integer>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Range() {
		
	}
	
	public ArrayList<Integer> getRange(int start_value,int end_value) {
		ArrayList<Integer> range = new ArrayList<Integer>();
		if (start_value <= end_value) {
			for (int i=start_value ; i<=end_value ; i++) {
				range.add(i);
			}
		}
		else if (start_value > end_value) {
			for (int i=start_value ; i>=end_value ; i--) {
				range.add(i);
			}
		}
		return range;
	}
}
