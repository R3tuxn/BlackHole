package commands;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.io.*;
import java.text.ParseException;
import java.util.HashMap;

    public class CMDAutoChannelPrivate implements Command {
      public static File file = new File("SERVER_SETTINGS/autochannel_Private.txt");

        private static HashMap<VoiceChannel, Guild> autochannels = new HashMap<>();

    public static VoiceChannel Autochannel;
    public static String idreader = "";

    public static VoiceChannel getVchan(String id, Guild g) {
        return g.getVoiceChannelById(id);
    }

    public static HashMap<VoiceChannel, Guild> getAutochannels() {
        return autochannels;
    }

    public static void setChannel(String id, Guild g, TextChannel tc) throws FileNotFoundException {

       FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);

        try {
            idreader = br.readLine();
            id = idreader;
            Autochannel = getVchan(id, g);
            autochannels.put(Autochannel, g);
            System.out.println(autochannels);

        } catch (Exception e) {
            System.out.println(e);
            tc.sendMessage("Error").queue();
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

        setChannel(idreader, g, tc);

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
