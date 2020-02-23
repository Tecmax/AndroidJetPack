package com.maersk.androidmng.rest.model.citis;

import java.util.ArrayList;

public class CityResponse {

    private ArrayList<LocationsList> location_suggestions;
    private int has_more;
    private int has_total;
    private boolean user_has_addresses;
    private String status;

    public ArrayList<LocationsList> getLocation_suggestions() {
        return location_suggestions;
    }

    public void setLocation_suggestions(ArrayList<LocationsList> location_suggestions) {
        this.location_suggestions = location_suggestions;
    }

    public int getHas_more() {
        return has_more;
    }

    public void setHas_more(int has_more) {
        this.has_more = has_more;
    }

    public int getHas_total() {
        return has_total;
    }

    public void setHas_total(int has_total) {
        this.has_total = has_total;
    }

    public boolean isUser_has_addresses() {
        return user_has_addresses;
    }

    public void setUser_has_addresses(boolean user_has_addresses) {
        this.user_has_addresses = user_has_addresses;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
