package org.pva.singerapp.dao;

import org.pva.singerapp.model.PoetryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PoetryDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<PoetryEntity> findAll() {
        return namedParameterJdbcTemplate.query(
                "SELECT " +
                        "POETRY_ID, CREATION_DATE, POEM_NAME, AUTHOR, POEM_TEXT, USER_OWNER_ID, IS_PUBLIC " +
                        "FROM POETRY",
                new PoetryRowMapper());
    }

    public PoetryEntity findById(String id) {
        return namedParameterJdbcTemplate.queryForObject("SELECT " +
                        "POETRY_ID, CREATION_DATE, POEM_NAME, AUTHOR, POEM_TEXT, USER_OWNER_ID, IS_PUBLIC " +
                        "FROM POETRY WHERE POETRY_ID = CAST(:POETRY_ID AS uuid)",
                new MapSqlParameterSource("POETRY_ID", id), new PoetryRowMapper());
    }

    class PoetryRowMapper implements RowMapper<PoetryEntity> {

        @Override
        public PoetryEntity mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            final PoetryEntity poetryEntity = new PoetryEntity();
            poetryEntity.setId(rs.getString("POETRY_ID"));
            poetryEntity.setCreationDate(rs.getDate("CREATION_DATE"));
            poetryEntity.setPoemName(rs.getString("POEM_NAME"));
            poetryEntity.setAuthor(rs.getString("AUTHOR"));
            poetryEntity.setText(rs.getString("POEM_TEXT"));
            poetryEntity.setOwnerUserId(rs.getString("USER_OWNER_ID"));
            poetryEntity.setPublic(rs.getBoolean("IS_PUBLIC"));
            return poetryEntity;
        }
    }

}
