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
    private ICadreRepository cadreRepository;

    @Transactional(readOnly = true)
    public List<Cadre> query(Cadre cadre, Class<Cadre> type) {
        return cadreRepository.query(cadre, type);
    }

    @Transactional
    public int save(Cadre cadre) {
        return cadreRepository.save(cadre);
    }

    @Transactional(readOnly = true)
    public Cadre queryForObject(Cadre cadre, Class<Cadre> type) {
        return cadreRepository.queryForObject(cadre, type);
    }

    @Transactional
    public int update(Cadre where, Cadre cadre) {
        return cadreRepository.update(where, cadre);
    }

    @Transactional
    public int delete(Cadre cadre) {
        return cadreRepository.delete(cadre);
    }
}
