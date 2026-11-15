package footballmanagementsystem;

import java.util.UUID;

public class FootballManagementSystem {

    public static void main(String[] args) {
     
        Player player1 = new Player("Arda Güler", "15", "midfielder", 2);
        Player player2 = new Player("Luka Modrić", "10", "central midfielder", 6);
        Player player3 = new Player("Vinícius Júnior", "7", "Left Wing", 12) ;
        
        Player player4 = new Player("Jules Koundé", "23", "center back", 2);
        Player player5 = new Player("Robert Lewandowski", "9", "striker", 10);
        Player player6 = new Player("Lamine Yamal", "19", "forward", 4);
        
        Team team1 = new Team("Real Madrid", UUID.randomUUID().toString(), new LinkedList(), 0, 0);
        Team team2 = new Team("Barcelona", UUID.randomUUID().toString(), new LinkedList(), 0, 0);

        Player.addPlayer(player1);
        Player.addPlayer(player2);
        Player.addPlayer(player3);
        Player.addPlayer(player4);
        Player.addPlayer(player5);
        Player.addPlayer(player6);

        Team.addPlayerToPlayerList(player1, team1);
        Team.addPlayerToPlayerList(player2, team1);
        Team.addPlayerToPlayerList(player3, team1);
        Team.addPlayerToPlayerList(player4, team2);
        Team.addPlayerToPlayerList(player5, team2);
        Team.addPlayerToPlayerList(player6, team2);
        
        Team.addTeam(team1);
        Team.addTeam(team2);

        System.out.println("Player added to team1: " + player1.getPlayerName());
        System.out.println("Player added to team1: " + player2.getPlayerName());
        System.out.println("Player added to team1: " + player3.getPlayerName());
        System.out.println("Player added to team2: " + player4.getPlayerName());
        System.out.println("Player added to team2: " + player5.getPlayerName());
        System.out.println("Player added to team2: " + player6.getPlayerName());
        
        MatchSimulation simulation = new MatchSimulation();
        simulation.scheduleMatch(team1, team2);

        System.out.println("Scheduled Matches:");
        System.out.println(simulation.getMatchQueue().toString());

        simulation.processMatches();
        simulation.retrieveLastNMatches(1);

        // Test updating points after a match
        Match match = new Match(team1, team2, 3, 1);
        simulation.updatePoints(match);

        System.out.println("Team 1 Points: " + team1.getTotalPoints());
        System.out.println("Team 2 Points: " + team2.getTotalPoints());
        
        LeagueRankings rankings = new LeagueRankings(10);
        rankings.addTeam(team1);
        rankings.addTeam(team2);

        rankings.printRankings();

        team1.setTotalPoints(10);
        rankings.updateTeam(team1);

        rankings.printRankings();
        
        SearchFunctionality search = new SearchFunctionality();
        search.addTeam(team1);
        search.addPlayer(player1);

        System.out.println("Searching for team 'Real Madrid': " + search.searchTeam("Real Madrid"));
        System.out.println("Searching for player 'Arda Güler': " + search.searchPlayer("Arda Güler"));
        
        Team.updateTeam(team1.getTeamID(), "Real Madrid", 40, 23);
        Team.deleteTeam(team2.getTeamID());
    }
}