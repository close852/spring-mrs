package com.cjhm.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discount {

	@GeneratedValue
	@Id
	@Column(name = "discount_id")
	private Long id;

	@OneToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;
	
	@Column
	private String discountType;

	@Column
	private long feeAmount;

	@Column
	private long feeCurrency;

	@Column
	private long percent;

	@Embedded
	private Money fee;

	public boolean isAmountType() {
		boolean isBoolean = false;
		return isBoolean;
	}

	public boolean isPercentType() {
		boolean isBoolean = false;
		return isBoolean;
	}
}
