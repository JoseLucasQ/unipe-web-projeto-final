package br.com.unipe.aula.dao;


import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.unipe.aula.model.Blog;

@Repository
public class BlogDAO {
	
	public static List<Blog> blogs;
	
	public BlogDAO()
	{
		blogs = new LinkedList<Blog>();
	}
	
	public void salvar(Blog blog) 
	{
		blogs.add(blog);
		System.out.println(blogs);
	}
	
		public List<Blog> getAll()
		{ 
			return blogs; 
		}
		public Blog getId(int id)
		{
			return blogs.get(id);
		}
		public void excluir(int id)
		{
			blogs.remove(id);
			System.out.println(blogs);
		}
		public void editar(int id, Blog blog)
		{
			blogs.get(id).setTexto(blog.getTexto());
		}

}
