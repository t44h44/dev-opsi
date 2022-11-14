package tn.esprit.rh.achat.test;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import tn.esprit.rh.achat.entities.Facture;

import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.services.FactureServiceImpl;


@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Slf4j
public class FactureTest {
	@Mock
	FactureRepository facturerepo;

   @InjectMocks
   FactureServiceImpl factureService;
    //Fournisseur f=Fournisseur.builder().idFournisseur(1L).code("123").libelle("test1")
         //   .categorieFournisseur(null).detailFournisseur(null).factures(null)
          //  .secteurActivites(null).build();
   Facture f3 = new Facture(6L,233,11,null,null,true,null,null,null);
    @Test
    public void retrieveFacture(){
        Facture f = new Facture(1L,233,11,null,null,true,null,null,null);

        when(facturerepo.findById(1L)).thenReturn(Optional.of(f));
        Facture Facture= factureService.retrieveFacture((long) 1);
        Assertions.assertNotNull(Facture);
        log.info("get ==>"+ Facture.toString());
    }
    
    @Test
    public void addFacture(){
    	Facture f = new Facture(2L,233,11,null,null,true,null,null,null);
        f.setIdFacture(2L);
        factureService.addFacture(f);
        verify(facturerepo, times(1)).save(f);
        System.out.println(f);
        log.info("add ==>"+ f.toString());
    }

    @Test
    public void retrieveAllFactures()
    {
        List<Facture> Lf = new ArrayList<Facture>() {
			private static final long serialVersionUID = 1L;

			{
                add(new Facture(3L,233,11,null,null,true,null,null,null));
                add(new Facture(4L,233,11,null,null,true,null,null,null));
                add(new Facture(5L,233,11,null,null,true,null,null,null));
            }};

        when(factureService.retrieveAllFactures()).thenReturn(Lf);
        //test
        List<Facture> factureList = factureService.retrieveAllFactures();
        assertEquals(3, factureList.size());
        log.info("retrieve all ==>"+ factureList.toString());

    }

}
