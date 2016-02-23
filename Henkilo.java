import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AnonymousX
 */
public class Henkilo implements Comparable<Henkilo>{
    private ArrayList<String> puhelinnumerot;
    private String nimi;
    private HashMap<String, String> osote;
        public Henkilo(String nimi){
            this.puhelinnumerot = new ArrayList<String>();
            this.nimi = nimi;
            this.osote = new HashMap<String, String>();
        }
            public void lisaaNumero(String numero){
                this.puhelinnumerot.add(numero);
            }
            public void asetaOsoite(String katu, String kaupunki){
                this.osote.put(katu, kaupunki);
            }
            public String haeNimi(){
                return this.nimi;
            }
            public void printtaaKokoOsoite(){
                if(this.osote.isEmpty()){
                    System.out.println("  osoite ei tiedossa");
                }
                else{
                    System.out.println("  osoite: " + haeKatu() + " " + haeKaupunki());
                }
                if(this.puhelinnumerot.isEmpty()){
                    System.out.println("  ei puhelinta");
                }
                else{
                    System.out.println("  puhelinnumerot:");
                    int koko = puhlistankoko();
                    int i;                
                    for (i = 0; i < koko; i++) {
                        System.out.println("   " + this.puhelinnumerot.get(i));
                    }
                }
            }
            public String haeKatu(){
                for (String avain : this.osote.keySet()) {
                    return avain;
                }
                return null;    // ei mene tänne ikinä
            }
            public String haeKaupunki(){
                for (String avain : this.osote.keySet()) {
                    return this.osote.get(avain);
                }
                return null;    //ei mene tänne ikinä
            }
            public boolean loytyykoNumero(String puhNumero){
                int koko = puhlistankoko();
                int i;                
                for (i = 0; i < koko; i++) {
                    if(this.puhelinnumerot.get(i).equals(puhNumero)){
                        return true;
                    }
                }
                return false;
            }
            public void tulostaPuhelinNumerot(){
                int koko = puhlistankoko();
                if(koko == 0){
                    System.out.println("  ei puhelinta");
                }
                int i;                
                for (i = 0; i < koko; i++) {
                    System.out.println(" " + this.puhelinnumerot.get(i));
                }
            }
            public void nollaaPoistaOsoite(){
                this.osote.clear();
            }
            public int haeNimenAscii(){
                return this.nimi.charAt(0);
            }
            public int puhlistankoko(){
                return this.puhelinnumerot.size();
            }
            public int compareTo(Henkilo verrattava){
                if(haeNimenAscii() > verrattava.haeNimenAscii()){
                    return 1;
                }
                else if(haeNimenAscii() < verrattava.haeNimenAscii()){
                    return -1;
                }
                else{
                    return 0;
                }
            }
}
