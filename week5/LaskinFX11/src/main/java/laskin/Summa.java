package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Sovelluslogiikka {
    public Summa(TextField tulos, TextField syote, Button reset, Button undo) {
        super(tulos, syote, reset, undo);
    }

    @Override
    protected int laske(int edellinen, int syote) {
        return edellinen + syote;
    }
}
