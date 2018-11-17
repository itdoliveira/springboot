package br.com.demo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.demo.springboot.model.Usuario;
import br.com.demo.springboot.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/lista");
		mv.addObject("usuarios", usuarioService.findAll());
		
		return mv;
	}
	
	@GetMapping("/adicionar")
	public ModelAndView adicionar(Usuario usuario) {
		
		ModelAndView mv = new ModelAndView("/cadastro");
		mv.addObject("usuario", usuario);
		
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(Usuario usuario) {
		usuarioService.save(usuario);
		return findAll();
	}
}
