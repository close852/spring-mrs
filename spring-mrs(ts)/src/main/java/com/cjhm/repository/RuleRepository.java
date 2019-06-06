package com.cjhm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjhm.entity.Rule;

public interface RuleRepository extends JpaRepository<Rule, Long> {

}
