package com.digitalinnovationone.buscadorcidadesbrasil.services.utility;

import com.digitalinnovationone.buscadorcidadesbrasil.models.Cidade;
import com.digitalinnovationone.buscadorcidadesbrasil.repositories.CidadeRepository;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

@Service
public class CidadeUtility {

    private final CidadeRepository cidadeRepository;
    public CidadeUtility(final CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public Double distanceByCubeInMeters(Cidade origem, Cidade destino) {

        Point p1 = getGeolocation(origem.getLatitude(), origem.getLongitude());
        Point p2 = getGeolocation(destino.getLatitude(), destino.getLongitude());

        return cidadeRepository.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    private Point getGeolocation(String lat, String lon){
        return new Point(Double.parseDouble(lat), Double.parseDouble(lon));
    }

}
