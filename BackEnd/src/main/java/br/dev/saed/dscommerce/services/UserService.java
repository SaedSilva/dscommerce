package br.dev.saed.dscommerce.services;

import br.dev.saed.dscommerce.entities.Role;
import br.dev.saed.dscommerce.entities.User;
import br.dev.saed.dscommerce.projections.UserDetailsProjection;
import br.dev.saed.dscommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override // Este método é chamado pelo Spring Security para buscar um usuário pelo email
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsProjection> result = repository.searchUserAndRolesByEmail(username);
        if (result.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        User user = new User();
        user.setEmail(username);
        user.setPassword(result.get(0).getPassword());
        for (UserDetailsProjection u : result) {
            user.addRole(new Role(u.getRoleId(), u.getAuthority()));
        }
        return user;
    }
}
