/**
 * HelloWorldForm.Java
 * @author j2meSalsa.com
 * Common class which is accessed by all MIDlets.
 */



//Midlet's User interface API
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.midlet.MIDlet;

public class HelloWorldForm extends Form implements CommandListener{


	private Command exitCommand;
	MIDlet midlet;

 /**
  * Midlet constructor is called and the objects are instantiated.
  * Midlet enters paused state
  * */

    public HelloWorldForm(String greeting, MIDlet midlet) {
    	
    	super("MIDlet Suite");
    	this.midlet = midlet;
    	exitCommand = new Command("Exit", Command.EXIT, 1);
    	this.append(greeting);
    	this.addCommand(exitCommand);
    	this.setCommandListener(this);

    }

    /**
     * Midlet event handling
     */
    public void commandAction(Command cmd, Displayable disp) {
        if (cmd == exitCommand) {
             midlet.notifyDestroyed(); // Midlet notifies the AMS that it has done its work.
        }
    }
}