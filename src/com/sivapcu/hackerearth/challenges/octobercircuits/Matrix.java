package com.sivapcu.hackerearth.challenges.octobercircuits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Matrix {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = (br.readLine()).split(" ");
		int numOfBuildings = Integer.parseInt(s[0]);
		int teamSize = Integer.parseInt(s[1]);

		int[][] buildings = new int[numOfBuildings][2];
		for (int i = 0; i < numOfBuildings; i++) {
			s = (br.readLine()).split(" ");
			buildings[i][0] = Integer.parseInt(s[0]);
			buildings[i][1] = Integer.parseInt(s[1]);
		}

		for (int i = 0; i < teamSize; i++) {
			s = (br.readLine()).split(" ");
			
			int startX = Integer.parseInt(s[0]);
			int startY = Integer.parseInt(s[1]);

			int endX = Integer.parseInt(s[2]);
			int endY = Integer.parseInt(s[3]);

			
			int xDistance = endX >= startX? endX-startX : startX-endX;
			int yDistance = endX >= startY? endY-startY : startY-endY;
			int biggerY = startY > endY ? startY : endY;
			int buildingEscapeDistance = calcBuildingEscDist(startX, endX, biggerY, buildings);
			System.out.println(xDistance + yDistance + (2 * buildingEscapeDistance));
		}
		br.close();
	}

	private static int calcBuildingEscDist(int startX, int endX, int biggerY, int[][] buildings) {
		int escDist = 0;
		for (int i = 0; i < buildings.length; i++) {
			if (startX < buildings[i][0] && buildings[i][0] < endX) {
				if (buildings[i][1] >= biggerY) {
					escDist = buildings[i][1] - biggerY + 1;
				}
			}
		}
		return escDist;
	}
}
