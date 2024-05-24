package framework.visitor;

import framework.domain.Account;
import ui.bank.BankFrm;

public interface MyOperation{
    void action(Visitor visitor, Account account);
}
