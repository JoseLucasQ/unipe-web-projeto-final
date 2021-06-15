package br.com.unipe.aula.dao;

import java.util.List;

import javax.persistence.*;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.unipe.aula.model.Blog;

@Repository
public class BlogDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public BlogDAO()
	{
		
	}
	
	@Transactional(readOnly = false)
	public void salvar(Blog blog) 
	{
		entityManager.persist(blog);
	}
	//IMPORT MEIO BUGADO
	@Transactional(readOnly = true)
	public List<Blog> getAll()
	{ 
		String jpql = "from Blog u";
		TypedQuery<Blog> consulta = entityManager.createQuery(jpql, Blog.class);
		
		return consulta.getResultList();
	}
	public Blog getId(long id)
	{
		return entityManager.find(Blog.class, id);
	}
	@Transactional(readOnly = false)
	public void excluir(Long id)
	{
		Blog blog = getId(id);
		entityManager.remove(blog);
	}
	@Transactional(readOnly = false)
	public void editar(Blog blog)
	{
		entityManager.merge(blog);
	}

}
