package br.com.ono.erp.entidade;

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
        endp.setCodigoBcPais("235");
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
        
        // Cria uns paises para teste
        Pais pais = new Pais();
        pais.setCodigoBacen("01058");
        pais.setNome("BRASIL");
        pais.setSigla2("BR");

        Pais pais2 = new Pais();
        pais2.setCodigoBacen("05860");
        pais2.setNome("PARAGUAI");
        pais2.setSigla2("PY");
        
        em.getTransaction().begin();
        em.persist(pj);
        em.persist(pais);
        em.persist(pais2);
        em.getTransaction().commit();
    }
  
}
