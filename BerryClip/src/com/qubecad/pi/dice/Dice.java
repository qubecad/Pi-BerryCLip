
/*
 * 
 * Implementation of a D6 for the Berry Clip Raspberry Pi add on available from http://www.raspberrypi-spy.co.uk
 * 
 * Based on an example by Matt Hawkins
 * 
 */

package com.qubecad.pi.dice;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class Dice {

	public static void main(String[] args) throws InterruptedException {

		GpioController gpio = GpioFactory.getInstance();

		// Set up the pins and set low to start
		System.out.println("Setting up GPIO Pins for output");
		GpioPinDigitalOutput pina = gpio.provisionDigitalOuputPin(RaspiPin.GPIO_07, "Pin A", PinState.LOW);
		GpioPinDigitalOutput pinb = gpio.provisionDigitalOuputPin(RaspiPin.GPIO_00, "Pin B", PinState.LOW);
		GpioPinDigitalOutput pinc = gpio.provisionDigitalOuputPin(RaspiPin.GPIO_03, "Pin C", PinState.LOW);
		GpioPinDigitalOutput pind = gpio.provisionDigitalOuputPin(RaspiPin.GPIO_12, "Pin D", PinState.LOW);
		GpioPinDigitalOutput pine = gpio.provisionDigitalOuputPin(RaspiPin.GPIO_13, "Pin E", PinState.LOW);
		GpioPinDigitalOutput pinf = gpio.provisionDigitalOuputPin(RaspiPin.GPIO_14, "Pin F", PinState.LOW);

		// Setup pin for button

		GpioPinDigitalInput roleButton = gpio
				.provisionDigitalInputPin(RaspiPin.GPIO_11, "Role Button", PinPullResistance.PULL_DOWN);

		// add a listener for the button press event

		roleButton.addListener(new GpioRoleListener(pina, pinb, pinc, pind, pine, pinf));

		// start a loop until the user quits via CTRL C

		while (true) {
			Thread.sleep(500);

		}

	}

}
