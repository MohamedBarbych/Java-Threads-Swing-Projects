/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * @author DELL
 *
 * **/

package Ascensor;

import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
//==================début de la classe Person=======================================
public class Person extends JLabel implements Runnable {

	/**
	 *
	 */

	private String personnIdentifie;
	private int weightOfPerson;
	private ImageIcon personImage;
	private int posLabelX;
	private int posLabelY;
	public AcsensorLabel ourAsc;
//======================coooonstructeur Person======================================
	public Person(String identifie, int weight, AcsensorLabel a) {

		this.weightOfPerson = weight;
		this.personnIdentifie = identifie;
		this.personImage = new ImageIcon("images/1.png");
		this.setIcon(personImage);
		this.posLabelX = 50;
		this.posLabelY = 580;
		Dimension sizeOfImage = this.getPreferredSize();
		this.setBounds(this.posLabelX, this.posLabelY, sizeOfImage.width, sizeOfImage.height);
		System.out.println("Our Personn Start = " + this.weightOfPerson);
		this.ourAsc = a;
	}
//==============================toString method===============================
	public String getIdetifieOfPerson() {
		return getPersonnIdentifie();
	}

	public int getWeightOfPerson() {
		return weightOfPerson;
	}

	public String getPersonnIdentifie() {
		return personnIdentifie;
	}

	public ImageIcon getPersonImage() {
		return personImage;
	}

	public void setPersonImage(String nameOfImage) {
		this.personImage = new ImageIcon(nameOfImage);
		this.setIcon(personImage);
	}

	public int getPosLabelX() {
		return posLabelX;
	}

	public void setPosLabelX(int posLabelX) {
		this.posLabelX = posLabelX;
	}

	public int getPosLabelY() {
		return posLabelY;
	}

	public void setPosLabelY(int posLabelY) {
		this.posLabelY = posLabelY;
	}

	@Override
//========================redéfinition de la méthode run()================================
	public void run() {

//        System.out.println("Start Person : " + this.getIdetifieOfPerson());
		while (true) {

			try {

//          System.out.println("Person : "+this.getIdetifieOfPerson() + " Want Go From Down To Up");
//          Check Access TO Elevator
				AscensorInterface.ourControlAccess.acquire();

				if (!(ourPanelElevator.goInsideAscensorToMonte(this, ourAsc))) {

					System.out.println("You Can't Go Inside Elevator Because You Are Too Heavy");
				}

//       System.out.println("person : "+this.getIdetifieOfPerson() +" Not Allow To Access The Elevator");

				AscensorInterface.ourControlAccess.release();
				Thread.sleep((long) (5000 * Math.random()));

//     System.out.println("Person : "+this.getIdetifieOfPerson() + " Want Go From Up To Down");

				AscensorInterface.ourControlAccess.acquire();

				if (!(ourPanelElevator.goInsideAscensorToDown(this, ourAsc))) {

					System.out.println("You Can't Go Inside Elevator Because You Are Too Heavy");
				}

				AscensorInterface.ourControlAccess.release();
				Thread.sleep((long) (5000 * Math.random()));

			} catch (InterruptedException ex) {

				Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);

			}
		}
	}
//========================implémntation de la méthode sleep()=============================
	public void sleep(int i) {
		try {

			Thread.sleep(i);

		} catch (InterruptedException ex) {

			Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}
