package access_control_app.service.business_logic_impl;

import access_control_app.model.Department;
import access_control_app.repository.DepartmentRepository;
import access_control_app.service.business_logic.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department getDepartment(String id) {
        return departmentRepository.findById(Long.parseLong(id)).get();
    }
}
