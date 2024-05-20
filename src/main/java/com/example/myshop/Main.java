package com.example.myshop;

// import java.time.LocalDate;

// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;
// import org.springframework.security.crypto.password.PasswordEncoder;

// import com.example.myshop.domain.Categoria;
// import com.example.myshop.domain.Arma;
// import com.example.myshop.domain.Rol;
// import com.example.myshop.domain.Usuario;
// import com.example.myshop.domain.Comentario;
// import com.example.myshop.services.CategoriaService;
// import com.example.myshop.services.ArmaService;
// import com.example.myshop.services.UsuarioService;
// import com.example.myshop.services.ComentarioService;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	// @Bean
	// CommandLineRunner initData(
	// 		ArmaService productoService, CategoriaService categoriaService,
	// 		UsuarioService usuarioService, ComentarioService valoracionService, PasswordEncoder passwordEncoder) {
	// 	return args -> {
	// 		Categoria c1 = categoriaService.añadir(new Categoria(0L, "Katana"));
	// 		Categoria c2 = categoriaService.añadir(new Categoria(0L, "Espadones"));
	// 		Arma p1 = new Arma(0L, "Katana2", "Fuerza", c1);
	// 		productoService.añadir(p1);
	// 		Arma p2 = new Arma(0L, "Katana2", "Fé", c1);
	// 		productoService.añadir(p2);
	// 		Arma p3 = new Arma(0L, "Espadon1", "Inteligencia", c2);
	// 		productoService.añadir(p3);
	// 		Arma p4 = new Arma(0L, "Espadon2", "Destreza", c2);
	// 		productoService.añadir(p4);
	// 		LocalDate d1 = LocalDate.of(2000, 10, 10);
	// 		LocalDate d2 = LocalDate.of(2004, 1, 21);
	// 		Usuario u1 = new Usuario(0L, "Juan", passwordEncoder.encode("2345"), Rol.ADMIN, d1);
	// 		usuarioService.añadir(u1);
	// 		Usuario u2 = new Usuario(0L, "Ana", passwordEncoder.encode("1234"), Rol.USUARIO, d2);
	// 		usuarioService.añadir(u2);
	// 		valoracionService.añadir(new Comentario(0L, 1d, "Muy malo", u2, p1));
	// 	};
	// }
}