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
public class Kayttoliittyma {
    private Scanner lukija;
    private Puhelinluettelo puhelinluettelo;
        public Kayttoliittyma(Scanner lukija){
            this.lukija = new Scanner(System.in);
            this.puhelinluettelo = new Puhelinluettelo();
        }
        public void kaynnista(){
           String syote;
            
            System.out.println("numerotiedustelu");
            System.out.println("käytettävissä olevat komennot:");
            System.out.println(" 1 lisää numero");
            System.out.println(" 2 hae numerot");
            System.out.println(" 3 hae puhelinnumeroa vastaava henkilö");
            System.out.println(" 4 lisää osoite");
            System.out.println(" 5 hae henkilön tiedot");
            System.out.println(" 6 poista henkilön tiedot");
            System.out.println(" 7 filtteröity listaus");
            System.out.println(" x lopeta\n");
            
            for(;;){
                System.out.print("komento: ");
                syote = lukija.nextLine();
                
                if(syote.equals("x")){
                    break;
                }
                else if(syote.equals("1")){
                    System.out.print("kenelle: ");
                    syote = lukija.nextLine();
                    String x = syote;
                    if(this.puhelinluettelo.onkoHenkiloListalla(syote) == false){
                        this.puhelinluettelo.lisaaHenkilo(syote);
                    }
                    System.out.print("numero: ");
                    syote = lukija.nextLine();
                    this.puhelinluettelo.lisaaHenkilolleNumero(x, syote);   //nimi, numero
                }
                else if(syote.equals("2")){
                    System.out.print("kenen: ");
                    syote = lukija.nextLine();
                    if(this.puhelinluettelo.onkoHenkiloListalla(syote) == false){
                        System.out.println("  ei löytynyt");
                    }
                    else{
                        String indeksi = this.puhelinluettelo.haeHenkilonListaIndeksiNimella(syote);
                        this.puhelinluettelo.haeHenkiloListaIndeksilla(indeksi).tulostaPuhelinNumerot();
                    }    
                }
                else if(syote.equals("3")){
                    System.out.print("numero: ");
                    syote = lukija.nextLine();
                    String x = syote;
                    System.out.println(this.puhelinluettelo.haeNumerollaNimi(syote));
                }
                else if(syote.equals("4")){
                    System.out.print("kenelle: ");
                    syote = lukija.nextLine();
                    String kenelle = syote;
                    System.out.print("katu: ");
                    syote = lukija.nextLine();
                    String katu = syote;
                    System.out.print("kaupunki: ");
                    syote = lukija.nextLine();
                    if(this.puhelinluettelo.onkoHenkiloListalla(kenelle) == false){
                        this.puhelinluettelo.lisaaHenkilo(kenelle);
                    }
                    String indeksi = this.puhelinluettelo.haeHenkilonListaIndeksiNimella(kenelle);
                    this.puhelinluettelo.haeHenkiloListaIndeksilla(indeksi).asetaOsoite(katu, syote);
                }
                else if(syote.equals("5")){
                    System.out.print("kenen: ");
                    syote = lukija.nextLine();
                    if(this.puhelinluettelo.onkoHenkiloListalla(syote) == false){
                        System.out.println("  ei löytynyt");
                    }
                    else{
                        String indeksi = this.puhelinluettelo.haeHenkilonListaIndeksiNimella(syote);
                        this.puhelinluettelo.haeHenkiloListaIndeksilla(indeksi).printtaaKokoOsoite();
                    }
                }
                else if(syote.equals("6")){
                    System.out.print("kenet: ");
                    syote = lukija.nextLine();
                    if(this.puhelinluettelo.onkoHenkiloListalla(syote) == true){
                        this.puhelinluettelo.poistaHenkilo(syote);
                    }
                }
                else if(syote.equals("7")){
                    System.out.print("hakusana (jos tyhjä, listataan kaikki): ");
                    syote = lukija.nextLine();
                    if(syote.equals("")){
                        this.puhelinluettelo.printtaaKaikkiHenkilotAakkosJarj();
                    }
                    else{
                        this.puhelinluettelo.printtaaHenkilotHakusanalla(syote);
                    }
                }
                else if(syote.equals("8")){
                    this.puhelinluettelo.testiprint();
                }
                
                System.out.println(""); //rivinvaihto        
            }

        }
}
