package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import core.permscore;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

public class cmdEmbedSay implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws ParseException, IOException {

        EmbedBuilder builder = new EmbedBuilder();
        String Text = "By " + event.getAuthor().getName();
        String Avatar = event.getAuthor().getEffectiveAvatarUrl();

        if (permscore.check(event)) {
            return;
        } else if (args.length == 0) {
            event.getTextChannel().sendMessage(builder.setDescription(":x: Error\n\nUse !embedsay <Text>").build()).queue();
           return;
        }
        if (args.length > 0) {

            //Timer Zeit = new Timer();

           // EmbedBuilder Timer = new EmbedBuilder();
         //   String Member = event.getMember().getUser().getAsMention();
//
          //  Zeit.schedule(new TimerTask() {
          //      @Override
          //      public void run() {
               //     event.getTextChannel().sendMessage(
               //             Timer.setColor(Color.red).setDescription(Member + " ! **Not so fast! :timer: **").build()).queue();
                }
         //   }, 20000);
      //  }




            event.getMessage().delete().complete();

            List argsList = Arrays.asList(args);
            StringBuilder sb = new StringBuilder();
            argsList.forEach(s -> sb.append(s + " "));
            send(sb.toString(), event);

            event.getTextChannel().sendMessage(builder.setColor(Color.orange).setDescription(sb).setFooter(Text, Avatar).build()).queue();
        System.out.println("[COMMAND] -> !embedsay < "+ sb + ">");

    }


    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {return null;}
    public void send(String msg, MessageReceivedEvent event) {

    }
    }

