package org.sayari.examen1.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class LogTime {

    @After("execution(* org.sayari.examen1.service.*.ajouterCandidat(..))")
    public void logExecutionTime() {
        log.info("   Début méthode « nom de la méthode » ");
    }

}
