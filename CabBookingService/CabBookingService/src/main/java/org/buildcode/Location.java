package org.buildcode;

public class Location {
    private Integer latitude;
    private Integer longitude;

    public Integer getLatitude() {
        return latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public boolean isEqual(Location location) {
        return this.latitude == location.getLatitude() &&
                this.longitude == location.getLongitude();
    }
}