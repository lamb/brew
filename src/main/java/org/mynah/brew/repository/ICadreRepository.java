package org.mynah.brew.repository;

import java.util.List;

import org.mynah.brew.model.Cadre;

public interface ICadreRepository {

    List<Cadre> query(Cadre Cadre, Class<Cadre> type);

    int save(Cadre Cadre);

    Cadre queryForObject(Cadre Cadre, Class<Cadre> type);

    int update(Cadre where, Cadre Cadre);

    int delete(Cadre Cadre);

}
