package org.example.data.repo;

import org.example.data.models.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepo extends JpaRepository<Likes, Long> {
}
