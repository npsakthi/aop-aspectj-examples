package org.sb.aop.examples.afa.audit;

import java.lang.reflect.Field;
import java.util.Date;

import org.aspectj.lang.reflect.FieldSignature;
import org.sb.aop.examples.afa.service.ClientLocatorService;
import org.springframework.beans.factory.annotation.Autowired;

public aspect FieldAuditAspect {

	@Autowired
	private ClientLocatorService clientLocatorService;

	@Autowired
	private ActionRepository actionRepository;

	pointcut auditField(Object t, Object value): set(* @*.AopAudit *.*) && args(value) && target(t);

	before(Object target, Object newValue): auditField(target, newValue) {
		FieldSignature sig = (FieldSignature) thisJoinPoint.getSignature();
		Field field = sig.getField();
		field.setAccessible(true);

		Object oldValue;
		try {
			oldValue = field.get(target);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("Failed to create audit Action", e);
		}

		Action a = new Action();
		a.setAction("update");
		a.setChangeDate(new Date());
		a.setFieldName(sig.getName());
		a.setOldValue(oldValue == null ? null : oldValue.toString());
		a.setNewValue(newValue == null ? null : newValue.toString());
		a.setModifiedBy(clientLocatorService.getCurrentClientId());

		actionRepository.saveAction(a);
	}

}
