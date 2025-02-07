package org.iut.montreuil.Interface;

import org.iut.montreuil.bean.Annonce;

import java.util.List;

public interface AnnonceService {

    void saveAnnonce(Annonce annonce);

    void updateAnnonce(Annonce annonce);

    void deleteAnnonce(Annonce annonce);

    List<Annonce> getAnnonces();

    Annonce getAnnonceById(int id);
}
