package org.pva.singerapp.controller;

import org.pva.singerapp.dao.PoetryDao;
import org.pva.singerapp.model.PoetryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(path = "/poems/{id}", method = RequestMethod.GET)
    public PoetryEntity getPoem(@PathVariable("id") String id) {
        return poetryDao.findById(id);
    }

    @RequestMapping(path = "/poems/{id}", method = RequestMethod.DELETE)
    public void deletePoem(@PathVariable("id") String id) {
        poetryDao.delete(id);
    }

    @RequestMapping(path = "/poems", method = RequestMethod.POST)
    public void insertPoem(@RequestBody PoetryEntity poetryEntity) {
        poetryDao.insert(poetryEntity);
    }

    @RequestMapping(path = "/poems", method = RequestMethod.PATCH)
    public void updatePoem(@RequestBody PoetryEntity poetryEntity) {
        poetryDao.update(poetryEntity);
    }
}
