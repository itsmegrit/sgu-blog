package dacn.sgublog.services;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public interface IAuthenticationService {
   public Authentication getAuthentication();
}
