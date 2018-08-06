package commands;

import core.permscore;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

import java.awt.*;

public class cmdhelp implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        EmbedBuilder Error = new EmbedBuilder();
        EmbedBuilder em1 = new EmbedBuilder();

        if (STATIC.Switch1.equals("off")) {
            event.getTextChannel().sendMessage(Error.setColor(Color.red).setDescription("**Error** :x:\n\nBot disabled!").build()).queue();
            return;
        }

        if (permscore.check(event)) {
            return;
        }

        if (args.length > 0) {
            event.getTextChannel().sendMessage(Error.setColor(Color.red).setDescription("**Error** :x:\n\nUse `" + STATIC.Prefix + "help`").build()).queue();
        } else {

            String Playername = event.getAuthor().getName();
            String PlayerID = event.getMember().getUser().getDiscriminator();
            String Stringtext = "Requested by " + Playername + "#" + PlayerID;
            String Avatar = event.getAuthor().getEffectiveAvatarUrl();

            String Admin = STATIC.Prefix + "`prefix help` *Change the bot prefix!*\n" + STATIC.Prefix + "`embedsay <Text>` *Send a message in a EmbedBuilder!*\n" + STATIC.Prefix + "`settings help` *Edit the bot settings*\n";
            String Moderation = "";
            String Fun = STATIC.Prefix + "`say <Text>` *Say something!*\n";
            String Informations = STATIC.Prefix + "`help` *Open this message!*\n" + STATIC.Prefix + "`ping` *Shows the bot ping!*\n" + STATIC.Prefix + "`membercount` *Member and Bot counter!*\n" + STATIC.Prefix + "`userstats <Name>` *Shows stats of a user!*\n" + STATIC.Prefix + "`serverstats` *Shows stats of the server!*\n" + STATIC.Prefix + "`invite` *Get a invite of the server!*\n";
            String Others = STATIC.Prefix + "`suggestion <Text>` *Give us a suggestion!*\n" + STATIC.Prefix + "`report <Name> <Reason>` **[Comming Soon!]** *Report a user!*\n";

            event.getTextChannel().sendMessage(em1
                    .setDescription(":clipboard: Help Menu")
                    .addField("Admin: ", Admin, false)
                    .addField("Moderation: ", Moderation, false)
                    .addField("Fun: ", Fun, false)
                    .addField("Informations: ", Informations, false)
                    .addField("Others: ", Others, false)
                    .setFooter(Stringtext, Avatar)
                    .setColor(Color.orange)
                    .build()).queue();

            System.out.println("[COMMAND] -> " + STATIC.Prefix + "help");

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
