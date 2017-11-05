package com.sivapcu.hackerearth.challenges.noveasy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FurthestPoint {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfOperations = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		List<Location> locations = new ArrayList<>();
		for (int i = 0; i < numOfOperations; i++) {
			st = new StringTokenizer(br.readLine());
			if (Integer.parseInt(st.nextToken()) == 0) {
				locations.add(new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			} else {
				Location target = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				Rectangle rectangle = new Rectangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				long distance = rectangle.findGreatestManhattanDistance(locations, target);
				if(distance == -1) {
					System.out.println("no point!");
				} else {
					System.out.println(distance);
				}
			}
		}
	}
}

class Rectangle {
	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public Rectangle(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public long findGreatestManhattanDistance(List<Location> locations, Location target) {
		long output = -1;
		for(Location l : locations) {
			if((x1 <= l.getX() && x2 >= l.getX()) && (y1 <= l.getY() && y2 >= l.getY())) {
				long dist = Math.abs(target.getX() - l.getX()) + Math.abs(target.getY() - l.getY());
				if(dist > output)  {
					output = dist;
				}
			}
		}
		return output;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

}

class Location {
	private int x;
	private int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
