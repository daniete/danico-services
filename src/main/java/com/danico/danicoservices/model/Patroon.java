package com.danico.danicoservices.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patroon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String doos;
    private String path;

    public Patroon(){
    }

    public Patroon(String name, String doos, String path) {
        this.name = name;
        this.doos = doos;
        this.path = path;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDoos() {
        return doos;
    }

    public void setDoos(String doos) {
        this.doos = doos;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patroon patroon = (Patroon) o;

        if (id != patroon.id) return false;
        if (name != null ? !name.equals(patroon.name) : patroon.name != null) return false;
        if (doos != null ? !doos.equals(patroon.doos) : patroon.doos != null) return false;
        return path != null ? path.equals(patroon.path) : patroon.path == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (doos != null ? doos.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        return result;
    }
}
