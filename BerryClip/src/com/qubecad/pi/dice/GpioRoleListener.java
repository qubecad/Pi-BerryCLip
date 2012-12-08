/*
 * 
 * Implementation of a D6 for the Berry Clip Raspberry Pi add on available from http://www.raspberrypi-spy.co.uk
 * 
 * Based on an example by Matt Hawkins
 * 
 */



package com.qubecad.pi.dice;

import java.util.HashMap;
import java.util.Random;

import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

class GpioRoleListener implements GpioPinListenerDigital {

	private static GpioPinDigitalOutput resultpina;
	private static GpioPinDigitalOutput resultpinb;
	private static GpioPinDigitalOutput resultpinc;
	private static GpioPinDigitalOutput resultpind;
	private static GpioPinDigitalOutput resultpine;
	private static GpioPinDigitalOutput resultpinf;

	private static HashMap<Integer, String> diceresult = new HashMap<Integer, String>();

	/*
	 * Listener to handle the Button Press event and roll the dice
	 *  
	 */
	
	
	
	
	public GpioRoleListener(GpioPinDigitalOutput pina, GpioPinDigitalOutput pinb, GpioPinDigitalOutput pinc,
			GpioPinDigitalOutput pind, GpioPinDigitalOutput pine, GpioPinDigitalOutput pinf) {

		// pass through the output pins and setup the dice roll results

		resultpina = pina;
		resultpinb = pinb;
		resultpinc = pinc;
		resultpind = pind;
		resultpine = pine;
		resultpinf = pinf;

		diceresult.put(0, "000001");
		diceresult.put(1, "000011");
		diceresult.put(2, "000111");
		diceresult.put(3, "001111");
		diceresult.put(4, "011111");
		diceresult.put(5, "111111");

	}

	/* (non-Javadoc)
	 * @see com.pi4j.io.gpio.event.GpioPinListenerDigital#handleGpioPinDigitalStateChangeEvent(com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent)
	 */
	@Override
	public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {

		// check the button state, if HIGH roll the dice and set the LEDS

		if (event.getState().isHigh()) {
			Random seed = new Random();

			String result = (String) diceresult.get(seed.nextInt(6));
			System.out.println(result);

			setPin(resultpina, result.charAt(0));
			setPin(resultpinb, result.charAt(1));
			setPin(resultpinc, result.charAt(2));
			setPin(resultpind, result.charAt(3));
			setPin(resultpine, result.charAt(4));
			setPin(resultpinf, result.charAt(5));
		}

	}

	/**
	 * 
	 * Sets the passed pin Low or High depending on the passed value.
	 * 
	 * @param pin
	 * @param value
	 */
	private static void setPin(GpioPinDigitalOutput pin, char value) {
		if (value == '0') {

			pin.low();
		} else {

			pin.high();
		}
	}

}
