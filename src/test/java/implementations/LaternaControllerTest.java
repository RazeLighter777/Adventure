package implementations;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.ansi.UnixTerminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;
import implementations.controllers.LaternaController;
import org.junit.Test;

import java.io.IOException;

public class LaternaControllerTest {
    @Test
    public void test() {
        DefaultTerminalFactory df = new DefaultTerminalFactory();
        Terminal term;
        Screen screen = null;
        try {
            term = df.createTerminal();
            screen = new TerminalScreen(term);
            screen.startScreen();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        LaternaController lc = new LaternaController(screen, null);
        //lc.alert("", "This is a test message");
        try {
            term.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
