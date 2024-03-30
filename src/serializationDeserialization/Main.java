package serializationDeserialization;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		try {

			test1();

			test2();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static ArrayList<Name> createNames() {

		ArrayList<Name> list = new ArrayList<>();
		list.add(new Name("AB", "Ryan"));
		list.add(new Name("Audri", "Udash"));
		list.add(new Name("Ashraful", "Mahim"));
		list.add(new Name("Mukhlesur", "Rahman"));
		list.add(new Name("Jihad", "Kudu"));

		return list;

	}

	private static void test1() {

		try {
			ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("Names.txt"));
			stream.writeObject(createNames());
			stream.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private static void printNames(ArrayList<Name> list) {
		for (Name n : list)
			System.out.println(n);
	}

	private static void test2() throws ClassNotFoundException {

		try {
			ObjectInputStream stream = new ObjectInputStream(new FileInputStream("Names.txt"));

			printNames((ArrayList<Name>) stream.readObject());
			stream.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
