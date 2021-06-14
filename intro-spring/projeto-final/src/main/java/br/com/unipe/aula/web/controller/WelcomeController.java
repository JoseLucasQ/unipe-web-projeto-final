package br.com.unipe.aula.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.unipe.aula.dao.BlogDAO;
import br.com.unipe.aula.model.Blog;
@Controller
public class WelcomeController {
	
	@Autowired
	private BlogDAO dao;
	
	public WelcomeController()
	{
		dao = new BlogDAO();
	}
	
	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public String welcome()
	{
		return "welcome";
	}
	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public ModelAndView blog(Model model)
	{
		model.addAttribute("blog", new Blog());
		return new ModelAndView("blog");
	}
	
	@RequestMapping(value = "/blog", method = RequestMethod.POST)
	public ModelAndView blog(@ModelAttribute Blog blog)
	{
		ModelAndView view = new ModelAndView("blog");
		
		view.addObject("mensagem", "O texto é" + blog.getTexto());
		
		return view;
	}
	
	@PostMapping(value = "/posts")
	public ModelAndView postarBlog(@ModelAttribute Blog blog)
	{
		//dao = new BlogDAO();
		dao.salvar(blog);
		
		ModelAndView view = new ModelAndView("blog");
		view.addObject("mensagem", "Texto Postado");
		view.addObject("blogs", dao.getAll());
		
		return view;
		
		
	}
	
	@GetMapping(value = "/posts")
	public ModelAndView retornaAposExcluir(@ModelAttribute Blog blog)
	{
		//dao = new BlogDAO();
		//dao.salvar(blog);
		
		ModelAndView view = new ModelAndView("blog");
		view.addObject("mensagem", "Texto Postado");
		view.addObject("blogs", dao.getAll());
		
		return view;
		
		
	}
	
	@GetMapping(value = "/excluir/{id}")
	public String excluirPost(@PathVariable("id") int id, Model model)
	{
		dao.excluir(id);
		
		
		return "redirect:../posts";
	}

}
