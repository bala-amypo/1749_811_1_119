package com.example.demo.repository;
import java.util.List;
import com.example.demo.model.UserPortfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPortfolioRepository extends JpaRepository<UserPortfolio, Long> {
       List<UserPortfolio> findByUserId(Long userId);
}
