package com.kalkan.calculator.diffservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.kalkan.calculator.calculatorcore.Diff;


public class DiffServiceActivator implements BundleActivator {

	ServiceRegistration serviceRegistration;
	public void start(BundleContext context) throws Exception {
		Diff diffInt = new DiffImpl();
		serviceRegistration = context.registerService(Diff.class.getName(), diffInt, null);
	}

	public void stop(BundleContext context) throws Exception {
		serviceRegistration.unregister();
	}

}
