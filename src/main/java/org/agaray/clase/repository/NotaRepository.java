package org.agaray.clase.repository;

import org.agaray.clase.entity.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Long> {

}
