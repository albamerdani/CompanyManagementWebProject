package model.dao_interface;

import java.util.List;

import model.entities.Company;
import model.entities.Department;

public interface DepInterface {
	
	public void addDepartment(Department department);
	
	public List<Department> listDepartment();
	
	public Department getDepByName(String name);
	
	public String getDepById(int id);
	
	public List<Department> getDepByComp(Company comp);
	
	public void updateDepartment(Department dep);
	
	public void deleteDepartment(Department dep);
	
	

}
