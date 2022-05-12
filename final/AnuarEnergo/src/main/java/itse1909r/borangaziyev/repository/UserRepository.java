package itse1909r.borangaziyev.repository;

import itse1909r.borangaziyev.model.User;
import itse1909r.borangaziyev.model.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getAll() {
        return jdbcTemplate.query(
                "SELECT * FROM Users;",
                new UserMapper()
        );
    }

    public User getById(int id) {

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return jdbcTemplate.query(
                "SELECT * FROM Users WHERE userId = :id",
                params,
                new UserMapper()
        ).get(0);
    }

    public int[] batchDeleteUserRolesByUser(int userId, int roleIds[]) {
        String sql =    "DELETE FROM userroles WHERE userid= :userId AND roleId=:roleId";

        List<MapSqlParameterSource> params = new ArrayList<MapSqlParameterSource>();
        for(int roleId: roleIds) {

            MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("roleId", roleId);
            source.addValue("userId", userId);

            params.add(source);
        }

        return jdbcTemplate.batchUpdate(sql, params.toArray(MapSqlParameterSource[]::new));
    }

    public boolean deleteUserById(int id) {

        String sql = "DELETE FROM Users WHERE userId = :id;";
        Map<String, Integer> params = new HashMap<>();
        params.put("id", id);

        return jdbcTemplate.update(sql, params) > 0;
    }

    public int[] batchInsert(List<User> users) {
        String sql =    "INSERT INTO Users(username, password, firstName, lastName) " +
                        "VALUES(:username, :password, :firstName, :lastName);";

        List<MapSqlParameterSource> params = new ArrayList<MapSqlParameterSource>();
        for(User user:users) {

            MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("username", user.getUsername());
            source.addValue("password", user.getPassword());
            source.addValue("firstName", user.getFirstName());
            source.addValue("lastName", user.getLastName());

            params.add(source);
        }

        return jdbcTemplate.batchUpdate(sql, params.toArray(MapSqlParameterSource[]::new));
    }

    public boolean insertUser(User user) {
        String sql =    "INSERT INTO Users (username, password, firstName, lastName) " +
                        "VALUES(:username, :password, :firstName, :lastName);";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("username", user.getUsername());
        params.addValue("password", user.getPassword());
        params.addValue("firstName", user.getFirstName());
        params.addValue("lastName", user.getLastName());


        return jdbcTemplate.update(sql, params) > 0;
    }

}
