package com.mv.mvpsi.servicio;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mv.mvpsi.modelo.User;
import com.mv.mvpsi.repositorio.RepositorioUser;

@Service
public class UserDetServicio implements UserDetailsService {

    private final RepositorioUser RepositorioUser;

    public UserDetServicio(RepositorioUser repositorioUser) {
        this.RepositorioUser = repositorioUser;
    }

    @Override
    public UserDetails loadUserByUsername(String correo)
            throws UsernameNotFoundException {

        User user = RepositorioUser.findByCorreo(correo)
                .orElseThrow(() ->
                    new UsernameNotFoundException("El correo no existe: " + correo));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getCorreo())
                .password(user.getContrasena())
                .roles(user.getRol())
                .build();
    }
    
}

