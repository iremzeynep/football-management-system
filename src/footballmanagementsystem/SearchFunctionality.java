package footballmanagementsystem;

public class SearchFunctionality {
       private final BinarySearchTree teamBST;
    private final BinarySearchTree playerBST;

    public SearchFunctionality() {
        this.teamBST = new BinarySearchTree();
        this.playerBST = new BinarySearchTree();
    }

    // Add team to the BST
    public void addTeam(Team team) {
        teamBST.insert(team.getTeamName());
    }

    // Add player to the BST
    public void addPlayer(Player player) {
        playerBST.insert(player.getPlayerName());
    }

    // Search for team by name
    public boolean searchTeam(String teamName) {
        return teamBST.search(teamName);
    }

    // Search for player by name
    public boolean searchPlayer(String playerName) {
        return playerBST.search(playerName);
    }

    
}
