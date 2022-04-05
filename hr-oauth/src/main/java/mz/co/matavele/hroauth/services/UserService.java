package mz.co.matavele.hroauth.services;

import mz.co.matavele.hroauth.entities.User;
import mz.co.matavele.hroauth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

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
}
