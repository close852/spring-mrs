package com.cjhm.entity.rule;

import com.cjhm.entity.Showing;

public class SequenceRule implements Rule {

	private int sequence;

	@Override
	public boolean isStatisfiedBy(Showing showing) {
		return showing.isSequence(sequence);
	}

}
