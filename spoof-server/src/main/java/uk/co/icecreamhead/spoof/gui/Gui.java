package uk.co.icecreamhead.spoof.gui;

import uk.co.icecreamhead.spoof.game.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created with IntelliJ IDEA.
 * User: joshcooke
 * Date: 05/04/15
 * Time: 22:09
 */
public class Gui {
    private final Game game;

    public void launch() {
        JFrame guiFrame = new JFrame();

        guiFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        guiFrame.setTitle("Spoof Server GUI");
        guiFrame.setSize(600,400);

        guiFrame.setLocationRelativeTo(null);

        JButton button = new JButton();
        button.setText("Start game!");
        button.setVisible(true);
        button.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.start();
            }
        });

        guiFrame.add(button);
        guiFrame.setVisible(true);
    }

    public Gui(Game game) {
        this.game = game;
    }
}
