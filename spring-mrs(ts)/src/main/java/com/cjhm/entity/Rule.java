package com.cjhm.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rule {

	@GeneratedValue
	@Id
	@Column(name = "rule_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "discount_id")
	private Discount discount;

	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;

	@Column
	private String position;

	@Column
	private String ruleType;

	@Column
	private LocalDateTime dayOfWeek;

	@Column
	private LocalDateTime startTime;

	@Column
	private LocalDateTime endTime;

	@Column
	private Long sequence;

	public boolean isTimeOfDayRule() {
		boolean isBool = false;
		return isBool;
	}

}
