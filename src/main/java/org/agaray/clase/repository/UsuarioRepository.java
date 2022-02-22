package org.agaray.clase.repository;

import org.agaray.clase.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Usuario getByDni(String dni);
}
