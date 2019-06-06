package com.cjhm.entity.rule;

import com.cjhm.entity.Showing;

public interface Rule {
	public boolean isStatisfiedBy(Showing showing);

}
