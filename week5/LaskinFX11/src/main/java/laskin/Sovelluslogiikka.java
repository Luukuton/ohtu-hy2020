package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Sovelluslogiikka implements Komento {
    private final TextField tulos, syote;
    private final Button reset, undo;
    private int edellinenTulos;
    
    public Sovelluslogiikka(TextField tulos, TextField syote, Button reset, Button undo) {
        this.tulos = tulos;
        this.syote = syote;
        this.reset = reset;
        this.undo = undo;
    }

    @Override
    public void suorita() {
        try {
            edellinenTulos = Integer.parseInt(tulos.getText());
            int result = laske(edellinenTulos, Integer.parseInt("0" + syote.getText()));

            syote.setText("");
            tulos.setText("" + result);

            reset.disableProperty().set(result == 0);
            undo.disableProperty().set(false);
        } catch(Exception ignored) {}
    }

    @Override
    public void peru() {
        tulos.setText("" + edellinenTulos);
        reset.disableProperty().set(edellinenTulos == 0);
        undo.disableProperty().set(true);
    }

    protected abstract int laske(int edellinen, int syote);
}
