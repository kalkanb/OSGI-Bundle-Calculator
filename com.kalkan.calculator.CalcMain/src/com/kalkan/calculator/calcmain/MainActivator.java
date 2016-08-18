package com.kalkan.calculator.calcmain;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.kalkan.calculator.calculatorcore.Diff;
import com.kalkan.calculator.calculatorcore.Div;
import com.kalkan.calculator.calculatorcore.Mult;
import com.kalkan.calculator.calculatorcore.Sum;



public class MainActivator implements BundleActivator {
	SumServiceTracker sumServiceTracker;
	DiffServiceTracker diffServiceTracker;
	MultServiceTracker multServiceTracker;
	DivServiceTracker divServiceTracker;
	
    public void start(BundleContext context) throws Exception {
    	sumServiceTracker= new SumServiceTracker(context);
        diffServiceTracker= new DiffServiceTracker(context);
        multServiceTracker= new MultServiceTracker(context);
        divServiceTracker= new DivServiceTracker(context);
        
        sumServiceTracker.open();
        diffServiceTracker.open();
        multServiceTracker.open();
        divServiceTracker.open();
        
        int a = -5, b = 2;
        
        Sum sumInt = (Sum)sumServiceTracker.getService();
        Diff diffInt = (Diff)diffServiceTracker.getService();
        Mult multInt = (Mult)multServiceTracker.getService();
        Div divInt = (Div)divServiceTracker.getService();
        /*
        System.out.println(a + " + " + b + " = " + sumInt.sum2(a, b));
        System.out.println(a + " - " + b + " = "  + diffInt.diff2(a, b));
        System.out.println(a + " x " + b + " = "  + multInt.mult2(a, b));
        System.out.println(a + " / " + b + " = "  + divInt.div2(a, b));
        */
        try {
			Screen window = new Screen(sumInt, diffInt, multInt, divInt);
			window.getFrame().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
    public void stop(BundleContext context) throws Exception {
        System.out.println("Goodbye World!!");
        sumServiceTracker.close();
        diffServiceTracker.close();
        multServiceTracker.close();
        divServiceTracker.close();
    }
}
