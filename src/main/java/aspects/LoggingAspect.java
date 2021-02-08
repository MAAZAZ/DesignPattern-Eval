package aspects;

import com.sun.javafx.util.Logging;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Component
@Aspect
@EnableAspectJAutoProxy
public class LoggingAspect {

    private long t1,t2;
    private Logger logger=Logger.getLogger(Logging.class.getName());

    public LoggingAspect() throws Exception{
        logger.addHandler(new FileHandler("log.xml"));
        logger.setUseParentHandlers(false);
    }

    @Around(value = "@annotation(Log)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("---------------");
        t1=System.currentTimeMillis();
        logger.info("Avant "+ joinPoint.getSignature());
        Object object=joinPoint.proceed();
        logger.info("Après "+ joinPoint.getSignature());
        t2=System.currentTimeMillis();
        logger.info("Durée : "+ (t2-t1)+"ms");
        return object;
    }
}

