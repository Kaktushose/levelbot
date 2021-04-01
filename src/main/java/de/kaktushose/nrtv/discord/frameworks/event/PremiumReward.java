package de.kaktushose.nrtv.discord.frameworks.event;

import de.kaktushose.nrtv.discord.core.bot.Bot;
import de.kaktushose.nrtv.discord.core.database.data.BotUser;
import de.kaktushose.nrtv.discord.frameworks.level.shop.ItemType;
import de.kaktushose.nrtv.discord.frameworks.level.shop.PremiumRole;
import net.dv8tion.jda.api.entities.Member;

public class PremiumReward extends EventReward {


    public PremiumReward(int bound, String name) {
        super(bound, name);
    }

    @Override
    public void onReward(BotUser botUser, Bot bot) {
        botUser.getItemStack().put(ItemType.PREMIUM, bot.getDatabase().getItemType(1, ItemType.PREMIUM));
        botUser.setPremiumBuyTime(System.currentTimeMillis());
        Member member = bot.getGuild().getMemberById(botUser.getId());
        bot.addRole(member, Bot.Roles.PREMIUM);
        bot.getDatabase().setBotUser(botUser);
    }
}