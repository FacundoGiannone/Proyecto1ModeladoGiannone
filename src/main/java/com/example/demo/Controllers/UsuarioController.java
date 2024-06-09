package com.example.demo.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.modelo.Usuario;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@RequestMapping(value="mensaje")
	public String mensaje() {
		
		return "hola mundo";
	}
	
	@RequestMapping(value="persona")
	public List<String> listapersonas(){
		
		return List.of("Diego","Juan","Pedro");

}
	
	@RequestMapping(value="User")
	public Usuario listarUsuario() {
		
		Usuario u=new Usuario(38101316,"Facundo","Giannone","fngiannone23@gmail.com","2615192633","Chingolito1234");
		return u;
}
	@RequestMapping(value="user/{id}")
	public Usuario getUsuario(@PathVariable Long id) {
		Usuario i=new Usuario(id,"Facundo","Giannone","fngiannone23@gmail.com","2615192633","Chingolito1234");
		return i;
	}
	
	@RequestMapping(value="listar/usuarios")
	public List<Usuario> ListarVariosUsuarios(){
		
		List<Usuario> usuarios=new ArrayList<>();
		
		Usuario usuario1=new Usuario("Facundo","Giannone","fngiannone23@gmail.com","2615192633","Chingolito1234");
		usuario1.setId(3L);
		
		Usuario usuario2=new Usuario("Facundo","Giannone","fngiannone23@gmail.com","2615192633","Chingolito1234");
		usuario2.setId(4L);
		
		Usuario usuario3=new Usuario("Facundo","Giannone","fngiannone23@gmail.com","2615192633","Chingolito1234");
		usuario3.setId(5L);
		
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		usuarios.add(usuario3);
		
		return usuarios;
		
	}
	
	@RequestMapping(value="api/usuarios")
	public List<Usuario> getUsuario(){
		
		List<Usuario> user=usuarioDao.obtenerUsuarios();
		return user;
	}
}