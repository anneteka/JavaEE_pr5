package javaee.hw5.service;

import javaee.hw5.repository.UserRepository;
import javaee.hw5.repository.entity.User;
import javaee.hw5.repository.entity.myenums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class DetailsService
        implements UserDetailsService
{
    private UserRepository userRepository;

    @Autowired
    public DetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No user with login: " + username));

        return org.springframework.security.core.userdetails.User.builder()
                .username(username)
                .password(user.getPassword())
                .authorities(mapAuthorities(user.getRole()))
                .build();
    }



    private static GrantedAuthority mapAuthorities(Role role) {
        return new SimpleGrantedAuthority(role.name());
    }
}
