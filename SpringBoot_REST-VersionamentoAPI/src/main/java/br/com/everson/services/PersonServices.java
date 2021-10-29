package br.com.everson.services;

import br.com.everson.converter.DozerConverter;
import br.com.everson.converter.custom.PersonConverter;
import br.com.everson.data.model.Person;
import br.com.everson.data.vo.PersonVO;
import br.com.everson.data.vo.v2.PersonVOV2;
import br.com.everson.exception.ResourceNotFoundException;
import br.com.everson.request.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class PersonServices {

    @Autowired
    PersonRepository repository;
    @Autowired
    PersonConverter converter;


    public PersonVO create(PersonVO person) {
        var entity = DozerConverter.parserObject(person, Person.class);
        var vo = DozerConverter.parserObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVOV2 createV2(PersonVOV2 person) {
        var entity = converter.convertVOToEntity(person);
        var vo = converter.convertEntityToVO(repository.save(entity));
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
        var entity = repository.findById(person.getId())
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
