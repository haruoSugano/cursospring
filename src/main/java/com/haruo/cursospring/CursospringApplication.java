package com.haruo.cursospring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.haruo.cursospring.domain.Categoria;
import com.haruo.cursospring.domain.Cidade;
import com.haruo.cursospring.domain.Estado;
import com.haruo.cursospring.domain.Produto;
import com.haruo.cursospring.repositories.CategoriaRepository;
import com.haruo.cursospring.repositories.CidadeRepository;
import com.haruo.cursospring.repositories.EstadoRepository;
import com.haruo.cursospring.repositories.ProdutoRepository;

@SpringBootApplication
public class CursospringApplication implements CommandLineRunner{ // CommandLineRunner, ao executar a aplicacao permite que, o metódo inicie com uma ação. 
	
	// Criando as dependências:
	@Autowired
	private CategoriaRepository categoriaRepository; // É o responsável  por salvar as categorias
	@Autowired
	private ProdutoRepository produtoRepository; // Responsável por salvar os produtos
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursospringApplication.class, args);
	}

	// Método criado pelo CommandLineRunner
	@Override
	public void run(String... args) throws Exception {
		/**
		 * Instanciando os objetos:
		 */
		Categoria categoria1 = new Categoria(null, "Informatica"); // BD gera ID automaticamente. por isso é null.
		Categoria categoria2 = new Categoria(null, "Escritorio");
		
		Produto produto1 = new Produto(null, "Computador", 2000.00);
		Produto produto2 = new Produto(null, "Impressora", 800.00);
		Produto produto3 = new Produto(null, "Mouse", 80.00);
		
		/**
		 * Associando Categoria com produtos e Produto com categorias:
		 */
		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3)); // Produtos associados com categoria1
		categoria2.getProdutos().addAll(Arrays.asList(produto2)); // Produtos associados com categoria2
		
		produto1.getCategorias().addAll(Arrays.asList(categoria1)); // Categoria associados com produtos
		produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));
		
		// Salvando categoria ao banco D:
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2)); // Chamando -> categoriaRepository e uma função para salvar -> saveAll() 
		// Salvando produtos ao banco D:
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
		// Arrays.asList() criar uma lista automatico.
		
		/**
		 * Estado e Cidade
		 */
		Estado estado1 = new Estado(null, "Minas Gerais");
		Estado estado2 = new Estado(null, "São Paulo");
		
		Cidade cidade1 = new Cidade(null, "Uberlandia", estado1);
		Cidade cidade2 = new Cidade(null, "São Paulo", estado2);
		Cidade cidade3 = new Cidade(null, "Campinas", estado2);
		
		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));
		
		estadoRepository.saveAll(Arrays.asList(estado1, estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
		
	}
}
