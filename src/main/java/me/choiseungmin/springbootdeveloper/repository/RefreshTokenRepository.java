package me.choiseungmin.springbootdeveloper.repository;

import me.choiseungmin.springbootdeveloper.domain.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByUserId(Long userid);
    Optional<RefreshToken> findByRefreshToken(String refreshToken);
}
