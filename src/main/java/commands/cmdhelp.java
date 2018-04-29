package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public class cmdhelp implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        EmbedBuilder builder = new EmbedBuilder();

        if (args.length > 0) {
            event.getTextChannel().sendMessage(
                    builder.setColor(Color.red).setDescription(":x: **Error**\n\nUse *!help*").build()).queue();
            return;
        } else {


            String Playername = event.getAuthor().getName();
            String Stringtext = "Requested by " + Playername;
            String Avatar = event.getAuthor().getEffectiveAvatarUrl();

            String Admin = "`!prefix help` **[BETA]** *Change the bot prefix!*\n`!embedsay <Text>` *Send a message in a EmbedBuilder!*\n";
            String Moderation = "";
            String Fun = "`!say <Text>` *Say something!*\n";
            String Informations = "`!help` *Open this message!*\n`!ping` *Shows the bot ping!*\n`!membercount` *Member and Bot counter!*\n`!userstats <Name>` *Shows stats of a user!*\n`!serverstats` *Shows stats of the server!*\n`!invite` *Get a invite of the server!*\n";
            String Others = "`!suggestion <Text>` *Give us a suggestion!*\n`!report <Name> <Reason>` **[Comming Soon!]** *Report a user!*\n";

            event.getTextChannel().sendMessage(builder
                    .setDescription(":clipboard: Help")
                    .addField("Admin: ", Admin, false)
                    .addField("Moderation: ", Moderation, false)
                    .addField("Fun: ", Fun, false)
                    .addField("Informations: ", Informations, false)
                    .addField("Others: ", Others, false)
                    .setFooter(Stringtext, Avatar)
                    .setColor(Color.orange)
                    .build()).queue();

        }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

        System.out.println("[COMMAND] -> !help");
    }

    @Override
    public String help() {
        return null;
    }
}
