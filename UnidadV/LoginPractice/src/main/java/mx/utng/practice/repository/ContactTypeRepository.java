package mx.utng.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.utng.practice.model.ContactType;

public interface ContactTypeRepository extends JpaRepository<ContactType, Long>{

}
