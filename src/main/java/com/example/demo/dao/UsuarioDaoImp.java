package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;




@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<Usuario> obtenerUsuarios() {
		// TODO Auto-generated method stub
		String query="From Usuario";
		return entityManager.createQuery(query).getResultList();
		
	}

}
