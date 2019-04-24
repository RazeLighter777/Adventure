package implementations.controllers;

import api.IController;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogBuilder;
import com.googlecode.lanterna.screen.Screen;
import lib.internalApi.controls.*;

import java.io.IOException;
import java.util.ArrayList;

public class LaternaController implements IController {

    WindowBasedTextGUI gui;

    Screen screen;

    IControllable subject;

    public LaternaController(Screen screen, IControllable controllable) {
        subject = controllable;
        this.screen = screen;
        gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLACK));
        System.out.println(gui.isPendingUpdate());
        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void alert(String title, String al) {
        new MessageDialogBuilder().setTitle(title).setText(al).build().showDialog(gui);

    }

    @Override
    public void vibrate(double len, double intensity) {

    }

    @Override
    public void presentControls(Controls c) {

    }

    public void displayResult(Result r) {}

    @Override
    public void resolveControls(Controls c) {
        for (MultipleSelectionControl msc : c.msc) {
            ArrayList<Option> ops = msc.getOptions();
            TerminalSize size = new TerminalSize(14, 10);
            CheckBoxList<String> checkBoxList = new CheckBoxList<String>(size);
            for (Option o : ops) {
                checkBoxList.addItem(o.getTitle() + " : " + o.getDescription());
            }
            ArrayList<Integer> selectedIntegers = new ArrayList<>();
            for (int i = 0; i < ops.size(); i++) {
                if (checkBoxList.isChecked(i)) {
                    selectedIntegers.add(i);
                }
            }
            displayResult(msc.select(selectedIntegers));
        }
    }
}
