package com.kalkan.calculator.calcmain;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import com.kalkan.calculator.calculatorcore.Mult;

public class MultServiceTracker extends ServiceTracker {
    public MultServiceTracker(BundleContext context) {
        super(context, Mult.class.getName(),null);
    }
    public Object addingService(ServiceReference reference) {
        return super.addingService(reference);
    }
    public void removedService(ServiceReference reference, Object service) {
        System.out.println("Inside MultServiceTracker.removedService " + reference.getBundle());
        super.removedService(reference, service);
    }
}