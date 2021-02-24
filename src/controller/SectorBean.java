package controller;

import java.io.Serializable;
import java.util.List;

import model.dao.SectorDAO;
import model.entities.Department;
import model.entities.Sector;
import model.entities.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="sectorBean")
@SessionScoped
public class SectorBean implements Serializable{
	
	private static final long serialVersionUID = -1086855020561152108L;
	
	private Sector sector = new Sector();
	private static SectorDAO sectorDAO = new SectorDAO();
	
	public SectorBean(){
		
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public SectorDAO getSectorDAO() {
		return sectorDAO;
	}

	public void setSectorDAO(SectorDAO sectorDAO) {
		this.sectorDAO = sectorDAO;
	}
	
	
	
	// Method To Add New sector In Database
	public void saveSectorRecord() {
		System.out.println("Calling saveSectorRecord() Method To Save Sector Record");
		sectorDAO.addSector(sector);
	}

	// Method To Delete A Particular sector Record From The Database
	public void deleteSectorRecord() {
		System.out.println("Calling deleteSectorRecord() Method To Delete Sector Record");
		sectorDAO.deleteSector(sector);
	}


	// Method To Update Particular sector Details In Database
	public void updateSectorDetails() {
		System.out.println("Calling updateSectorDetails() Method To Update Sector Record");
		sectorDAO.updateSector(sector);
	}

	// Method To Fetch All Records From The Database
	public List<Sector> getAllSectorRecords() {
		System.out.println("Calling getAllSectorRecords() Method To Fetch Sector Record");
		List<Sector> sectorList = sectorDAO.listSector();
		return sectorList;
	}
	
	
	// Method To Fetch Particular sector Details From The Database
		public String selectSectorById(int id){
			System.out.println("Calling getSectorById() Method To Fetch Sector Record");
			String name = sectorDAO.getSectorById(id);
			return name;
		}
	
	public List<Sector> selectSectByDep(Department dep){
		List<Sector> s = sectorDAO.getSectorByDep(dep);
		return s;
	}
	
	
	public String turnBack(){
		User user = new model.entities.User();	
		return "admin.xhtml?faces-redirect=true";
	}
		
		
	public String getPage(){
		User user = new model.entities.User();
		return "adminSector.xhtml?faces-redirect=true";
	}
		

}
