package org.mynah.brew.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.mynah.brew.jdbc.exception.IncorrectColumnSizeDataAccessException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.JdbcUtils;

public class MapResultSetExtractor implements ResultSetExtractor<Map<String, Object>> {

    @Override
    public Map<String, Object> extractData(ResultSet rs) throws SQLException, DataAccessException {
        rs.last();
        int rows = rs.getRow();
        Map<String, Object> results = null;
        if (rows > 0) {
            results = new LinkedHashMap<String, Object>(rows);
            rs.first();
            int columnCount = rs.getMetaData().getColumnCount();
            int expectedSize = 2;
            if (columnCount != expectedSize) {
                throw new IncorrectColumnSizeDataAccessException(expectedSize, columnCount);
            }
            results.put(rs.getString(1), JdbcUtils.getResultSetValue(rs, 2));
            while (rs.next()) {
                results.put(rs.getString(1), JdbcUtils.getResultSetValue(rs, 2));
            }
        }
        return results;
    }
}
