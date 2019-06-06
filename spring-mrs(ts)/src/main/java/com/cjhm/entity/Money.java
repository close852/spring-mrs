package com.cjhm.entity;

import javax.persistence.Embeddable;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@Embeddable
public class Money {

	public static final Money ZERO = new Money(0);
	private long fee;

	public Money(long fee) {
		this.fee = fee;
	}

	public static Money wons(Money fee) {
		return fee;
	}

	public Money times(double percent) {
		this.fee = (long) (this.fee * (percent));
		return this;
	}
	public Money minus(Money fee) {
		this.fee = this.fee - fee.getFee();
		return this;
	}

}
