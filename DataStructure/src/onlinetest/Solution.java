package onlinetest;

import java.util.*;

public class Solution {
    public static class PlayerStatisticsCollectorImpl implements PlayerStatisticsCollector {
    		
    	
    	Map<String,Player>players;
    	
    	public PlayerStatisticsCollectorImpl() {
    		players = new HashMap<String,Player>();
		}
    	
    	class Player{
    		private String playerName;
    		private int innings;
    		private double totalRuns;
    		
    		
    		
			public Player(String playerName, int innings, double totalRuns) {
				this.playerName = playerName;
				this.innings = innings;
				this.totalRuns = totalRuns;
			}
			public String getPlayerName() {
				return playerName;
			}
			public void setPlayerName(String playerName) {
				this.playerName = playerName;
			}
			public int getInnings() {
				return innings;
			}
			public void setInnings(int innings) {
				this.innings = innings;
			}
			public double getTotalRuns() {
				return totalRuns;
			}
			public void setTotalRuns(double totalRuns) {
				this.totalRuns = totalRuns;
			}
    		
    		
    	}
    	
        @Override
        public void putNewInnings(String player, int runs){
        	Player tempPlayer = players.get(player);
        	 if(tempPlayer == null) {
        		 Player pl = new Player(player, 1, runs);
        		 players.put(player, pl);
        	 }else {
        		 tempPlayer.setInnings(tempPlayer.getInnings()+1);
        		 tempPlayer.setTotalRuns(tempPlayer.getTotalRuns()+runs);
        	 }
        }

        @Override
        public double getAverageRuns(String player){
        	Player tempPlayer = players.get(player);
       	 if(tempPlayer == null) {
       		 return 0;
    	 }else {
    		 return tempPlayer.getTotalRuns()/tempPlayer.getInnings();
    	 }
        }

        @Override
        public int getInningsCount(String player){
        	return players.get(player).getInnings();
        }
    }

    ////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

    public interface PlayerStatisticsCollector {
        // This is an input. Make note of this player inning.  Runs is a non negative integer.
        void putNewInnings(String player, int runs);

        // Get the runs average(mathematical average) for a player
        double getAverageRuns(String player);

        // Get the total number of innings for the player
        int getInningsCount(String player);
    }

    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
        int numLines = Integer.parseInt(scanner.nextLine());
        int currentLine = 0;
        while (currentLine++ < numLines) {
            final PlayerStatisticsCollector stats = new PlayerStatisticsCollectorImpl();
            final Set<String> players = new TreeSet<>();

            String line = scanner.nextLine();
            String[] inputs = line.split(",");
            for (int i = 0; i < inputs.length; ++i) {
                String[] tokens = inputs[i].split(" ");
                final String player = tokens[0];
                players.add(player);
                final int runs = Integer.parseInt(tokens[1]);

                stats.putNewInnings(player, runs);

            }

            for (String player : players) {
                System.out.println(
                        String.format("%s %.4f %d", player, stats.getAverageRuns(player), stats.getInningsCount(player)));
            }

        }
        scanner.close();

    }
}

