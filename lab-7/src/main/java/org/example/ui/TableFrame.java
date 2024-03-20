package org.example.ui;

import org.example.ui.components.InstrumentPanel;
import org.example.ui.components.Table;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TableFrame extends Frame {

    public static void init() {
        Frame frame = new Frame();
        frame.setLayout(new BorderLayout());

        frame.setBounds(0, 0, 800, 800);

        frame.add(new InstrumentPanel(), BorderLayout.NORTH);
        frame.add(new Table(), BorderLayout.CENTER);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }
}
