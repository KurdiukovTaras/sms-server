package smsServer.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import smsServer.model.Sms;
import smsServer.repository.SmsRepository;
import javax.sql.DataSource;
import java.util.List;

/**
 * User: gkislin
 * Date: 26.08.2014
 */

@Repository
public class JdbcSmsRepositoryImpl implements SmsRepository {

    private static final RowMapper<Sms> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Sms.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertSms;

    @Autowired
    public JdbcSmsRepositoryImpl(DataSource dataSource) {
        this.insertSms = new SimpleJdbcInsert(dataSource)
                .withTableName("sms")
                .usingGeneratedKeyColumns("id");
    }

    public Sms save(Sms sms, int clientId) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", sms.getId())
                .addValue("message", sms.getMessage())
                .addValue("readed", sms.getReaded())
                .addValue("date_time", sms.getDatetime())
                .addValue("client_id", clientId);

        if (sms.isNew()) {
            Number newId = insertSms.executeAndReturnKey(map);
            sms.setId(newId.intValue());
        } else {
            if (namedParameterJdbcTemplate.update("" +
                            "UPDATE sms " +
                            "   SET message=:message, readed=:readed, date_time=:date_time " +
                            " WHERE id=:id AND client_id=:client_id"
                    , map) == 0) {
                return null;
            }
        }
        return sms;
    }

    public boolean delete(int id, int clientId) {
        return jdbcTemplate.update("DELETE FROM sms WHERE id=? AND client_id=?", id, clientId) != 0;
    }


    public Sms get(int id, int clientId) {
        List<Sms> sms = jdbcTemplate.query(
                "SELECT * FROM sms WHERE id = ? AND client_id = ?", ROW_MAPPER, id, clientId);
        return DataAccessUtils.singleResult(sms);
    }

    public List<Sms> getAll(int clientId) {
        return jdbcTemplate.query(
                "SELECT * FROM sms WHERE client_id=? ORDER BY date_time DESC", ROW_MAPPER, clientId);
    }


}