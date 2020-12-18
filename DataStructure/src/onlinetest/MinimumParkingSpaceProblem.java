package onlinetest;

import java.io.*;
import java.util.*;

public class MinimumParkingSpaceProblem {

	static List<Slot> slots = new ArrayList<MinimumParkingSpaceProblem.Slot>();

	static class Slot {

		private int maxParking;
		private int startTime;
		private int endtime;

		public Slot(int maxParking, int startTime, int endtime) {
			super();
			this.maxParking = maxParking;
			this.startTime = startTime;
			this.endtime = endtime;
		}

		public int getMaxParking() {
			return maxParking;
		}

		public void setMaxParking(int maxParking) {
			this.maxParking = maxParking;
		}

		public int getStartTime() {
			return startTime;
		}

		public void setStartTime(int startTime) {
			this.startTime = startTime;
		}

		public int getEndtime() {
			return endtime;
		}

		public void setEndtime(int endtime) {
			this.endtime = endtime;
		}

	}

	static int minParkingSpaces(int[][] parkingStartEndTimes) {
		
		int maxParking=Integer.MIN_VALUE;
		for (int i = 0; i < parkingStartEndTimes.length; i++) {
				boolean found = false;
				for(Slot slot :slots) {
					if(checkIfSlotExist(slot, parkingStartEndTimes[i][0],parkingStartEndTimes[i][1])) {
						if(slot.getMaxParking()> maxParking) {
							maxParking = slot.getMaxParking();
						}
						found = true;
					}
				}
				if(!found) {
					Slot tempSlot = new Slot(1, parkingStartEndTimes[i][0], parkingStartEndTimes[i][1]);
					if(maxParking <1) {
						maxParking = 1;
					}
					slots.add(tempSlot);
				}
		}
		return maxParking;
	}

	private static boolean checkIfSlotExist(Slot slot, int startTime, int endTime) {
		if(startTime<=slot.getStartTime()&& endTime>=slot.getEndtime()) {
			slot.setMaxParking(slot.getMaxParking()+1);
			slot.setStartTime(startTime);
			slot.setEndtime(endTime);
			return true;
		}
		if(startTime>=slot.getStartTime()&& endTime<=slot.getEndtime()) {
			slot.setMaxParking(slot.getMaxParking()+1);
			return true;
		}
		if(startTime<=slot.getEndtime()&& endTime>=slot.getEndtime()) {
			slot.setMaxParking(slot.getMaxParking()+1);
			slot.setEndtime(endTime);
			return true;
		}
		return false;
	}

	// DO NOT MODIFY ANYTHING BELOW THIS LINE!!

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine().trim());
		int[][] parkingStartEndTimeList = new int[n][2];
		String[] parkingStartEndTimes = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			String[] parkingStartEndTime = parkingStartEndTimes[i].split(",");
			for (int j = 0; j < parkingStartEndTime.length; j++) {
				parkingStartEndTimeList[i][j] = Integer.parseInt(parkingStartEndTime[j]);
			}
		}

		int out = minParkingSpaces(parkingStartEndTimeList);
		System.out.println(out);

		wr.close();
		br.close();
	}

}