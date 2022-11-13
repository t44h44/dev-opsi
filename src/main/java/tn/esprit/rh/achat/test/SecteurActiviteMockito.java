package tn.esprit.rh.achat.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.SecteurActiviteServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SecteurActiviteMockito {
    @Mock
    SecteurActiviteRepository secteurRepository;
    @InjectMocks
    SecteurActiviteServiceImpl secteurSer;

    SecteurActivite secteur = new SecteurActivite("test", "test");
    List<SecteurActivite> listSecteur = new ArrayList<SecteurActivite>() {
        {
            add(new SecteurActivite("code1", "secteur1"));
            add(new SecteurActivite("code2", "secteur2"));
        }
    };
    
    @Test

    void retreiveSecteurActivite() {
        Mockito.when(secteurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(secteur));
        SecteurActivite secteur1 = secteurSer.retrieveSecteurActivite(1L);
        Assertions.assertNotNull(secteur1);
    }
}