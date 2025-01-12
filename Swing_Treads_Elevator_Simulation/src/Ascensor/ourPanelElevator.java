package Ascensor;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

//=======================debut classe ourPanelElevator=============================
public class ourPanelElevator extends JPanel {

	public ImageIcon imageForPanel;
	public static int capacitorOfElevatorWeight;
	public int numberOfPerson;
//==========================constructeur =======================================
	public ourPanelElevator() {

		this.numberOfPerson = 1;
		this.capacitorOfElevatorWeight = 100;

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		imageForPanel = new ImageIcon("images/bg6.png");
		imageForPanel.paintIcon(this, g, WIDTH, WIDTH);
	}
//===========m�thode goInsideAscenserToMonte=======================================
	public static boolean goInsideAscensorToMonte(Person p, AcsensorLabel a) throws InterruptedException {

		int x = p.getPosLabelX();
		int y = p.getPosLabelY();

		if (p.getWeightOfPerson() > capacitorOfElevatorWeight) {

			return false;

		} else {

//                 System.out.println("Person "+p.getIdetifieOfPerson() + " Is Start Runing");          
			while (x < 1200) {

				x += 50;
				p.setLocation(x, y);
				if (x == 1000) {
//                         Check If Elevator Up Or Down
					a.elevatorStatusCaseUp();
					a.SwitchIconAscensor("images/3.png");
					Thread.sleep(1000);
				}
				p.sleep(200);
			}
//                 System.out.println("Person "+p.getIdetifieOfPerson() + " Is Inside Elevator From Down");
//                 Switch Person Image
			p.setPersonImage("images/2.png");
			p.hide();
			a.AscensorToUp();
			y -= 580;
			p.setLocation(x, y);
			p.show();

//                 System.out.println("Person "+p.getIdetifieOfPerson() + " Is Start Going Outside Elevator " );
			while (x > 50) {
				x -= 50;
				p.setLocation(x, y);
				p.sleep(200);
			}
			// Switch Person Image
			a.SwitchIconAscensor("images/a1.png");
			p.setPersonImage("images/1.png");
			p.setPosLabelX(x);
			p.setPosLabelY(y);

			return true;

		}
	}
//=========================m�thode goInsideAscenserToMonte=============================
	public static boolean goInsideAscensorToDown(Person p, AcsensorLabel a) throws InterruptedException {

		int x = p.getPosLabelX();
		int y = p.getPosLabelY();

		if (p.getWeightOfPerson() > capacitorOfElevatorWeight) {

			return false;

		} else {

			while (x < 1200) {

				x += 50;
				p.setLocation(x, y);

				if (x == 1000) {

					// Check If Elevator Up Or Down
					a.elevatorStatusCaseDown();
					a.SwitchIconAscensor("images/3.png");
					Thread.sleep(1000);

				}
				p.sleep(200);
			}
//                 System.out.println("Person "+p.getIdetifieOfPerson() + " Is Inside Elevator From Up" );
//                 Switch Person Image
			p.setPersonImage("images/2.png");
			p.hide();
			a.AscensorToDown();
			y += 580;
			p.setLocation(x, y);
			p.show();

//                  System.out.println("Person "+p.getIdetifieOfPerson() + " Is Start going Outside Elevator");
			while (x > 50) {

				x -= 50;
				p.setLocation(x, y);
				p.sleep(200);
			}

			a.SwitchIconAscensor("images/a1.png");
			// Switch Person Image
			p.setPersonImage("images/1.png");

			p.setPosLabelX(x);
			p.setPosLabelY(y);
			return true;
		}
	}
}
