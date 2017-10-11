package ru.itis.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.itis.dao.AutoDao;
import ru.itis.models.Auto;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 11.10.2017
 * AutoDaoJdbcImpl
 *
 * @author Victoria Noumenko
 * @version v1.0
 */

@Repository
public class AutoDaoJdbcImpl implements AutoDao {

    //language=SQL
    private final String SQL_SELECT_AUTO =
            "SELECT * FROM auto";

    //language=SQL
    private final String SQL_INSERT_AUTO =
            "INSERT INTO auto(model, color, carmileage, used) " +
                    "VALUES(:model, :color, :carmileage, :used)";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public AutoDaoJdbcImpl(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private RowMapper<Auto> autoRowMapper = new RowMapper<Auto>() {
        @Override
        public Auto mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Auto.Builder()
                    .setId(rs.getInt("id"))
                    .setModel(rs.getString("model"))
                    .setColor(rs.getString("color"))
                    .setCarMileage(rs.getDouble("carmileage"))
                    .setUsed(rs.getBoolean("used")).build();
        }
    };

    @Override
    public List<Auto> findAll() {
        return namedParameterJdbcTemplate.query(SQL_SELECT_AUTO, autoRowMapper);
    }

    @Override
    public Auto find(int id) {
        return null;
    }

    @Override
    public int save(Auto model) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("model", model.getModel());
        params.addValue("color", model.getColor());
        params.addValue("carmileage", model.getCarMileage());
        params.addValue("used", model.getIsUsed());

        KeyHolder holder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(SQL_INSERT_AUTO, params, holder, new String[]{"id"});
        Number number = holder.getKey();
        return number.intValue();
    }

    @Override
    public void update(Auto model) {

    }

    @Override
    public void delete(int id) {

    }
}
