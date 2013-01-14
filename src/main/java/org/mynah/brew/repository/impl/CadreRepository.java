package org.mynah.brew.repository.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.mynah.brew.jdbc.Template;
import org.mynah.brew.model.Cadre;
import org.mynah.brew.repository.ICadreRepository;

@Repository
public class CadreRepository implements ICadreRepository {

    @Autowired
    private Template template;

    @Override
    public List<Cadre> query(Cadre cadre, Class<Cadre> type) {
        return template.query(cadre, type);
    }

    @Override
    public int save(Cadre cadre) {
        return template.insert(cadre);
    }

    @Override
    public Cadre queryForObject(Cadre cadre, Class<Cadre> type) {
        return template.queryForObject(cadre, type);
    }

    @Override
    public int update(Cadre where, Cadre cadre) {
        return template.update(where, cadre);
    }

    @Override
    public int delete(Cadre cadre) {
        return template.delete(cadre);
    }
}
