package com.cjhm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjhm.entity.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Long> {

	public Discount findByMovieId(Long movieId);
}
