package com.cjhm.entity;

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
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

	public Reservation(Customer customer, Showing showing, int audienceCount) {
		this.customer=customer;
		this.showing = showing;
		this.fee = showing.calculateFee().times(audienceCount);
		this.audienceCount = audienceCount;
	}

	@GeneratedValue
	@Id
	@Column(name = "reservation_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "showing_id")
	private Showing showing;

	@Column
	private Money fee;
	@Column
	private long feeAmount;

	@Column
	private long feeCurrency;

	@Column
	private long audienceCount;
	
	//reservation info
}
