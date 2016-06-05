package uk.co.icecreamhead.spoof.gui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 05/06/2016
 * Time: 15:50
 */
public class ConsoleGameView implements GameView {

    @Override
    public void updatePlayers(List<String> players) {
        printList("Players", players);
    }

    @Override
    public void announceGuess(String player, int guess) {
        System.out.println(player + " guessed " + guess + ".");
    }

    @Override
    public void announceLoser(String player, int loss) {
        System.out.println("Loser is " + player + " (" + loss + ").");
    }

    @Override
    public void updateScores(Map<String, Integer> scores) {
        printMap("Scores", scores);
    }

    private void printMap(String header, Map<?, ?> map) {
        ArrayList<String> scoreList = new ArrayList<>();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            scoreList.add(entry.getKey().toString() + "|" + entry.getValue().toString());
        }
        printList(header, scoreList);
    }

    private void printList(String header, Collection<String> list) {
        int width = header.length();
        for (String e : list) {
            width = Math.max(e.length(), width);
        }
        printDivider(width);
        printLine(header, width);
        printDivider(width);
        for (String line : list) {
            printLine(line, width);
        }
        printDivider(width);
    }

    private void printDivider(int width) {
        System.out.print("|");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.print("|\n");
    }

    private void printLine(String text, int width) {
        int pad = width - text.length();
        System.out.print("|" + text);
        for (int i = 0; i < pad; i++) {
            System.out.print(" ");
        }
        System.out.print("|\n");
    }
}
