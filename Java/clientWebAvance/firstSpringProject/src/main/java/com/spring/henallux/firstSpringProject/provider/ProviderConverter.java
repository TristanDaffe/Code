package com.spring.henallux.firstSpringProject.provider;

import com.spring.henallux.firstSpringProject.dataAccess.entity.MagicKeyEntity;
import com.spring.henallux.firstSpringProject.model.MagicKeyForm;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {

    public MagicKeyEntity magicKeyFormtoMagicKeyEntity(MagicKeyForm form){
        MagicKeyEntity magicKeyEntity = new MagicKeyEntity();
        magicKeyEntity.setMagicValue(form.getMagicKey());
        return magicKeyEntity;
    }

    public MagicKeyForm magicKeyEntitytoMagicKeyForm(MagicKeyEntity entity){
        MagicKeyForm magicKeyForm = new MagicKeyForm();
        magicKeyForm.setMagicKey(entity.getMagicValue());
        return magicKeyForm;
    }
}
