package com.cjhm.entity.discountstrategy;

import java.util.List;

import com.cjhm.entity.Money;
import com.cjhm.entity.Showing;
import com.cjhm.entity.rule.Rule;

public abstract class DiscountStrategy {

	private List<Rule> rules;

	public Money calculateDiscountFee(Showing showing) {
		for (Rule each : rules) {
			if (each.isStatisfiedBy(showing)) {

				return getDiscountFee(showing);
			}
		}
		return Money.ZERO;
	}

	protected abstract Money getDiscountFee(Showing showing);

}
