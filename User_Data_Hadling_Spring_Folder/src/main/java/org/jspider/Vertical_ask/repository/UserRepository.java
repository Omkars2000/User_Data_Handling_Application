package org.jspider.Vertical_ask.repository;

import org.jspider.Vertical_ask.module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
