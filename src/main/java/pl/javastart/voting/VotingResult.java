package pl.javastart.voting;

import java.util.List;

/**
 * Możesz dodać kolejne metody i pola do klasy. Nie zmieniaj istniejących metod.
 */
public class VotingResult {
    public static final boolean PRO_VOTE = true;
    public static final boolean AGAINST_VOTE = false;
    public static final Boolean ABSTAIN_VOTE = null;
    private List<String> voters;
    private List<Boolean> votes;

    public VotingResult(List<String> voters, List<Boolean> votes) {
        this.voters = voters;
        this.votes = votes;
    }

    /**
     * Metoda powinna drukować wyniki głosowania w takiej postaci:
     * Głosów za: 56.53%
     * Głosów przeciw: 35.00%
     * Wstrzymało się: 8.47%
     */
    public void printResults() {
        double pro = calculateVotes(votes, PRO_VOTE);
        double against = calculateVotes(votes, AGAINST_VOTE);
        double abstain = calculateVotes(votes, ABSTAIN_VOTE);

        System.out.printf("Wstrzymało się: %.2f", abstain);
        System.out.println("%");
        System.out.printf("Głosów za: %.2f", pro);
        System.out.println("%");
        System.out.printf("Głosów przeciw: %.2f", against);
        System.out.println("%\n");
    }

    private double calculateVotes(List<Boolean> votes, Boolean artOfVote) {
        int numberOfVotes = 0;
        double numberOfVotesPercent;
        for (Boolean vote : votes) {
            if (vote == artOfVote) {
                numberOfVotes++;
            }
        }
        numberOfVotesPercent = (double) numberOfVotes  * 100 / votes.size();
        return numberOfVotesPercent;
    }

    /**
     * Metoda przyjmuje imię i nazwisko głosującego, np "Zigniew Siobro".
     * Uzupełnij tę metodę, żeby drukowała informację w formie:
     * Zigniew Siobro: ZA
     * Nie zmieniaj sygnatury tej metody!
     */
    public void printVoteForVoter(String voterName) {
        for (int i = 0; i < voters.size(); i++) {
            if (voters.get(i).equals(voterName)) {
                printVoteForVoter(voterName, i);
                break;
            }
        }
    }

    private void printVoteForVoter(String voterName, int i) {
        if (votes.get(i) == null) {
            System.out.println(voterName + ": WSTRZYMAŁ SIĘ");
        } else if (votes.get(i) == AGAINST_VOTE) {
            System.out.println(voterName + ": PRZECIW");
        } else {
            System.out.println(voterName + ": ZA");
        }
    }
}
