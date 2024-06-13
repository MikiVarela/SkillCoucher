package com.example.myshop;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.myshop.domain.Categoria;
import com.example.myshop.domain.Sky;
import com.example.myshop.domain.Over;
import com.example.myshop.domain.Usuario;
import com.example.myshop.domain.enumerales.Rol;
import com.example.myshop.services.CategoriaService;
import com.example.myshop.services.UsuarioService;
import com.example.myshop.services.SkyService;
import com.example.myshop.services.OverService;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner initData(
			CategoriaService categoriaService, SkyService skyService, OverService overService,
			UsuarioService usuarioService, PasswordEncoder passwordEncoder) {
		return args -> {
			Categoria expedicion = categoriaService.añadir(new Categoria(0L, "Expedicion"));
			Categoria armas = categoriaService.añadir(new Categoria(0L, "Arma"));
			Categoria naves = categoriaService.añadir(new Categoria(0L, "Nave"));
			Categoria tecnico = categoriaService.añadir(new Categoria(0L, "Técnico"));
			Categoria meta = categoriaService.añadir(new Categoria(0L, "Meta"));
			skyService.añadir(new Sky(0L, "EXpedición 13", "https://www.youtube.com/embed/XJnlXtDD1-Y", expedicion));
			skyService.añadir(new Sky(0L, "Carguero pirata ", "https://www.youtube.com/embed/3xSVdbs102E", naves));
			skyService.añadir(new Sky(0L, "Faciones", "https://www.youtube.com/embed/X1S9ZiSjLgQ", tecnico));
			skyService.añadir(new Sky(0L, "Aumentos de comercio", "https://www.youtube.com/embed/UJqvurMQh3E", tecnico));
			skyService.añadir(new Sky(0L, "Cetro del altar", "https://www.youtube.com/embed/1Tb0CGSeJD8", armas));
			skyService.añadir(new Sky(0L, "Expedición 12", "https://www.youtube.com/embed/Jg6Z6NJqQLc", expedicion));
			skyService.añadir(new Sky(0L, "Fabricacion de naves", "https://www.youtube.com/embed/7lQuXwCf2kU", naves));
			skyService.añadir(new Sky(0L, "Mejor multitool", "https://www.youtube.com/embed/667uipFoST8", armas));
			skyService.añadir(new Sky(0L, "La granja sas ilegal", "https://www.youtube.com/embed/vYhv5HVjuIc", tecnico));
			skyService.añadir(new Sky(0L, "Espacio de carguero", "https://www.youtube.com/embed/LIgGtdbm4eU", naves));
			skyService.añadir(new Sky(0L, "Exonaves", "https://www.youtube.com/embed/OrZKOq1hhg4", naves));
			skyService.añadir(new Sky(0L, "Expedición 1", "https://www.youtube.com/embed/yuq85tAekFI", expedicion));
			overService.añadir(new Over(0L, "Meta temporada 10", "https://www.youtube.com/embed/38y67GYNtt0", meta));
			overService.añadir(new Over(0L, "Combo rotísimo", "https://www.youtube.com/embed/8nDghSjPwnY", meta));
			overService.añadir(new Over(0L, "Consigue esta skin gratis", "https://www.youtube.com/embed/YUTyk7RGLtg", meta));
			overService.añadir(new Over(0L, "Peores metas de Overwatch 'classic'", "https://www.youtube.com/embed/iVFvyXYrjxI", meta));
			overService.añadir(new Over(0L, "Mejores y peores héroes", "https://www.youtube.com/embed/u0z2GuSfiqU", meta));
			overService.añadir(new Over(0L, "Nuevo parche de emergencia", "https://www.youtube.com/embed/stTd4AepNsU", meta));
			overService.añadir(new Over(0L, "Nuevo parche", "https://www.youtube.com/embed/vXE_eruKTzY", meta));
			overService.añadir(new Over(0L, "Counters", "https://www.youtube.com/embed/wEmf3LzA3-U", meta));
			overService.añadir(new Over(0L, "3 mejores héroes por rol", "https://www.youtube.com/embed/Aik5Bppp49U", meta));
			LocalDate d1 = LocalDate.of(2000, 10, 10);
			LocalDate d2 = LocalDate.of(2004, 1, 21);
			Usuario u1 = new Usuario(0L, "Juan", passwordEncoder.encode("2345"), Rol.ADMIN, d1);
			usuarioService.añadir(u1);
			Usuario u2 = new Usuario(0L, "Ana", passwordEncoder.encode("1234"), Rol.USUARIO, d2);
			usuarioService.añadir(u2);
		};
	}
}