package baemin.repository;

import baemin.entity.MemberAuth;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberAuthRepository extends CrudRepository<MemberAuth, Integer> {

    Optional<MemberAuth> findByEmail(String email);
}
