package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.model.MagicKeyForm;

import java.util.ArrayList;
import java.util.Collection;


public interface MagicKeyDataAccess {
    ArrayList<MagicKeyForm> getAllMagicKeys();
    void addMagicKey(MagicKeyForm magicKeyForm);
}
