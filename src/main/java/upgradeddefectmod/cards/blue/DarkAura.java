package upgradeddefectmod.cards.blue;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.Dark;
import upgradeddefectmod.UpgradedDefect;
import upgradeddefectmod.powers.DarkAuraPower;

import java.nio.channels.Channel;

public class DarkAura extends CustomCard {


    public static final String ID = "UpgradedDefect:DarkAura";
    private static final String IMG_NAME = UpgradedDefect.makeCardPath(ID.split(":")[1]);
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    private static final String NAME = cardStrings.NAME;
    private static final String DESCRIPTION = cardStrings.DESCRIPTION;
    private static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    private static final int COST = 2;

    public DarkAura() {
        super(ID, NAME, IMG_NAME, COST, DESCRIPTION, AbstractCard.CardType.POWER, AbstractCard.CardColor.BLUE, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.NONE);
        this.isEthereal = true;
        this.baseMagicNumber = 1;
        this.magicNumber = this.baseMagicNumber;
    }

    public AbstractCard makeCopy() {
        return new DarkAura();
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.rawDescription = UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new DarkAuraPower(p, this.magicNumber), this.magicNumber));
        if (this.upgraded) {
            AbstractDungeon.actionManager.addToBottom(new ChannelAction(new Dark()));
        }
    }
}
