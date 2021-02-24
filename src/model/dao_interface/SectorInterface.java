package model.dao_interface;

import java.util.List;

import model.entities.Department;
import model.entities.Sector;

public interface SectorInterface {
	
	public void addSector(Sector sector);
	
	public List<Sector> listSector();
	
	public String getSectorById(int id);
	
	public Sector getSectorByName(String name);
	
	public List<Sector> getSectorByDep(Department dep);
	
	public void updateSector(Sector sector);
	
	public void deleteSector(Sector sector);

}
