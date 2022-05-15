package com.example.covidtracker;

public class StateModel {

    private String state;
    private int recovered;
    private int deaths;
    private int cases;

    public StateModel() {
    }

    public StateModel(String state, int recovered, int deaths, int cases) {
        this.state = state;
        this.recovered = recovered;
        this.deaths = deaths;
        this.cases = cases;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }
}
