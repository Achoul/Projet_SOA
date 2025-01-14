package insa.soa.util;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.util.List;
import java.util.Map;

public class SQL_connector {
    private JdbcTemplate jdbcTemplate;

    // Constructor to initialize the JdbcTemplate with database connection details
    public SQL_connector(String url, String username, String password, String driverClassName) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * Execute a SQL query and return the results as a list of maps.
     * Each map represents a row, with column names as keys and column values as values.
     *
     * @param sql the SQL query to execute
     * @return a list of maps representing the rows returned by the query
     */
    public List<Map<String, Object>> executeQuery(String sql) {
        return jdbcTemplate.queryForList(sql);
    }

    /**
     * Execute a SQL update or insert statement.
     *
     * @param sql the SQL statement to execute
     * @return the number of rows affected
     */
    public int executeUpdate(String sql) {
        return jdbcTemplate.update(sql);
    }
}