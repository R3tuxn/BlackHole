package util;

import net.dv8tion.jda.core.entities.VoiceChannel;

import java.util.ArrayList;
import java.util.List;

public class STATIC {

    public static String Prefix = "!";

    public static String Switch1 = "on";

    public static final String[] ADMINPERMS = {"Developer", "[FOUNDER]", "[OWNER]", "admin", "[CO-OWNER]", "[OWNER]"};

    public static final String GAME = STATIC.Prefix + "help | 24/7 Online | Welcome to all new members! :)";

    public static List<VoiceChannel> active = new ArrayList<>();

    public static List<VoiceChannel> active2 = new ArrayList<>();
    public static List<String> Checker = new ArrayList<>();
}
