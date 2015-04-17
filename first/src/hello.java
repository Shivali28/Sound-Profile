

/**
 * MIDlet1.Java
 * @author j2meSalsa.com
 * Ist MIDlet of MIDlet Suite.
 */

//Midlet's User interface API
import javax.microedition.lcdui.Display;

//Midlet class's package
import javax.microedition.midlet.MIDlet;

public class hello extends MIDlet{

 /**
  * Midlet constructor is called and the objects are instantiated.
  * Midlet enters paused state
  * */

    public hello() {
    	
    	HelloWorldForm helloForm = new HelloWorldForm("Hello World From Midlet 1", this);
    	Display.getDisplay(this).setCurrent(helloForm);

    }

    /**
     * startApp() method is called to change the paused state to active state.
     */

    protected void startApp() {

        
    }

    /**
     * The MIDlet frees as much resources as it can.
     */

    protected void pauseApp() {}

    /**
     * Midlet cleans up resources before the application exits.
     *
     */

    protected void destroyApp(boolean bool) {}

}
