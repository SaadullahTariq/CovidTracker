package com.example.covidtracker;

public class StateModel {
    String state, active, recovered, deaths;

    public StateModel() {
    }

    public StateModel(String state, String active, String recovered, String deaths) {
        this.state = state;
        this.active = active;
        this.recovered = recovered;
        this.deaths = deaths;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }
}
