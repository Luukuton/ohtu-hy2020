package laskin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class Tapahtumankuuntelija implements EventHandler {
    private Komento edellinen = null;
    private final Map<Button, Komento> komennot;
    private final Button undo;

    public Tapahtumankuuntelija(TextField tulos, TextField syote, Button plus, Button minus, Button reset, Button undo) {
        this.undo = undo;
        komennot = new HashMap<>();
        komennot.put(plus, new Summa(tulos, syote, reset, undo));
        komennot.put(minus, new Erotus(tulos, syote, reset, undo));
        komennot.put(reset, new Reset(tulos, syote, reset, undo));
    }

    @Override
    public void handle(Event event) {
        if (event.getTarget() != undo) {
            Komento komento = komennot.get(event.getTarget());
            komento.suorita();
            edellinen = komento;
        } else {
            edellinen.peru();
            edellinen = null;
        }
    }
}
