package com.company;

import com.company.Game;

import java.util.ArrayList;

public class Persoon {

    private ArrayList<Game> games = new ArrayList<>();
    private String naam;
    private double budget;


    public Persoon(String naam, double budget) {
        this.naam = naam;
        this.budget = budget;
    }

    public boolean koop(Game game) {
        if (game.huidigeWaarde() <= budget) {
            for (Game g : games) {
                if (g.equals(game)) {
                    return false;
                }
            }
            budget -= game.huidigeWaarde();
            games.add(game);
            return true;
        }
        return false;
    }

    public boolean verkoop(Game g, Persoon p) {
        if (games.contains(g)) {
            if (p.koop(g)) {
                budget += g.huidigeWaarde();
                games.remove(g);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String string = naam + " heeft een budget van €" + String.format("%.2f", budget) + " en bezit de volgende games:";
        for (Game g : games) {
            string += "\n" + g;
        }
        return string.replace(".", ",");
    }

    public double getBudget() {
        return budget;
    }

}
