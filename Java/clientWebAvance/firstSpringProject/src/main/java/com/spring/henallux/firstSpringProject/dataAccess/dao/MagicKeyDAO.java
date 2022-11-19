package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.MagicKeyEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.MagicKeyRepository;
import com.spring.henallux.firstSpringProject.model.MagicKeyForm;
import com.spring.henallux.firstSpringProject.provider.ProviderConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class MagicKeyDAO implements MagicKeyDataAccess{

    private MagicKeyRepository magicKeyRepository;
    private ProviderConverter providerConverter;


    @Autowired
    public MagicKeyDAO( MagicKeyRepository magicKeyRepositor, ProviderConverter providerConverter ){
        this.magicKeyRepository = magicKeyRepositor;
        this.providerConverter = providerConverter;
    }

    public ArrayList<MagicKeyForm> getAllMagicKeys(){
        Collection<MagicKeyEntity> entities = magicKeyRepository.findAll();

        ArrayList<MagicKeyForm> forms = new ArrayList<>();
        for(MagicKeyEntity entity : entities){
            forms.add(providerConverter.magicKeyEntitytoMagicKeyForm(entity));
        }
        return forms;
    }
    public void addMagicKey(MagicKeyForm magicKeyForm){
        MagicKeyEntity entity = providerConverter.magicKeyFormtoMagicKeyEntity(magicKeyForm);
        magicKeyRepository.save(entity);
    }

}
