package org.mynah.brew.jdbc;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.mynah.brew.jdbc.exception.IncorrectColumnSizeDataAccessException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.JdbcUtils;

public class MapResultSetExtractor implements ResultSetExtractor<Map<String, Object>> {

    @Override
    public Map<String, Object> extractData(ResultSet rs) throws SQLException, DataAccessException {
        rs.last();
        int rowsExpected = rs.getRow();
        Map<String, Object> results = new HashMap<String, Object>(rowsExpected);
        rs.first();
        while (rs.next()) {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            if (columnCount < 2) {
                throw new IncorrectColumnSizeDataAccessException(2, columnCount);
            }
            String key = rs.getString(1);
            Object value = JdbcUtils.getResultSetValue(rs, 2);
            results.put(key, value);
        }
        return results;
    }

}
