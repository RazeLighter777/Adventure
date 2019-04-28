package implementations;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.ansi.TelnetTerminal;
import com.googlecode.lanterna.terminal.ansi.TelnetTerminalServer;
import implementations.controllers.LaternaController;
import lib.internalApi.controls.MultipleSelectionControl;
import lib.internalApi.controls.Option;
import lib.internalApi.controls.OptionControl;
import lib.internalApi.controls.Result;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class LaternaControllerTest {
    @Test
    public void test() {
        DefaultTerminalFactory df = new DefaultTerminalFactory();
        Terminal term;
        Screen screen = null;
        /*
        try {
            TelnetTerminalServer telnetTerminalServer = new TelnetTerminalServer(1025);
            term = telnetTerminalServer.acceptConnection();
            screen = new TerminalScreen(term);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        */
        try {
            term = df.createTerminal();
            screen = new TerminalScreen(term);
            screen.startScreen();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        LaternaController lc = new LaternaController(screen, null);
        /*
        lc.alert("", "This is a test message");

        lc.resolve(new MultipleSelectionControl("Title", "Message", null, new ArrayList<Option>(Arrays.asList(new Option[]{new Option("Example2", "Derp"), new Option("Example", "other")}))) {
            @Override
            public Result select(ArrayList<Integer> selections) {
                return new Result(false, true, "df");
            }
        });
        */
        try {
            term.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
