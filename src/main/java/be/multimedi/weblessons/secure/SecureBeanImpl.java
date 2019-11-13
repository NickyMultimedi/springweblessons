package be.multimedi.weblessons.secure;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
public class SecureBeanImpl implements SecureBean {
    @Override
    @Secured("ROLE_ADULT")
    public String getSecret() {
        return "You're an Adult. Haba Haba";
    }
}
