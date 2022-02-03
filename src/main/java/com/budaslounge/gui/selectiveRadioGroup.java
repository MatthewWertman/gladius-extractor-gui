package com.budaslounge.gui;
//https://stackoverflow.com/questions/37598206/how-to-deselect-already-selected-jradiobutton-by-clicking-on-it
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

public class selectiveRadioGroup extends ButtonGroup {
    private ButtonModel prevModel;
    @Override public void setSelected(ButtonModel m, boolean b) {
        if (m.equals(prevModel)) {
            clearSelection();
        } else {
            super.setSelected(m, b);
        }
        prevModel = getSelection();
    }
}
