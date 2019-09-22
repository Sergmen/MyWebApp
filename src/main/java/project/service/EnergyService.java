package project.service;

import project.model.Energy;

import java.util.List;

public interface EnergyService {
    List<Energy> allEnergy();
    void add(Energy energy);
    void delete(Energy energy);
    void edit(Energy energy);
    Energy getById(int id);


}