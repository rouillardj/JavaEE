package fr.imie.contact.action;

import fr.imie.contact.entities.BankAccount;
import fr.imie.contact.repositories.BankAccountRepository;
import fr.imie.contact.repositories.PersonRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/transfer/*")
public class TransferAction extends HttpServlet {

    @Inject
    private PersonRepository personRepository;

    @Inject
    private BankAccountRepository bankAccountRepository;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getMethod().equalsIgnoreCase("post")) {
            BigDecimal amount = new BigDecimal(request.getParameter("amount"));
            BankAccount debitAccount = bankAccountRepository.findById(Integer.parseInt(request.getParameter("debit")));
            BankAccount creditAccount = bankAccountRepository.findById(Integer.parseInt(request.getParameter("credit")));

            debitAccount.setBalance(debitAccount.getBalance().subtract(amount));
            creditAccount.setBalance(creditAccount.getBalance().add(amount));

            bankAccountRepository.save(debitAccount);
            bankAccountRepository.save(creditAccount);
        }

        List<BankAccount> accounts = bankAccountRepository.findAll();

        request.setAttribute("accounts", accounts);
        request.getRequestDispatcher("/WEB-INF/views/transfer.jsp").forward(request, response);
    }

}
