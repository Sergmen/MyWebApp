package project.dao;

import project.model.Energy;

import java.util.List;

public interface EnergyDAO {
    List<Energy> allEnergy();
    void add(Energy energy);
    void delete(Energy energy);
    void edit(Energy energy);
    Energy getById(int id);


}
