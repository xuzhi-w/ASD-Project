package framework.rule;

import framework.domain.Account;

public interface Rule {

     boolean matches(Account account);
     void apply(Account account);
}
