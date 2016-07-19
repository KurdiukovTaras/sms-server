package smsServer.repository.jdbc;

import com.sun.deploy.util.SessionState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import smsServer.model.Client;
import smsServer.repository.ClientRepository;

import javax.sql.DataSource;
import java.util.List;

/**
 * User: gkislin
 * Date: 26.08.2014
 */

@Repository
public class JdbcClientRepositoryImpl implements ClientRepository {

    private static final BeanPropertyRowMapper<Client> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Client.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertClient;

    @Autowired
    public JdbcClientRepositoryImpl(DataSource dataSource) {
        this.insertClient = new SimpleJdbcInsert(dataSource)
                .withTableName("CLIENT")
                .usingGeneratedKeyColumns("id");
    }

    public Client save(Client client) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", client.getId())
                .addValue("name", client.getName())
                .addValue("description", client.getDescription())
                .addValue("phonenumber", client.getPhoneNumber());
        if (client.isNew()) {
            Number newKey = insertClient.executeAndReturnKey(map);
            client.setId(newKey.intValue());
        } else {
            namedParameterJdbcTemplate.update(
                    "UPDATE client SET name=:name, description=:description, phonenumber=:phonenumber, " +
                            " WHERE id=:id", map);
        }
        return client;
    }


    public boolean delete(int id) {
        return jdbcTemplate.update("DELETE FROM client WHERE id=?", id) != 0;
    }


    public Client get(int id) {
        List<Client> client = jdbcTemplate.query("SELECT * FROM client WHERE id=?", ROW_MAPPER, id);
        return DataAccessUtils.singleResult(client);
    }


    public Client getByPhoneNumber(String phonenumber) {
        return jdbcTemplate.queryForObject("SELECT * FROM client WHERE phonenumber=?", ROW_MAPPER, phonenumber);
    }


    public List<Client> getAll() {
        return jdbcTemplate.query("SELECT * FROM client ORDER BY name, phonenumber", ROW_MAPPER);
    }
}
