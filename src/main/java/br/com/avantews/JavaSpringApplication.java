package br.com.avantews;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.avantews.domain.Categoria;
import br.com.avantews.domain.Cidade;
import br.com.avantews.domain.Cliente;
import br.com.avantews.domain.Endereco;
import br.com.avantews.domain.Estado;
import br.com.avantews.domain.Produto;
import br.com.avantews.domain.enums.TipoCliente;
import br.com.avantews.repositories.CategoriaRepository;
import br.com.avantews.repositories.CidadeRepository;
import br.com.avantews.repositories.ClienteRepository;
import br.com.avantews.repositories.EnderecoRepository;
import br.com.avantews.repositories.EstadoRepository;
import br.com.avantews.repositories.ProdutoRepository;

@SpringBootApplication
public class JavaSpringApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Autowired
    private EstadoRepository estadoRepository;
    
    @Autowired
    private CidadeRepository cidadeRepository;
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private EnderecoRepository enderecoRepository;
    
    public static void main(String[] args) {
        SpringApplication.run(JavaSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub

        //Instanciando objetos e gerando informações
        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");
        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "Rio de Janeiro");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);
        Cidade cid1 = new Cidade(null, "Uberlandia", est1);
        Cidade cid2 = new Cidade(null, "Rio de Janeiro", est2);
        Cidade cid3 = new Cidade(null, "Paraiba do Sul", est2);
    
        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "12387945677", TipoCliente.PESSSOAFISICA);
        cli1.getTelefones().addAll(Arrays.asList("22555522", "22559988"));
        Endereco end1 = new Endereco(null, "Rua Flores da Junqueira", "300", "Apto 203", "Jardim Botanico", "25715363", cli1, cid1);
        Endereco end2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, cid2);
        cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
                
        //Associando categorias ao tipo de produtos correspondente.
        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));
        est1.getCidades().addAll(Arrays.asList(cid1));
        est2.getCidades().addAll(Arrays.asList(cid2, cid3));

        //Associando produtos ao tipo de categorias correspondente.
        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        //Salvando categorias na base de dadoss
        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        //Salvando produtos na base de dados
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
        //Salvando estados na base de dados
        estadoRepository.saveAll(Arrays.asList(est1, est2));
        //Salvando cidades na base de dados
        cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
        //Salvando cliente na base de dados
        clienteRepository.saveAll(Arrays.asList(cli1));
        //Salvando endereços na base de dados
        enderecoRepository.saveAll(Arrays.asList(end1, end2));
                
    }
}
