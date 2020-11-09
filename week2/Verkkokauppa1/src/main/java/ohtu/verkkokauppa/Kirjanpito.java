package ohtu.verkkokauppa;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Kirjanpito implements KirjanpitoInterface {
    
    private final ArrayList<String> tapahtumat;

    public Kirjanpito() {
        tapahtumat = new ArrayList<>();
    }
    
    @Override
    public void lisaaTapahtuma(String tapahtuma) {
        tapahtumat.add(tapahtuma);
    }

    @Override
    public ArrayList<String> getTapahtumat() {
        return tapahtumat;
    }       
}
