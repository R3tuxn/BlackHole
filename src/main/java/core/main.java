package core;

import commands.*;
import listeners.*;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import commands.MessageBuilder;
import util.SECRETS;
import util.STATIC;

import javax.security.auth.login.LoginException;

public class main {

    public static JDABuilder builder;

    public static void main(String[] args) throws LoginException, InterruptedException {

        JDABuilder builder = new JDABuilder(AccountType.BOT);

        builder.setToken(SECRETS.TOKEN);
        builder.setAutoReconnect(true);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setGame(Game.playing(STATIC.GAME));

        addCommand();
        builder.addEventListener(new commandListener());
        builder.addEventListener(new readyListener());
        builder.addEventListener(new ReactionClicked());
        builder.addEventListener(new JoinListener());
        builder.addEventListener(new LeftListener());

        try {
            JDA jda = builder.buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static void addCommand() throws LoginException, InterruptedException {

            commandHandler.commands.put("ping", new cmdPing());
            commandHandler.commands.put("say", new cmdsay());
            commandHandler.commands.put("membercount", new cmdmembercount());
            commandHandler.commands.put("help", new cmdhelp());
            commandHandler.commands.put("userstats", new cmdUserStats());
            commandHandler.commands.put("embedsay", new cmdEmbedSay());
            commandHandler.commands.put("serverstats", new CMDServerStats());
            commandHandler.commands.put("sayadmin", new MessageBuilder());
            commandHandler.commands.put("suggestion", new CMDSuggestions());
            commandHandler.commands.put("report", new CMDReport());
            commandHandler.commands.put("invite", new CMDInvite());
            commandHandler.commands.put("prefix", new CMDPrefix());
            commandHandler.commands.put("settings", new CMDSettings());
            commandHandler.commands.put("restart", new CMDAutoChannelPrivate());

    }

}
