package com.cjhm.entity.discountstrategy;

import com.cjhm.entity.Money;
import com.cjhm.entity.Showing;

public class AmountDiscountStrategy extends DiscountStrategy {

	private Money discountAmount;

	@Override
	protected Money getDiscountFee(Showing showing) {
		return discountAmount;
	}

}
