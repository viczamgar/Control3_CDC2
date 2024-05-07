package cdc2.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import java.util.logging.*;

import cdc2.entities.Coche;


public class JPACocheDao implements Dao<Coche>{
	
	List<Coche> concesionario = new ArrayList<Coche>();

	public List<Coche> getConcesionario() {
		return concesionario;
	}

	public void setConcesionario(List<Coche> concesionario) {
		this.concesionario = concesionario;
	}

	@Override
	public Coche findById(int key) {
		Coche coche = null;
		Coche cocheBuscado=null;
		Iterator<Coche> it;
		
		it= this.concesionario.iterator();
		
		while(it.hasNext()) {
			
			coche = it.next();
			
			if(coche.getId() == key) {
				cocheBuscado=coche;
				break;
			}
			
		}
		
		
		return cocheBuscado;
	}

	@Override
	public List<Coche> findAll() {
		
		return this.concesionario;
	}

	@Override
	public void save(Coche t) {
		this.concesionario.add(t);
		
	}
	
	@Override
	public void saveAll(Coche [] t) {
		
		for(int i = 0; i < t.length; i++)
			this.concesionario.add(t[i]);
		
	}

	@Override
	public void update(Coche t, int id) {
		Iterator<Coche> it;
		boolean encontrado=false;
		
		it= this.concesionario.iterator();
		
		
		Coche cocheActual = null;
		while(it.hasNext()) {
			
			cocheActual = it.next();
			
			if(cocheActual.getId()==id) {
				it.remove();
				encontrado = true;
			}
		}
		
		if(encontrado)
			this.concesionario.add(t);
		
	}

	@Override
	public void delete(Coche t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public	void delete(int key) {
	} 
	
	@Override
	public void deleteAll() {
		this.concesionario.clear();
		
	}

}




