package creditcard.domain;

import framework.domain.Account;
import framework.domain.AccountTypeEnum;

public class CreditCardCreater extends CreditCardFactory{
    @Override
    public void setAccountype(Account account, AccountTypeEnum accountTypeEnum) {
        if (accountTypeEnum == AccountTypeEnum.BRONZE){
            account.setAccountType(bronzeAccount);
        } else if (accountTypeEnum == AccountTypeEnum.SILVER) {
            account.setAccountType(silverAccount);
        }else if (accountTypeEnum == AccountTypeEnum.GOLD) {
            account.setAccountType(goldAccount);
        }
    }
}
