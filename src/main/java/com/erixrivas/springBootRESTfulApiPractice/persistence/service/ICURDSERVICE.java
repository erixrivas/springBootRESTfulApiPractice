package com.erixrivas.springBootRESTfulApiPractice.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICURDSERVICE<T,ID> {

	public default T  save(T entity) {
	return	getRepository().save( entity);

	}
	public default void saveAll(Iterable<T> entities) {
		getRepository().saveAll( entities);
	}
	
	public default List<T> getAll() {
		return getRepository().findAll();

	}
	
	public default Optional<T>	findByID(ID id) {
		 return getRepository().findById(id);
	}

	public JpaRepository<T, ID> getRepository();
	public default Boolean delete(T id) {
		
		try {
			 getRepository().delete( id);
			 return Boolean.TRUE;
		} catch (Exception e) {
			e.printStackTrace();
			 return Boolean.FALSE;
		}


	}

}