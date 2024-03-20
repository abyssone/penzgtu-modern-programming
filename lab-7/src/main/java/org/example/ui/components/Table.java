package org.example.ui.components;

import org.example.ui.events.EventBroker;
import org.example.ui.events.EventType;
import org.example.ui.events.MessageListener;

import java.awt.*;
import java.awt.event.ActionEvent;

public class Table extends Panel implements MessageListener {

    private static final int START_ROWS_NUMBER = 3;
    private static final int COLUMNS_NUMBER = 5;

    public Table() {
        EventBroker.getInstance().subscribeToMessages(EventType.ADD_ROW, this);
        EventBroker.getInstance().subscribeToMessages(EventType.DELETE_ROW, this);
        this.setLayout(new GridLayout(0, 1));
        this.setVisible(true);
        for (int i = 0; i < START_ROWS_NUMBER; i++) {
            addRow();
        }
    }

    public void addRow() {
        Panel row = new Panel();
        row.setVisible(true);
        row.setLayout(new GridLayout(1, COLUMNS_NUMBER));
        for (int i = 0; i < COLUMNS_NUMBER; i++) {
            row.add(new TextField());
        }
        this.add(row);
        update();
    }

    public void deleteRow() {
        int length = getComponents().length;

        if (length >= 1) {
            remove(getComponents().length - 1);
            update();
        } else {
            System.out.println("Cannot delete row, number of rows 0");
        }
    }

    @Override
    public void onMessage(EventType eventType, ActionEvent event) {
        if (eventType.equals(EventType.ADD_ROW)) {
            addRow();
        } else if (eventType.equals(EventType.DELETE_ROW)) {
            deleteRow();
        }
    }

    private void update() {
        this.revalidate();
        this.repaint();
    }
}
