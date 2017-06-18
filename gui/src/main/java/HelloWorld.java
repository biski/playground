import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class HelloWorld {
    public static void main(String[] args) throws IOException {

        // Setup terminal and screen layers
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        screen.startScreen();


        Panel mainPanel = new Panel();
        mainPanel.setPreferredSize(terminal.getTerminalSize());
        mainPanel.setLayoutManager(new LinearLayout(Direction.VERTICAL));
//        mainPanel.setPreferredSize(new TerminalSize(50,10));
        mainPanel.setPosition(TerminalPosition.OFFSET_1x1);

        Panel testsInQueue = new Panel();
        Panel testsInProgress = new Panel();
        testsInProgress.setPreferredSize(new TerminalSize(50,3));
        Panel testsPassed = new Panel();
        Panel testsFailed = new Panel();
        new Label("Sample test name in progress").setBackgroundColor(TextColor.ANSI.RED).addStyle(SGR.FRAKTUR).addTo(testsInProgress);
        new Label("Sample tdsfest name in progress sadd ad").setBackgroundColor(TextColor.ANSI.GREEN).addStyle(SGR.FRAKTUR).addTo(testsInProgress);
        new Label("Sample tdsfest name in progress sadd ad").setBackgroundColor(TextColor.ANSI.GREEN).addStyle(SGR.FRAKTUR).addTo(testsInProgress);
        new Label("Sample tdsfest name in progress sadd ad").setBackgroundColor(TextColor.ANSI.GREEN).addStyle(SGR.FRAKTUR).addTo(testsInProgress);
        new Label("Sample tdsfest name in progress sadd ad").setBackgroundColor(TextColor.ANSI.GREEN).addStyle(SGR.FRAKTUR).addTo(testsInProgress);
        new Label("Sample tdsfest name in progress sadd ad").setBackgroundColor(TextColor.ANSI.GREEN).addStyle(SGR.FRAKTUR).addTo(testsInProgress);
        new Label("Sample tdsfest name in progress sadd ad").setBackgroundColor(TextColor.ANSI.GREEN).addStyle(SGR.FRAKTUR).addTo(testsInProgress);
        new Label("Sample tdsfest name in progress sadd ad").setBackgroundColor(TextColor.ANSI.GREEN).addStyle(SGR.FRAKTUR).addTo(testsInProgress);

        mainPanel.addComponent(testsInQueue.withBorder(Borders.singleLine("Tests in queue")));
        mainPanel.addComponent(testsInProgress.withBorder(Borders.singleLine("Tests in progress")));
        mainPanel.addComponent(testsPassed.withBorder(Borders.singleLine("Tests PASSED")));
        mainPanel.addComponent(testsFailed.withBorder(Borders.singleLine("Tests FAILED")));

        // Create window to hold the panel
        BasicWindow window = new BasicWindow();
        window.setComponent(mainPanel.withBorder(Borders.doubleLine("Test status")));


        // Create gui and start gui
        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.CYAN));
        gui.addWindowAndWait(window);

    }
}