package com.cjhm.entity.discountstrategy;

import com.cjhm.entity.Money;
import com.cjhm.entity.Showing;

public class PercentDiscountStrategy extends DiscountStrategy {

	private double percent;

	@Override
	protected Money getDiscountFee(Showing showing) {
		return showing.getFixedFee().times(percent);
	}

}
