package footballmanagementsystem;

public class Team {
    private final String teamName;
    private String teamID;
    private LinkedList playerList;
    private int totalPoints;
    private int goalDifference;
    private static final HashTable teamTable = new HashTable(21);

    
    public Team(String teamName) {
        this.teamName = teamName;
        this.playerList = new LinkedList();
        this.totalPoints = 0;
        this.goalDifference = 0;
    }
    
    
    public Team(String teamName, String teamID, LinkedList playerList, int totalPoints, int goalDifference) {
        this.teamName = teamName;
        this.teamID = teamID;
        this.playerList = playerList;
        this.totalPoints = totalPoints;
        this.goalDifference = goalDifference;
    }

    public void setTeamID(String teamID) { this.teamID = teamID; }
    public void setPlayerList(LinkedList playerList) { this.playerList = playerList; }
    
    public String getTeamName() { return teamName; }
    public String getTeamID() { return teamID; }
    public LinkedList getPlayerList() { return playerList; }
    public int getTotalPoints() { return totalPoints; }
    public void setTotalPoints(int totalPoints) { this.totalPoints = totalPoints; }
    public int getGoalDifference() { return goalDifference; }
    public void setGoalDifference(int goalDifference) { this.goalDifference = goalDifference; }
    
    public static void addPlayerToPlayerList(Player player, Team team) {
        team.playerList.addNode(new Node(player.getPlayerID(), player.getPlayerName()));
    }

    public static void addTeam(Team team) {
        if (!teamTable.searchLinear(team.teamID.hashCode())) {
            teamTable.putLinear(team.teamID.hashCode());
            System.out.println("Team added: " + team.teamName);
        } else {
            System.out.println("This team is previously added.");
        }
    }

    public static void deleteTeam(String teamID) {
        if (teamTable.searchLinear(teamID.hashCode())) {
            teamTable.delete(teamID.hashCode());
            System.out.println("Team deleted: " + teamID);
        } else {
            System.out.println("Team does not exist.");
        }
    }
    
    public static void updateTeam(String teamID, String newTeamName, int newTotalPoints, int newGoalDifference) {
        if (teamTable.searchLinear(teamID.hashCode())) {
            Team updatedTeam = new Team(newTeamName);
            updatedTeam.teamID = teamID; 
            updatedTeam.setTotalPoints(newTotalPoints);
            updatedTeam.setGoalDifference(newGoalDifference);

            teamTable.delete(teamID.hashCode()); 
            teamTable.putLinear(updatedTeam.getTeamID().hashCode()); 

            System.out.println("Team updated ");
        } else {
            System.out.println("Team does not exist.");
        }
    }
}