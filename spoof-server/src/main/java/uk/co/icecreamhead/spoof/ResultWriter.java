package uk.co.icecreamhead.spoof;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 28/04/2013
 * Time: 16:48
 * To change this template use File | Settings | File Templates.
 */
public class ResultWriter {

    private File outputFile;
    private HashMap<Player,Queue<Integer>> scores;
    private int numRounds;

    public ResultWriter(String outputFile) {
        this.outputFile = new File(outputFile);
        scores = new HashMap<Player, Queue<Integer>>();
        numRounds = 0;
    }

    public File getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = new File(outputFile);
    }

    public void addRoundScores(LinkedHashMap<Player,Integer> roundScores) {
        for (Player player : roundScores.keySet()) {
            if (!scores.containsKey(player)) {
                scores.put(player,new LinkedList<Integer>());
            }
            scores.get(player).offer(roundScores.get(player));
        }
        numRounds++;
    }

    public boolean write() {
        try {
            PrintWriter writer = new PrintWriter(outputFile);
            StringBuilder headings = new StringBuilder();
            headings.append("Round,");
            for (int i = 1; i <= numRounds;i++) {
                headings.append(i+",");
            }
            headings.append("Total,");
            writer.println(headings);

            for (Player player : scores.keySet()) {
                StringBuilder playerScoreOutput = new StringBuilder();
                playerScoreOutput.append(player.getName()+",");
                int playerTotal = 0;
                Queue<Integer> playerScores = scores.get(player);
                while (!playerScores.isEmpty()) {
                    int score = playerScores.remove();
                    playerScoreOutput.append(score+",");
                    playerTotal+=score;
                }
                playerScoreOutput.append(playerTotal+",");
                writer.println(playerScoreOutput);
            }
            writer.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
