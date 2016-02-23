import java.util.*;
public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Kayttoliittyma liittyma = new Kayttoliittyma(lukija);
        liittyma.kaynnista();
    }
}

