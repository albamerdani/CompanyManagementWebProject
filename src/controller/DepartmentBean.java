package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.dao.DepartmentDAO;
import model.entities.Company;
import model.entities.Department;
import model.entities.User;

@ManagedBean(name="depBean")
@SessionScoped
public class DepartmentBean implements Serializable{

	private static final long serialVersionUID = -1086855020561152108L;

	private Department dep = new Department();
	private static DepartmentDAO depDAO = new DepartmentDAO();
	
	public DepartmentBean(){
		
	}

	public Department getDep() {
		return dep;
	}

	public void setDep(Department dep) {
		this.dep = dep;
	}

	public DepartmentDAO getDepDAO() {
		return depDAO;
	}

	public void setDepDAO(DepartmentDAO depDAO) {
		this.depDAO = depDAO;
	}
	
	
	// Method To Add New department Details In Database
	public void saveDepRecord() {
		System.out.println("Calling saveDepRecord() Method To Save Department Record");
		depDAO.addDepartment(dep);
	}

	// Method To Delete A Particular department Record From The Database
	public void deleteDepRecord() {
		System.out.println("Calling deleteDepRecord() Method To Delete Department Record");
		depDAO.deleteDepartment(dep);
	}


	// Method To Update Particular department Details In Database
	public void updateDepDetails() {
		System.out.println("Calling updateDepDetails() Method To Update Department Record");
		depDAO.updateDepartment(dep);
	}

	// Method To Fetch All Records From The Database
	public List<Department> allDepRecords() {
		System.out.println("Calling getAllDepRecords() Method To Fetch Department Record");
		List<Department> depList = depDAO.listDepartment();
		return depList;
	}
	
	
	// Method To Fetch Particular department Details From The Database
		public String selectDepById(int id){
			System.out.println("Calling getDepById() Method To Fetch Department Record");
			String name = depDAO.getDepById(id);
			return name;
		}

	
	public List<Department> selectDepByComp(Company comp){
		List<Department> dep = depDAO.getDepByComp(comp);
		return dep;
	}
	
	
	public String turnBack(){
		User user = new model.entities.User();			
		return "admin.xhtml?faces-redirect=true";
	}
		
		
	public String getPage(){
		User user = new model.entities.User();
		return "adminDepartment.xhtml?faces-redirect=true";
	}
		
}
