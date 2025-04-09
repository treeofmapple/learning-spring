package com.tom.first.management.config;

import java.time.LocalDateTime;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.tom.first.management.model.Audit;
import com.tom.first.management.repository.AuditRepository;

import lombok.RequiredArgsConstructor;

@Aspect
@Component
@RequiredArgsConstructor
public class AuditConfig {

	private final AuditRepository auditoriaRepository;

	@Pointcut("@annotation(logAuditoria)")
	public void logAuditoriaPointcut(LogAuditoria logAuditoria) {
	}

	@AfterReturning(value = "logAuditoriaPointcut(logAuditoria)", argNames = "logAuditoria")
	public void salvarAuditoria(LogAuditoria logAuditoria) {
		var auditoria = Audit.builder().action(logAuditoria.acao()).date(LocalDateTime.now())
				.details("Ação realizada automaticamente pelo aspecto.").build();

		auditoriaRepository.save(auditoria);
	}
}