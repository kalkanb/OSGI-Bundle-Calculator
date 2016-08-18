package com.kalkan.calculator.calcmain;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import com.kalkan.calculator.calculatorcore.Sum;

public class SumServiceTracker extends ServiceTracker {
    public SumServiceTracker(BundleContext context) {
        super(context, Sum.class.getName(),null);
    }
    public Object addingService(ServiceReference reference) {
        return super.addingService(reference);
    }
    public void removedService(ServiceReference reference, Object service) {
        System.out.println("Inside SumServiceTracker.removedService " + reference.getBundle());
        super.removedService(reference, service);
    }
}