package pgdp.sim;

import pgdp.sim.ui.Board;
import pgdp.sim.ui.Settings;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        // Setup der GUI
        SwingUtilities.invokeLater(() -> {
            try {
                JFrame frame = new JFrame("Pingu-Simulation");
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                Board board = new Board();
                board.setPreferredSize(new Dimension(
                        board.getWidth() * 32,
                        board.getHeight() * 32
                ));

                frame.setLayout(new BorderLayout());
                frame.add(board, BorderLayout.CENTER);

                // Optional: Einstellungs-Panel auf der rechten Seite
                var settings = new Settings();
                frame.add(settings.getSettings(), BorderLayout.EAST);

                frame.pack();
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                // Timer für die Simulation
                int delayMs = SimConfig.msBetweenTicks; // Tick alle 350 ms
                new Timer(delayMs, e -> {
                    try {
                        board.tick();
                        board.repaint();
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }).start();
            } catch (Throwable t) {
                t.printStackTrace();
            }
        });
    }
}

