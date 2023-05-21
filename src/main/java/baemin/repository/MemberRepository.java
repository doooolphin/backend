package baemin.repository;

import baemin.entity.Member;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, Integer> {

    Optional<Member> findById(String email);
}
