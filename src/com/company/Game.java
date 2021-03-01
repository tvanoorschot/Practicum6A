package com.company;

import java.time.LocalDate;
import java.util.Objects;

public class Game {

    private String naam;
    private int releaseJaar;
    private double prijs;

    public Game(String naam, int releaseJaar, double prijs) {
        this.naam = naam;
        this.releaseJaar = releaseJaar;
        this.prijs = prijs;
    }

    public String getNaam() {
        return naam;
    }

    public double huidigeWaarde() {
        double prijs = this.prijs;
        int verschil = LocalDate.now().getYear() - releaseJaar;
        return prijs * Math.pow(0.70, verschil);
    }

    @Override
    public String toString() {
        return (naam + ", uitgegeven in " + releaseJaar + "; nieuwprijs: €" +
                String.format("%.2f", prijs) + " nu voor: €" + String.format("%.2f", huidigeWaarde())).replace(".", ",");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return releaseJaar == game.releaseJaar && Objects.equals(naam, game.naam);
    }

}
