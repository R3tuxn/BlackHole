package listeners;

import commands.CMDAutoChannelFriends;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class AutoChannelFriendsListener extends ListenerAdapter {

    private String Friend = "[Friend Lounge]";
    public static HashMap<VoiceChannel, Guild> autochannels2 = CMDAutoChannelFriends.getAutochannels2();

    public void onGuildVoiceJoin(GuildVoiceJoinEvent event) {

        VoiceChannel vc = event.getChannelJoined();
        VoiceChannel nvc;
        Guild g = event.getGuild();

        if (autochannels2.containsKey(vc)) {

            nvc = (VoiceChannel) g.getController().createVoiceChannel(Friend).setBitrate(vc.getBitrate()).setUserlimit(10).complete();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            g.getController().modifyVoiceChannelPositions().selectPosition(nvc).moveTo(vc.getPosition() + 2).queue();

            if (vc.getParent() != null) {
                nvc.getManager().setParent(vc.getParent()).queue();
            }

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            g.getController().moveVoiceMember(event.getMember(), nvc).queue();

            nvc.createPermissionOverride(event.getJDA().getRolesByName("[MEMBERS]", false).get(0)).setDeny(Permission.getRaw(Permission.VOICE_CONNECT, Permission.VOICE_DEAF_OTHERS, Permission.VOICE_MUTE_OTHERS, Permission.MANAGE_CHANNEL, Permission.CREATE_INSTANT_INVITE, Permission.MANAGE_WEBHOOKS, Permission.MANAGE_PERMISSIONS)).queue();
            nvc.createPermissionOverride(event.getJDA().getRolesByName("[FRIENDS]", false).get(0)).setAllow(Permission.getRaw(Permission.VOICE_CONNECT, Permission.VOICE_SPEAK, Permission.VOICE_MOVE_OTHERS)).queue();

            VoiceLogListener.VoiceJoin(event);
            try {
                try {
                    vc.createPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
                } catch (Exception e) {
                    vc.putPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
                }
                TimeUnit.SECONDS.sleep(10);
                vc.putPermissionOverride(event.getMember()).setAllow(Permission.VOICE_CONNECT).queue();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onGuildVoiceMove(GuildVoiceMoveEvent event) {

        HashMap<VoiceChannel, Guild> autochannels2 = CMDAutoChannelFriends.getAutochannels2();
        VoiceChannel vc = event.getChannelLeft();
        VoiceChannel nvc;
        VoiceChannel vc2 = event.getGuild().getVoiceChannelById(CMDAutoChannelFriends.idscanner2);
        Guild g = event.getGuild();

        if (vc.getMembers().size() == 0 && vc.getName().contains(Friend)) {

            try {
                TimeUnit.MILLISECONDS.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            vc.delete().complete();
            VoiceLogListener.VoiceMove(event);
            try {
                try {
                    vc2.createPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
                } catch (Exception e) {
                    vc2.putPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
                }
                TimeUnit.SECONDS.sleep(10);
                vc2.putPermissionOverride(event.getMember()).setAllow(Permission.VOICE_CONNECT).queue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        vc = event.getChannelJoined();

        if (autochannels2.containsKey(vc)) {

            nvc = (VoiceChannel) g.getController().createVoiceChannel(Friend).setBitrate(vc.getBitrate()).setUserlimit(10).complete();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            g.getController().modifyVoiceChannelPositions().selectPosition(nvc).moveTo(vc.getPosition() + 2).queue();

            if (vc.getParent() != null) {
                nvc.getManager().setParent(vc.getParent()).queue();
            }

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            g.getController().moveVoiceMember(event.getMember(), nvc).queue();

            nvc.createPermissionOverride(event.getJDA().getRolesByName("[MEMBERS]", false).get(0)).setDeny(Permission.getRaw(Permission.VOICE_CONNECT, Permission.VOICE_DEAF_OTHERS, Permission.VOICE_MUTE_OTHERS, Permission.MANAGE_CHANNEL, Permission.CREATE_INSTANT_INVITE, Permission.MANAGE_WEBHOOKS, Permission.MANAGE_PERMISSIONS)).queue();
            nvc.createPermissionOverride(event.getJDA().getRolesByName("[FRIENDS]", false).get(0)).setAllow(Permission.getRaw(Permission.VOICE_CONNECT, Permission.VOICE_SPEAK, Permission.VOICE_MOVE_OTHERS)).queue();

            VoiceLogListener.VoiceMove(event);
            try {
                try {
                    vc.createPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
                } catch (Exception e) {
                    vc.putPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
                }
                TimeUnit.SECONDS.sleep(10);
                vc.putPermissionOverride(event.getMember()).setAllow(Permission.VOICE_CONNECT).queue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event) {
        VoiceChannel vc = event.getChannelLeft();
        VoiceChannel nvc = event.getGuild().getVoiceChannelById(CMDAutoChannelFriends.idscanner2);

        if (vc.getMembers().size() == 0 && vc.getName().contains(Friend)) {

            try {
                TimeUnit.MILLISECONDS.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            vc.delete().complete();
            VoiceLogListener.VoiceLeave(event);
            try {
                try {
                    nvc.createPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
                } catch (Exception e) {
                    nvc.putPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
                }
                TimeUnit.SECONDS.sleep(10);
                nvc.putPermissionOverride(event.getMember()).setAllow(Permission.VOICE_CONNECT).queue();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}