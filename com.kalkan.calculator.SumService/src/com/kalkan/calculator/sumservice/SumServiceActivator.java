package com.kalkan.calculator.sumservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.kalkan.calculator.calculatorcore.Sum;


public class SumServiceActivator implements BundleActivator {

	ServiceRegistration serviceRegistration;
	public void start(BundleContext context) throws Exception {
		Sum sumInt = new SumImpl();
		serviceRegistration = context.registerService(Sum.class.getName(), sumInt, null);
	}

	public void stop(BundleContext context) throws Exception {
		serviceRegistration.unregister();
	}
}
