package one.digitalinnovation.gof.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.model.Produto;
import one.digitalinnovation.gof.model.ProdutoRepository;
import one.digitalinnovation.gof.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	// Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private ProdutoRepository produtoRepository;

	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<Produto> buscarTodos() {
		// Buscar todos os Produtos.
		return produtoRepository.findAll();
	}

	@Override
	public Produto buscarPorId(Long id) {
		// Buscar Produto por ID.
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.get();
	}

	@Override
	public void inserir(Produto produto) {
		produtoRepository.save(produto);
	}

	@Override
	public void atualizar(Long id, Produto produto) {
		// Buscar Produto por ID, caso exista:
		Optional<Produto> produtoBd = produtoRepository.findById(id);
		if (produtoBd.isPresent()) {
			inserir(produto);
		}
	}

	@Override
	public void deletar(Long id) {
		// Deletar Produto por ID.
		produtoRepository.deleteById(id);
	}
}
