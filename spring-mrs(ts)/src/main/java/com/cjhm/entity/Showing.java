package com.cjhm.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

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

	public boolean isDayOfWeek(LocalDateTime dayOfWeek) {
		boolean isBool = false;
		return isBool;
	}
	public boolean isDurationBetween(LocalDateTime startTime, LocalDateTime endTime) {
		boolean isBool = false;
		return isBool;
	}
}
