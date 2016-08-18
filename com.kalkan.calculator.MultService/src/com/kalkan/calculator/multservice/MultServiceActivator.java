package com.kalkan.calculator.multservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.kalkan.calculator.calculatorcore.Mult;

public class MultServiceActivator implements BundleActivator {
	
	ServiceRegistration serviceRegistration;
	public void start(BundleContext context) throws Exception {
		Mult multInt = new MultImpl();
		serviceRegistration = context.registerService(Mult.class.getName(), multInt, null);
	}

	public void stop(BundleContext context) throws Exception {
		serviceRegistration.unregister();
	}
}
