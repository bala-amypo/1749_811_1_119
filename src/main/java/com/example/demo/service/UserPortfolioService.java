package com.example.demo.service;

import com.example.demo.model.UserPortfolio;
import java.util.List;

public interface UserPortfolioService {

    UserPortfolio save(UserPortfolio portfolio);

    List<UserPortfolio> getAll();

    UserPortfolio getById(Long id);
}
