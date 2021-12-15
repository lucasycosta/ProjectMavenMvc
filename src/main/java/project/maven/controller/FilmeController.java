package project.maven.controller;

import projeto.maven.model.Filme;

public class FilmeController {
	public boolean cadastrarFilme(String nome, String genero) {
		if(nome != null && genero.length() > 0 && genero != null && genero.length() > 0) {
			Filme filme = new Filme(null, nome, genero);
			return true;
		}
		
		return false;
	}
}
