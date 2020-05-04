package org.pva.singerapp.controller;

import org.pva.singerapp.dao.PersonDao;
import org.pva.singerapp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    private PersonDao personDao;

    @Autowired
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @RequestMapping(path = "/persons", method = RequestMethod.GET)
    public List<Person> getAllPersons() {
        List<Person> personList = personDao.findAll();
        for (Person person : personList) {
            System.out.println(person);
        }
        return personList;
    }

}
