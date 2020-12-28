package br.com.desafio.cooperforteservice.security;

import br.com.desafio.cooperforteservice.Usuario;
import br.com.desafio.cooperforteservice.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {

        Optional<Usuario> usuarioEncontrado = usuarioRepository.findByEmail(usuario);

        return usuarioEncontrado
                .orElseThrow(() -> {throw new UsernameNotFoundException("Usuario não encontrado: " + usuario);});

    }


}
