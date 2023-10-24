package net.reliqs.gleeometer.glee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.reliqs.gleeometer.users.User;


@Repository
interface GleeRepository extends JpaRepository<Glee, Long>, GleeRepositoryCustom {
    Page<Glee> findAllByUser(User user, Pageable pageable);
}
