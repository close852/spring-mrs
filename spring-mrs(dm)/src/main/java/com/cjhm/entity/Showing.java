package com.cjhm.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
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
public class Showing {

	@GeneratedValue
	@Id
	@Column(name = "showing_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;

	@Column
	private Long sequence;

	@Column
	private LocalTime showingTime;
	
	public Reservation reserve(Customer customer, int audienceCount) {
		return new Reservation(customer, this, audienceCount);
	}

	public Money calculateFee() {
		return movie.calculateFee(this);
	}

	public boolean isSequence(int sequence) {
		return this.sequence == sequence;
	}

	public boolean isPlayingOn(LocalDateTime dayOfWeek) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object getPlayingInterval() {
		// TODO Auto-generated method stub
		return null;
	}

	public Money getFixedFee() {
		return movie.getFee();
	}
}
