package br.com.everson.data.vo;


import java.io.Serializable;
import java.util.Objects;


public class PersonVO implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;


    private String firstName;

    private String lastName;

    private String adress;

    private String gender;

    public PersonVO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonVO)) return false;
        PersonVO personVO = (PersonVO) o;
        return Objects.equals(id, personVO.id) && Objects.equals(firstName, personVO.firstName) && Objects.equals(lastName, personVO.lastName) && Objects.equals(adress, personVO.adress) && Objects.equals(gender, personVO.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, adress, gender);
    }
}
