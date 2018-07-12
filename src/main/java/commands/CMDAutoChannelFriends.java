package commands;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.io.*;
import java.text.ParseException;
import java.util.HashMap;

public class CMDAutoChannelFriends implements Command {
    public static File file = new File("SERVER_SETTINGS/autochannel_Friends.txt");
    private static HashMap<VoiceChannel, Guild> autochannels2 = new HashMap<>();
    public static HashMap<VoiceChannel, Guild> getAutochannels2() { return autochannels2; }

    public static VoiceChannel AutoChannel2;
    public static String idscanner2 = "";

    public static VoiceChannel getVchan(String id, Guild g) { return g.getVoiceChannelById(id); }

    public static void setChan(String id, Guild g, TextChannel tc) throws FileNotFoundException {

        FileReader fileReader = new FileReader(file);
        BufferedReader br2 = new BufferedReader(fileReader);

        try {
            idscanner2 = br2.readLine();
            id = idscanner2;
            AutoChannel2 = getVchan(id, g);
            autochannels2.put(AutoChannel2,g);
            System.out.println(autochannels2);
        } catch (Exception e) {
            e.printStackTrace();
            util.Logger.ErrorMessage("CMDAutoChannelFriends", 27, "Could not read or set  Autochannel ID!");
        }

    }
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws ParseException, IOException, InterruptedException {

        Guild g = event.getGuild();
        TextChannel tc = event.getTextChannel();

        setChan(idscanner2, g, tc);
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}

