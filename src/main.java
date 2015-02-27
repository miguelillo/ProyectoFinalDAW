
import java.sql.Date;
import org.mig.java.BLL.UsuarioBLL;
import org.mig.java.Entities.Usuarios;

/**
 *
 * @author miguelangel
 */
public class main {

    public static void main(String[] args) {

        UsuarioBLL usuarioBll = new UsuarioBLL();
        Usuarios usuario = new Usuarios();
        //PRUEBA LOGIN USUARIO

        String Mail = "miguel.navarrovera@gmail.com";
        String passwordLogin = "963922224";
        usuario.setMail(Mail);
        usuario.setPassword(passwordLogin);

        Usuarios usuarioValido = usuarioBll.loginUsuario(usuario);

        if (usuarioValido != null) {
            System.out.println("Bienvenido!" + usuarioValido.getNombre());
        } else {
            System.out.println("Error de Login");
        }

//PRUEBA REGISTRO USUARIO
        String dni = "22595516V";
        String userName = "Hildegard";
        String mail = "miguel.navarrovera@gmail.com";
        String password = "963922224";
        String nombre = "Miguel Angel";
        String apellido1 = "Navarro";
        String apellido2 = "vera";
        Date fechaNacimiento = Date.valueOf("1987-06-01");
        String pais = "España";

        String perfil = "A";

        usuario.setDni(dni);
        usuario.setUserName(userName);
        usuario.setMail(mail);
        usuario.setPassword(password);
        usuario.setNombre(nombre);
        usuario.setApellido1(apellido1);
        usuario.setApellido2(apellido2);
        usuario.setPais(pais);
        usuario.setFechaNacimiento(fechaNacimiento);
        usuario.setPerfil(perfil);
        
        usuarioBll.RegistrarUsuario(usuario);

    }

}
