package framework.visitor;

import framework.domain.Account;
import ui.bank.BankFrm;

public interface Visitor {

    void visit(BankFrm bankFrm, Account account);
}
