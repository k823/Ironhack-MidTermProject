package com.ironhack.MidTermProject.controller.interfaces;

import java.math.BigDecimal;

public interface Transactional {
    BigDecimal increaseAmount(BigDecimal addAmount);
    BigDecimal decreaseAmount(BigDecimal addAmount);
    String toString();
}