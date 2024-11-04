package org.example.data.repo;

import org.example.data.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CartRepo extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUserId(Long userId);
    @Query("SELECT c FROM Cart c JOIN FETCH c.products WHERE c.user.id = :userId")
    Optional<Cart> findByUserIdWithProducts(@Param("userId") Long userId);

}
