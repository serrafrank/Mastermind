package  org.mastermind.view;

import org.mastermind.controller.Controller;
import org.mastermind.core.Core;
import org.mastermind.view.consoleinterface.ConsoleInterface;
import org.mastermind.view.graphicinterface.GraphicInterface;

public class View {

	AbstractInterface gameInterface;
	
	Controller controller;
	

	/** Instance du core */
	protected Core core = Core.getInstance(this);

	/**
	 * Constructeur
	 * @param c
	 * 		Instance du controlleur
	 */
	public View(Controller c) {
		
		this.controller = c;
		String viewMode = core.config.get("view");
		
		//Initialisation du type de vue
		core.logger.info("View mode : " + viewMode);
		switch (viewMode) {
			case "console" :
				this.gameInterface = new ConsoleInterface(controller);
				break;
			case "graphic" : 
				this.gameInterface = new GraphicInterface(controller); 
				break;
		default: 
			//Exception si le mode de jeu est inconnu
			try {
				throw new Exception("View not found. Supported modes are console & graphic");
			}catch(Exception e) {
				core.error(e); 
			}
		}
		
	}

	/**
	 * Demarrage de la vue
	 */
	public void start() {
		this.gameInterface.start();
	}
	
	/**
	 * Retourn l'instance de l'interface utilisée
	 * @return
	 * 		Instance de l'interface 
	 */
	
	public AbstractInterface getObserver() {
		return this.gameInterface;
	}
		
}
