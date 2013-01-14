package org.mynah.brew.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.mynah.brew.model.Cadre;
import org.mynah.brew.repository.ICadreRepository;

@Service
public class CadreService {

    @Autowired
    private ICadreRepository CadreRepository;

    @Transactional(readOnly = true)
    public List<Cadre> query(Cadre cadre, Class<Cadre> type) {
        return CadreRepository.query(cadre, type);
    }

    @Transactional
    public int save(Cadre cadre) {
        return CadreRepository.save(cadre);
    }

    @Transactional(readOnly = true)
    public Cadre queryForObject(Cadre cadre, Class<Cadre> type) {
        return CadreRepository.queryForObject(cadre, type);
    }

    @Transactional
    public int update(Cadre where, Cadre cadre) {
        return CadreRepository.update(where, cadre);
    }

    @Transactional
    public int delete(Cadre cadre) {
        return CadreRepository.delete(cadre);
    }
}
