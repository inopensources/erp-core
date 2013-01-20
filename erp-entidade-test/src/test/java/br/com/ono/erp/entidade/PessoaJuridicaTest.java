package br.com.ono.erp.entidade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testes para Entidade PessoaJuridica.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.0.0 (18/01/2013 10:26)
 */
public class PessoaJuridicaTest {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("entidadePU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void criarPessoaJuridica() {
        PessoaJuridica pj = new PessoaJuridica();
        pj.setCnpj("62236146000198");
        pj.setInscricaoEstadual("1234567");
        pj.setNomeFantasia("YACIMA");
        pj.setRazaoSocial("YACIMA ATACADISTA DE ROUPAS LTDA");
        
        // Endereco
        EnderecoParticipante endp = null;
        endp= new EnderecoParticipante();
        endp.setBairro("BRAS");
        endp.setCep("03010000");
        endp.setComplemento("---");
        endp.setLogradouro("RUA MENDES JUNIOR");
        endp.setNumero("148/160");
        endp.setTipo("LOCAL");
        endp.setMunicipio("SAO PAULO");
        endp.setCodigoIbgeMunicipio("12345");
        endp.setUf("SP");
        endp.setCodigoIbgeUf("35");
        endp.setPais("Brasil");
        endp.setCodigoBacenPais("235");
        pj.getEnderecos().add(endp);
        
        EmailParticipante emlp = null;
        // Email para NFe
        emlp = new EmailParticipante();
        emlp.setEmail("yacima@yacima.com.br");
        emlp.setTipo("nfe");
        pj.getEmails().add(emlp);
        // Email CAC
        emlp = new EmailParticipante();
        emlp.setEmail("cac@yacima.com.br");
        emlp.setTipo("cac");
        pj.getEmails().add(emlp);
        
        TelefoneParticipante tp = new TelefoneParticipante();
        // Celular do responsavel
        tp.setDescricao("CEL");
        tp.setDdd("11");
        tp.setNumero("998969127");
        pj.getTelefones().add(tp);
        // Telefone fixo
        tp.setDescricao("FIXO");
        tp.setDdd("11");
        tp.setNumero("26930418");
        pj.getTelefones().add(tp);
        
        em.getTransaction().begin();
        em.persist(pj);
        
        // Obtem a lista de paises diretamente do site do BACEN
        // e salva no banco
        try {
            for (Pais pais : getPaisesSiteBacen()) {
                em.persist(pais);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        // Obtem a lista de estados do Brasil e salva no banco
        for (Estado estado : getEstadosBrasil()) {
            em.persist(estado);
        }
        
        // Obtem a lista de municipios do Brasil e salva no banco
        for (Municipio municipio : getMunicipiosBrasil()) {
            em.persist(municipio);
        }        

        // Cria a empresa a ser gerenciada
        Empresa empresa = new Empresa();
        empresa.setDataCadastro(new Date());
        empresa.setRegimeTributacao("LUCRO REAL");
        empresa.setPessoaJuridica(pj);
        em.persist(empresa);
        
        // Obtem a lista de natureza de operacoes de teste e salva no banco
        for (NaturezaOperacao naturezaOperacao : getNaturezasOperacoes(empresa)) {
            em.persist(naturezaOperacao);
        }        
        
        em.getTransaction().commit();
    }
  
    // Obtem a lista de paises diretamente do site do BACEN
    private static List<Pais> getPaisesSiteBacen() throws Exception {
        List<Pais> paises = new ArrayList<Pais>();
        Pais pais = null;
        URL url = new URL("http://www.bcb.gov.br/Rex/TabPaises/Ftp/paises.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        String linha = null;
        while ((linha = br.readLine()) != null) {
            linha = linha.trim();
            String codigoBacen = linha.substring(0, linha.indexOf(" "));
            String nomePais = linha.substring(linha.indexOf(" "));
            pais = new Pais();
            pais.setCodigoBacen(codigoBacen);
            pais.setNome(nomePais);
            paises.add(pais);
        }
        br.close();
        return paises;
    }
    
    // Cria todos estados do Brasil
    private static List<Estado> getEstadosBrasil() {
        List<Estado> estados = new ArrayList<Estado>();
        estados.add(criarEstado("12","AC","ACRE"));
        estados.add(criarEstado("27","AL","ALAGOAS"));        
        estados.add(criarEstado("13","AM","AMAZONAS"));
        estados.add(criarEstado("16","AP","AMAPA"));
        estados.add(criarEstado("23","CE","CEARA"));
        estados.add(criarEstado("53","DF","DISTRITO FEDERAL"));
        estados.add(criarEstado("52","GO","GOIAS"));
        estados.add(criarEstado("21","MA","MARANHAO"));
        estados.add(criarEstado("31","MG","MINAS GERAIS"));
        estados.add(criarEstado("50","MS","MATO GROSSO DO SUL"));
        estados.add(criarEstado("51","MT","MATO GROSSO"));
        estados.add(criarEstado("15","PA","PARA"));
        estados.add(criarEstado("25","PB","PARAIBA"));
        estados.add(criarEstado("26","PE","PERNAMBUCO"));
        estados.add(criarEstado("22","PI","PIAUI"));
        estados.add(criarEstado("41","PR","PARANA"));
        estados.add(criarEstado("33","RJ","RIO DE JANEIRO"));
        estados.add(criarEstado("24","RN","RIO GRANDE DO NORTE"));
        estados.add(criarEstado("11","RO","RONDONIA"));
        estados.add(criarEstado("14","RR","RORAIMA"));
        estados.add(criarEstado("43","RS","RIO GRANDE DO SUL"));
        estados.add(criarEstado("42","SC","SANTA CATARINA"));
        estados.add(criarEstado("28","SE","SERGIPE"));
        estados.add(criarEstado("35","SP","SAO PAULO"));
        estados.add(criarEstado("17","TO","TOCANTIS"));        
        return estados;
    }
    
    private static Estado criarEstado(String codigoIbge, String sigla, String nome) {
        Estado estado = new Estado();
        estado.setCodigoIbge(codigoIbge);
        estado.setSigla(sigla);
        estado.setNome(nome);
        return estado;
    }
    
    // Cria todos municipios do Brasil. Pega os dados de /municipios.txt
    private static List<Municipio> getMunicipiosBrasil() {
        List<Municipio> municipios = new ArrayList<Municipio>();
        try {
            Municipio municipio = null;
            InputStream is = PessoaJuridicaTest.class.getResourceAsStream("/municipios.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linha = null;
            while ((linha = br.readLine()) != null) {
                String uf = linha.split(",")[0];
                String codigoIbge = linha.split(",")[1];
                String nomeMunicipio = linha.split(",")[2].toUpperCase();
                municipio = new Municipio();
                municipio.setCodigoIbge(codigoIbge);
                municipio.setNome(nomeMunicipio);
                municipio.setUf(uf);
                municipios.add(municipio);
            }
            br.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return municipios;
    }
    
    // Cria as naturezas de operacoes de teste
    private static List<NaturezaOperacao> getNaturezasOperacoes(Empresa empresa) {
        List<NaturezaOperacao> naturezasDeOperacoes = new ArrayList<NaturezaOperacao>();
        NaturezaOperacao naturezaDeOperacao = null;
        naturezaDeOperacao = new NaturezaOperacao();
        naturezaDeOperacao.setCodigo(1L);
        naturezaDeOperacao.setDescricao("COMPRA");
        naturezaDeOperacao.setEmpresa(empresa);
        naturezasDeOperacoes.add(naturezaDeOperacao);
        naturezaDeOperacao = new NaturezaOperacao();
        naturezaDeOperacao.setCodigo(2L);
        naturezaDeOperacao.setDescricao("VENDA");
        naturezaDeOperacao.setEmpresa(empresa);
        naturezasDeOperacoes.add(naturezaDeOperacao);
        naturezaDeOperacao = new NaturezaOperacao();
        naturezaDeOperacao.setCodigo(3L);
        naturezaDeOperacao.setDescricao("DEVOLUCAO DE VENDA");
        naturezaDeOperacao.setEmpresa(empresa);
        naturezasDeOperacoes.add(naturezaDeOperacao);
        naturezaDeOperacao = new NaturezaOperacao();
        naturezaDeOperacao.setCodigo(4L);
        naturezaDeOperacao.setDescricao("DEVOLUCAO DE COMPRA");
        naturezaDeOperacao.setEmpresa(empresa);
        naturezasDeOperacoes.add(naturezaDeOperacao);
        naturezaDeOperacao = new NaturezaOperacao();
        naturezaDeOperacao.setCodigo(5L);
        naturezaDeOperacao.setDescricao("SIMPLES REMESSA");
        naturezaDeOperacao.setEmpresa(empresa);
        naturezasDeOperacoes.add(naturezaDeOperacao);
        return naturezasDeOperacoes;
    }    
    
}
