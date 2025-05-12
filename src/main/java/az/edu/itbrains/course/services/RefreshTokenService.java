package az.edu.itbrains.course.services;

import az.edu.itbrains.course.models.RefreshToken;
import az.edu.itbrains.course.models.User;

import java.util.Optional;

public interface RefreshTokenService {
    RefreshToken createRefreshToken(String username);
    boolean removeToken(String email);
    Optional<RefreshToken> findByToken(String token);
    RefreshToken verifyExpiration(RefreshToken token);
}
