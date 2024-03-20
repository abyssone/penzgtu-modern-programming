package org.example.ui.components;

import org.example.ui.events.EventType;
import org.example.ui.events.EventBroker;

import java.awt.*;

public class InstrumentPanel extends Panel {

    public InstrumentPanel() {
        Button addRowButton = new Button("Добавить строку");
        addRowButton.addActionListener(EventBroker.getInstance().getActionListener(EventType.ADD_ROW));
        this.add(addRowButton);

        Button deleteRowButton = new Button("Удалить строку");
        deleteRowButton.addActionListener(EventBroker.getInstance().getActionListener(EventType.DELETE_ROW));
        this.add(deleteRowButton);
        this.setVisible(true);
    }
}
