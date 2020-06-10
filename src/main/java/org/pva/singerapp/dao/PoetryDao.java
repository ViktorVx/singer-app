package org.pva.singerapp.dao;

import org.pva.singerapp.model.PoetryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PoetryDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PoetryEntity> findAll() {
        return jdbcTemplate.query(
                "SELECT " +
                        "POETRY_ID, CREATION_DATE, POEM_NAME, AUTHOR, POEM_TEXT, USER_OWNER_ID, IS_PUBLIC " +
                        "FROM POETRY",
                new PoetryRowMapper());
    }

    public PoetryEntity findById(String id) {
        return jdbcTemplate.queryForObject("SELECT " +
                        "POETRY_ID, CREATION_DATE, POEM_NAME, AUTHOR, POEM_TEXT, USER_OWNER_ID, IS_PUBLIC " +
                        "FROM POETRY WHERE POETRY_ID = CAST(:POETRY_ID AS uuid)",
                new MapSqlParameterSource("POETRY_ID", id), new PoetryRowMapper());
    }

    public void insert(PoetryEntity poetryEntity) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("AUTHOR", poetryEntity.getAuthor())
                .addValue("POEM_NAME", poetryEntity.getPoemName())
                .addValue("CREATION_DATE", poetryEntity.getCreationDate())
                .addValue("POEM_TEXT", poetryEntity.getText())
                .addValue("USER_OWNER_ID", poetryEntity.getOwnerUserId())
                .addValue("IS_PUBLIC", poetryEntity.isPublic());
        jdbcTemplate.update("INSERT INTO POETRY (AUTHOR, POEM_NAME, CREATION_DATE, POEM_TEXT, USER_OWNER_ID, IS_PUBLIC)" +
                "VALUES (:AUTHOR, :POEM_NAME, :CREATION_DATE, :POEM_TEXT, :USER_OWNER_ID,:IS_PUBLIC)", params);
    }

    public void update(PoetryEntity poetryEntity) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("POETRY_ID", poetryEntity.getId())
                .addValue("AUTHOR", poetryEntity.getAuthor())
                .addValue("POEM_NAME", poetryEntity.getPoemName())
                .addValue("CREATION_DATE", poetryEntity.getCreationDate())
                .addValue("POEM_TEXT", poetryEntity.getText())
                .addValue("USER_OWNER_ID", poetryEntity.getOwnerUserId())
                .addValue("IS_PUBLIC", poetryEntity.isPublic());
        jdbcTemplate.update("UPDATE POETRY " +
                "SET AUTHOR = :AUTHOR, " +
                "POEM_NAME = :POEM_NAME, " +
                "CREATION_DATE = :CREATION_DATE, " +
                "POEM_TEXT = :POEM_TEXT, " +
                "USER_OWNER_ID = :USER_OWNER_ID, " +
                "IS_PUBLIC = :IS_PUBLIC " +
                "WHERE POETRY_ID = CAST(:POETRY_ID AS uuid)", params);
    }

    public void delete(String id) {
        jdbcTemplate.update("DELETE FROM POETRY WHERE POETRY_ID = CAST(:POETRY_ID AS uuid)",
                new MapSqlParameterSource("POETRY_ID", id));
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
