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
public class Puhelinluettelo {
    private ArrayList<Henkilo> henkilolista;
        public Puhelinluettelo(){
            this.henkilolista = new ArrayList<Henkilo>();
        }
            public void lisaaHenkilo(String nimi){
                Henkilo henkilo = new Henkilo(nimi);
                this.henkilolista.add(henkilo);
            }
            public boolean onkoHenkiloListalla(String haettavanimi){
                int koko = henkListanKoko();
                int i;                
                for (i = 0; i < koko; i++) {
                    if(this.henkilolista.get(i).haeNimi().equals(haettavanimi)){
                        return true;    // on listalla
                    }
                }
                return false;   // ei ole listalla
            }
            public String haeHenkilonListaIndeksiNimella(String nimi){
                int koko = henkListanKoko();
                int i;                
                for (i = 0; i < koko; i++) {
                    if(this.henkilolista.get(i).haeNimi().equals(nimi)){
                        return "" + i;
                    }
                }
                return null;  // ei mene tänne mikäli nimi on oikein
            }
            public void lisaaHenkilolleNumero(String nimi, String puhnumero){
                
                String indeksi = haeHenkilonListaIndeksiNimella(nimi);
                this.henkilolista.get(Integer.parseInt(indeksi)).lisaaNumero(puhnumero);
            }
            public Henkilo haeHenkiloListaIndeksilla(String indeksi){
                return this.henkilolista.get(Integer.parseInt(indeksi));
            }
            public String haeNumerollaNimi(String puhNumero){
                int koko = henkListanKoko();
                int i;                
                for (i = 0; i < koko; i++) {
                    if(this.henkilolista.get(i).loytyykoNumero(puhNumero) == true){
                        return " "+this.henkilolista.get(i).haeNimi();
                    }
                }
                return " ei löytynyt";
            }
            public void poistaHenkilo(String nimi){
                String indeksi = haeHenkilonListaIndeksiNimella(nimi);
                this.henkilolista.remove(Integer.parseInt(indeksi));
            }
            public void testiprint(){
                System.out.println(this.henkilolista.get(0).haeKatu());
            }
            public void printtaaKaikkiHenkilotAakkosJarj(){
                Collections.sort(this.henkilolista);
                int koko = henkListanKoko();
                int i;                
                for (i = 0; i < koko; i++) {
                    System.out.println(" "+this.henkilolista.get(i).haeNimi());
                    this.henkilolista.get(i).printtaaKokoOsoite();
                    System.out.println("");
                }
            }
            public void printtaaHenkilotHakusanalla(String hakusana){
                Collections.sort(this.henkilolista);
                int koko = henkListanKoko();
                int x = 0;
                int i;                
                for (i = 0; i < koko; i++) {
                    String katu = this.henkilolista.get(i).haeKatu();
                    String kaupunki = this.henkilolista.get(i).haeKaupunki();
                    String nimi = this.henkilolista.get(i).haeNimi();
                    if(nimi.contains(hakusana) || (katu != null && katu.contains(hakusana)) || (katu != null && kaupunki.contains(hakusana))){
                        System.out.println(" "+nimi);
                        this.henkilolista.get(i).printtaaKokoOsoite();
                        x++;
                    }
                }
                if(x == 0){
                    System.out.println(" ei löytynyt");
                }
                x = 0;
            }
            public int henkListanKoko(){
                return this.henkilolista.size();
            }
}
