package com.cjhm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cjhm.entity.Customer;
import com.cjhm.entity.Discount;
import com.cjhm.entity.Money;
import com.cjhm.entity.Movie;
import com.cjhm.entity.Reservation;
import com.cjhm.entity.Showing;
import com.cjhm.entity.rule.Rule;
import com.cjhm.repository.DiscountRepository;
import com.cjhm.repository.ReservationRepository;
import com.cjhm.repository.ShowingRepository;

@Service
public class ReservationService {

	private ShowingRepository showingRepository;

	private DiscountRepository discountRepository;
	private ReservationRepository reservationRepository;

	public ReservationService(ShowingRepository showingRepository, ReservationRepository reservationRepository, DiscountRepository discountRepository) {
		this.showingRepository = showingRepository;
		this.reservationRepository = reservationRepository;
		this.discountRepository = discountRepository;
	}

	/**
	 * 
	 * 1. DB로 부터 Movie, Showing, Rule 조회<br>
	 * 2. Showing에 적용 가능한 Rule 조회<br>
	 * 3. Rule에 대한 할인요금 계산<br>
	 * 4. Reservation 생성 후 DB 저장
	 * 
	 * @param customerId   사용자ID
	 * @param showingId    영화상영ID
	 * @param audientCount 관람자수
	 * @return
	 */
	public Reservation reserveShowing(Customer customer, Long showingId, Long audienceCount) {
		Showing showing = showingRepository.getOne(showingId);
		Movie movie = showing.getMovie();
		List<Rule> rules = movie.getRules();
		Rule rule = findRule(showing, rules);
		Money fee = movie.getFee();
		if (rule != null) {
			fee = calculateFee(movie);
		}

		Reservation reservation = makeReservation(customer, showing, audienceCount, fee);
		return reservationRepository.save(reservation);
	}

	private Reservation makeReservation(Customer customer, Showing showing, Long audienceCount, Money payment) {
		return Reservation.builder()
				.customer(customer)
				.showing(showing)
				.audienceCount(audienceCount)
				.fee(payment)
				.build();
	}

	private Money calculateFee(Movie movie) {
		Discount discount = discountRepository.findByMovieId(movie.getId());
		Money discountFee = Money.ZERO;
		if (discount != null) {
			if (discount.isAmountType()) {
				discountFee = Money.wons(discount.getFee());
			} else if (discount.isPercentType()) {
				discountFee = movie.getFee().times(discount.getPercent());
			}
		}
		return movie.getFee().minus(discountFee);
	}

	private Rule findRule(Showing showing, List<Rule> rules) {

//		for (Rule rule : rules) {
//			if (rule.isTimeOfDayRule()) {
//				// 시간에 대한 규칙
//				if (showing.isDayOfWeek(rule.getDayOfWeek()) && showing.isDurationBetween(rule.getStartTime(), rule.getEndTime())) {
//					return rule;
//				}
//			} else {
//				// 회차에 대한 규칙
//				if (rule.getSequence() == showing.getSequence()) {
//					return rule;
//				}
//			}
//		}
		return null;
	}
}
