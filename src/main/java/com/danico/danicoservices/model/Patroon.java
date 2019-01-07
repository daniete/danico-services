package com.danico.danicoservices.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(schema = "public", name = "patroon")
public class Patroon {

    @Id
    @Column(name = "patroon_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //@ManyToOne(fetch =FetchType.LAZY, cascade = CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name = "klant_id", referencedColumnName = "klant_id", nullable = false)
    private Klant klant;

    //@ManyToOne(fetch =FetchType.LAZY, cascade = CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name = "doos_id", referencedColumnName = "doos_id", nullable = false)
    private Doos doos;

    @Column(name = "path")
    private String path;

    @Column(name = "opmerking")
    private String opmerking;

    public Patroon(){
    }

    public Patroon(Klant klant, Doos doos, String opmerking, String path) {
        this.klant = klant;
        this.doos = doos;
        this.opmerking = opmerking;
        this.path = path;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public Doos getDoos() {
        return doos;
    }

    public void setDoos(Doos doos) {
        this.doos = doos;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getOpmerking() {
        return opmerking;
    }

    public void setOpmerking(String opmerking) {
        this.opmerking = opmerking;
    }
}
