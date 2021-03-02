package com.poo.lab12.reports;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.poo.lab12.entities.*;

public class BusinessReport {

    public static Map<Disability, List<Employee>> getEmployeesOnSameDisability(Business business) {
        // Get employees and map them on the type of disability they possess

        return business.getEmployees().stream().collect(Collectors.groupingBy(Employee::getDisability));
    }

    public static long getNumberOfDifferentProjectsWorkedByCurrentFemaleEmployees(Business business) {
        // Get employees, filter by gender, get their projects without duplicates, count

        return business.getEmployees().stream().filter(employee -> employee.getGender().equals(Gender.FEMALE))
                .flatMap(employee -> employee.getProjects().stream()).distinct().count();
    }

    public static SortedSet<Employee> getEmployeesMaxByReligionMinByGenderSortedByCitySortedByAge(Business business) {
        // Get the employees with majority by religion, from this group select the subgroup that has the minority by gender
        // Sort the set by city and, in case of equality, by age

        return business.getEmployees().stream().collect(Collectors.groupingBy(Employee::getReligion))
                .entrySet().stream().max(Comparator.comparingInt(entry -> entry.getValue().size())).get()
                .getValue().stream().collect(Collectors.groupingBy(Employee::getGender))
                .entrySet().stream().min(Comparator.comparingInt(entry -> entry.getValue().size())).get()
                .getValue().stream().collect(Collectors.toCollection(() -> new TreeSet<>(Comparator
                .comparing(Employee::getCity).thenComparing(Employee::getAge))));
    }

    public static Religion getReligionOfEmployeesWithMostAccounts(Business business) {
        // Group employees by religion, count the accounts in each group, return the religion with biggest score

        return business.getEmployees().stream().collect(Collectors.groupingBy(Employee::getReligion))
                .entrySet().stream().max(Comparator.comparingLong(entry -> entry.getValue().stream().
                        mapToLong(employee -> employee.getAccounts().size()).sum())).get().getKey();
    }

    public static Map<Religion, Map<Gender, List<Employee>>> getEmployeesOnSameReligionAndGender(Business business) {
        // Map the employees by religion (Map<Religion, List<Employee>>) then map each of the lists by city (Map<String, List<Employee>>)
        // Hint: use Collectors.groupingBy(Function, Collector)

        return business.getEmployees().stream().collect(Collectors.groupingBy(Employee::getReligion,
                Collectors.groupingBy(Employee::getGender)));
    }

    public static Map<Project, Map<String, List<Employee>>> getEmployeesOnSameProjectAndCity(Business business) {
        // Map the employees to the business projects (not to their respective projects)

        Map<Project, Map<String, List<Employee>>> map = new HashMap<>();
        business.getEmployees().forEach(e -> e.getProjects().forEach(p -> {
            if (!map.containsKey(p)) {
                Map<String, List<Employee>> m = new HashMap<>();
                map.put(p, m);
            }

            if (!map.get(p).containsKey(e.getCity())) {
                List<Employee> employees = new ArrayList<>();
                map.get(p).put(e.getCity(), employees);
            }

            map.get(p).get(e.getCity()).add(e);
        }));
        return map;
    }
}
