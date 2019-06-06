package com.cjhm.entity.discountstrategy;

import com.cjhm.entity.Money;
import com.cjhm.entity.Showing;

public class NonDiscountStrategy extends DiscountStrategy {

	@Override
	protected Money getDiscountFee(Showing showing) {
		return Money.ZERO;
	}

}
