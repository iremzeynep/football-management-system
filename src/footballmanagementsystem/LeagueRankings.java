package footballmanagementsystem;

public class LeagueRankings {
    private final MaxHeap heap;

    public LeagueRankings(int size) {
        this.heap = new MaxHeap(size);
    }

    public void addTeam(Team team) {
        heap.insert(team);
    }

    public void updateTeam(Team updatedTeam) {
        Team[] tempArray = new Team[heap.maxSize];
        int tempSize = 0;

        Team rank = heap.extractMax();
        while (rank != null) {
            if (rank.getTeamID().equals(updatedTeam.getTeamID())) {
                rank.setTotalPoints(updatedTeam.getTotalPoints());
                rank.setGoalDifference(updatedTeam.getGoalDifference());
            }
            tempArray[tempSize++] = rank;
            rank = heap.extractMax();
        }

        for (int i = 0; i < tempSize; i++) {
            heap.insert(tempArray[i]);
        }
    }

    public void printRankings() {
        System.out.println("League Rankings:");
        heap.printHeap();
    }
}

