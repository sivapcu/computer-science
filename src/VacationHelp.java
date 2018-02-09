import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class VacationHelp {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Station[] stations = new Station[n];
		for (int i = 0; i < n; i++) {
			String[] st = br.readLine().split(" ");
			stations[i] = new Station(Long.parseLong(st[0]), Long.parseLong(st[1]));
		}

		String[] dp = br.readLine().split(" ");
		long remDist = Long.parseLong(dp[0]);
		long remFuel = Long.parseLong(dp[1]);
		if (remDist - remFuel <= 0) {
			System.out.println(0);
			System.exit(0);
		} else {
			Arrays.sort(stations);
			int stops = 0;
			int index = 0;
			long nextStop;
			while (remDist > 0 && index < n) {
				if(index > 0) {
					nextStop = stations[index].getDistance() - stations[index-1].getDistance();
				} else {
					nextStop = stations[index].getDistance();
				}
				if (nextStop > remFuel) {
					stops = -1;
					break;
				}
				remDist = remDist - nextStop;
				remFuel = remFuel - nextStop + stations[index].getCapacity();
				stops++;
				if (remDist <= remFuel) {
					stops = stops+1;
					break;
				}
				index++;
			}
			System.out.println(stops);
		}
	}
}

class Station implements Comparable<Station> {

	long distance;
	long capacity;

	public Station(long distance, long capacity) {
		this.distance = distance;
		this.capacity = capacity;
	}

	public long getDistance() {
		return distance;
	}

	public void setDistance(long distance) {
		this.distance = distance;
	}

	public long getCapacity() {
		return capacity;
	}

	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}

	@Override
	public int compareTo(Station other) {
		if (this.distance == other.distance) {
			return 0;
		} else {
			return this.distance > other.distance ? 1 : -1;
		}
	}
}
