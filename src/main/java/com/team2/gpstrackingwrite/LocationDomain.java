package com.team2.gpstrackingwrite;

import javax.persistence.*;
import java.util.Date;

@Entity
public class LocationDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Date added;
    private float latitude;
    private float longitude;

    public LocationDomain() {
    }

    public LocationDomain(Integer id, float latitude, float longitude) {
        this.id = id;
        this.added = new Date();
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public LocationDomain(float latitude, float longitude) {
        this.added = new Date();
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

}
