package implementations.controllers;

import api.IController;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogBuilder;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import com.googlecode.lanterna.gui2.dialogs.TextInputDialogBuilder;
import com.googlecode.lanterna.screen.Screen;
import lib.internalApi.controls.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

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
    public void resolve(BinaryDecisionControl bc) {
         MessageDialogButton  choice = new MessageDialogBuilder()
                .setTitle(bc.getTitle())
                .setText(bc.getDescription())
                .addButton(MessageDialogButton.Yes)
                .addButton(MessageDialogButton.No)
                .build()
                .showDialog(gui);
         Result result;
         switch (choice) {
             case Yes:
                 result = bc.select(true);
                 break;
             default:
                 result = bc.select(false);
                 break;
         }
         alert(bc.getTitle(), result.getText());
         if (!result.isValid()) {
             resolve(bc);
         }
    }

    @Override
    public void resolve(StringControl sc) {
        String text = new TextInputDialogBuilder()
                .setTitle(sc.getTitle())
                .setDescription(sc.getDescription())
                .setValidationPattern(Pattern.compile(sc.getRegex()), "Input was invalid, must follow" + sc.getRegex())
                .build()
                .showDialog(gui);
        Result result = sc.select(text);
        alert(sc.getTitle(), result.getText());
        if (!result.isValid()) {
            resolve(sc);
        }
    }

    @Override
    public void resolve(OptionControl oc) {
        RadioBoxList<String> radioBoxList = new RadioBoxList<>();
        for (Option o : oc.getOptions()) {
            radioBoxList.addItem(o.getTitle() + " : " + o.getDescription());
        }
        Window w = new BasicWindow();
        Panel p = new Panel();
        p.addComponent(new Label(oc.getTitle() + " : " + oc.getDescription()));
        p.addComponent(new Button("OK", new Runnable() {
            @Override
            public void run() {
                w.close();
            }
        }));
        radioBoxList.addTo(p);
        w.setComponent(p);
        gui.addWindowAndWait(w);
        for (int i = 0; i < oc.getOptions().size(); i++) {
            if (radioBoxList.isChecked(i)) {
                Result result = oc.select(i);
                alert(oc.getTitle(), result.getText());
                if (!result.isValid()) {
                    resolve(oc);
                }
            }
        }

    }

    @Override
    public void resolve(MultipleSelectionControl msc) {
        CheckBoxList<String> checkBoxList = new CheckBoxList<>();
        for (Option o : msc.getOptions()) {
            checkBoxList.addItem(o.getTitle() + " : " + o.getDescription());
        }
        Window w = new BasicWindow();
        Panel p = new Panel();
        p.addComponent(new Label(msc.getTitle() + " : " + msc.getDescription()));
        p.addComponent(new Button("OK", new Runnable() {
            @Override
            public void run() {
                w.close();
            }
        }));
        checkBoxList.addTo(p);
        w.setComponent(p);
        gui.addWindowAndWait(w);
        ArrayList<Integer> checkedItems = new ArrayList<>();
        for (int i = 0; i < msc.getOptions().size(); i++) {
            if (checkBoxList.isChecked(i)) {
                checkedItems.add(i);
            }
        }
        Result result = msc.select(checkedItems);
        alert(msc.getTitle(), result.getText());
        if (!result.isValid()) {
            resolve(msc);
        }

    }
}
