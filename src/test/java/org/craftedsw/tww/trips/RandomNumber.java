package org.craftedsw.tww.trips;

import java.util.Random;

public class RandomNumber {
	
	public static void main(String[] args) {
		Random r = new Random();
		System.out.println(r.nextInt(30) + 1);
		System.out.println(r.nextInt(30) + 1);
	}

}
