package br.uem.iss.anesthesia.model.repository;

import br.uem.iss.anesthesia.model.entity.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {

    Set<UserModel> findByLoginContaining(String login);

    Set<UserModel> findByLoginContainingAndPasswordContaining(String login, String password);

}