package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        boolean running = true;

        Scanner chat = new Scanner(System.in);
        HypotheekBerekenen hypo = new HypotheekBerekenen();

        hypo.intro();
        System.out.println("Kies je opties: 1 - Hypotheek aanvraag, 2 - test, 3 - test, 4 - Stop");

        while(running){

            int start = chat.nextInt();

            switch (start){
                case 1:
                    deVragen(chat, hypo);
                    deBerekenaar(chat, hypo);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    running = false;
            }
        }
    }

    public static void deVragen(Scanner chat, HypotheekBerekenen hypo) {

        // partner
        System.out.println("Heb je een Partner?: ja/nee");
        String a = chat.next();
        hypo.partner(a);

        // Studie schuld
        System.out.println("Heb je studie schuld openstaan?: ja/nee");
        String b = chat.next();
        hypo.schuld(b);

        // Postcode
        System.out.println("Binnen welke postcode woon je?: *1234AB*");
        Integer c = chat.nextInt();
        hypo.postcode(c);

        // termijn
        System.out.println("Voor welke termijn tijd wil je lenen: 1 - 5 - 10 - 20 - 30 Jaar");
        String d = chat.next();
        hypo.termijnBerekeningMetRente(d);
        System.out.println("De termijn tijd: "+hypo.getTermijn()+" Jaar");
        System.out.println("De rente over de termijn: "+hypo.getRente()+"%");
    };

    public static void deBerekenaar(Scanner chat, HypotheekBerekenen hypo) {

        // eigen
        System.out.println("wat is je maandinkomen: ");

        double a = chat.nextInt();
        hypo.setBrutoInkomsten(a);

        // partner

        if(hypo.getPartner()){
            System.out.println("wat is het maandinkomen van je partner: ");

            double b = chat.nextInt();
            hypo.setBrutoPartnerInkomsten(b);
        }
        else {
            System.out.println("je hebt geen partner.");
        }

        // eigen + partner
        hypo.totaalInkomen(hypo.getBrutoInkomsten(), hypo.getBrutoPartnerInkomsten());
        System.out.println("€ "+hypo.getTotaalInkomsten() + " dit is het totaal inkomen.");

        // termijn kiezen
        double termijnBerekening = (double)(hypo.getTotaalInkomsten() * hypo.getTermijn() * 12);
        System.out.println("€ "+termijnBerekening + " dit is de termijn berekening.");
        hypo.setTotaalInkomsten(termijnBerekening);

        // maximaal te lenen bedrag

        double maxlenen = (hypo.getTotaalInkomsten() * 4.25);

        // hoeveel wil je lenen

        System.out.println("Je mag maximaal "+maxlenen+" lenen, kies je leen bedrag: ");
        double wilLenen = chat.nextDouble();

        while (wilLenen >= maxlenen ) {
            System.out.println("Je mag maximaal "+maxlenen+" lenen, kies je leen bedrag onder het maximum: ");
            wilLenen = chat.nextDouble();
        }

        // studie schuld
        if(hypo.getSchuld()){
           double metschuld = (wilLenen * 0.75);
           hypo.setTotaalInkomsten(metschuld);
           System.out.println("dit is het maxleenbedrag met schuld: € "+hypo.getTotaalInkomsten());
        }
        else {
            System.out.println("je hebt geen schuld");
        }

        // rente die erbij komt
        double metrente = (wilLenen + (wilLenen * hypo.getRente()));
        System.out.println("Het bedrag inclusief rente: € "+ metrente);

        // laat zien hoeveel rente er elke maand betaalt word

        double rentezien = wilLenen * hypo.getRente();
        System.out.println("Rente bedrag dat betaalt word elke maand: € "+ rentezien);

        // laat zien hoeveel er elke maand word afgelost

        double afgelost = (metrente / hypo.getTermijn() / 12);
        System.out.println("Het termijn bedrag dat elke maand word afgelost inclusief rente: € "+ afgelost);
    }
}
