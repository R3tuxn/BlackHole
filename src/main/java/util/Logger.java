package util;

public class Logger {

    public static void InfoMessage(String Class, int Line, String Message) {
        System.out.println("[Info: " + Class + " - " + Line + " ] -> " + Message + "\n");
    }
    public static void ErrorMessage(String Class, int Line, String ErrorMessage) {
        System.out.println("[Error: " + Class + " - " + Line + " ] -> " + ErrorMessage + "\n");
    }
    public static void CommandMessage(String Prefix,String Command, String CommandInfo) {
        System.out.println("[Command: " + Prefix + Command + " ] -> " + CommandInfo + "\n");
    }
    public static void ListenerdMessage(String ListenerName, String ListenerInfo) {
        System.out.println("[Listener: " + ListenerName + "] -> " + ListenerInfo + "\n");
    }
}