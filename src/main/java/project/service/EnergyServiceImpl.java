package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.dao.EnergyDAO;
import project.dao.EnergyDAOImpl;
import project.model.Energy;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnergyServiceImpl implements EnergyService {

    @Autowired
    private EnergyDAOImpl energyDAOImpl;

    @Override
    public List<Energy> allEnergy() {
        return energyDAOImpl.allEnergy();
    }


}
