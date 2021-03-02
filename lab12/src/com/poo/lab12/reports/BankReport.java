package com.poo.lab12.reports;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.poo.lab12.entities.*;

public class BankReport {
    // Customer = Employee of the Business
    // Business = a client of the Bank
    // Customers of the Bank = all the Employees that work for the Businesses that are clients of the Bank

    public static int getNumberOfCustomers(Bank bank) {
        // All the customers that have accounts at the bank

        return bank.getClients().stream().map(client -> client.getEmployees().size())
                .reduce(0, Integer::sum);
    }

    public static int getNumberOfAccounts(Bank bank) {
        // Accounts of all the customers of the bank

        return bank.getClients().stream().flatMap(client -> client.getEmployees().stream())
                .map(employee -> employee.getAccounts().size())
                .reduce(0, Integer::sum);
    }

    public static SortedSet<Employee> getCustomersSorted(Bank bank) {
        // Display the set of customers in alphabetical order

        return bank.getClients().stream().flatMap(client -> client.getEmployees().stream())
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Employee::getName))));
    }

    public static double getTotalSumInAccounts(Bank bank) {
        // Sum of all customers' accounts balances

        return bank.getClients().stream().flatMap(client -> client.getEmployees().stream())
                .flatMap(employee -> employee.getAccounts().stream())
                .map(Account::getBalance)
                .reduce(0.0, Double::sum);
    }

    public static SortedSet<Account> getAccountsSortedBySum(Bank bank) {
        // The set of all accounts, ordered by current account balance

        return bank.getClients().stream().flatMap(client -> client.getEmployees().stream())
                .flatMap(employee -> employee.getAccounts().stream())
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Account::getBalance)
                .thenComparing(Account::getId))));
    }

    public static Map<Employee, Collection<Account>> getCustomerAccounts(Bank bank) {
        // Return a map of all the customers with their respective accounts

        return bank.getClients().stream().flatMap(client -> client.getEmployees().stream())
                .collect(Collectors.toMap(Function.identity(), Employee::getAccounts));
    }

    public static Map<String, List<Employee>> getCustomersByCity(Bank bank) {
        // Map all the customers to their respective cities

        return bank.getClients().stream().flatMap(client -> client.getEmployees().stream())
                .collect(Collectors.groupingBy(Employee::getCity));
    }

    public static Project getProjectWorkedOnByMostCustomers(Bank bank) {
        // Get all the projects from the employees and find the most repeated one in the list

        Map<Project, Integer> map = new HashMap<>();
        bank.getClients().stream().flatMap(client -> client.getEmployees().stream())
                .flatMap(employee -> employee.getProjects().stream())
                .forEach(project -> map.put(project, map.getOrDefault(project, 0) + 1));
        return map.entrySet().stream().filter(entry -> (entry.getValue().equals(Collections.max(map.values())))).findFirst().get().getKey();
    }

    public static Gender getGenderWhoWorkedOnMostProjects(Bank bank) {
        // Get all the pairs <gender, project> or <gender, List<project>>, then reduce the array to only one pair
        // of each gender and retrieve the one with most counted projects (you are expected to count duplicates as well).

        return bank.getClients().stream().flatMap(client -> client.getEmployees().stream())
                .collect(Collectors.groupingBy(Employee::getGender)).entrySet().stream()
                .max(Comparator.comparingLong(entry -> entry.getValue().stream()
                .mapToLong(employee -> employee.getProjects().size()).sum())).get().getKey();
    }
}
