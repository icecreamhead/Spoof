package uk.co.icecreamhead.spoof.gui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import uk.co.icecreamhead.spoof.game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 05/04/15
 * Time: 22:09
 */
public class Gui {
    private final Game game;
    //    int i = 1;
    private double j = 0;
    private Millisecond sec = new Millisecond();
    private final Vector<String> playerVector = new Vector<String>();
    private final JList<String> playerList = new JList<String>(playerVector);

    public void launch() {
        JFrame guiFrame = new JFrame("Spoof Server GUI");
        guiFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        guiFrame.setSize(1200, 800);
        guiFrame.setLocationRelativeTo(null);
        Container contentPane = guiFrame.getContentPane();
        contentPane.setLayout(new GridLayout(2, 2));

        /* Setup individual panels */
        // Top left panel - options
        JPanel optionsPanel = new JPanel();
        JLabel label = new JLabel("Number of rounds:");
        final JTextField textField = new JTextField();
        textField.setSize(200, 50);
        optionsPanel.add(label);
        optionsPanel.add(textField);

        JButton button = new JButton();
        button.add(new JLabel("Start game!"), BorderLayout.CENTER);
        button.setVisible(true);
        button.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.start();
                playerVector.add(textField.getText());
                playerList.updateUI();
            }
        });
        optionsPanel.add(button);
        contentPane.add(optionsPanel);

        // Top Right panel - stats
        JPanel statsPanel = new JPanel();
        JTable table = new JTable(new Integer[][]{new Integer[]{0, 1}, new Integer[]{2, 3}}, new String[]{"Col 1", "Col 2"});
        statsPanel.add(table);
        contentPane.add(statsPanel);

        // Bottom left panel - players
        JPanel playerPanel = new JPanel();


        playerVector.add("Player 1");
        playerVector.add("Player 2");
        playerPanel.add(playerList);
        contentPane.add(playerPanel);

        // Bottom right panel - graph
        JPanel graphPanel = new JPanel();


        // JFreeChart stuff
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        final TimeSeries timeSeries = new TimeSeries("Random data");
        dataset.addValue(50, "a", new Double(0));
        dataset.addValue(0, "b", new Double(0));
        timeSeries.add(sec.next(), j);
        JFreeChart chart = ChartFactory.createTimeSeriesChart("Time series chart", "Seconds", "CPU", new TimeSeriesCollection(timeSeries));
        graphPanel.add(new ChartPanel(chart));
        contentPane.add(graphPanel);

        guiFrame.setVisible(true);


        for (int i = 0; i < 100; i++) {
            timeSeries.addOrUpdate(sec, new Double(j));
            sec = (Millisecond) sec.next();
            j = j + Math.random() - 0.5;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Gui(Game game) {
        this.game = game;
    }
}
