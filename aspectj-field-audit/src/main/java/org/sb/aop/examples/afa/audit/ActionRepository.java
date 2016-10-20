package org.sb.aop.examples.afa.audit;

import org.springframework.stereotype.Repository;

@Repository
public class ActionRepository {

	public void saveAction(Action action) {
		System.out.println(String.format("[%s] was changed from [%s] to [%s] by [%s]", action.getFieldName(),
				action.getOldValue(), action.getNewValue(), action.getModifiedBy()));
	}

}
