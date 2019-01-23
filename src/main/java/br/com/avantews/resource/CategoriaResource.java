package br.com.avantews.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	//Apresenta dados para o final user!
	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
		return "Rest yes found!";
	}

}
