package project.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonAutoDetect
public class Energy {


    @JsonIgnore
    private Integer id;

    private String Electroenergy;
    private String units;
    private float fact;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setElectroenergy(String electroenergy) {
        Electroenergy = electroenergy;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public void setFact(float fact) {
        this.fact = fact;
    }

    public String getElectroenergy() {
        return Electroenergy;
    }

    public String getUnits() {
        return units;
    }

    public float getFact() {
        return fact;
    }

    @Override
    public String toString() {
        return this.getElectroenergy() + this.getUnits() + this.getFact();
    }
}
