package com.neusoft.medical.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.neusoft.medical.service.doctorWorkstation.ExaminationService;
import org.springframework.stereotype.Service;

@Service
public class ExaminationServiceImpl implements ExaminationService {
    private Gson gson = new Gson();

    @Override
    public boolean addExamination(String examinationJson) {
        JsonObject examinationJsonObject = gson.toJsonTree(examinationJson).getAsJsonObject();

        return false;
    }
}
