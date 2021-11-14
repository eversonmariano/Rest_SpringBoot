package br.com.everson.security;

import java.io.Serializable;
import java.util.Objects;

public class AccountCredentialsVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String passaword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassaword() {
        return passaword;
    }

    public void setPassaword(String passaword) {
        this.passaword = passaword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountCredentialsVO)) return false;
        AccountCredentialsVO that = (AccountCredentialsVO) o;
        return Objects.equals(username, that.username) && Objects.equals(passaword, that.passaword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, passaword);
    }
}
