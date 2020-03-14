package com.secretaria.repositorios;

import com.secretaria.dominios.PreMatricula;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PreMatriculaRepository {
    private List<PreMatricula> preMatriculas = new ArrayList<PreMatricula>();
    
    public PreMatricula save(PreMatricula preMatricula) {
        preMatriculas.add(preMatricula);
        return preMatricula;
    }
}