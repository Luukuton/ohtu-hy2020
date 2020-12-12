package ohtu.kivipaperisakset;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class IO {
    private final Scanner scan;
    private final PrintStream out;

    public IO(InputStream in, PrintStream out) {
        this.scan = new Scanner(in);
        this.out = out;
    }

    public String nextLine() {
        return this.scan.nextLine();
    }

    public void println() {
        this.out.println();
    }

    public void println(String s) {
        this.out.println(s);
    }

    public void println(Object o) {
        this.out.println(o);
    }

    public String prompt(String prompt) {
        this.out.print(prompt + ": ");
        this.flushOut();
        return this.nextLine();
    }

    public void flushOut() {
        this.out.flush();
    }
}
