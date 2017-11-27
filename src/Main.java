import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import structure.Structure;
import map.Map;


public class Main {
	public static void main(String[] Args) {
		System.out.println("Galerie builder v2.0");
		System.out.println("Building the map ...");
		Map map = new Map();
		//map.print();
		System.out.println("Building the structure ...");
		Structure structure = new Structure(map);
		System.out.println("Writing the code down ...");
		write_code(structure);
		System.out.println("done");
	}

	private static void write_code(Structure structure) {
		// TODO Auto-generated method stub
		String code = "G=[";
		for (int i=0 ; i<structure.size()-1 ; i++) {
			code += (structure.get(i).toString()+",");
		}
		code += structure.get(structure.size()-1).toString();
		code += "]";
		String file = "C:/Program Files (x86)/MCEdit-0.1.7.1.win-amd64/MCEdit-0.1.7.1.win-amd64/filters/build_galerie.py";
		code = "inputs = ()"
				+ "\n"+code
				+ "\ndef perform(level, box, options):"
				+ "\n\tfor b in G:"
				+ "\n\t\t# (x,y,z) triplets in galerie are so that z is the vertical axis"
				+ "\n\t\tlevel.setBlockAt(box.minx+b[0],box.miny+b[2],box.minz+b[1],b[3])";
		try {
			FileWriter fw = new FileWriter(file, false);
			BufferedWriter output = new BufferedWriter(fw);
			output.write(code);
			output.flush();
			output.close();
			System.out.println("the code has been written successfully");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
