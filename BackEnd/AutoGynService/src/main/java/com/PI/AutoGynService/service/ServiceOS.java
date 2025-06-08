package com.PI.AutoGynService.service;

import com.PI.AutoGynService.entity.dto.OSDTO;
import com.PI.AutoGynService.entity.OS;
import com.PI.AutoGynService.repository.OSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOS {
    @Autowired
    OSRepository osRepository;

    public void save(OS os){
        osRepository.save(os);
    }

    public OS findById(Long id){
        return osRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OS não encontrada com o ID: " + id));
    }

    public List<OS> findAll(){
        return osRepository.findAll();
    }

    public OS update(OSDTO os, Long id) {
        OS os1 = osRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OS não encontrado com o ID: " + id));

        if (os.getStatus() != null) {
            os1.setStatus(os.getStatus());
        }
        if (os.getDataInicio() != null) {
            os1.setDataInicio(os.getDataInicio());
        }
        if (os.getDataFim() != null) {
            os1.setDataFim(os.getDataFim());
        }

        return osRepository.save(os1);
    }
}
