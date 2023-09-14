package com.company;

public class HypotheekBerekenen {

    private double brutoInkomsten;
    private double brutoPartnerInkomsten;
    private double totaalInkomsten;
    private boolean partner;
    private boolean schuld;
    private double rente;
    private int termijn;
    private boolean postcode;

    // setters en getters
    // vragen voor de berekening

    public void setPartner(boolean partner) {
        this.partner = partner;
    }

    public boolean getPartner() { return partner; }

    public void setSchuld(boolean schuld) {
        this.schuld = schuld;
    }

    public boolean getSchuld() {
        return schuld;
    }

    public void setPostcode(boolean postcode) {
        this.postcode = postcode;
    }

    public boolean getPostcode() {
        return postcode;
    }

    // de berekening get/set

    public void setBrutoInkomsten(double brutoInkomsten) {
        this.brutoInkomsten = brutoInkomsten;
    }

    public double getBrutoInkomsten() {
        return brutoInkomsten;
    }

    public void setBrutoPartnerInkomsten(double brutoPartnerInkomsten) {
        this.brutoPartnerInkomsten = brutoPartnerInkomsten;
    }

    public double getBrutoPartnerInkomsten() {
        return brutoPartnerInkomsten;
    }

    public void setTotaalInkomsten(double totaalInkomsten) {
        this.totaalInkomsten = totaalInkomsten;
    }

    public double getTotaalInkomsten() {
        return totaalInkomsten;
    }

    public void setTermijn(int termijn) {
        this.termijn = termijn;
    }

    public int getTermijn() {
        return termijn;
    }

    public double getRente() {
        return rente;
    }

    public void setRente(double rente) {
        this.rente = rente;
    }

    // intro

    public void intro() {
        System.out.println("------------------------------------------");
        System.out.println("Welkom bij Hypo de hypotheekberekenaar");
        System.out.println("Bereken je hypotheek: ");
        System.out.println("------------------------------------------");
    }

    // de bereken functies

    public void partner( String antwoord ) {

        if ( antwoord.equalsIgnoreCase("ja")) {
            partner = true;
        }
        else {
            partner = false;
        }
    }

    public boolean schuld( String antwoord ) {

        if ( antwoord.equals("ja")) {
            schuld = true;
        }
        else {
            schuld = false;
        }

        return schuld;

    }

    public double totaalInkomen(double inkomen, double partnerInkomen) {

        this.totaalInkomsten = inkomen + partnerInkomen;

        return totaalInkomsten;
    }

    public double termijnBerekeningMetRente( String termijnInput ) {

        if(termijnInput.equals("1")){
            this.rente = 0.02;
            this.termijn = 1;
        }
        else if (termijnInput.equals("5")) {
            this.rente = 0.03;
            this.termijn = 5;
        }
        else if (termijnInput.equals("10")) {
            this.rente = 0.035;
            this.termijn = 10;
        }
        else if (termijnInput.equals("20")) {
            this.rente = 0.045;
            this.termijn = 20;
        }
        else if (termijnInput.equals("30")) {
            this.rente = 0.05;
            this.termijn = 30;
        }
        else {
            System.out.println("Geen juiste termijn gekozen, voer opnieuw in!");
        }
        return this.rente;
    }

    //9679, 9681 of 9682
    public boolean postcode (int postcode) {
        if(postcode == 9679 || postcode == 9681 || postcode == 9682) {
            System.out.println("dit mag niet");
            this.postcode = true;
            return true;
        }
        else {
            this.postcode = false;
            return false;
        }
    }
}
