package com.cjhm.entity;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.cjhm.entity.discountstrategy.DiscountStrategy;
import com.cjhm.entity.rule.Rule;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

	@GeneratedValue
	@Id
	@Column(name = "movie_id")
	private Long id;

	@OneToMany(mappedBy = "movie")
	private List<Rule> rules;

	@Column
	private String title;

	@Column
	private LocalTime runningTime;

	@Column
	private long feeAmount;

	@Column
	private long feeCurrency;

	private Money fee;

	private DiscountStrategy discountStrategy;
	public Money calculateFee(Showing showing) {
		return fee.minus(discountStrategy.calculateDiscountFee(showing));
	}
}
