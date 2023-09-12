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
                    System.out.println("test-1");
                    deVragen(chat, hypo);
                    deBerekenaar(chat, hypo);
                    break;
                case 2:
                    System.out.println("test-2");
                    break;
                case 3:
                    System.out.println("test-3");
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
        System.out.println("User input for partner: " + a);
        hypo.partner(a);
        if(hypo.getPartner()) {
            System.out.println("je hebt een partner");
        }
        else {
            System.out.println("je hebt geen parttner");
        }
        // Studie schuld
        System.out.println("Heb je studie schuld openstaan?: ja/nee");
        String b = chat.next();
        hypo.schuld(b);
        if(hypo.getSchuld()) {
            System.out.println("je hebt een openstaande schuld.");
        }
        else {
            System.out.println("je hebt Geen openstaande schulden lopen.");
        }
        // Postcode
        System.out.println("Binnen welke postcode woon je?: *1234AB*");
        Integer c = chat.nextInt();
        hypo.postcode(c);
        if(hypo.getPostcode()) {
            System.out.println("je kan geen hypotheek aanvragen voor dit postcode.");
        }
        else {
            System.out.println("je hebt een correcte postcode ingevoerd.");
        }
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
            System.out.println("je hebt niemand");
        }
        hypo.totaalInkomen(hypo.getBrutoInkomsten(), hypo.getBrutoPartnerInkomsten());
        System.out.println(hypo.getTotaalInkomsten());
        double termijnBerekening = (double)(hypo.getTotaalInkomsten() * 12);
        System.out.println(termijnBerekening);
        hypo.setTotaalInkomsten(termijnBerekening);
        System.out.println(hypo.getTotaalInkomsten() + "de nieuwe waarde checken - test");
    }
}
