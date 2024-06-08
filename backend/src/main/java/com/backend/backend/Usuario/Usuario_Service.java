package com.backend.backend.Usuario;

import com.backend.backend.Administrador.Administrador;
import com.backend.backend.Administrador.Administrador_Repository;
import com.backend.backend.Docente.Docente;
import com.backend.backend.Docente.DocenteRepository;
import com.backend.backend.Rol.Rol;
import com.backend.backend.Rol.Rol_Repository;
import com.backend.backend.Usuario.DTO.DTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Usuario_Service {
    private final Usuario_Repository usuarioRepository;
    private final DocenteRepository docenteRepository;
    private final Administrador_Repository administradorRepository;
    private final Rol_Repository rolRepository;
    private final PasswordEncoder passwordEncoder;

    public Usuario createUsuario(DTO dto_usuario) {
//        if (usuarioRepository.existsById(dto_usuario.getNro_registro())) {
//            throw new RuntimeException("El número de registro ya existe");
//        }
        System.out.println("entraaaaaaaaaaaa");
        Rol rol1 = rolRepository.getReferenceById(dto_usuario.getId_rol());
        Usuario usuario = Usuario.builder()
                .nroRegistro(dto_usuario.getNro_registro())
                .password(passwordEncoder.encode(dto_usuario.getPassword()))
                .nombre(dto_usuario.getNombre())
                .apellido(dto_usuario.getApellido())
                .ci(dto_usuario.getCi())
                .email(dto_usuario.getEmail())
                .direccion(dto_usuario.getDireccion())
                .fechaNacimiento(dto_usuario.getFechaNacimiento())
                .telefono(dto_usuario.getTelefono())
                .rol(rol1)
                .build();

         usuarioRepository.save(usuario);
         Rol rol = usuario.getRol();
        if (rol.getId() == 1) {
            Administrador admin = Administrador.builder()
                    .nroRegistro(dto_usuario.getNro_registro())
                    .build();
            administradorRepository.save(admin);
        } else if (rol.getId() == 2) {
            Docente docente = Docente.builder()
                    .nroRegistro(dto_usuario.getNro_registro())
                    .build();
            docenteRepository.save(docente);
        }

        return usuario;
    }


    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario updateUsuario(String nroRegistro, DTO dto_usuario) {
        Usuario usuario = usuarioRepository.findById(nroRegistro)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con el número de registro: " + nroRegistro));

        Rol rol = rolRepository.getReferenceById(dto_usuario.getId_rol());
        usuario.setNombre(dto_usuario.getNombre());
        usuario.setApellido(dto_usuario.getApellido());
        usuario.setCi(dto_usuario.getCi());
        usuario.setEmail(dto_usuario.getEmail());
        usuario.setDireccion(dto_usuario.getDireccion());
        usuario.setFechaNacimiento(dto_usuario.getFechaNacimiento());
        usuario.setTelefono(dto_usuario.getTelefono());
        usuario.setRol(rol);

        return usuarioRepository.save(usuario);
    }

    public Usuario getUsuarioByNroRegistro(String nroRegistro) {
        return usuarioRepository.findById(nroRegistro)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con el número de registro: " + nroRegistro));
    }
}
