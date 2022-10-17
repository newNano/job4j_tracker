package ru.job4j.collection.map.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу простейшей банковской системы.
 * В системе можно производить следующие действия: *
 * 1. Регистрировать пользователя.
 * 2. Удалять пользователя из системы.
 * 3. Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов.
 * 4. Переводить деньги с одного банковского счета на другой счет.
 *
 * @author NAZEKOV ULUKBEK
 * @version 1.0
 */
public class BankService {
    /**
     * Это поле содержит всех пользователей системы с привязанными к ним счетами:
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя в систему.
     *
     * @param user - пользователь, который добавляется в систему.
     *             в случае его отсутствия в системе.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет новый счет к пользователю
     *
     * @param passport - паспорт пользователя. По паспорту находим пользователя.
     *                 После этого мы получим список всех счетов пользователя и
     *                 если такого счета нет - добавим новый счет к ним.
     * @param account  - счет, который нужно добавить в список, если его нет.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = getAccounts(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта:
     *
     * @param passport - паспорт пользователя.
     * @return - метод возвращает найденного по паспорту пользователя,
     * если пользовтеля с таким паспортом нет - возвращает null.
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод ищет счет пользователя по реквизитам.
     *
     * @param passport  - паспорт пользователя
     * @param requisite - реквизиты пользователя
     * @return - метод возвращает счет, если есть пользовтель с такими данными,
     * в противном случае возвращает null.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return getAccounts(user).stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт.
     *
     * @param srcPassport   - паспорт отправителя
     * @param srcRequisite  - реквизиты отправителя
     * @param destPassport  - паспорт получателя
     * @param destRequisite - реквизиты получателя
     * @param amount        - сумма денег, которые нужно перевести
     * @return возвращает true если перевод прошел успешно,
     * в противном случае - false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean result = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        if (srcAccount != null && srcAccount.getBalance() >= amount) {
            Account destAccount = findByRequisite(destPassport, destRequisite);
            if (destAccount != null) {
                srcAccount.setBalance(srcAccount.getBalance() - amount);
                destAccount.setBalance(destAccount.getBalance() + amount);
                result = true;
            }
        }
        return result;
    }

    /**
     * Метод возвращает список всех счетов пользователя.
     *
     * @param user - пользователь у которого получаем список всех его счетов.
     * @return возвращает список всех счетов пользователя.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
