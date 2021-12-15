package project.maven.view;

import java.util.Scanner;

import project.maven.dao.FilmeDao;
import projeto.maven.model.Filme;

public class FilmeView {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char resp;
		do {
			System.out.print("O que você deseja fazer?");
			System.out.println("\n |1 - Incluir novo filme" + "\n |2 - Consultar filme existente"
					+ "\n |3 - Alterar os dados de um filme" + "\n |4 - Deletar o cadastro de um filme");
			System.out.print("Opção desejada: ");
			int opcao = input.nextInt();

			switch (opcao) {
			case 1: {
				Filme filme = new Filme();

				System.out.print("Insira o nome do filme: ");
				filme.setNome(input.next());
				System.out.print("Insira o genero do filme: ");
				filme.setGenero(input.next());

				FilmeDao filmeDao = new FilmeDao();
				filmeDao.CadastrarFilme(filme);

				break;
			}
			case 2: {
				System.out.print("Digite o ID do filme: ");
				int id = input.nextInt();

				FilmeDao filmeDao = new FilmeDao();
				for (Filme f : filmeDao.getFilme(id)) {}
				break;
			}
			case 3:{
				System.out.print("Digite o ID do filme: ");
				int id = input.nextInt();
				FilmeDao filme1 = new FilmeDao();
				Filme f1 = new Filme();
				for (Filme f : filme1.getFilme(id)) {
				System.out.println("ID: " + f.getId());
				System.out.println("Nome: " + f.getNome());
				System.out.println("Genero: " + f.getGenero());
				}
				f1.setId(id);
				System.out.println("\n Digite o novo nome do filme: ");
				String nome = input.next();
				
				System.out.println("\n Digite o novo genero do filme: ");
				String genero = input.next();
				
				filme1.AlterarFilme(id,nome,genero);
				
				break;
			}
			case 4:{
				System.out.print("Digite o ID do filme: ");
				int id = input.nextInt();

				FilmeDao filme2 = new FilmeDao();
				for (Filme f : filme2.getFilme(id)) {
					System.out.println("ID: " + f.getId());
					System.out.println("Nome: " + f.getNome());
					System.out.println("Genero: " + f.getGenero());
				}
				System.out.println("Deseja excluir este filme? <s> para sim e <n> para não");
				char ex = input.next().charAt(0);
				if(ex != 'n') {
					filme2.ExcluirFilme(id);
				}else {
					System.out.println("Filme não excluido");
				}
				break;
			}
			}
			
			System.out.println("Deseja continuar? <s> para sim e <n> para não");
			resp = input.next().charAt(0);
			
		} while (resp != 'n');
		
		if(resp == 'n') {
			System.out.println("Fim da operação!!!");
		}
		input.close();
	}
}
