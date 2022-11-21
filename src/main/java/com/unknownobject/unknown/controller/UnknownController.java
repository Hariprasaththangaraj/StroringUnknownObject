package com.unknownobject.unknown.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unknownobject.unknown.entity.UnknownEntity;
import com.unknownobject.unknown.repo.UnknownRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class UnknownController {

    @Autowired
    UnknownRepo unknownRepo;

    @PostMapping("/save")
    public String saveData(@RequestBody Object object){

        //convert Json to java object
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> convertedData = objectMapper.convertValue(object, Map.class);

          // convert to Entity
        Object fname = convertedData.get("firstName");
        UnknownEntity entity = new UnknownEntity();
        entity.setFirstName(fname.toString());

        unknownRepo.save(entity);
        return "Data Saved";

    }

}
