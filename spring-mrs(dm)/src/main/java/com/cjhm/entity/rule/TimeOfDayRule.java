package com.cjhm.entity.rule;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.cjhm.entity.Interval;
import com.cjhm.entity.Showing;

public class TimeOfDayRule implements Rule {

	private LocalDateTime dayOfWeek;
	private LocalTime startTime;
	private LocalTime endTime;

	@Override
	public boolean isStatisfiedBy(Showing showing) {
		//구체적으로 구현 필요
		return showing.isPlayingOn(dayOfWeek) && Interval.closed(startTime, endTime).includes(showing.getPlayingInterval());
	}

}
