package br.com.braulioti.repositoriy;

import br.com.braulioti.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> { }
