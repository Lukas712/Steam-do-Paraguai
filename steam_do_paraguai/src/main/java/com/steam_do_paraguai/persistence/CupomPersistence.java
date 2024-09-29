/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steam_do_paraguai.persistence;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.steam_do_paraguai.model.Cupom;
import com.steam_do_paraguai.model.CupomFixo;
import com.steam_do_paraguai.model.CupomPorcentagem;
import static com.steam_do_paraguai.persistence.Persistence.DIRECTORY;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author lukas-freitas
 */
public class CupomPersistence  implements Persistence<Cupom> {
     private static final String PATH = DIRECTORY +"/cupons.json";
    
    @Override
    public void save(List<Cupom> cupons) {
    List<Map<String, Object>> cuponsComTipo = new ArrayList<>();

    for (Cupom cupom : cupons) {
        Map<String, Object> cupomMap = new HashMap<>();
        cupomMap.put("typeClass", cupom.getClass().getSimpleName());
        cupomMap.put("dados", cupom);
        cuponsComTipo.add(cupomMap);
    }

    Gson gson = new Gson();
    String json = gson.toJson(cuponsComTipo);

    File diretorio = new File(DIRECTORY);
    if (!diretorio.exists())
        diretorio.mkdirs();

    Arquivo.salva(PATH, json);
}

    @Override
public List<Cupom> findAll() {
    List<Cupom> cupons = new ArrayList<>();
    Gson gson = new Gson();

    String json = Arquivo.le(PATH);
    if (!json.trim().equals("")) {
        Type tipoLista = new TypeToken<List<Map<String, Object>>>() {}.getType();
        List<Map<String, Object>> cuponsComTipo = gson.fromJson(json, tipoLista);

        for (Map<String, Object> cupomMap : cuponsComTipo) {
            String tipo = (String) cupomMap.get("typeClass");
            JsonElement cupomData = gson.toJsonTree(cupomMap.get("dados"));

            if (tipo.equals("CupomFixo")) {
                cupons.add(gson.fromJson(cupomData, CupomFixo.class));
            } else if (tipo.equals("CupomPorcentagem")) {
                cupons.add(gson.fromJson(cupomData, CupomPorcentagem.class));
            }
        }
    }

    return cupons;
    }
}
