package org.pva.singerapp.controller;

import org.pva.singerapp.dao.PoetryDao;
import org.pva.singerapp.model.PoetryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PoetryController {

    private PoetryDao poetryDao;

    @Autowired
    public void setPoetryDao(PoetryDao poetryDao) {
        this.poetryDao = poetryDao;
    }

    @RequestMapping(path = "/poems", method = RequestMethod.GET)
    public List<PoetryEntity> getAllPoems() {
        return poetryDao.findAll();
    }
}
