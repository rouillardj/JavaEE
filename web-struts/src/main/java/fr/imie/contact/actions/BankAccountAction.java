package fr.imie.contact.actions;

import com.opensymphony.xwork2.ActionSupport;
import fr.imie.contact.entities.*;
import fr.imie.contact.repositories.*;

import javax.inject.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;

//@WebServlet("/bankaccount/*")
public class BankAccountAction extends ActionSupport {

    @Inject
    private BankAccountRepository bankaccountrepository;

    @Inject
    private PersonRepository personrepository;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getMethod().equalsIgnoreCase("post")){
            BankAccount account = new BankAccount();

            BigDecimal balance = new BigDecimal(request.getParameter("balance"));
            Integer id = Integer.parseInt(request.getParameter("owner"));
            Person owner = personrepository.findById(id);

            account.setBalance(balance);
            account.setOwner(owner);
            bankaccountrepository.save(account);
        }

        List<BankAccount> accounts = bankaccountrepository.findAll();
        List<Person> persons = personrepository.findAll();

        request.setAttribute("accounts", accounts);
        request.setAttribute("persons", persons);

        request.getRequestDispatcher("/WEB-INF/views/bankaccount.jsp").forward(request, response);
    }

}