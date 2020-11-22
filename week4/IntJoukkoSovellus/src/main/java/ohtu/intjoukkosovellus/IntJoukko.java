package ohtu.intjoukkosovellus;

import java.util.Arrays;

public class IntJoukko {
    public final static int KAPASITEETTI = 5, OLETUSKASVATUS = 5;
    private int kasvatuskoko, alkiotYht;
    private int[] alkiot;

    public IntJoukko() {
        alkiot = new int[KAPASITEETTI];
        Arrays.fill(alkiot, 0);

        alkiotYht = 0;
        kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) return;

        alkiot = new int[kapasiteetti];
        Arrays.fill(alkiot, 0);

        alkiotYht = 0;
        kasvatuskoko = OLETUSKASVATUS;
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) throw new IndexOutOfBoundsException("Kapasitteetti negatiivinen");
        if (kasvatuskoko < 0) throw new IndexOutOfBoundsException("Kasvatuskoko negatiivinen");

        alkiot = new int[kapasiteetti];
        Arrays.fill(alkiot, 0);

        alkiotYht = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public void lisaa(int luku) {
        if (alkiotYht == 0) {
            alkiot[0] = luku;
            alkiotYht++;
            return;
        }

        if (!kuuluu(luku)) {
            alkiot[alkiotYht] = luku;
            alkiotYht++;
            if (alkiotYht % alkiot.length == 0) {
                int[] alkiotVanha = alkiot;
                kopioiTaulukko(alkiot, alkiotVanha);
                alkiot = new int[alkiotYht + kasvatuskoko];
                kopioiTaulukko(alkiotVanha, alkiot);
            }
        }
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkiotYht; i++) {
            if (luku == alkiot[i]) return true;
        }
        return false;
    }

    public void poista(int luku) {
        int indeksi = -1;
        for (int i = 0; i < alkiotYht; i++) {
            if (luku == alkiot[i]) {
                alkiot[i] = 0;
                indeksi = i;
                break;
            }
        }

        if (indeksi != -1) {
            for (int j = indeksi; j < alkiotYht - 1; j++) {
                int apu = alkiot[j];
                alkiot[j] = alkiot[j + 1];
                alkiot[j + 1] = apu;
            }
            alkiotYht--;
        }
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        System.arraycopy(vanha, 0, uusi, 0, vanha.length);
    }

    public int mahtavuus() {
        return alkiotYht;
    }

    @Override
    public String toString() {
        if (alkiotYht == 0) return "{}";
        if (alkiotYht == 1) return "{" + alkiot[0] + "}";

        StringBuilder tulostettava = new StringBuilder("{");

        for (int i = 0; i < alkiotYht - 1; i++) {
            tulostettava.append(alkiot[i]);
            tulostettava.append(", ");
        }
        tulostettava.append(alkiot[alkiotYht - 1]);
        tulostettava.append("}");

        return tulostettava.toString();
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkiotYht];
        if (taulu.length >= 0) System.arraycopy(alkiot, 0, taulu, 0, taulu.length);

        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();

        for (int j : aTaulu) {
            x.lisaa(j);
        }
        for (int j : bTaulu) {
            x.lisaa(j);
        }

        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int k : aTaulu) {
            for (int i : bTaulu) {
                if (k == i) y.lisaa(i);
            }
        }
        return y;
    }
    
    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();

        for (int j : aTaulu) {
            z.lisaa(j);
        }
        for (int j : bTaulu) {
            z.poista(j);
        }

        return z;
    }
}
