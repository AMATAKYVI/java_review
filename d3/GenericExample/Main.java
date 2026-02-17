package d3.GenericExample;




public class Main {

    public static void main(String[] args) {
        /*   BaseballTeam phillies = new BaseballTeam("Philadephia Phillies");

        phillies.addTeamMember(new BaseballPlayer("Bryce Harper", 0.309));
        phillies.addTeamMember(new BaseballPlayer("J.T. Realmuto", 0));

        BaseballTeam dodgers = new BaseballTeam("Los Angeles Dodgers");

        scoreResult(phillies, 2, dodgers, 1);
         */

        Team<FootballPlayer> eagles = new Team<>("Philadelphia Eagles");
        eagles.addTeamMember(new FootballPlayer("Jalen Hurts", 1));
        eagles.addTeamMember(new FootballPlayer("Miles Sanders", 26));

        Team<BaseballPlayer> phillies = new Team<>("West Lake");
        phillies.addTeamMember(new BaseballPlayer("Bryce Harper", 0.309));
        phillies.addTeamMember(new BaseballPlayer("J.T. Realmuto", 0));

        System.out.println("------");
        scoreResult(eagles, 2, phillies, 1);

        Team<String> justSomeTeam = new Team<>("Just Some Team ONE");
        justSomeTeam.addTeamMember("Jalen Hurts");
        justSomeTeam.addTeamMember("Miles Sanders");

        Team<Integer> justSomeTeam2 = new Team<>("Just Some Team TWO");
        justSomeTeam2.addTeamMember(1);
        justSomeTeam2.addTeamMember(2);

        scoreResult(justSomeTeam, 2, justSomeTeam2, 1);
    }

    private static void scoreResult(Team eagles, int i, Team phillies, int j) {
        eagles.scoreResult(phillies, i, j);
    }
}
