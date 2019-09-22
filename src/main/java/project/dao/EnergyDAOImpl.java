package project.dao;

import org.springframework.stereotype.Repository;
import project.model.Energy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EnergyDAOImpl implements EnergyDAO {

    private static final AtomicInteger AUTO_ID= new AtomicInteger(0);
    private static Map<Integer, Energy> energyMap = new HashMap<>();

    static {
        Energy energy = new Energy();
        energy.setId(AUTO_ID.getAndIncrement());
        energy.setElectroenergy("Объем");
        energy.setUnits("MВтч");
        energy.setFact(500);

        Energy energy1 = new Energy();
        energy1.setId(AUTO_ID.getAndIncrement());
        energy1.setElectroenergy("Цена");
        energy1.setUnits("руб");
        energy1.setFact(100000);

        Energy energy2 = new Energy();
        energy2.setId(AUTO_ID.getAndIncrement());
        energy2.setElectroenergy("Выручка");
        energy2.setUnits("руб");
        energy2.setFact(900000);

        energyMap.put(energy.getId(), energy);
        energyMap.put(energy1.getId(), energy1);
        energyMap.put(energy2.getId(), energy2);
    }

    @Override
    public List<Energy> allEnergy() {
        return new ArrayList<>(energyMap.values());
    }

    @Override
    public void add(Energy energy) {
        energy.setId(AUTO_ID.getAndIncrement());
        energyMap.put(energy.getId(), energy);

    }

    @Override
    public void delete(Energy energy) {
        energyMap.remove(energy.getId());

    }

    @Override
    public void edit(Energy energy) {
        energyMap.put(energy.getId(),energy);

    }

    @Override
    public Energy getById(int id) {
        return energyMap.get(id);
    }
}
