package org.mynah.brew.repository.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.mynah.brew.jdbc.MapResultSetExtractor;
import org.mynah.brew.jdbc.Template;
import org.mynah.brew.model.Department;
import org.mynah.brew.repository.IDepartmentRepository;

@Repository
public class DepartmentRepository implements IDepartmentRepository {

    @Autowired
    private Template template;

    @Override
    public List<Department> query(Department department, Class<Department> type) {
        return template.query(department, type);
    }

    @Override
    public Map<String, Object> query() {
        return template.query("select id,name from department order by id asc", new MapResultSetExtractor());
    }

}
