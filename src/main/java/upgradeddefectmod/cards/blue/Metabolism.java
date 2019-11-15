package upgradeddefectmod.cards.blue;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.BiasPower;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import upgradeddefectmod.UpgradedDefect;

public class Metabolism extends CustomCard {


    public static final String ID = "UpgradedDefect:Metabolism";
    private static final String IMG_NAME = UpgradedDefect.makeCardPath(ID.split(":")[1]);
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    private static final String NAME = cardStrings.NAME;
    private static final String DESCRIPTION = cardStrings.DESCRIPTION;
    private static final int COST = 2;

    public Metabolism() {
        super(ID, NAME, IMG_NAME, COST, DESCRIPTION, CardType.POWER, CardColor.BLUE, CardRarity.UNCOMMON, CardTarget.NONE);
        this.baseMagicNumber = 2;
        this.magicNumber = this.baseMagicNumber;
    }

    public AbstractCard makeCopy() {
        return new Metabolism();
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(1);
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new StrengthPower(p, this.magicNumber)));
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new DexterityPower(p, this.magicNumber)));
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new BiasPower(p, 2)));
    }
}
