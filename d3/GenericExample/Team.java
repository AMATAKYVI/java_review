package d3.GenericExample;

import java.util.ArrayList;
import java.util.List;

public class Team<T> {

    private String teamName;
    private List<T> teamMembers = new ArrayList<>();

    private int wins = 0, losses = 0, ties = 0;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public void addTeamMember(T teamMember) {
        if (!teamMembers.contains(teamMember)) {
            teamMembers.add(teamMember);
            System.out.println("Adding " + teamMember + " to " + teamName);
        } else {
            System.out.println(teamMember + " is already on " + teamName);
        }
    }

    public void scoreResult(Team<T> opponent, int ourScore, int theirScore) {
        if (ourScore > theirScore) {
            wins++;
        } else if (ourScore < theirScore) {
            losses++;
        } else {
            ties++;
        }
        System.out.println(teamName + " scored " + ourScore + " points against " + opponent.teamName + " who scored " + theirScore);
    }

    @Override
    public String toString() {
        return teamName + " with members: " + teamMembers + " (W:" + wins + ", L:" + losses + ", T:" + ties + ")";
    }
}
