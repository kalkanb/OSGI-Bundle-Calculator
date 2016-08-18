package com.kalkan.calculator.calcmain;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import com.kalkan.calculator.calculatorcore.Diff;

public class DiffServiceTracker extends ServiceTracker {
    public DiffServiceTracker(BundleContext context) {
        super(context, Diff.class.getName(),null);
    }
    public Object addingService(ServiceReference reference) {
        return super.addingService(reference);
    }
    public void removedService(ServiceReference reference, Object service) {
        System.out.println("Inside DiffServiceTracker.removedService " + reference.getBundle());
        super.removedService(reference, service);
    }
}