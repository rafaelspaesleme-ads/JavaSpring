package br.com.avantews.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avantews.domain.Categoria;
import br.com.avantews.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria buscar(Integer id) {
				Optional<Categoria> objeto = categoriaRepository.findById(id);
				return objeto.orElse(null);
	}
	
}
