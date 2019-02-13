package test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {

        List<String> strings = Arrays.asList("Alex", "Ivan", "Andrew", "Peter", "Vasilii", "Sanya");
        List<String> integers = Arrays.asList("1,2,4", "2,1000,12;232");
//        System.out.println(task1(strings));
//        System.out.println(task2(strings));
//        System.out.println(task3(integers));
//        task4(25214903917L,11,2^48,1).forEach(System.out::println);

        zip(strings.stream(), integers.stream()).forEach(System.out::println);

    }

    public static List<String> task1(List<String> someList){
        return someList.stream()
                .filter((x)->someList.indexOf(x)%2!=0)
                .map(x->someList.indexOf(x)+". " + x)
                .collect(Collectors.toList());
    }

    public static List<String> task2(List<String> someList){
        return someList.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
    public static List<String> task3(List<String> someList){
        return  someList.stream()
                .map(str -> str.split(","))
//                .flatMap(x -> Arrays.stream(x))
                .flatMap(Arrays::stream)
                .map(x-> ">"+x)
                .collect(Collectors.toList());

    }

    public static Stream<Long> task4(long a, long c, long m, long seed) {
        return Stream.iterate(seed, n -> (a * n + c) % m)
                .limit(100);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        Object[] objects = first.toArray();
        Object[] objects1 = second.toArray();
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < objects.length&&i<objects1.length; i++) {
            list.add(objects[i]);
            list.add(objects1[i]);
        }
        return (Stream<T>) list.stream();
    }
}