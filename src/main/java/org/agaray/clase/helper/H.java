package org.agaray.clase.helper;

import javax.servlet.http.HttpSession;

import org.agaray.clase.entity.Alumno;
import org.agaray.clase.entity.Profesor;
import org.agaray.clase.entity.Usuario;
import org.agaray.clase.exception.DangerException;
import org.agaray.clase.exception.PRG;

public class H {
		/**
		 * 
		 * @param 	rolExigido 			Tres posibilidades "anon", "alumno", "profesor"
		 * @param 	s   				la sesión activa
		 * @throws 	DangerException		si el rol no coincide con el del usuario activo
		 */
		public static void isRolOK(String rolExigido, HttpSession s) throws DangerException {
			String rolActual = "anon";
			
			Usuario usuario = (Usuario)s.getAttribute("usuario"); 
			if (usuario!=null) {
				if (usuario instanceof Alumno) {
					rolActual="alumno";
				}
				else if (usuario instanceof Profesor) {
					rolActual="profesor";
				}
			}
			
			if (!rolExigido.equals(rolActual)) {
				PRG.error("El rol no es adecuado");
			}
	}

}
