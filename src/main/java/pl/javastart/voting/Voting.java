package pl.javastart.voting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Voting {

    public static void main(String[] args) {
        List<String> voters = new ArrayList<>();

        // możesz dowolnie dodawać / usuwać dane testowe
        voters.add("Jan Kowalski");
        voters.add("Zigniew Siobro");
        voters.add("Zbyszek Stonoga");

        Voting voting = new Voting();

        VotingResult votingResult = voting.executeVoting(voters, new Scanner(System.in));
        votingResult.printResults();
        votingResult.printVoteForVoter("Zigniew Siobro");
    }

    /**
     * Uzupełnij metodę metodę, ale nie zmieniaj jej sygnatury! (typu tego, co przyjmuje i zwraca).
     * do wczytywania danych od użytkownika użyj scannera z parametru
     * Metoda powinna pobrać głos dla każdego przekazanego głosującego i zapisać wyniki głosowania do VotingResult
     */
    VotingResult executeVoting(List<String> voters, Scanner scanner) {
        List<Boolean> votes = new ArrayList<>(voters.size());
        Boolean voteBoolean = null;
        for (String voter : voters) {
            boolean result = false;
            do {
                System.out.println("Jak głosuje " + voter + "? (z - za, p - przeciw, w - wstrzymanie się)");
                String voteString = scanner.nextLine();
                switch (voteString) {
                    case "z":
                        voteBoolean = true;
                        result = true;
                        break;
                    case "p":
                        voteBoolean = false;
                        result = true;
                        break;
                    case "w":
                        voteBoolean = null;
                        result = true;
                        break;
                    default:
                        System.out.println("Niepoprawny głos, spróbuj jeszcze raz");
                }
            } while (!result);
            votes.add(voteBoolean);
        }
        scanner.close();
        return new VotingResult(voters, votes);
    }
}
