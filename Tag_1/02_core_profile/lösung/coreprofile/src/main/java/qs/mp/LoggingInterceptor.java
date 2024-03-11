package qs.mp;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.util.Arrays;
import java.util.logging.Logger;

@Logged
@Interceptor
public class LoggingInterceptor {
    private static final Logger LOGGER = Logger.getLogger(LoggingInterceptor.class.getName());

    @AroundInvoke
    public Object logMethodEntry(InvocationContext ctx) throws Exception {
        LOGGER.info("Entering method: " + ctx.getMethod().getName() + " with params: " + Arrays.toString(ctx.getParameters()));

        try {
            return ctx.proceed();
        } finally {
            LOGGER.info("Exiting method: " + ctx.getMethod().getName());
        }
    }
}
