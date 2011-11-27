package net.javaci.lighthouse.server.dao;

import java.util.List;

import net.javaci.lighthouse.server.domain.Person;
import net.javaci.lighthouse.server.exception.AuthenticationException;

public interface PersonDao {

  public Person getPerson(Long personId);

  public void savePerson(Person person);

  public List<Person> getPeople();

  public Person getPersonByUsername(String username);

  public Person authenticatePerson(String user, String password)
      throws AuthenticationException;
}
