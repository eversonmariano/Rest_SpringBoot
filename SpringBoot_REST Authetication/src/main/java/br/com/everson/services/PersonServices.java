package br.com.everson.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everson.converter.DozerConverter;
import br.com.everson.data.model.Person;
import br.com.everson.data.vo.v1.PersonVO;
import br.com.everson.exception.ResourceNotFoundException;
import br.com.everson.request.repository.PersonRepository;



@Service
public class PersonServices {

    @Autowired
    PersonRepository repository;

    public PersonVO create(PersonVO person) {
        var entity = DozerConverter.parserObject(person, Person.class);
        var vo = DozerConverter.parserObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public List<PersonVO> findAll() {
        return DozerConverter.parserListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) {

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return DozerConverter.parserObject(entity, PersonVO.class);
    }

    public PersonVO update(PersonVO person) {
        var entity = repository.findById(person.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAdress(person.getAdress());
        entity.setGender(person.getGender());

        var vo = DozerConverter.parserObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(Long id) {
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }

}
