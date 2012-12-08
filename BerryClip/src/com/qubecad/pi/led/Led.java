
/*
 * 
 * LED Test for the Berry Clip Raspberry Pi add on available from http://www.raspberrypi-spy.co.uk
 * 
 *  
 */


package com.qubecad.pi.led;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class Led {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		GpioController gpio = GpioFactory.getInstance();
		// TODO Auto-generated method stub

		// Set up the pins and set low to start
		System.out.println("Setting up GPIO Pins for output");
		GpioPinDigitalOutput pina = gpio.provisionDigitalOuputPin(RaspiPin.GPIO_07, "Pin A", PinState.LOW);
		GpioPinDigitalOutput pinb = gpio.provisionDigitalOuputPin(RaspiPin.GPIO_00, "Pin B", PinState.LOW);
		GpioPinDigitalOutput pinc = gpio.provisionDigitalOuputPin(RaspiPin.GPIO_03, "Pin C", PinState.LOW);
		GpioPinDigitalOutput pind = gpio.provisionDigitalOuputPin(RaspiPin.GPIO_12, "Pin D", PinState.LOW);
		GpioPinDigitalOutput pine = gpio.provisionDigitalOuputPin(RaspiPin.GPIO_13, "Pin E", PinState.LOW);
		GpioPinDigitalOutput pinf = gpio.provisionDigitalOuputPin(RaspiPin.GPIO_14, "Pin F", PinState.LOW);

		while (true) {
			try {

				// Set the lights

				System.out.println("A high");
				pina.high();
				Thread.sleep(1000);
				pina.low();
				Thread.sleep(1000);
				System.out.println("B high");
				pinb.high();
				Thread.sleep(1000);
				pinb.low();
				Thread.sleep(1000);
				System.out.println("C high");
				pinc.high();
				Thread.sleep(1000);
				pinc.low();
				Thread.sleep(1000);
				System.out.println("D high");
				pind.high();
				Thread.sleep(1000);
				pind.low();
				Thread.sleep(1000);
				System.out.println("E high");
				pine.high();
				Thread.sleep(1000);
				pine.low();
				Thread.sleep(1000);
				System.out.println("F high");
				pinf.high();
				Thread.sleep(1000);
				pinf.low();
				Thread.sleep(1000);

			} catch (InterruptedException e) {

				System.out.print("Interrupted! ");
			}

		}

	}

}
