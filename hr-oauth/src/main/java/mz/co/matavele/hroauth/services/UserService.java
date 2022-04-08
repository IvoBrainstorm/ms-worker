package mz.co.matavele.hroauth.services;

import mz.co.matavele.hroauth.entities.User;
import mz.co.matavele.hroauth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email){
        User user = userFeignClient.finfByEmail(email).getBody();
        if (user == null){
            logger.error("email not found" + email);
            throw new IllegalArgumentException("User not found");
        }

        logger.info("Email " + email+ " found!" );
        return user;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userFeignClient.finfByEmail(username).getBody();
        if (user == null) {
            logger.error("Email not found: " + username);
            throw new UsernameNotFoundException("Email not found");
        }
        logger.info("Email found: " + username);
        return user;
    }
}
