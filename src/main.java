
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mig.java.BLL.UsuarioBLL;
import org.mig.java.Entities.Usuarios;
import org.mig.java.BLL.TiendasBLL;
import org.mig.java.Entities.Tiendas;

/**
 *
 * @author miguelangel
 */
public class main {

    public static void main(String[] args) {

        //LOGIN USUARIO
        //LoginUsuario();
        //REGISTRO USUARIO
        // RegistrarUsuario();
        //REGISTRAR TIENDA
        RegistrarTienda();
    }

    private static void RegistrarTienda() {
        TiendasBLL tiendasBll = new TiendasBLL();
        Tiendas tiendas = new Tiendas();
        Usuarios usuario = LoginUsuario();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Logeate para poder registrar una tienda");

        if (usuario != null) {
            try {
                System.out.println("Bienvenido!" + usuario.getNombre());
                System.out.println("Puedes registrar tu tienda");
                System.out.println("Introduce un CIF VALIDO:"); //Aqui validariamos el NIF
                tiendas.setCif(bf.readLine());
                System.out.println("Introduce un nombre para la tienda.");
                tiendas.setNombre(bf.readLine());

            } catch (IOException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("Error de Login");
            System.out.println("Necesitas estar registado para registrar una tienda");
        }
        tiendasBll.RegistrarTienda(tiendas, usuario);

    }

    private static void RegistrarUsuario() {

        UsuarioBLL usuarioBll = new UsuarioBLL();
        Usuarios usuario = new Usuarios();
        String dni = "22659449X";

        String userName = "jana";
        String mail = "bonanadjana@hotmail.com";
        String password = "963922224";
        String nombre = "Juan Antonio";
        String apellido1 = "Navarro";
        String apellido2 = "Boananad";
        Date fechaNacimiento = Date.valueOf("1987-06-01");
        String pais = "España";
        String perfil = "V";
        String sexo = "H";

        //validar dni
        //nifValidator.validarNif(dni, letra);
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
        usuario.setSexo(sexo);
        usuarioBll.RegistrarUsuario(usuario);
    }

    private static Usuarios LoginUsuario() {
        Usuarios usuario = new Usuarios();
        UsuarioBLL usuarioBll = new UsuarioBLL();

        String Mail = "bonanadjana@hotmail.com";
        String passwordLogin = "963922224";
        usuario.setMail(Mail);
        usuario.setPassword(passwordLogin);

        Usuarios usuarioValido = usuarioBll.loginUsuario(usuario);

        if (usuarioValido != null) {
            System.out.println("Bienvenido!" + usuarioValido.getNombre());
        } else {
            System.out.println("Error de Login");
        }

        return usuarioValido;
    }
}
