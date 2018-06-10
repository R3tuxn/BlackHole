package listeners;

import commands.CMDAutoChannelPrivate;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AutoChannelPrivateListener extends ListenerAdapter {

    public static List<VoiceChannel> active = new ArrayList<>();
    public void onGuildVoiceJoin(GuildVoiceJoinEvent event) {

        HashMap<VoiceChannel, Guild> autochannels = CMDAutoChannelPrivate.getAutochannels();
        VoiceChannel vc = event.getChannelJoined();
        Guild g = event.getGuild();
        if (autochannels.containsKey(vc)) {
            VoiceChannel nvc = (VoiceChannel) g.getController().createVoiceChannel(event.getMember().getUser().getName() + " [Private]").setUserlimit(10).setBitrate(vc.getBitrate()).complete();
            active.add(nvc);
            System.out.println(active.size());
            if (vc.getParent() != null) {
                nvc.getManager().setParent(vc.getParent()).queue();
            }
            g.getController().modifyVoiceChannelPositions().selectPosition(nvc).moveTo(vc.getPosition() + 2).queue();
            g.getController().moveVoiceMember(event.getMember(), nvc).queue();
            try {
                if (active.size() == 1) {
                    g.getController().addRolesToMember(event.getMember(), event.getJDA().getRolesByName("MovePermission", false).get(0)).queue();
                    nvc.createPermissionOverride(event.getJDA().getRolesByName("MovePermission", false).get(0)).setAllow(Permission.getRaw(Permission.VOICE_MOVE_OTHERS)).queue();
                } else if (active.size() == 2) {
                    g.getController().addRolesToMember(event.getMember(), event.getJDA().getRolesByName("MovePermission2", false).get(0)).queue();
                    nvc.createPermissionOverride(event.getJDA().getRolesByName("MovePermission2", false).get(0)).setAllow(Permission.getRaw(Permission.VOICE_MOVE_OTHERS)).queue();
                } else if (active.size() == 3) {
                    g.getController().addRolesToMember(event.getMember(), event.getJDA().getRolesByName("MovePermission3", false).get(0)).queue();
                    nvc.createPermissionOverride(event.getJDA().getRolesByName("MovePermission3", false).get(0)).setAllow(Permission.getRaw(Permission.VOICE_MOVE_OTHERS)).queue();
                } else if (active.size() == 4) {
                    g.getController().addRolesToMember(event.getMember(), event.getJDA().getRolesByName("MovePermission4", false).get(0)).queue();
                    nvc.createPermissionOverride(event.getJDA().getRolesByName("MovePermission4", false).get(0)).setAllow(Permission.getRaw(Permission.VOICE_MOVE_OTHERS)).queue();
                } else {
                    g.getController().addRolesToMember(event.getMember(), event.getJDA().getRolesByName("MovePermission5", false).get(0)).queue();
                    nvc.createPermissionOverride(event.getJDA().getRolesByName("MovePermission5", false).get(0)).setAllow(Permission.getRaw(Permission.VOICE_MOVE_OTHERS)).queue();
                }
                nvc.createPermissionOverride(event.getJDA().getRolesByName("[MEMBERS]", false).get(0)).setDeny(Permission.getRaw(Permission.VOICE_CONNECT, Permission.VOICE_DEAF_OTHERS, Permission.VOICE_MUTE_OTHERS, Permission.MANAGE_CHANNEL,Permission.CREATE_INSTANT_INVITE,Permission.MANAGE_WEBHOOKS,Permission.MANAGE_PERMISSIONS)).queue();
            } catch (Exception e) {
                g.getTextChannelsByName("owner-lounge", false).get(0).sendMessage(new EmbedBuilder().setDescription("Could not find role **MovePermission** or **[MEMBERS]**!").setColor(Color.red).build()).queue();
            }

        }
    }
    public void onGuildVoiceMove(GuildVoiceMoveEvent event) {

        HashMap<VoiceChannel, Guild> autochannels = CMDAutoChannelPrivate.getAutochannels();
        VoiceChannel vc = event.getChannelJoined();
        Guild g = event.getGuild();

        if (autochannels.containsKey(vc)) {
            VoiceChannel nvc = (VoiceChannel) g.getController().createVoiceChannel(event.getMember().getUser().getName() + " [Private]").setUserlimit(10).setBitrate(vc.getBitrate()).complete();

            if (vc.getParent() != null) {
                nvc.getManager().setParent(vc.getParent()).queue();
            }
            g.getController().modifyVoiceChannelPositions().selectPosition(nvc).moveTo(vc.getPosition() + 2).queue();
            g.getController().moveVoiceMember(event.getMember(), nvc).queue();
            try {
                if (active.size() == 1) {
                    g.getController().addRolesToMember(event.getMember(), event.getJDA().getRolesByName("MovePermission", false).get(0)).queue();
                    nvc.createPermissionOverride(event.getJDA().getRolesByName("MovePermission", false).get(0)).setAllow(Permission.getRaw(Permission.VOICE_MOVE_OTHERS)).queue();
                } else if (active.size() == 2) {
                    g.getController().addRolesToMember(event.getMember(), event.getJDA().getRolesByName("MovePermission2", false).get(0)).queue();
                    nvc.createPermissionOverride(event.getJDA().getRolesByName("MovePermission2", false).get(0)).setAllow(Permission.getRaw(Permission.VOICE_MOVE_OTHERS)).queue();
                } else if (active.size() == 3) {
                    g.getController().addRolesToMember(event.getMember(), event.getJDA().getRolesByName("MovePermission3", false).get(0)).queue();
                    nvc.createPermissionOverride(event.getJDA().getRolesByName("MovePermission3", false).get(0)).setAllow(Permission.getRaw(Permission.VOICE_MOVE_OTHERS)).queue();
                } else if (active.size() == 4) {
                    g.getController().addRolesToMember(event.getMember(), event.getJDA().getRolesByName("MovePermission4", false).get(0)).queue();
                    nvc.createPermissionOverride(event.getJDA().getRolesByName("MovePermission4", false).get(0)).setAllow(Permission.getRaw(Permission.VOICE_MOVE_OTHERS)).queue();
                } else {
                    g.getController().addRolesToMember(event.getMember(), event.getJDA().getRolesByName("MovePermission5", false).get(0)).queue();
                    nvc.createPermissionOverride(event.getJDA().getRolesByName("MovePermission5", false).get(0)).setAllow(Permission.getRaw(Permission.VOICE_MOVE_OTHERS)).queue();
                }

                nvc.createPermissionOverride(event.getJDA().getRolesByName("[MEMBERS]", false).get(0)).setDeny(Permission.getRaw(Permission.VOICE_CONNECT, Permission.VOICE_DEAF_OTHERS, Permission.VOICE_MUTE_OTHERS, Permission.MANAGE_CHANNEL,Permission.CREATE_INSTANT_INVITE,Permission.MANAGE_WEBHOOKS,Permission.MANAGE_PERMISSIONS)).queue();

            } catch (Exception e) {
                System.out.println(e);
                g.getTextChannelsByName("owner-lounge", false).get(0).sendMessage(new EmbedBuilder().setDescription("Could not find role **MovePermission** or **[MEMBERS]**!").setColor(Color.red).build()).queue();
            }
            active.add(nvc);
        }
        vc = event.getChannelLeft();
        if (active.contains(vc) && vc.getMembers().size() == 0) {
            try {
                g.getController().removeRolesFromMember(event.getMember(), event.getJDA().getRolesByName("MovePermission", false).get(0)).queue();
                g.getController().removeRolesFromMember(event.getMember(), event.getJDA().getRolesByName("MovePermission2", false).get(0)).queue();
                g.getController().removeRolesFromMember(event.getMember(), event.getJDA().getRolesByName("MovePermission3", false).get(0)).queue();
                g.getController().removeRolesFromMember(event.getMember(), event.getJDA().getRolesByName("MovePermission4", false).get(0)).queue();
                g.getController().removeRolesFromMember(event.getMember(), event.getJDA().getRolesByName("MovePermission5", false).get(0)).queue();
            } catch (Exception e) {
                g.getTextChannelsByName("owner-lounge", false).get(0).sendMessage(new EmbedBuilder().setDescription("Could not find role **MovePermission**!").setColor(Color.red).build()).queue();
            }
            active.remove(vc);
            vc.delete().queue();
        }
    }
    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event) {
        Guild g = event.getGuild();
        VoiceChannel vc = event.getChannelLeft();

        if (active.contains(vc) && vc.getMembers().size() == 0) {
            try {
                g.getController().removeRolesFromMember(event.getMember(), event.getJDA().getRolesByName("MovePermission", false).get(0)).queue();
                g.getController().removeRolesFromMember(event.getMember(), event.getJDA().getRolesByName("MovePermission2", false).get(0)).queue();
                g.getController().removeRolesFromMember(event.getMember(), event.getJDA().getRolesByName("MovePermission3", false).get(0)).queue();
                g.getController().removeRolesFromMember(event.getMember(), event.getJDA().getRolesByName("MovePermission4", false).get(0)).queue();
                g.getController().removeRolesFromMember(event.getMember(), event.getJDA().getRolesByName("MovePermission5", false).get(0)).queue();
            } catch (Exception e) {
                g.getTextChannelsByName("owner-lounge", false).get(0).sendMessage(new EmbedBuilder().setDescription("Could not find role **MovePermission**!").setColor(Color.red).build()).queue();
            }
            active.remove(vc);
            vc.delete().queue();
        }
    }
}
