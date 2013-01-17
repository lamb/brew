package org.mynah.brew.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.mynah.brew.model.Department;
import org.mynah.brew.repository.IDepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    private IDepartmentRepository departmentRepository;

    @Transactional(readOnly = true)
    public List<Department> query(Department department, Class<Department> type) {
        return departmentRepository.query(department, type);
    }

}
