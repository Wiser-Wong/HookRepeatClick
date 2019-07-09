package com.wiser.hookrepeatclick;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import android.util.Log;

/**
 * @author Wiser
 * 
 *         Hook onClick
 */
@Aspect
public class HookRepeatClick {

	private static Long			lastClick	= 0L;

	private static final Long	DELAY		= 1000L;

	@Around("execution(* android.view.View.OnClickListener.onClick(..))") public void hookRepeatClick(ProceedingJoinPoint joinPoint) {
		if (System.currentTimeMillis() - lastClick >= DELAY) {
			lastClick = System.currentTimeMillis();
			try {
				joinPoint.proceed();
			} catch (Throwable throwable) {
				throwable.printStackTrace();
			}
		} else {
			Log.e(HookRepeatClick.class.getName(), "重复点击,已过滤");
		}
	}
}