package uk.co.icecreamhead.spoof.gui;

import uk.co.icecreamhead.spoof.game.Game;
import uk.co.icecreamhead.spoof.game.UpdateListener;

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
public class GraphGui implements Runnable {
    private final Game game;
    //    int i = 1;
//    private double j = 0;
//    private Millisecond sec = new Millisecond();
    private final Vector<String> playerVector = new Vector<String>();
    private final JList<String> playerList = new JList<>(playerVector);
    private final JFrame guiFrame;
    private final JScrollPane scrollPane = new JScrollPane();
    private final JTextArea messageArea = new JTextArea();
//    private final ListDataListener dataListener;

    public void launch() {

        Container contentPane = guiFrame.getContentPane();
        contentPane.setLayout(new GridLayout(1, 2));

        /* Setup individual panels */
        // Top left panel - options
//        JPanel optionsPanel = new JPanel();
        Box leftBox = Box.createVerticalBox();
//        JLabel label = new JLabel("Number of rounds:");
//        final JTextField textField = new JTextField();
//        textField.setText("10");
//        textField.setSize(200, 50);
//        optionsPanel.add(label);
//        optionsPanel.add(textField);

        JButton button = new JButton();
        button.add(new JLabel("Start!"), BorderLayout.CENTER);
        button.setVisible(true);
        button.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.start();
            }
        });

        contentPane.add(leftBox);

        // Top Right panel - stats
        //JPanel statsPanel = new JPanel();
        //JTable table = new JTable(new Integer[][]{new Integer[]{0, 1}, new Integer[]{2, 3}}, new String[]{"Col 1", "Col 2"});
        //statsPanel.add(table);
        //contentPane.add(statsPanel);

        // Bottom left panel - players
//        JPanel playerPanel = new JPanel();


        //playerVector.add("Player 1");
        //playerVector.add("Player 2");
        leftBox.add(playerList);
        leftBox.add(button);
//        contentPane.add(playerPanel);

        // Text update panel
        Box textBox  = Box.createHorizontalBox();

        textBox.add(scrollPane);
        scrollPane.add(messageArea);
        contentPane.add(textBox);

        // Bottom right panel - graph
        //JPanel graphPanel = new JPanel();


        // JFreeChart stuff
        /*final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        final TimeSeries timeSeries = new TimeSeries("Random data");
        dataset.addValue(50, "a", new Double(0));
        dataset.addValue(0, "b", new Double(0));
        timeSeries.add(sec.next(), j);
        JFreeChart chart = ChartFactory.createTimeSeriesChart("Time series chart", "Seconds", "CPU", new TimeSeriesCollection(timeSeries));
        graphPanel.add(new ChartPanel(chart));
        contentPane.add(graphPanel);*/

        guiFrame.setVisible(true);


        /*for (int i = 0; i < 100; i++) {
            timeSeries.addOrUpdate(sec, new Double(j));
            sec = (Millisecond) sec.next();
            j = j + Math.random() - 0.5;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }

    @Override
    public void run() {
        playerList.updateUI();
        messageArea.updateUI();
        scrollPane.updateUI();
        guiFrame.repaint();
    }

    private void updateGui() {
        SwingUtilities.invokeLater(this);
    }

    public GraphGui(Game game) {
        this.game = game;

        guiFrame = new JFrame("Spoof Server GUI");
        guiFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        guiFrame.setSize(400, 160);
        guiFrame.setLocationRelativeTo(null);

        game.setUpdateListener(new UpdateListener() {
            @Override
            public void addPlayer(String player) {
                playerVector.add(player);
                updateGui();
            }

            @Override
            public void addMessage(String message) {
                messageArea.setText(message+'\n'+messageArea.getText());
            }
        });

    }
}
