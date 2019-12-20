package pt.upacademy.repositoryExample.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import pt.upacademy.repositoryExample.entities.Veiculo;

public abstract class VeicRepository <T extends Veiculo> {

	private Map<Long,T> map= new HashMap<Long, T>();
	
	private long actualId=0;
	
	public void save(T veic) {
		veic.setId(actualId);
		map.put(veic.getId(), veic);
		actualId++;
	}
	
	public T findById(Long id) {
		return map.get(id);
	}
	
	public void removeById(Long id) {		
		map.remove(id);
	}
	
	public void updateById(T veic) {
		map.replace(veic.getId(), veic);
	}
	
	public Collection<T> getAll() {
		return map.values();
	}
	
	public Map<Long, T> getMap() {
		return map;
	}	
}
