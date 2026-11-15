package footballmanagementsystem;

import java.util.Random;

public class MatchSimulation {
    private final Queue<Match> matchQueue;
    private final Stack<Match> matchStack;
    private Stack<Match> tempStack;

    public MatchSimulation(Queue<Match> matchQueue, Stack<Match> matchStack, Stack<Match> tempStack) {
        this.matchQueue = matchQueue;
        this.matchStack = matchStack;
        this.tempStack = tempStack;
    }

    public Queue<Match> getMatchQueue() {
        return matchQueue;
    }

    public Stack<Match> getMatchStack() {
        return matchStack;
    }

    public Stack<Match> getTempStack() {
        return tempStack;
    }

    public void setTempStack(Stack<Match> tempStack) {
        this.tempStack = tempStack;
    }
    
    

    public MatchSimulation() {
        this.matchQueue = new Queue<>();
        this.matchStack = new Stack<>(100); // Assuming a maximum of 100 matches for simplicity
        
    }

    public void scheduleMatch(Team team1, Team team2) {
        matchQueue.enqueue(new Match(team1, team2, 0, 0)); // Scores will be set during processing
    }

    public void processMatches() {
        Random random = new Random();
        while (!matchQueue.isEmpty()) {
            Match match = matchQueue.dequeue();
            int team1Score = random.nextInt(5); // Random score for team1 (0 to 4)
            int team2Score = random.nextInt(5); // Random score for team2 (0 to 4)
            match = new Match(match.getTeam1(), match.getTeam2(), team1Score, team2Score);
            matchStack.push(match);
            System.out.println(match.toString());
        }
    }
    public void updatePoints(Match match){
        Team team1 = match.getTeam1();
        Team team2 = match.getTeam2();
        int score1 = match.getTeam1Score();
        int score2 = match.getTeam2Score();
        
        team1.setGoalDifference(team1.getGoalDifference() +(score1 - score2) );
        team2.setGoalDifference(team2.getGoalDifference() + (score2 - score1));
        if (score1 > score2) {
            team1.setTotalPoints(team1.getTotalPoints() + 3);
        } else if (score1 < score2) {
            team2.setTotalPoints(team2.getTotalPoints() + 3);
        } else {
            team1.setTotalPoints(team1.getTotalPoints() + 1);
            team2.setTotalPoints(team2.getTotalPoints() + 1);
        }
    }

    public void auditMatches() {
        System.out.println("Match Audit:");
        while (!matchStack.isEmpty()) {
            Match match = matchStack.pop();
            System.out.println(match.toString());
        }
    }
     public void retrieveLastNMatches(int n) {
        System.out.println("Last " + n + " match results:");
        this.tempStack = new Stack<>(n);
        int count = 0;
        while (count < n && !matchStack.isEmpty()) {
            Match match = matchStack.pop();
            tempStack.push(match);
            System.out.println(match.toString());
            count++;
        }
        while (!tempStack.isEmpty()) {
            matchStack.push(tempStack.pop());
        }
    }
    
}

