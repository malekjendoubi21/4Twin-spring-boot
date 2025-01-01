package tn.esprit.exam.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.exam.entity.ProjetDetail;
import tn.esprit.exam.entity.ProjetDetail;
import tn.esprit.exam.repository.ProjetDetailRepository;

import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class ProjetDetailService implements  IProjetDetailService {
    ProjetDetailRepository projetDetailRepository;
    @Override
    public List<ProjetDetail> retrieveAllProjetDetails() {
        List<ProjetDetail> listC = projetDetailRepository.findAll();
        log.info("nombre total des chambres : " + listC.size());
        for (ProjetDetail c: listC) {
            log.info("ProjetDetail : " + c);
        }
        return listC;
    }

    @Override
    public ProjetDetail retrieveProjetDetail(Long idProjetDetail) {


        ProjetDetail projetDetail = projetDetailRepository.findById(idProjetDetail).get();
        return projetDetail;
    }

    @Override
    public ProjetDetail addProjetDetail(ProjetDetail projetDetail) {

        ProjetDetail e = projetDetailRepository.save(projetDetail);
        return e;
    }

    @Override
    public void removeProjetDetail(Long idProjetDetail) {
        projetDetailRepository.deleteById(idProjetDetail);
    }

    @Override
    public ProjetDetail modifyProjetDetail(ProjetDetail idProjetDetail) {

        ProjetDetail e = projetDetailRepository.save(idProjetDetail);
        return e;
    }
}
