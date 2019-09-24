package project.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import project.model.Energy;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Component
public class EnergyDAOImpl implements EnergyDAO{

    @Autowired
    DataSource dataSource;

    private JdbcTemplate jdbcTemplate;
    @PostConstruct
    public void init(){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Energy> allEnergy() {
        System.out.println("JDBCExample");
        List<Energy> energyList = this.jdbcTemplate.query(Query.query, new RowMapper<Energy>() {
            public Energy mapRow(ResultSet resulSet, int rowNum) throws SQLException {
                Energy energy = new Energy();
                energy.setElectroenergy(resulSet.getString(1));
                energy.setUnits(resulSet.getString(2));
                energy.setFact(resulSet.getString(3));
                return energy;
            }
        });
        return energyList;
    }
}
