package com.example.demo.service;

import com.example.demo.model.UserPortfolio;
import java.util.List;

public interface UserPortfolioService {
    UserPortfolio savePortfolio(UserPortfolio portfolio);
    List<UserPortfolio> getAllPortfolios();
}
