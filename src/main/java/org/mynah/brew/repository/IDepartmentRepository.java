package org.mynah.brew.repository;

import java.util.List;
import org.mynah.brew.model.Department;

public interface IDepartmentRepository {

    List<Department> query(Department department, Class<Department> type);

}
